package blk.interfacetesting.service.impl.common;

import blk.common.exception.SystemException;
import blk.common.util.Constants;
import blk.interfacetesting.component.ExcelParser;
import blk.interfacetesting.dao.ExecuteTestDao;
import blk.interfacetesting.modle.data.*;
import blk.interfacetesting.service.IBaseService;
import blk.interfacetesting.service.common.ParseDataFileService;
import blk.interfacetesting.service.data.*;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

/**
 * @author Mark
 * @date 2018/1/24
 */
@Service("parseDataFileService")
public class ParseDataFileServiceImpl implements ParseDataFileService {
    private static final Logger logger = LoggerFactory.getLogger(ParseDataFileServiceImpl.class);

    private Map<String, IBaseService> serviceMap;

    private ExecuteTestDao executeTestDao;

    private ExcelParser excelParser;

    @Autowired
    public ParseDataFileServiceImpl(Map<String, IBaseService> serviceMap, ExecuteTestDao executeTestDao, ExcelParser excelParser) {
        this.serviceMap = serviceMap;
        this.executeTestDao = executeTestDao;
        this.excelParser = excelParser;
    }

    private Map<String, IBaseService> getServiceMap() {
        return serviceMap;
    }

    @Override
    public void dbInit(String dbName) {
        executeTestDao.dbInit(dbName);
    }

    @Override
    public String validateExpectResult(String expectResult) {
        try {
            excelParser.validateJson(expectResult);
            return "符合Json格式";
        } catch (JSONException e) {
            return e.getMessage();
        }
    }

    @Override
    public Map<String, Object> parseDataFile(MultipartFile multipartFile, boolean isOverWrite) {
        InputStream is;
        try {
            is = multipartFile.getInputStream();
        } catch (IOException e) {
            logger.error("解析文件出错", e);
            throw new SystemException("解析文件出错", e);
        }

        Map<String, Object> dataMap = excelParser.parse(is, isOverWrite);
        String iemName = (String) dataMap.get("iemNameInvalid");

        if (null != iemName) {
            String validationInfo = Constants.MSG_ERROR_PREFIX + "测试场景名称重复：" + iemName;
            List<String> validationInfoList = new ArrayList<String>();
            validationInfoList.add(validationInfo);

            Map<String, Object> map = new HashMap<String, Object>();
            map.put("msg", "测试场景名称重复");
            map.put("validationInfo", validationInfoList);
            return map;
        }

        Boolean flag = (Boolean) dataMap.get("flag");
        List<String> validationInfoList = (List<String>) dataMap.get("validationInfoList");
        if (!flag) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("msg", "测试数据存在错误");
            map.put("validationInfo", validationInfoList);
            return map;
        }

        return saveData(dataMap);
    }

    private Map<String,Object> saveData(Map<String, Object> dataMap) {
        MstbProject mstbProject = (MstbProject) dataMap.get("mstbProject");
        if (null == mstbProject.getMpId()) {
            saveMstbProject(mstbProject);
        }
        IftbExecuteMain executeMain = (IftbExecuteMain) dataMap.get("executeMain");
        List<Map<String, Object>> interfaceList = (List<Map<String, Object>>) dataMap.get("interface");
        List<Map<String, Object>> testCaseMapList = (List<Map<String, Object>>) dataMap.get("testCase");
        List<Map<String, Object>> testDataList = (List<Map<String, Object>>) dataMap.get("testData");

        // 验证测试用例设计与测试用例数据是否完全匹配
        List<String> tctdList = validateTestCaseAndTestData(testCaseMapList, testDataList);

        // 验证接口参数与测试用例对应数据是否完全匹配
        List<String> paramValidateResultList = validateInterfaceParameter(interfaceList, testDataList);

        tctdList.addAll(paramValidateResultList);

        int mpId = mstbProject.getMpId();

        executeMain.setMpId(mpId);
        executeMain.setMpName(mstbProject.getMpName());
        saveExecuteMain(executeMain);

        int iemId = executeMain.getIemId();
        Map<String, Integer> interfaceMap = saveUrl(interfaceList, mpId, iemId);

        List<MstbTestCase> testCaseList = saveMtc(testCaseMapList, interfaceMap, mpId, iemId);
        Map<String, Integer> mtcMap = getMtcMap(testCaseList);
        Map<String, List<String>> mtcDependencyMap = getMtcDependencyMap(testCaseList);

        Map<String, List<IftbTestData>> testDataListMap = saveTestData(testDataList, mtcMap, interfaceMap, iemId);

        Map<String, List<Integer>> itdIdDependencyMap = findItdIdDependency(mtcDependencyMap, testDataListMap);

        // 根据动态参数，确定数据依赖关系
        Map<String, List<Integer>> dependencyRelationMap = findDependRelation(testDataList, mtcMap, interfaceMap);

        saveTestDataDependency(testDataList, mtcMap, interfaceMap, dependencyRelationMap, itdIdDependencyMap);

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("msg", "解析成功");
        map.put("validationInfo", tctdList);

        return map;
    }

    /**
     * 保存测试数据依赖
     * @param dataList
     * @param mtcMap
     * @param interfaceMap
     * @param dependencyRelationMap
     * @param itdIdDependencyMap
     */
    private void saveTestDataDependency(List<Map<String, Object>> dataList, Map<String, Integer> mtcMap,
                                        Map<String, Integer> interfaceMap, Map<String,
            List<Integer>> dependencyRelationMap,
                                        Map<String, List<Integer>> itdIdDependencyMap) {
        // 添加前置数据
        for (Map<String, Object> map : dataList) {
            String tcNum = (String) map.get("tcNum");
            if (mtcMap.containsKey(tcNum)) {
                // 接口
                Map<String, Object> anInterface = (Map<String, Object>) map.get("interface");
                for (Map.Entry<String, Object> entry : anInterface.entrySet()) {
                    String key = entry.getKey();
                    if (interfaceMap.containsKey(key)) {
                        List<Map<String, Object>> testDataList = (List<Map<String, Object>>) entry.getValue();
                        for (Map<String, Object> mm : testDataList) {
                            IftbTestData testData = (IftbTestData) mm.get("testData");
                            Set<Integer> itdIdSet = new HashSet<Integer>();
                            // 添加依赖数据
                            String depend = (String) mm.get("depend");
                            if (!"null".equalsIgnoreCase(depend)) {
                                String[] names = depend.split(";");
                                for (String name : names) {
                                    itdIdSet.add(getItdId(name));
                                }
                            } else {
                                List<Integer> itdIdList = itdIdDependencyMap.get(testData.getItdName());
                                if (null != itdIdList) {
                                    itdIdSet.addAll(itdIdList);
                                }
                            }
                            if (dependencyRelationMap.containsKey(testData.getItdName())) {
                                itdIdSet.addAll(dependencyRelationMap.get(testData.getItdName()));
                            }
                            if (itdIdSet.size() > 0) {
                                StringBuilder builder = new StringBuilder();
                                for (int id : itdIdSet) {
                                    builder.append(id).append("#");
                                }
                                builder.setLength(builder.length() - 1);
                                IftbTestDataDependency dependency = new IftbTestDataDependency();
                                dependency.setItdId(testData.getItdId());
                                dependency.setItddDependency(builder.toString());
                                TestDataDependencyService testDataDependencyService = (TestDataDependencyService) this.getServiceMap().get("testDataDependencyService");
                                int result1 = testDataDependencyService.add(dependency);
                                if (result1 < 1) {
                                    logger.info("添加前置数据出错，前置数据对应的测试数据id为" + testData.getItdId());
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    /**
     * 通过测试数据名称获取测试数据序号
     * @param itdName 测试数据名称
     * @return 测试数据名称对应的id，如果不存在，返回0
     */
    private int getItdId(String itdName) {
        IftbTestDataCriteria testDataCriteria = new IftbTestDataCriteria();
        IftbTestDataCriteria.Criteria criteria = testDataCriteria.createCriteria();
        if (StringUtils.isNotEmpty(itdName)){
            criteria.andItdNameEqualTo(itdName);
        }
        TestDataService testDataService = (TestDataService) this.getServiceMap().get("testDataService");
        List<IftbTestData> testDataList = testDataService.queryForAll(testDataCriteria);
        if (CollectionUtils.isNotEmpty(testDataList)){
            IftbTestData testData = testDataList.get(0);
            return testData.getItdId();
        }
        return 0;
    }

    /**
     * 遍历测试数据的参数，找到动态参数，并获取对应的测试数据id
     * @param dataList 测试数据信息集合
     * @return 测试数据及对应的依赖Id
     */
    private Map<String,List<Integer>> findDependRelation(List<Map<String, Object>> dataList, Map<String, Integer> mtcMap, Map<String, Integer> interfaceMap) {
        Map<String, List<Integer>> dependencyMap = new HashMap<String, List<Integer>>(dataList.size());
        for (Map<String, Object> map : dataList) {
            String tcNum = (String) map.get("tcNum");
            if (mtcMap.containsKey(tcNum)) {
                // 接口
                Map<String, Object> anInterface = (Map<String, Object>) map.get("interface");
                for (Map.Entry<String, Object> entry : anInterface.entrySet()) {
                    String key = entry.getKey();
                    if (interfaceMap.containsKey(key)) {
                        List<Map<String, Object>> testDataList = (List<Map<String, Object>>) entry.getValue();
                        for (Map<String, Object> mm : testDataList) {
                            IftbTestData testData = (IftbTestData) mm.get("testData");
                            String values = testData.getItdValues();
                            if (values.contains("?")) {
                                String[] splits = values.split("#");
                                List<Integer> itdIdList = new ArrayList<Integer>(splits.length);
                                for (String str : splits) {
                                    if (str.contains("?")) {
                                        if (str.contains("&")) {
                                            str = str.replace("&", "]");
                                        }
                                        String dynamicParam = StringUtils.substringBetween(str, "[", "]");
                                        dynamicParam = dynamicParam.replace("?", "");
                                        int itdId = findItdIdByDynamicParamName(dynamicParam.trim());
                                        itdIdList.add(itdId);
                                    }
                                }
                                dependencyMap.put(testData.getItdName(), itdIdList);
                            }
                        }
                    }
                }
            }
        }
        return dependencyMap;
    }

    /**
     * 根据动态参数名查找对应的测试数据id
     * @param dynamicParam 动态参数名
     * @return 测试数据id
     */
    private int findItdIdByDynamicParamName(String dynamicParam) {
        MstbDynamicParamCriteria criteria = new MstbDynamicParamCriteria();
        criteria.createCriteria().andMdpNameEqualTo(dynamicParam);
        DynamicParamService dynamicParamService = (DynamicParamService) this.getServiceMap().get("dynamicParamService");
        MstbDynamicParam mstbDynamicParam = dynamicParamService.query(criteria);
        if (mstbDynamicParam == null) {
            return 0;
        } else {
            return mstbDynamicParam.getItdId();
        }
    }

    /**
     * 根据测试用例的依赖关系和测试用例对应的测试数据集合，获取用例层级的依赖
     * @param mtcDependencyMap
     * @param testDataListMap
     * @return 用例层级依赖
     *         key: 测试数据名称
     *         value: 被依赖的测试数据id集合
     */
    private Map<String,List<Integer>> findItdIdDependency(Map<String, List<String>> mtcDependencyMap, Map<String, List<IftbTestData>> testDataListMap) {
        Map<String, List<Integer>> resultMap = new HashMap<String, List<Integer>>(mtcDependencyMap.size());
        for (Map.Entry<String, List<String>> entry : mtcDependencyMap.entrySet()) {
            // 遍历获取被依赖的测试数据id集合
            List<String> mtcDependencyList = entry.getValue();
            List<Integer> itdDependencyIdList = new ArrayList<Integer>();
            for (String mtcDependency : mtcDependencyList) {
                List<IftbTestData> dependencyList = testDataListMap.get(mtcDependency);
                if (null != dependencyList) {
                    for (IftbTestData testData : dependencyList) {
                        itdDependencyIdList.add(testData.getItdId());
                    }
                }
            }
            // 为测试数据找到对应的被依赖的测试数据id集合
            String mtcNum = entry.getKey();
            List<IftbTestData> testDataList = testDataListMap.get(mtcNum);
            for (IftbTestData testData : testDataList) {
                resultMap.put(testData.getItdName(), itdDependencyIdList);
            }
        }
        return resultMap;
    }

    /**
     * 保存数据
     * @param dataList 测试数据excel文件数据记录
     * @param mtcMap 用例Map key: 接口编号（用作标记） value: 用例对象
     * @param interfaceMap 接口Map key: 接口编号（用作标记） value: 接口id
     * @return 测试用例编号与该用例的测试数据id集合的映射关系
     *         key: 测试用例编号
     *         value: 该用例的测试数据Id集合
     */
    @SuppressWarnings("unchecked")
    private Map<String, List<IftbTestData>> saveTestData(List<Map<String, Object>> dataList, Map<String, Integer> mtcMap, Map<String, Integer> interfaceMap, int iemId) {
        Map<String, List<IftbTestData>> returnMap = new HashMap<String, List<IftbTestData>>();
        // 添加测试数据
        for (Map<String, Object> map : dataList) {
            String tcNum = (String) map.get("tcNum");
            if (mtcMap.containsKey(tcNum)) {
                int mtcId = mtcMap.get(tcNum);
                // 接口
                Map<String, Object> anInterface = (Map<String, Object>) map.get("interface");
                for (Map.Entry<String, Object> entry : anInterface.entrySet()) {
                    String key = entry.getKey();
                    if (interfaceMap.containsKey(key)) {
                        int mumId = interfaceMap.get(key);
                        List<Map<String, Object>> testDataList = (List<Map<String, Object>>) entry.getValue();
                        List<IftbTestData> itdIdList = new ArrayList<IftbTestData>();
                        for (Map<String, Object> mm : testDataList) {
                            // 往数据库添加测试数据记录
                            IftbTestData testData = (IftbTestData) mm.get("testData");
                            testData.setIemId(iemId);
                            testData.setMtcId(mtcId);
                            testData.setMumId(mumId);
                            TestDataService testDataService = (TestDataService) this.getServiceMap().get("testDataService");
                            int result = testDataService.add(testData);
                            if (result < 1) {
                                logger.warn("添加测试数据" + testData.getItdName() + "出错");
                                continue;
                            }
                            itdIdList.add(testData);
                            // 往数据库添加动态参数记录
                            List<MstbDynamicParam> dynamicParamList = (List<MstbDynamicParam>) mm.get("dynamicParam");
                            if (dynamicParamList.size() > 0) {
                                saveDynamicParam(dynamicParamList, testData.getItdId(), iemId);
                            }
                        }
                        returnMap.put(tcNum, itdIdList);
                    } else {
                        logger.warn("保存测试数据时，找不到对应的接口编号:" + key);
                    }
                }
            } else {
                logger.warn("保存测试数据时，找不到对应的用例编号:" + tcNum);
            }
        }

        return returnMap;
    }

    /**
     * 保存动态参数到数据库
     * @param dynamicParamList 动态参数集合
     * @param itdId 测试数据id
     */
    private void saveDynamicParam(List<MstbDynamicParam> dynamicParamList, Integer itdId, int iemId) {
        for (MstbDynamicParam mstbDynamicParam : dynamicParamList) {
            mstbDynamicParam.setIemId(iemId);
            mstbDynamicParam.setItdId(itdId);
            mstbDynamicParam.setCreateTime(new Date(System.currentTimeMillis()));
            DynamicParamService dynamicParamService = (DynamicParamService) this.getServiceMap().get("dynamicParamService");
            int result = dynamicParamService.add(mstbDynamicParam);
            if (result < 0) {
                System.out.println("添加动态参数时出错，动态参数为" + mstbDynamicParam.getMdpName());
            }
        }
    }

    /**
     * 通过遍历测试用例对象集合，获取用例编号与用例依赖的映射关系
     * @param testCaseList
     * @return key: 用例编号
     *         value: 用例依赖集合（实际上就是被依赖的用例编号）
     */
    private Map<String,List<String>> getMtcDependencyMap(List<MstbTestCase> testCaseList) {
        Map<String, List<String>> dependencyMap = new HashMap<String, List<String>>();
        for (MstbTestCase testCase : testCaseList) {
            String dependency = testCase.getMtcDependency();
            if (StringUtils.isNotBlank(dependency)) {
                String[] array = dependency.split(";");
                List<String> dependencyList = Arrays.asList(array);
                dependencyMap.put(testCase.getMtcNumber(), dependencyList);
            }
        }
        return dependencyMap;
    }

    /**
     * 通过遍历测试用例对象集合，获取用例编号与用例Id的映射关系
     * @param testCaseList
     * @return key: 用例编号
     *         value: 用例id
     */
    private Map<String,Integer> getMtcMap(List<MstbTestCase> testCaseList) {
        Map<String, Integer> mtcMap = new HashMap<String, Integer>(testCaseList.size());
        for (MstbTestCase testCase : testCaseList) {
            mtcMap.put(testCase.getMtcNumber(), testCase.getMtcId());
        }
        return mtcMap;
    }

    /**
     * 插入测试用例信息，并返回mtcId
     * @param dataList Excel数据
     * @return Map对象，key: 接口编号, value: mtcId
     */
    @SuppressWarnings("unchecked")
    private List<MstbTestCase> saveMtc(List<Map<String, Object>> dataList, Map<String, Integer> interfaceMap, int mpId, int iemId) {
        List<MstbTestCase> testCaseList = new ArrayList<MstbTestCase>(dataList.size());
        for (Map<String, Object> map : dataList) {
            String tcNum = (String) map.get("tcNum");
            MstbTestCase mstbTestCase = (MstbTestCase) map.get("tc");
            mstbTestCase.setMpId(mpId);
            mstbTestCase.setMtcNumber(tcNum);
            TestCaseService testCaseService = (TestCaseService) this.getServiceMap().get("testCaseService");
            int result = testCaseService.add(mstbTestCase);
            if (result > 0) {
                testCaseList.add(mstbTestCase);
            } else {
                System.out.println("添加测试用例:" + mstbTestCase.getMtcName() + "出错");
                testCaseList.add(mstbTestCase);
            }
            // 添加用例与接口关系
            ArrayList<String> mumNums = (ArrayList<String>) map.get("mumNums");
            for (String mumNum : mumNums) {
                if (interfaceMap.containsKey(mumNum)) {
                    IftbURLTestCase iftbURLTestCase = new IftbURLTestCase();
                    iftbURLTestCase.setMtcId(mstbTestCase.getMtcId());
                    iftbURLTestCase.setMumId(interfaceMap.get(mumNum));
                    URLTestCaseService urlTestCaseService = (URLTestCaseService) this.getServiceMap().get("urlTestCaseService");
                    int result3 = urlTestCaseService.add(iftbURLTestCase);
                    if (result3 < 1) {
                        logger.info("添加用例与接口关系出错，对应用例id为" + iftbURLTestCase.getMtcId()
                                + "对应接口id为" + interfaceMap.get(mumNum));
                    }
                }
            }
        }
        for (MstbTestCase testCase : testCaseList) {
            IftbExecuteTestCase iftbExecuteTestCase = new IftbExecuteTestCase();
            iftbExecuteTestCase.setIemsId(iemId);
            iftbExecuteTestCase.setMtcId(testCase.getMtcId());
            ExecuteTestCaseService executeTestCaseService = (ExecuteTestCaseService) this.getServiceMap().get("executeTestCaseService");
            int result6 = executeTestCaseService.add(iftbExecuteTestCase);
            if (result6 < 1) {
                logger.info("添加执行场景与测试用例对应关系出错，对应用例id为" +
                        testCase.getMtcId() + "对应场景id为" + iemId);
            }
        }
        return testCaseList;
    }

    /**
     * 保存接口与接口参数信息
     * @param dataList 接口excel文件数据集
     * @return Map key: 接口编号（用作标记） value: 接口id
     */
    @SuppressWarnings("unchecked")
    private Map<String, Integer> saveUrl(List<Map<String, Object>> dataList, int mpId, int iemId) {
        Map<String, Integer> interfaceMap = new HashMap<String, Integer>(); // key: 接口编号 value: 接口id
        // 插入接口数据，并返回接口id
        for (Map<String, Object> map : dataList) {
            String mumNum = (String) map.get("mumNum");
            MstbURLManagement mstbURLManagement = (MstbURLManagement) map.get("url");
            mstbURLManagement.setMpId(mpId);
            mstbURLManagement.setIemId(iemId);
            mstbURLManagement.setMumNumber(mumNum);
            URLManagementService urlManagementService = (URLManagementService) this.getServiceMap().get("urlManagementService");
            int result1 = urlManagementService.add(mstbURLManagement);
            if (result1 > 0) {
                int mumId = mstbURLManagement.getMumId();
                interfaceMap.put(mumNum, mumId);
                // 获取接口参数，并插入数据库
                List<MstbURLParameters> parametersList = (List<MstbURLParameters>) map.get("parametersList");
                for (MstbURLParameters param : parametersList) {
                    param.setMumId(mumId);
                    URLParameterService urlParameterService = (URLParameterService) this.getServiceMap().get("urlParameterService");
                    int result2 = urlParameterService.add(param);
                    if (result2 < 1) {
                        System.out.println("接口参数" + param.getMupName() + "插入失败...");
                    }
                }
            } else {
                System.out.println("接口" + mstbURLManagement.getMumName() + "插入失败...");
            }
        }
        return interfaceMap;
    }

    private void saveExecuteMain(IftbExecuteMain executeMain) {
        ExecuteMainService executeMainService = (ExecuteMainService) this.getServiceMap().get("executeMainService");
        executeMainService.add(executeMain);
    }

    private void saveMstbProject(MstbProject mstbProject) {
        ProjectService projectService = (ProjectService) this.getServiceMap().get("projectService");
        projectService.add(mstbProject);
    }

    /**
     * 验证测试用例设计与测试用例数据是否完全匹配
     * @param testCaseList
     * @param testDataList
     * @return
     */
    private List<String> validateTestCaseAndTestData(List<Map<String, Object>> testCaseList, List<Map<String, Object>> testDataList) {
        List<String> list = new ArrayList<String>();
        // 验证 测试用例设计顺序 与 测试用例数据执行顺序
        List<String> mtcNumList = new ArrayList<String>();
        for (Map<String, Object> mtcMap : testCaseList) {
            mtcNumList.add(String.valueOf(mtcMap.get("tcNum")));
        }

        List<String> tdNumList = new ArrayList<String>();
        for (Map<String, Object> tdMap : testDataList) {
            tdNumList.add(String.valueOf(tdMap.get("tcNum")));
        }

        // 求差集
        List<String> validateMtcNumList = new ArrayList<String>();
        validateMtcNumList.addAll(mtcNumList);
        validateMtcNumList.removeAll(tdNumList);
        if (validateMtcNumList.size() > 0) {
            for (String mtcNum : validateMtcNumList) {
                list.add(Constants.MSG_WARN_PREFIX + "测试用例设计：" + mtcNum + "，无对应的测试用例数据");
            }
        }

        List<String> validateTdNumList = new ArrayList<String>();
        validateTdNumList.addAll(tdNumList);
        validateTdNumList.removeAll(mtcNumList);
        if (validateTdNumList.size() > 0) {
            for (String mtcNum: validateTdNumList) {
                list.add(Constants.MSG_WARN_PREFIX + "测试用例数据：" + mtcNum + "，无对应的测试用例设计");
            }
        }

        // 验证顺序是否不同
        if (mtcNumList.size() == tdNumList.size()) {
            for (int i = 0; i < mtcNumList.size(); i++) {
                if (!mtcNumList.get(i).equals(tdNumList.get(i))) {
                    list.add(Constants.MSG_WARN_PREFIX + "测试用例设计顺序 与 测试用例数据执行顺序不符；建议使用系统导出的测试用例数据。");
                    break;
                }
            }
        }

        return list;
    }

    /**
     * 验证接口参数与测试用例对应数据是否完全匹配
     * @param interfaceList
     * @param testDataList
     * @return
     */
    private List<String> validateInterfaceParameter(List<Map<String, Object>> interfaceList, List<Map<String, Object>> testDataList) {
        List<String> list = new ArrayList<String>();
        // 处理测试数据中的参数
        Map<String, List<String>> tdParamMap = new HashMap<String, List<String>>();
        for (Map<String, Object> mtcMap : testDataList) {
            Map<String, Object> interfaceMap = (Map<String, Object>) mtcMap.get("interface");
            for (Map.Entry<String, Object> entry : interfaceMap.entrySet()) {
                String mumNum = entry.getKey();
                List<Map<String, Object>> testDataMapList = (List<Map<String, Object>>) entry.getValue();
                for (Map<String, Object> testDataMap : testDataMapList) {
                    IftbTestData testData = (IftbTestData) testDataMap.get("testData");
                    String cols = testData.getItdCols();
                    String[] names = cols.split(Constants.PARAMS_SEPARATOR);
                    List<String> nameList = Arrays.asList(names);
                    tdParamMap.put(mumNum, nameList);
                    break;
                }
            }
        }

        // 处理接口中的参数
        for (Map<String, Object> interfaceMap : interfaceList) {
            String mumNum = (String) interfaceMap.get("mumNum");
            if (tdParamMap.containsKey(mumNum)) {
                List<String> tdParamList = tdParamMap.get(mumNum);
                List<MstbURLParameters> parametersList = (List<MstbURLParameters>) interfaceMap.get("parametersList");
                if (tdParamList.size() != parametersList.size()) {
                    list.add(Constants.MSG_WARN_PREFIX + "接口参数 与 测试用例对应数据不符；建议使用系统导出的测试用例数据。");
                    break;
                }
                List<String> paramList = new ArrayList<String>();
                for (MstbURLParameters urlParameters : parametersList) {
                    paramList.add(urlParameters.getMupName());
                }
                List<String> validateTdParamList = new ArrayList<String>(tdParamList.size());
                validateTdParamList.addAll(tdParamList);
                List<String> validateParamList = new ArrayList<String>(paramList.size());
                validateParamList.addAll(paramList);

                // 求差集，验证接口参数 与 测试用例对应数据参数是否完全一致
                validateParamList.removeAll(tdParamList);
                if (validateParamList.size() > 0) {
                    list.add(Constants.MSG_WARN_PREFIX + "接口参数 与 测试用例对应数据不符；建议使用系统导出的测试用例数据。");
                    break;
                }

                validateTdParamList.removeAll(paramList);
                if (validateTdParamList.size() > 0) {
                    list.add(Constants.MSG_WARN_PREFIX + "接口参数 与 测试用例对应数据不符；建议使用系统导出的测试用例数据。");
                    break;
                }
            }
        }

        return list;
    }
}
