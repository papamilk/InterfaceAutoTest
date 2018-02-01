package blk.interfacetesting.service.impl.common;

import blk.common.exception.BusinessException;
import blk.common.util.CommonUtils;
import blk.common.util.Constants;
import blk.common.util.ThreadMgt;
import blk.interfacetesting.component.http.HttpMethodEnum;
import blk.interfacetesting.component.http.HttpRequestUtils;
import blk.interfacetesting.component.http.ResponseResult;
import blk.interfacetesting.dao.ExecuteTestDao;
import blk.interfacetesting.dao.IBaseDao;
import blk.interfacetesting.dao.data.MstbDynamicParamDao;
import blk.interfacetesting.dao.data.MstbProjectDao;
import blk.interfacetesting.dao.data.MstbURLManagementDao;
import blk.interfacetesting.dao.result.TstbResultTestDataDao;
import blk.interfacetesting.modle.data.*;
import blk.interfacetesting.modle.result.TstbResultTestData;
import blk.interfacetesting.modle.result.TstbResultTestDataCriteria;
import blk.interfacetesting.service.IBaseService;
import blk.interfacetesting.service.common.ExecuteTestService;
import blk.interfacetesting.service.data.TestCaseService;
import blk.interfacetesting.service.data.TestDataService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.json.JSONException;
import org.skyscreamer.jsonassert.FieldComparisonFailure;
import org.skyscreamer.jsonassert.JSONCompare;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.skyscreamer.jsonassert.JSONCompareResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static blk.common.util.Constants.DATA_SUCCESS;
import static blk.common.util.Constants.TIME_OUT;

/**
 * @author Mark
 * @date 2018/1/25
 */
@Service("executeTestService")
public class ExecuteTestServiceImpl implements ExecuteTestService {
    private static final Logger logger = LoggerFactory.getLogger(ExecuteTestServiceImpl.class);

    private ThreadMgt threadMgt;

    private Map<String, IBaseService> serviceMap;

    private Map<String, IBaseDao> daoMap;

    private String urlPrefix;

    @Autowired
    private ExecuteTestDao executeTestDao;

    @Autowired
    public ExecuteTestServiceImpl(ThreadMgt threadMgt, Map<String, IBaseService> serviceMap, Map<String, IBaseDao> daoMap) {
        this.threadMgt = threadMgt;
        this.serviceMap = serviceMap;
        this.daoMap = daoMap;
    }

    /**
     * 保存已经检查过的是否需要延迟的测试用例id
     * key：mtcId
     */
    private Set<Integer> mtcIdSet = new HashSet<Integer>();


    @Override
    public int execute(int iemId) {
        if (threadMgt.isEmpty()) {
            TestDataService testDataService = (TestDataService) this.serviceMap.get("testDataService");
            List<IftbTestData> testDataList = testDataService.getExecuteList(iemId);
            if (CollectionUtils.isNotEmpty(testDataList)) {
                for (IftbTestData testData : testDataList) {
                    if (threadMgt.isEmpty()) {
                        try {
                            threadMgt.putCommander(testData);
                            ExecuteCommand(testData);
                        } catch (Exception e) {
                            throw new BusinessException("执行测试数据" + testData.getItdNumber(), e);
                        } finally {
                            // 执行完毕,取出执行对象,继续执行下一条
                            threadMgt.getCommands();
                        }
                    }
                }
            }
        }
        return DATA_SUCCESS;
    }

    @Override
    public List<Map<String, Object>> executeQuery(String sql) {
        if (StringUtils.isBlank(sql)) {
            return new ArrayList<Map<String, Object>>();
        }
        try {
            String[] sqls = sql.split(";");
            if (sql.length() > 1) {
                List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
                for (String sqlStr : sqls) {
                    List<Map<String, Object>> result = executeTestDao.executeQuery(sqlStr);
                    list.addAll(result);
                }
                return list;
            }
            return executeTestDao.executeQuery(sql);
        }catch (Exception e){
            logger.error("SQL执行失败，SQL: " + sql, e);
            e.printStackTrace();
            return new ArrayList<Map<String, Object>>();
        }
    }

    @Override
    public int executeUpdate(String sql) {
        return executeTestDao.executeUpdate(sql);
    }

    @Override
    public int findTotalTestDataCount(int iemId) {
        TstbResultTestDataDao resultTestDataDao = (TstbResultTestDataDao) daoMap.get("resultTestDataDao");
        return resultTestDataDao.findTotalTestDataCount(iemId);
    }

    @Override
    public int findExecutedDataCount(int iemId) {
        TstbResultTestDataDao resultTestDataDao = (TstbResultTestDataDao) daoMap.get("resultTestDataDao");
        return resultTestDataDao.findExecutedDataCount(iemId);
    }

    /**
     * @return 0 success,-2,timeout
     */
    private int ExecuteCommand(final IftbTestData iftbTestData) {
        logger.info(String.valueOf(33));
        ExecutorService executor = Executors.newSingleThreadExecutor();
        final Integer[] result = {-1};
        FutureTask<Integer> future =
                new FutureTask<Integer>(new Callable<Integer>() {//使用Callable接口作为构造参数
                    public Integer call() throws IOException {
                        int stopTime = isDelay(iftbTestData);
                        if (stopTime > 0) {
                            logger.info("测试数据" + iftbTestData.getItdName() + "延迟" + stopTime + "分钟执行");
                            threadMgt.sleep(stopTime * 1000 * 60);
                        }
                        // 30/11/2017 Mark's function import here
                        // TODO
                        run(iftbTestData);
                        logger.info("s");
                        threadMgt.sleep(50);
                        return result[0];
                    }
                });
        executor.execute(future);
        try {
            result[0] = future.get(NumberUtils.toInt(CommonUtils.getProperties("system.properties", "thread.pool.timeout")), TimeUnit.SECONDS); //取得结果，同时设置超时执行时间为系统预定义时间。
        } catch (InterruptedException e) {
            future.cancel(true);
        } catch (ExecutionException e) {
            future.cancel(true);
        } catch (TimeoutException e) {
            future.cancel(true);
            // 超时处理
            TstbResultTestData resultTestData = new TstbResultTestData();
            resultTestData.setItdId(iftbTestData.getItdId());
            resultTestData.setTrtdName(iftbTestData.getItdName());
            resultTestData.setTrtdErrorDescription("请求超时");
            resultTestData.setTrtdResult(TIME_OUT);
            saveTestData(resultTestData);
            logger.info("timeOut");
            return -2;
        } finally {
            executor.shutdown();
            return result[0];
        }
    }

    /**
     * 判断测试数据所属的测试用例是否有延迟执行需求
     * @param iftbTestData
     * @return 0不需要延迟， 其它数字代表延迟时间，不能为负，单位：分钟
     */
    private int isDelay(IftbTestData iftbTestData) {
        int mtcId = iftbTestData.getMtcId();
        // 由于延迟是基于用例，因此所有的同一用例下的数据只需要延迟一次就行
        // 为了保证只延迟一次，只在用例下的第一条数据作延迟执行操作
        // 所以每拿到一条数据，都先拿到mtcId，判断mtcIdSet中是否已经有该mtcId
        // 如果有，说明该用例已经检查是否延迟，这样不用重复查询数据库
        // 如果没有，就根据mtcId查询用例信息，判断是否需求进行延迟执行，并将mtcId加入mtcIdSet
        if (!mtcIdSet.contains(mtcId)) {
            TestCaseService testCaseService = (TestCaseService) serviceMap.get("testCaseService");
            MstbTestCase mstbTestCase = testCaseService.query(mtcId);
            Integer stopTime = mstbTestCase.getStopTime();
            if (null == stopTime) {
                return 0;
            }
            mtcIdSet.add(mtcId);
            return stopTime;
        }
        return 0;
    }

    private void run(IftbTestData testData) {
        try {
            long PstartTime = System.currentTimeMillis();
            System.out.println("************ START" + testData.getItdName() + "***********************");
            System.out.println("1. Start Porcessing Test Data: " + testData.getItdName() + ", StartTime: " + PstartTime);
            logger.info("开始执行" + testData.getItdName());
            setUrlPrefix();
            String dependens = testData.getItddddependency();
            System.out.println("2. Verifying dependency Test cases: " + testData.getItdName() + ", 耗时: " + (System.currentTimeMillis() - PstartTime));
            PstartTime = System.currentTimeMillis();
            List<String> dependFailList = getDependencyFail(dependens);
            if (dependFailList.size() > 0) {
                // 保存前置数据失败记录
                StringBuilder builder = new StringBuilder();
                for (String string : dependFailList) {
                    builder.append(string).append(String.valueOf((char) 10));
                }
                TstbResultTestData resultTestData = new TstbResultTestData();
                resultTestData.setItdId(testData.getItdId());
                resultTestData.setTrtdName(testData.getItdName());
                resultTestData.setTrtdResult(Constants.DEPENDENCY_FAILURE);
                resultTestData.setTrtdErrorDescription("前置数据失败");
                resultTestData.setTrtdDependName(builder.toString());
                saveTestData(resultTestData);
                return;
            }
            MstbURLManagement urlManagement;
            System.out.println("3. Composing Target URL: " + testData.getItdName() + ", 耗时: " + (System.currentTimeMillis() - PstartTime));
            PstartTime = System.currentTimeMillis();
            MstbURLManagementDao urlManagementDao = (MstbURLManagementDao) daoMap.get("urlManagementDao");
            urlManagement = urlManagementDao.ReadByID(testData.getMumId());
            String urlPath = urlPrefix + urlManagement.getMumUrlPath();
            HttpMethodEnum method = HttpMethodEnum.fromMethodType(urlManagement.getMumMethodType());
            String cols = testData.getItdCols();
            String vals = testData.getItdValues();

            System.out.println("4. Assigning value to target parameters: " + testData.getItdName() + ", 耗时: " + (System.currentTimeMillis() - PstartTime));

            Map<String, String> params = handleParams(cols, vals);
            // 发送请求
            HttpRequestUtils utils = new HttpRequestUtils();

            System.out.println("5. Send HTTP Request: " + testData.getItdName());
            PstartTime = System.currentTimeMillis();

            String realParam = paramsToString(params);
            ResponseResult responseResult = new ResponseResult();
            try {
                responseResult = utils.sendHttpRequest(urlPath, params, method);
            } catch (Exception e) {
                logger.warn("测试数据" + testData.getItdName() + "发送Http请求失败");
                saveTestDataOfHttpError(testData, responseResult, realParam);
                return;
            }

            System.out.println("6. Complete sending HTTP Request: " + testData.getItdName() + ", 耗时: " + (System.currentTimeMillis() - PstartTime));
            PstartTime = System.currentTimeMillis();

            String executeResult = responseResult.getExecuteResult();

            System.out.println("7. Receiving HTTP Executing Result: " + testData.getItdName() + ", 耗时: " + (System.currentTimeMillis() - PstartTime));
            PstartTime = System.currentTimeMillis();

            if ("200".equals(responseResult.getStatusCode())) {
                List<String> resultList = compareResult(testData.getItdExpectResult(), executeResult);
                if (resultList.size() == 0) {
                    String sql = testData.getItdSql();
                    String sqlExpectResult = testData.getItdSqlExpectResult();
                    if (!(null == sql || "".equals(sql))) {
                        try {
                            //比较sql返回语句，先获取sql语句
                            List<Map<String, Object>> list = executeQuery(sql);
                            if (list.size() > 0) {
                                String sqlResult = handleSQLResultList(list);
                                boolean compareResult = compareSQLResult(sqlResult, sqlExpectResult);
                                if (compareResult) {
                                    saveSuccessDataOfSql(testData, responseResult,sqlResult);
                                } else {
                                    saveFailDataOfDifferentSqlResult(testData, responseResult, sqlResult, realParam);
                                }
                            } else {
                                // SQL执行失败
                                saveFailDataOfSql(testData, responseResult, realParam);
                            }
                        } catch (Exception e) {
                            logger.error("执行SQL时出错");
                            saveFailDataOfSql(testData, responseResult, realParam);
                        }
                    } else {
                        // 保存成功记录，无SQL比较
                        saveSucessDataOfNoSql(testData, responseResult);
                    }
                    // 赋值参数
                    //判断是否存在赋值操作
                    boolean isAssignmentExist = checkAssignmentIsExist(testData);
                    if (isAssignmentExist) {
                        //赋值操作存在
                        getFormulaAndSetValue(testData, executeResult, params);
                    }
                } else {
                    // 保存执行结果不一致记录
                    saveTestDataOfDifferentResult(testData, responseResult, resultList, realParam);
                }
            } else {
                // 保存Http请求错误记录
                saveTestDataOfHttpError(testData, responseResult, realParam);
            }
            System.out.println("8. Complete processing test data: " + testData.getItdName() + ", 耗时: " + (System.currentTimeMillis() - PstartTime));
            System.out.println("************ FINISH" + testData.getItdName() + "***********************");
        } catch (Exception e) {
            logger.info("执行测试数据" + testData.getItdName() + "出错", e);

            String cols = testData.getItdCols();
            String vals = testData.getItdValues();
            Map<String, String> params = handleParams(cols, vals);
            String realParam = paramsToString(params);

            TstbResultTestData resultTestData = new TstbResultTestData();
            resultTestData.setItdId(testData.getItdId());
            resultTestData.setTrtdName(testData.getItdName());
            resultTestData.setTrtdResult(6);
            resultTestData.setTrtdErrorDescription("未知原因失败");
            resultTestData.setTrtdData(realParam);
            saveTestData(resultTestData);
        }
    }

    /**
     * 处理查询SQL的返回结果
     * @param list
     * @return
     */
    private String handleSQLResultList(List<Map<String, Object>> list) {
        StringBuilder builder = new StringBuilder();
        for (Map<String, Object> map : list) {
            builder.append(map.toString()).append(";");
        }
        return builder.toString();
    }

    /**
     * 将实际执行数据转换为字符串
     * @param params
     * @return
     */
    private String paramsToString(Map<String, String> params) {
        StringBuilder builder = new StringBuilder();
        for (Map.Entry<String, String> entry : params.entrySet()) {
            builder.append(entry.getKey()).append(":").append(entry.getValue()).append(String.valueOf((char) 10));
        }
        return builder.toString();
    }

    /**
     * 处理测试数据期望返回值内容中的“系统参数”和“自定义参数”
     * @param itdExpectResult 测试数据期望返回值
     * @return 处理后的测试数据期望返回值
     */
    private String handleExpectResult(String itdExpectResult) {
        itdExpectResult = StringUtils.deleteWhitespace(itdExpectResult);
        while (itdExpectResult.contains("[*")) {
            int firstIndex = itdExpectResult.indexOf("[*");
            String firstStr = itdExpectResult.substring(firstIndex, itdExpectResult.length());
            int secondIndex = firstStr.indexOf("]");
            if (secondIndex < 0) {
                logger.info("处理测试数据期望返回值出错，系统参数格式有误: " + itdExpectResult);
            }
            String systemParam = firstStr.substring(0, secondIndex + 1);
            String value = getDateString(systemParam);
            itdExpectResult = itdExpectResult.replace(systemParam, value);
        }
        while (itdExpectResult.contains("[?")) {
            int firstIndex = itdExpectResult.indexOf("[?");
            String firstStr = itdExpectResult.substring(firstIndex, itdExpectResult.length());
            int secondIndex = firstStr.indexOf("]");
            if (secondIndex < 0) {
                logger.info("处理测试数据期望返回值出错，系统参数格式有误: " + itdExpectResult);
            }
            String customParam = firstStr.substring(0, secondIndex + 1);
            String value = getValueFromDB(customParam);
            itdExpectResult = itdExpectResult.replace(customParam, value);
        }
        return itdExpectResult;
    }

    /**
     * 保存有SQL的成功记录
     * @param testData 测试数据记录
     * @param responseResult Http执行结果
     * @param sqlExecuteResult sql期望结果
     */
    private void saveSuccessDataOfSql(IftbTestData testData, ResponseResult responseResult, String sqlExecuteResult) {
        TstbResultTestData resultTestData = new TstbResultTestData();
        resultTestData.setItdId(testData.getItdId());
        resultTestData.setTrtdName(testData.getItdName());
        resultTestData.setTrtdTime("0:0");
        resultTestData.setTrtdErrorDescription("成功");
        resultTestData.setTrtdExecuteResult(responseResult.getExecuteResult());
        resultTestData.setTrtdStatusCode(responseResult.getStatusCode());
        resultTestData.setTrtdResult(Constants.DATA_SUCCESS);
        resultTestData.setTrtdSqlExpectResult(testData.getItdSqlExpectResult());
        resultTestData.setTrtdSqlExecuteResult(sqlExecuteResult);
        resultTestData.setTrtdSqlComparedResult(Constants.DATA_SUCCESS);
        saveTestData(resultTestData);
    }

    /**
     * 保存SQL不一致的测试数据记录
     * @param testData 测试数据记录
     * @param responseResult Http执行结果
     * @param sqlExecuteResult sql期望结果
     */
    private void saveFailDataOfDifferentSqlResult(IftbTestData testData, ResponseResult responseResult, String sqlExecuteResult, String realParam) {
        TstbResultTestData resultTestData = new TstbResultTestData();
        resultTestData.setItdId(testData.getItdId());
        resultTestData.setTrtdName(testData.getItdName());
        resultTestData.setTrtdTime("0:0");
        resultTestData.setTrtdErrorDescription("SQL返回值不一致");
        resultTestData.setTrtdExecuteResult(responseResult.getExecuteResult());
        resultTestData.setTrtdStatusCode(responseResult.getStatusCode());
        resultTestData.setTrtdResult(Constants.DATA_FAILURE);
        resultTestData.setTrtdSqlExpectResult(testData.getItdSqlExpectResult());
        resultTestData.setTrtdSqlExecuteResult(sqlExecuteResult);
        resultTestData.setTrtdData(realParam);
        resultTestData.setTrtdSqlComparedResult(Constants.DATA_FAILURE);
        saveTestData(resultTestData);
    }

    /**
     * 保存无SQL执行结果的测试数据记录
     * @param testData 测试数据记录
     * @param responseResult Http执行结果
     */
    private void saveFailDataOfSql(IftbTestData testData, ResponseResult responseResult, String realParam) {
        TstbResultTestData resultTestData = new TstbResultTestData();
        resultTestData.setItdId(testData.getItdId());
        resultTestData.setTrtdName(testData.getItdName());
        resultTestData.setTrtdTime("0:0");
        resultTestData.setTrtdErrorDescription("SQL无执行结果");
        resultTestData.setTrtdExecuteResult(responseResult.getExecuteResult());
        resultTestData.setTrtdStatusCode(responseResult.getStatusCode());
        resultTestData.setTrtdResult(Constants.DATA_FAILURE);
        resultTestData.setTrtdSqlExpectResult(testData.getItdSqlExpectResult());
        resultTestData.setTrtdSqlExecuteResult("");
        resultTestData.setTrtdSqlComparedResult(Constants.DATA_FAILURE);
        resultTestData.setTrtdData(realParam);
        saveTestData(resultTestData);
    }

    /**
     * 保存没有SQL的成功记录
     * @param testData 测试数据记录
     * @param responseResult Http执行结果
     */
    private void saveSucessDataOfNoSql(IftbTestData testData, ResponseResult responseResult) {
        TstbResultTestData resultTestData = new TstbResultTestData();
        resultTestData.setItdId(testData.getItdId());
        resultTestData.setTrtdName(testData.getItdName());
        resultTestData.setTrtdTime("0:0");
        resultTestData.setTrtdErrorDescription("成功");
        resultTestData.setTrtdExecuteResult(responseResult.getExecuteResult());
        resultTestData.setTrtdStatusCode(responseResult.getStatusCode());
        resultTestData.setTrtdResult(Constants.DATA_SUCCESS);
        resultTestData.setTrtdSqlExpectResult(testData.getItdSqlExpectResult());
        saveTestData(resultTestData);
    }

    /**
     * 保存执行返回结果不一致的测试数据记录
     * @param testData 测试数据记录
     * @param responseResult Http执行结果
     */
    private void saveTestDataOfDifferentResult(IftbTestData testData, ResponseResult responseResult, List<String> resultList, String realParam) {
        StringBuilder builder = new StringBuilder();
        for (String string : resultList) {
            builder.append(string).append(String.valueOf((char)10));
        }
        TstbResultTestData resultTestData = new TstbResultTestData();
        resultTestData.setItdId(testData.getItdId());
        resultTestData.setTrtdName(testData.getItdName());
        resultTestData.setTrtdTime("0:0");
        resultTestData.setTrtdErrorDescription("执行返回结果不一致");
        resultTestData.setTrtdExecuteResult(responseResult.getExecuteResult());
        resultTestData.setTrtdStatusCode(responseResult.getStatusCode());
        resultTestData.setTrtdResult(Constants.DATA_FAILURE);
        resultTestData.setTrtdSqlExpectResult(testData.getItdSqlExpectResult());
        resultTestData.setTrtdErrorDetail(builder.toString());
        resultTestData.setTrtdData(realParam);
        saveTestData(resultTestData);
    }

    /**
     * 保存Http请求错误的测试数据记录
     * @param testData 测试数据记录
     * @param responseResult Http执行结果
     */
    private void saveTestDataOfHttpError(IftbTestData testData, ResponseResult responseResult, String realParam) {
        TstbResultTestData resultTestData = new TstbResultTestData();
        resultTestData.setItdId(testData.getItdId());
        resultTestData.setTrtdName(testData.getItdName());
        resultTestData.setTrtdTime("0:0");
        resultTestData.setTrtdErrorDescription("Http请求出错");
        resultTestData.setTrtdStatusCode(responseResult.getStatusCode());
        resultTestData.setTrtdResult(Constants.HTTP_ERROR);
        resultTestData.setTrtdData(realParam);
        saveTestData(resultTestData);
    }

    /**
     * 比较实际结果与预期结果(不含通配符)
     * @param realResult 实际结果
     * @param expectResult 预期结果
     * @return 0数据一致，1数据不符
     */
    @SuppressWarnings("unchecked")
    private boolean compareSQLResult(String realResult, String expectResult) {
        realResult = realResult.replace("\\\"", "\"");
        realResult = realResult.replace("\\", "");
        expectResult = expectResult.replace("\\\"", "\"");
        expectResult = expectResult.replace("\\", "");
        realResult = StringUtils.deleteWhitespace(realResult);
        expectResult = StringUtils.deleteWhitespace(expectResult);
        // 使用正则表达式，消除无效小数点".0"
        realResult = realResult.replaceAll("\\.0+\\s", "");
        expectResult = expectResult.replaceAll("\\.0+\\s", "");
        realResult = realResult.replaceAll("\\.0+,", ",");
        expectResult = expectResult.replaceAll("\\.0+,", ",");
        realResult = realResult.replaceAll("\\.0+}", "}");
        expectResult = expectResult.replaceAll("\\.0+}", "}");

        if (!expectResult.endsWith(";")) {
            expectResult = expectResult + ";";

        }
        return StringUtils.equals(realResult, expectResult);
    }

    /**
     * 比较执行返回结果
     * @param expectResult 期望值
     * @param actualResult 实际返回值
     * @return true数据一致, false数据不一致
     */
    private List<String> compareResult(String expectResult, String actualResult) {
        List<String> failReasonList = new ArrayList<String>();
        if ("success".equalsIgnoreCase(expectResult.trim())) {
            return failReasonList;
        }
        expectResult =  handleExpectResult(expectResult);

        // 消除值为数字时的双引号""
        actualResult = removeDoubleQuotation(actualResult);

        expectResult = expectResult.replaceAll("“", "\"");
        expectResult = expectResult.replaceAll("”", "\"");
        expectResult = removeDoubleQuotation(expectResult);

        actualResult = StringUtils.deleteWhitespace(actualResult);
        expectResult = StringUtils.deleteWhitespace(expectResult);

        // 使用正则表达式，消除无效小数点".0"
        actualResult = actualResult.replaceAll("\\.0+\"", "\"");
        expectResult = expectResult.replaceAll("\\.0+\"", "\"");
        actualResult = actualResult.replaceAll("\\.0+,", ",");
        expectResult = expectResult.replaceAll("\\.0+,", ",");
        actualResult = actualResult.replaceAll("\\.0+}", "}");
        expectResult = expectResult.replaceAll("\\.0+}", "}");

        JSONCompareResult result;
        try {
            result = JSONCompare.compareJSON(expectResult, actualResult, JSONCompareMode.LENIENT);
        } catch (JSONException e) {
            logger.info("比较执行返回结果时解析出错: " + e.getMessage());
            String failReason = "比较执行返回结果时解析出错: " + e.getMessage();
            failReasonList.add(failReason);
            return failReasonList;
        }
        List<FieldComparisonFailure> missingList = result.getFieldMissing();
        if (missingList.size() > 0) {
            for (FieldComparisonFailure missing : missingList) {
                String expect = String.valueOf(missing.getExpected()).trim();
                String field = missing.getField();
                String failReason = field + ": 期望结果是" + expect + "，无实际结果";
                failReasonList.add(failReason);
            }
            return failReasonList;
        }
        List<FieldComparisonFailure> failureList = result.getFieldFailures();
        for (FieldComparisonFailure failure: failureList) {
            String expect = String.valueOf(failure.getExpected()).trim();
            expect = expect.replace("\"", "");
            String actual = String.valueOf(failure.getActual()).trim();
            String field = failure.getField();
            if ("###".equals(expect)) {
                continue;
            }
            if (expect.trim().startsWith("[*")) {
                String date = getDateString(expect);
                if (!actual.equals(date)) {
                    String failReason = field + ": 期望结果是" + date + "，实际结果是" + actual;
                    failReasonList.add(failReason);
                }
                continue;
            }
            if (expect.trim().startsWith("[?")) {
                String value = getValueFromDB(expect);
                if (!actual.equals(value)) {
                    String failReason = field + ": 期望结果是" + value + "，实际结果是" + actual;
                    failReasonList.add(failReason);
                }
                continue;
            }
            if (actual.equals(expect)) {
                continue;
            }
            String failReason = field + ": 期望结果是" + expect + "，实际结果是" + actual;
            failReasonList.add(failReason);
        }
        return failReasonList;
    }

    /**
     * 移除值为数字时的双引号""
     * @param result 返回值期望结果或者执行结果
     * @return 移除双引号后的字符串
     */
    private String removeDoubleQuotation(String result) {
        Pattern pattern = Pattern.compile("\"(\\d+|[1-9]\\d*\\.\\d*|0\\.\\d*[1-9]\\d*)\"");
        Matcher matcher = pattern.matcher(result);
        while (matcher.find()) {
            String matchValue = matcher.group();
            String replacement = matchValue.replace("\"", " ");
            result = result.replace(matchValue, replacement);
        }
        return result;
    }

    /**
     * 获取赋值公式并设置对应动态参数值
     * @param testData 测试数据
     */
    private void getFormulaAndSetValue(IftbTestData testData, String executeResult, Map<String, String> params) {
        logger.info("测试数据" + testData.getItdName() + "进行自定义赋值");
        List<MstbDynamicParam> list;
        try {
            MstbDynamicParamDao dynamicParamDao = (MstbDynamicParamDao) daoMap.get("dynamicParamDao");
            list = dynamicParamDao.getDynamicParamListByItdId(testData.getItdId());
        } catch (Exception e) {
            logger.error("获取赋值公式时出错", e);
            throw new RuntimeException("获取赋值公式时出错", e);
        }
        if (CollectionUtils.isEmpty(list)) {
            return;
        }
        for (MstbDynamicParam dynamicParam : list) {
            String mdpName = dynamicParam.getMdpName().trim();
            String mdpFormula = dynamicParam.getMdpFormula().trim();
            byte mdpType = dynamicParam.getMdpType();
            if (mdpType == 1) {
                // SQL赋值
                getValueFromSQLFormula(mdpFormula, mdpName);
            } else if (mdpType == 2){
                // 接口返回值赋值
                getInterfaceReturnValue(mdpName, mdpFormula, executeResult);
            } else {
                // 时间参数返回值
                getDateParamValue(mdpName, mdpFormula, params);
            }
        }
    }

    /**
     * 执行赋值公式里的sql
     * @param sql
     * @return 执行结果
     */
    private String getValueFromSQLFormula(String sql, String mdpName){
        List<Map<String, Object>> list = null;
        try {
            list = executeQuery(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Map<String, Object> map;
        if (list.size() > 0){
            //{key=value}
            map = list.get(0);
            String result = map.toString();
            String[] array = result.split("=");
            result = array[1];
            //执行赋值公式返回的结果，把该结果更新至该条记录所在的动态值字段
            result = result.substring(0, result.length() - 1);
            updateValue(result, mdpName);
            return result;
        }else {
            logger.info("自定义参数SQL赋值时，数据库无记录");
            return "";
        }
    }

    /**
     * 更新数据库
     * @param result 参数值
     * @param mdpName 参数名
     * @return
     */
    private int updateValue(String result, String mdpName) {
        logger.info("更新自定义参数" + mdpName + "的值" + result);
        String db = CommonUtils.getProperties(Constants.SYSTEM_PROPERTIES, "database.name");
        String sql = "UPDATE " + db + ".mstb_dynamic_param SET mdp_value = '" + result + "' WHERE mdp_name = '" + mdpName + "'";
        logger.info("更新语句：" + sql);
        try {
            executeUpdate(sql);
        } catch (Exception e) {
            logger.error("更新自定义参数", e);
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * 根据请求参数更新数据库中的动态参数值
     * @param mdpName 参数名
     * @param mdpFormula 赋值方式，即时间参数
     * @param params 请求参数
     */
    private void getDateParamValue(String mdpName, String mdpFormula, Map<String, String> params) {
        if (params.containsKey(mdpFormula)) {
            String value = params.get(mdpFormula);
            updateValue(value, mdpName);
        }
    }

    /**
     * 根据接口返回值更新数据库中的动态参数值
     * @param mdpName 参数名
     * @param mdpFormula 赋值方式，即接口参数名
     * @param executeResult 接口返回结果
     * @return
     */
    private String getInterfaceReturnValue(String mdpName, String mdpFormula, String executeResult) {
        JSONObject jobj = JSON.parseObject(executeResult);
        JSONObject x = (JSONObject)jobj.get("data");
        //获取接口返回值
        String value = String.valueOf(x.get(mdpFormula));
        System.out.println("接口返回值："+value);
        updateValue(value, mdpName);
        return "";
    }

    /**
     * 判断测试数据是否存在赋值公式
     * @param testData 测试数据
     * @return true存在  false不存在
     */
    private boolean checkAssignmentIsExist(IftbTestData testData) {
        String db = CommonUtils.getProperties("system.properties", "database.name");
        String sql = "SELECT mdp_type FROM " + db + ".mstb_dynamic_param WHERE itd_id = " + String.valueOf(testData.getItdId());
        System.out.println("检测是否存在赋值方式的sql："+sql);
        List<Map<String, Object>> list;
        try {
            list = executeQuery(sql);
        } catch (Exception e) {
            logger.error("查询赋值参数出错", e);
            e.printStackTrace();
            return false;
        }
        if (list.size() > 0){
            return true;
        }else {
            return false;
        }
    }

    /**
     * 将测试数据的参数和值转换成Map对象
     * @param cols 参数名
     * @param vals 参数值
     * @return
     */
    private Map<String, String> handleParams(String cols, String vals) {
        Map<String, String> map = new LinkedHashMap<String, String>();
        if (StringUtils.isBlank(cols)) {
            return map;
        }
        String[] names = cols.split(Constants.PARAMS_SEPARATOR);
        String[] values = StringUtils.splitByWholeSeparatorPreserveAllTokens(vals, Constants.PARAMS_SEPARATOR, names.length);

        for (int i = 0; i < names.length; i++) {
            String typeOfParam = checkParamIsStaticOrDynamic(values[i]);
            if (typeOfParam.equals(Constants.STATIC_PARAM)){
                //是静态参数则需要获取当前时间值
                values[i] = getDateString(values[i]);
                map.put(names[i], values[i]);
            }else if (typeOfParam.equals(Constants.DYNAMIC_PARAM)){
                //动态参数则需要从数据库获取值
                values[i] = getValueFromDB(values[i]);
                map.put(names[i], values[i]);
            }else {
                //不是静态也不是动态直接获取值
                map.put(names[i], values[i]);
            }
        }
        return map;
    }

    /**
     * 从数据库获取动态参数的值
     * @param param 参数名
     * @return 参数值
     */
    private String getValueFromDB(String param) {
        String time = "";
        if (param.contains("&")) {
            time = StringUtils.substringBetween(param, "&", "]");
            int index = param.indexOf("&");
            param = param.substring(0, index + 1);
        }
        //分割参数获取实际的参数名称
        String db = CommonUtils.getProperties("system.properties", "database.name");
        param = StringUtils.deleteWhitespace(param);
        param = param.substring(2, param.length() - 1);
        System.out.println("参数"+param);
        String sql = "SELECT mdp_value FROM " + db + ".mstb_dynamic_param WHERE mdp_name = '" + param + "'";
        System.out.println("getValueFromDB:"+sql);
        List<Map<String, Object>> list = null;
        try {
            list = executeQuery(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Map<String, Object> map;
        if (list.size() > 0){
            map = list.get(0);
            //查询返回值的形式是{key=value}，需要分割才能提取出具体的值
            if (map == null) {
                return "";
            }
            String result  = map.toString();
            result = StringUtils.deleteWhitespace(result);
            int location = result.indexOf("=");
            //获取具体的值
            result = result.substring(location + 1, result.length() - 1) + time;
            System.out.println("具体的值："+result);
            return result;
        }else {
            return "";
        }
    }

    /**
     * 获取当前日期字符串（忽略关键字Y, M, D, H, F, S的大小写）
     * @param dateParam 日期参数
     * @return 日期
     */
    private String getDateString(String dateParam) {
        dateParam = StringUtils.deleteWhitespace(dateParam);
        dateParam = dateParam.toUpperCase();
        if (dateParam.contains(Constants.INTERFACE_STATIC_PARAM_DAY)){
            dateParam = dateParam.replace(Constants.INTERFACE_STATIC_PARAM_DAY, "");
            int year = getValueDateParam(dateParam, "Y");
            int month = getValueDateParam(dateParam, "M");
            int day = getValueDateParam(dateParam, "D");
            Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.YEAR, year);
            calendar.add(Calendar.MONTH, month);
            calendar.add(Calendar.DATE, day);
            //增加的时间段
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date date = calendar.getTime();
            return dateFormat.format(date);
        }else if (dateParam.contains(Constants.INTERFACE_STATIC_PARAM_SECOND)){
            dateParam = dateParam.replace(Constants.INTERFACE_STATIC_PARAM_SECOND, "");
            int year = getValueDateParam(dateParam, "Y");
            int month = getValueDateParam(dateParam, "M");
            int day = getValueDateParam(dateParam, "D");
            int hour = getValueDateParam(dateParam, "H");
            int minute = getValueDateParam(dateParam, "F");
            int second = getValueDateParam(dateParam, "S");
            Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.YEAR, year);
            calendar.add(Calendar.MONTH, month);
            calendar.add(Calendar.DATE, day);
            calendar.add(Calendar.HOUR_OF_DAY, hour);
            calendar.add(Calendar.MINUTE, minute);
            calendar.add(Calendar.SECOND, second);
            Date date = calendar.getTime();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            return dateFormat.format(date);
        }else {
            logger.info("时间参数格式有误，参数为" + dateParam);
            throw new RuntimeException("时间参数格式有误，参数为" + dateParam);
        }
    }

    /**
     * 获取时间增量
     * @param dateParam 时间参数
     * @return 增量
     */
    private int getValueDateParam(String dateParam, String type) {
        String upperCaseParam = dateParam.toUpperCase();
        if (!upperCaseParam.contains(type)) {
            return 0;
        }
        // 正负号
        char flag = upperCaseParam.charAt(upperCaseParam.indexOf(type) - 1);
        String[] splitStrs = upperCaseParam.split(type);
        String str1 = splitStrs[1];
        int minusIndex = str1.indexOf("-");
        int plusIndex = str1.indexOf("+");
        int index;
        if (minusIndex == -1 && plusIndex == -1) {
            index = str1.length() - 1;
        } else if (minusIndex == -1 || plusIndex == -1) {
            index = Math.max(minusIndex, plusIndex);
        } else {
            index = Math.min(minusIndex, plusIndex);
        }
        String value = str1.substring(0, index);
        return Integer.valueOf(flag + value);
    }

    /**
     * 检测参数是否是静态参数
     * @param param 参数
     * @return 检测结果
     */
    private boolean checkStaticParam(String param){
        if (param.contains(Constants.INTERFACE_STATIC_PARAM_DAY)){
            return true;
        }else if (param.contains(Constants.INTERFACE_STATIC_PARAM_SECOND)){
            return true;
        }else {
            return false;
        }
    }

    /**
     * 检测参数是动态参数还是静态参数
     * @param param 参数
     * @return 参数类型
     */
    private String checkParamIsStaticOrDynamic(String param){
        param = StringUtils.deleteWhitespace(param);
        if (param.contains(Constants.INTERFACE_DYNAMIC_PARAM)){
            return Constants.DYNAMIC_PARAM;
        }else if (param.contains(Constants.INTERFACE_STATIC_PARAM)){
            return Constants.STATIC_PARAM;
        }else {
            return param;
        }
    }

    /**
     * 保存测试数据结果
     * @param resultTestData
     */
    private void saveTestData(TstbResultTestData resultTestData) {
        try {
            TstbResultTestDataDao resultTestDataDao = (TstbResultTestDataDao) daoMap.get("resultTestDataDao");
            resultTestDataDao.save(resultTestData);
        } catch (Exception e) {
            throw new RuntimeException("保存失败的测试数据时报错", e);
        }
    }

    /**
     * 判断前置数据执行结果
     * @param dependens 前置数据id
     * @return true存在前置数据失败, false所有前置数据成功
     */
    private List<String> getDependencyFail(String dependens) {
        TstbResultTestDataDao resultTestDataDao = (TstbResultTestDataDao) daoMap.get("resultTestDataDao");
        List<String> dependNameList = new ArrayList<String>();
        if (StringUtils.isBlank(dependens)) {
            return dependNameList;
        }
        boolean flag = false;
        if (dependens.contains(Constants.PARAMS_SEPARATOR)) {
            String[] strings = dependens.split(Constants.PARAMS_SEPARATOR);
            try {
                for (String str : strings) {
                    int itdId = Integer.valueOf(str);
                    if (itdId == 0) {
                        continue;
                    }
                    TstbResultTestDataCriteria criteria = new TstbResultTestDataCriteria();
                    criteria.createCriteria().andItdIdEqualTo(itdId);
                    TstbResultTestData resultTestData = resultTestDataDao.ReadSingle(criteria);
                    String dependName = resultTestData.getTrtdName();
                    if (StringUtils.isBlank(dependName)) {
                        dependName = "此前置数据名称为空，它的数据库id为" + resultTestData.getItdId();
                    }
                    dependNameList.add(dependName);
                    if (resultTestData.getTrtdResult() != Constants.SUCCESS) {
                        flag = true;
                    }
                }
                if (flag) {
                    return dependNameList;
                }
                return new ArrayList<String>();
            } catch (Exception e) {
                logger.info("判断前置数据执行结果时出错", e);
                throw new RuntimeException("判断前置数据执行结果时出错", e);
            }
        }
        try {
            int itdId = Integer.valueOf(dependens);
            TstbResultTestDataCriteria criteria = new TstbResultTestDataCriteria();
            criteria.createCriteria().andItdIdEqualTo(itdId);
            TstbResultTestData resultTestData = resultTestDataDao.ReadSingle(criteria);
            if (resultTestData.getTrtdResult() != Constants.SUCCESS) {
                String dependName = resultTestData.getTrtdName();
                if (StringUtils.isBlank(dependName)) {
                    dependName = "此前置数据名称为空，它的数据库id为" + resultTestData.getItdId();
                }
                dependNameList.add(dependName);
                return dependNameList;
            }
            return new ArrayList<String>();
        } catch (Exception e) {
            logger.info("判断前置数据执行结果时出错", e);
            throw new RuntimeException("判断前置数据执行结果时出错", e);
        }
    }

    private void setUrlPrefix() {
        MstbProjectCriteria criteria = new MstbProjectCriteria();
        try {
            MstbProjectDao projectDao = (MstbProjectDao) daoMap.get("projectDao");
            MstbProject project = projectDao.ReadAll(criteria).get(0);
            urlPrefix = project.getMpUrlPrefixion();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
