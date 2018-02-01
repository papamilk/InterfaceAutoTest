package blk.interfacetesting.component;

import blk.common.exception.BusinessException;
import blk.common.exception.SystemException;
import blk.common.util.CommonUtils;
import blk.common.util.Constants;
import blk.interfacetesting.dao.data.IftbExecuteMainDao;
import blk.interfacetesting.dao.data.MstbProjectDao;
import blk.interfacetesting.modle.data.*;
import blk.interfacetesting.service.impl.common.AttachmentServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.JSONException;
import org.skyscreamer.jsonassert.JSONCompare;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Mark
 * @date 2018/1/24
 */
@Component
@Scope(value = WebApplicationContext.SCOPE_REQUEST,
        proxyMode = ScopedProxyMode.TARGET_CLASS)
public class ExcelParser {
    private static final Logger logger = LoggerFactory.getLogger(AttachmentServiceImpl.class);

    @Autowired
    private MstbProjectDao projectDao;
    @Autowired
    private IftbExecuteMainDao executeMainDao;

    /**
     * 全局自定义参数Map集合
     */
    private Map<String, MstbDynamicParam> globalDynamicParamMap =new HashMap<String, MstbDynamicParam>();

    /**
     * 标识录入数据是否符合规范
     */
    private boolean globalFlag = true;

    /**
     * 测试参数设置Map集合
     */
    private Map<String, String> globalParamSheetMap;

    /**
     * 数据验证信息，用于返回前台显示
     */
    private List<String> validationInfoList = new ArrayList<String>();


    private XSSFWorkbook xssfWorkbook;

    /**
     * 读取Excel文件流中数据，返回Map集合
     * @param is 数据流
     * @return Map对象
     * keys: interface, testCase, testData
     * values: 接口数据集合, 用例数据集合, 测试数据集合
     * 接口数据集合：
     * key: mumNum, url, parametersList
     * value: 接口编号, 接口对象, 接口参数集合
     * 用例数据集合：
     * key: tcNum, tc, mumNums
     * value: 用例编号, 用例对象, 接口编号集合
     * 测试数据集合：
     * key: tcNum, interface
     * value: 用例编号, 接口Map对象
     */
    public Map<String, Object> parse(InputStream is, boolean isOverWrite){
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            xssfWorkbook = new XSSFWorkbook(is);
        } catch (IOException e) {
            logger.warn("不能将文件转换成XSSFWorkbook对象", e);
            throw new SystemException("不能将文件转换成XSSFWorkbook对象", e);
        }
        Map<String, Object> paramMap = parseParamSheet(xssfWorkbook, isOverWrite);
        if (!isOverWrite && null != paramMap.get("iemNameInvalid")) {
            return paramMap;
        }
        map.putAll(paramMap);
        map.put("interface", parseInterfaceSheet(xssfWorkbook));
        map.put("testCase", parseTestCaseSheet(xssfWorkbook));
        map.put("testData", parseTestDataSheet(xssfWorkbook));
        map.put("flag", globalFlag);
        map.put("validationInfoList", validationInfoList);

        return map;
    }

    /**
     * 解析测试参数设置Sheet页
     * @param xssfWorkbook Excel文件对象
     */
    private Map<String, Object> parseParamSheet(XSSFWorkbook xssfWorkbook, boolean isOverWrite) {
        globalParamSheetMap = new HashMap<String, String>();
        Map<String, Object> map = new HashMap<String, Object>();
        XSSFSheet sheet = xssfWorkbook.getSheet(PARAM_SHEET_NAME);
        int column01 = 1;
        int column02 = 2;

        // 自动化测试相关信息
        int firstRow = 3;
        int row = firstRow;
        String projectName = getCellValue(sheet.getRow(row).getCell(column02));
        // 查询项目相关信息
        MstbProjectCriteria projectCriteria = new MstbProjectCriteria();
        projectCriteria.createCriteria().andMpNameEqualTo(projectName);
        MstbProject mstbProject = projectDao.ReadSingle(projectCriteria);

        String iemName = getCellValue(sheet.getRow(row + 1).getCell(column02));
        String iemType = getCellValue(sheet.getRow(row + 2).getCell(column02));
        String childSystem = getCellValue(sheet.getRow(row + 3).getCell(column02));
        String codeVersion = getCellValue(sheet.getRow(row + 4).getCell(column02));
        String description = getCellValue(sheet.getRow(row + 5).getCell(column02));

        row = 10;
        String urlPrefix = getCellValue(sheet.getRow(row).getCell(column02));

        if (null != mstbProject) {
            // 验证一个项目下的场景名称是否唯一
            IftbExecuteMainCriteria mainCriteria = new IftbExecuteMainCriteria();
            mainCriteria.createCriteria()
                    .andMpIdEqualTo(mstbProject.getMpId())
                    .andIemNameEqualTo(iemName);
            IftbExecuteMain executeMain = executeMainDao.ReadSingle(mainCriteria);
            if (null != executeMain) {
                if (isOverWrite) {
                    // 删除该场景下的所有数据库记录
                    executeMainDao.deleteAll(executeMain.getIemId());
                } else {
                    map.put("iemNameInvalid", iemName);
                    return map;
                }
            }
        } else {
            mstbProject = new MstbProject();
            mstbProject.setMpName(projectName);
            mstbProject.setMpUrlPrefixion(urlPrefix);
        }

        IftbExecuteMain executeMain = new IftbExecuteMain();
        executeMain.setIemName(iemName);
        executeMain.setIemType(iemType);
        executeMain.setCSystem(childSystem);
        executeMain.setCodeVersion(codeVersion);
        executeMain.setDescription(description);
        executeMain.setUrlPrefix(urlPrefix);

        // 测试数据库名称
        int dbNameFirstRow = 14;
        int dbNameLastRow = 23;
        row = dbNameFirstRow;
        XSSFRow xssfRow = sheet.getRow(row);
        while (row < dbNameLastRow) {
            String paramName = getCellValue(xssfRow.getCell(column01));
            String dbName = getCellValue(xssfRow.getCell(column02));
            if (StringUtils.isNotBlank(paramName)) {
                if (globalParamSheetMap.containsKey(paramName)) {
                    String validationInfo = "测试参数设置sheet页第" + (row + 1) + "行第" + CommonUtils.toRadix(column01 + 1) + "列的参数名称重复定义";
                    logger.warn(validationInfo);
                    validationInfoList.add(Constants.MSG_WARN_PREFIX + validationInfo);
                    globalFlag = false;
                } else {
                    globalParamSheetMap.put(paramName, dbName);
                }
            }
            row = row + 1;
            xssfRow = sheet.getRow(row);
        }

        // 接口执行成功返回数据
        int standardTrueRow = 26;
        xssfRow = sheet.getRow(standardTrueRow );
        String standardTrue = getCellValue(xssfRow.getCell(column01));
        globalParamSheetMap.put(PARAM_STANDARD_TRUE, standardTrue);

        // 场景参数设置（与自定义参数相关）
        setSceneParam(sheet);

        map.put("executeMain", executeMain);
        map.put("mstbProject", mstbProject);
        return map;
    }

    /**
     * 场景参数设置（与自定义参数相关）
     * @param sheet
     */
    private void setSceneParam(XSSFSheet sheet) {
        int row = 4;
        int column1 = 4;
        int column2 = 7;

        for (int i = row; i < 50; i++) {
            XSSFRow xssfRow = sheet.getRow(i);
            if (xssfRow == null) {
                break;
            }
            String paramName = getCellValue(xssfRow.getCell(column1)).trim();
            String paramValue = getCellValue(xssfRow.getCell(column2)).trim();
            if (StringUtils.isBlank(paramName + paramValue)) {
                break;
            }
            if (!validateSceneParam(paramName)) {
                String validationInfo = "测试参数设置sheet页第" + (row + 1) + "行" + "第" + CommonUtils.toRadix(column1 + 1) + "列的自定义参数名格式有误";
                logger.warn(validationInfo);
                validationInfoList.add(Constants.MSG_WARN_PREFIX + validationInfo);
                globalFlag = false;
            }
            paramName = paramName.substring(1, paramName.length() - 1);
            if (globalDynamicParamMap.containsKey(paramName)) {
                String validationInfo = "测试参数设置sheet页第" + (row + 1) + "行" + "第" + CommonUtils.toRadix(column1 + 1) + "列的自定义参数名重复";
                logger.warn(validationInfo);
                validationInfoList.add(Constants.MSG_WARN_PREFIX + validationInfo);
                globalFlag = false;
            }
            MstbDynamicParam dynamicParam = new MstbDynamicParam();
            dynamicParam.setMdpName(paramName);
            dynamicParam.setMdpValue(paramValue);
            globalDynamicParamMap.put(paramName, dynamicParam);
        }
    }

    /**
     * 验证场景参数名
     * @param paramName 场景参数名
     * @return true表示符合格式, false不符合
     */
    private boolean validateSceneParam(String paramName) {
        return paramName.startsWith("[") && paramName.endsWith("]");
    }


    /**
     * 解析测试数据sheet
     * @param xssfWorkbook Excel文件对象
     * @return 测试数据Map对象集合
     * keys: tcNum, interface
     * values: 用例编号, 接口Map对象
     */
    public List<Map<String,Object>> parseTestDataSheet(XSSFWorkbook xssfWorkbook){
        logger.info("读取测试数据sheet...");
        XSSFSheet sheet = xssfWorkbook.getSheet(TESTDATA_SHEET_NAME);
        if (null == sheet) {
            String validationInfo = "找不到测试数据sheet，测试数据sheet名称应该为" + TESTDATA_SHEET_NAME;
            logger.warn(validationInfo);
            validationInfoList.add(Constants.MSG_WARN_PREFIX + validationInfo);
            globalFlag = false;
            throw new BusinessException("找不到测试数据sheet，测试数据sheet名称应该为" + TESTDATA_SHEET_NAME);
        }
        int[] markColNums = setMarkColumnNumber(sheet, TESTDATA_MARK, TESTDATA_MARK_ROW_NUM, TESTDATA_START_COLUMN, TESTDATA_END_COLUMN);
        logger.info("设置标识位成功 " + Arrays.toString(markColNums));
        List<CellRangeAddress> listCombineCell = getCombineCell(sheet);
        List<Map<String, Object>> dataList = new ArrayList<Map<String, Object>>();
        // 数据记录第一行序号
        int firstRowNum = TESTDATA_START_ROW;
        logger.info("数据记录开始行号为" + (firstRowNum + 1));
        Map<String, Object> testDataMap;
        logger.info("开始遍历测试数据sheet");
        while (!validateCell(sheet.getRow(firstRowNum), markColNums)) {
            testDataMap = parseTestDataRow(sheet, markColNums, firstRowNum, listCombineCell);
            firstRowNum = Integer.valueOf(testDataMap.get("lastRowNum") + "") + 1;
            testDataMap.remove("lastRowNum");
            dataList.add(testDataMap);
        }
        logger.info("结束遍历测试数据sheet，共解析到" + dataList.size() + "组测试数据");
        return dataList;
    }


    /**
     * 解析用例sheet页
     * @param xssfWorkbook Excel文件对象
     * @return 用例Map对象集合
     * keys: tcNum, tc, mumNums
     * values: 用例编号, 用例对象, 接口编号集合
     */
    private List<Map<String,Object>> parseTestCaseSheet(XSSFWorkbook xssfWorkbook) {
        XSSFSheet sheet = xssfWorkbook.getSheet(TESTCASE_SHEET_NAME);
        int[] markColNums = setMarkColumnNumber(sheet, TESTCASE_MARK, TESTCASE_MARK_ROW_NUM, TESTCASE_START_COLUMN, TESTCASE_END_COLUMN);
        List<CellRangeAddress> listCombineCell = getCombineCell(sheet);
        List<Map<String, Object>> dataList = new ArrayList<Map<String, Object>>();
        // 用例记录第一行序号
        int firstRowNum = TESTCASE_START_ROW;
        Map<String, Object> testCaseMap;
        while (!validateCell(sheet.getRow(firstRowNum), markColNums)) {
            testCaseMap = parseTestCaseRow(sheet, markColNums, firstRowNum, listCombineCell);
            firstRowNum = Integer.valueOf(testCaseMap.get("lastRowNum") + "") + 1;
            testCaseMap.remove("lastRowNum");
            dataList.add(testCaseMap);
        }
        return dataList;
    }

    /**
     * 解析接口sheet页
     * @param xssfWorkbook Excel文件对象
     * @return Map集合
     * keys: mumNum, url, parametersList
     * values: 接口编号, 接口对象, 接口参数集合
     */
    public List<Map<String,Object>> parseInterfaceSheet(XSSFWorkbook xssfWorkbook) {
        XSSFSheet sheet = xssfWorkbook.getSheet(INTERFACE_SHEET_NAME);
        int[] markColNums = setMarkColumnNumber(sheet, INTERFACE_MARK, INTERFACE_MARK_ROW_NUM, INTERFACE_START_COLUMN, INTERFACE_END_COLUMN);
        List<CellRangeAddress> listCombineCell = getCombineCell(sheet);
        List<Map<String, Object>> dataList = new ArrayList<Map<String, Object>>();
        // 接口记录第一行序号
        int firstRowNum = INTERFACE_START_ROW;
        Map<String, Object> interfaceMap;
        while (!validateCell(sheet.getRow(firstRowNum), markColNums)) {
            interfaceMap = parseInterfaceRow(sheet, markColNums, firstRowNum, listCombineCell);
            firstRowNum = Integer.valueOf(interfaceMap.get("lastRowNum") + "") + 1;
            interfaceMap.remove("lastRowNum");
            dataList.add(interfaceMap);
        }
        return dataList;
    }

    /**
     * 验证单元格内容是否为空
     * @param xssfRow 记录行
     * @return true表示为空，false不为空
     */
    public static boolean validateCell(XSSFRow xssfRow, int[] markColNums) {
        if (xssfRow == null) {
            return true;
        }
        String value = getCellValue(xssfRow.getCell(markColNums[0]));
        return StringUtils.isBlank(value);
    }

    /**
     * 解析测试数据sheet中以用例作为一行的记录
     * @param sheet 测试数据sheet对象
     * @param markColNums 标识位列序号数组
     * @param firstRowNum  首条记录所在行序号
     * @param listCombineCell 合并单元格集合
     * @return Map 对象
     * keys: tcNum, interface, lastRowNum
     * values: 用例编号, 接口Map对象, 末行所在行序号
     */
    public Map<String,Object> parseTestDataRow(XSSFSheet sheet, int[] markColNums, int firstRowNum, List<CellRangeAddress> listCombineCell){
        logger.info("当前记录的首行序号为" + (firstRowNum + 1));
        XSSFRow xssfRow = sheet.getRow(firstRowNum);
        // 当前用例记录第末行序号
        int lastRowNum = getLastRowNum(listCombineCell, xssfRow.getCell(TESTDATA_START_COLUMN));
        logger.info("当前记录的末行序号为" + (lastRowNum + 1));
        // 用例编号
        String tcNum = getCellValue(xssfRow.getCell(markColNums[0]));
        logger.info("当前记录的测试用例编号为" + tcNum);
        Map<String, List<Map<String, Object>>> interfaceMap = new HashMap<String, List<Map<String, Object>>>();
        for (int i = firstRowNum + 1; i < lastRowNum; i++) {
            xssfRow = sheet.getRow(i);
            int interfaceLastRowNum;
            // 接口编号
            String mumNum = getCellValue(xssfRow.getCell(markColNums[1]));
            logger.info("当前记录的接口编号为" + mumNum);
            //获取接口编号所在的合并单元格的最后一行行号
            if (isCombineCell(listCombineCell, xssfRow.getCell(markColNums[1]))){
                interfaceLastRowNum = getLastRowNum(listCombineCell, xssfRow.getCell(markColNums[1]));
            }else {
                //只有一个参数时接口编号的单元格不是合并的
                interfaceLastRowNum = i;
            }
            logger.info("当前接口编号所在合并单元格的最后一行行号为" + (interfaceLastRowNum + 1));
            // 测试数据集合（包括测试数据，前置数据，场景）
            List<Map<String, Object>> testDataList = parseTestDataList(sheet, markColNums, i, interfaceLastRowNum);
            interfaceLastRowNum += 3;
            i = interfaceLastRowNum;
            interfaceMap.put(mumNum, testDataList);
        }
        Map<String, Object> testDataMap = new HashMap<String, Object>();
        testDataMap.put("tcNum", tcNum);
        testDataMap.put("interface", interfaceMap);
        testDataMap.put("lastRowNum", lastRowNum);
        return testDataMap;
    }

    /**
     * 解析测试数据sheet中接口对应的测试数据组
     * @param sheet 测试数据sheet对象
     * @param markColNums 标志位所在列序号
     * @param firstRow 首条记录所在行序号
     * @param lastRow 末行记录所在行序号
     * @return 数据集合
     */
    private List<Map<String, Object>> parseTestDataList(XSSFSheet sheet, int[] markColNums, int firstRow, int lastRow){
        logger.info("解析测试数据...");
        int row = 0;
        int column = 0;
        try {
            // 参数名称
            StringBuilder colsBuilder = new StringBuilder();
            // 参数类型
            StringBuilder typesBuilder = new StringBuilder();
            for (int i = firstRow; i <= lastRow; i++) {
                row = i;
                XSSFRow xssfRow = sheet.getRow(row);
                column = markColNums[2];
                colsBuilder.append(getCellValue(xssfRow.getCell(column))).append(Constants.PARAMS_SEPARATOR);
                column = markColNums[3];
                typesBuilder.append(getCellValue(xssfRow.getCell(column))).append(Constants.PARAMS_SEPARATOR);
            }
            colsBuilder.setLength(colsBuilder.length() - 1);
            typesBuilder.setLength(typesBuilder.length() - 1);
            String cols = colsBuilder.toString();
            String types = typesBuilder.toString();
            List<Map<String, Object>> testDataList = new ArrayList<Map<String, Object>>();
            for (int i = 0; i < TESTDATA_TOTAL; i++) {
                // 根据 数据序号 >> 前置数据 判断测试数据记录的最后一列
                row = firstRow - 1;
                XSSFRow  xssfRow = sheet.getRow(row);
                column = TESTDATA_END_COLUMN + (i * 3 + 1);
                String head = getCellValue(xssfRow.getCell(column));
                if (StringUtils.isNotBlank(head)) {
                    // 处理字符串，先把数据序号 >> 前置数据#数据描述 根据“#”隔断
                    String[] valueArray = head.split(Constants.PARAMS_SEPARATOR, 2);
                    // 测试数据描述信息
                    String description = "";
                    if (valueArray.length == 2) {
                        description = valueArray[1];
                    }
                    //取#前面的部分，分割数据名称与依赖数据
                    head = valueArray[0];
                    String[] strs = splitStrs(head);
                    // 数据名称, 前置数据
                    String tdName, depend;
                    if (strs.length != 2) {
                        tdName = "";
                        depend = "NULL";
                    } else {
                        tdName = strs[0];
                        depend = strs[1];
                    }
                    row = firstRow;
                    xssfRow = sheet.getRow(row);
                    column = TESTDATA_END_COLUMN + (i * 3 + 3);
                    String expectResult = getCellValue(xssfRow.getCell(column)).trim();
                    if (!validateExpectResult(expectResult, row, column)) {
                        globalFlag = false;
                    }
                    if (PARAM_STANDARD_TRUE.equalsIgnoreCase(expectResult)) {
                        expectResult = globalParamSheetMap.get(PARAM_STANDARD_TRUE);
                    }
                    if (expectResult.startsWith("[")) {
                        expectResult = combineExpectResult(expectResult);
                    }
                    // 参数值
                    StringBuilder valsBuilder = new StringBuilder();
                    column = TESTDATA_END_COLUMN + (i * 3 + 1);
                    for (int j = firstRow; j <= lastRow; j++) {
                        row = j;
                        xssfRow = sheet.getRow(row);
                        String paramValue = getCellValue(xssfRow.getCell(column));
                        if (!validateParamValue(paramValue)) {
                            String validationInfo = TESTDATA_SHEET_NAME + "Sheet第" + (row + 1) + "行第" + CommonUtils.toRadix(column + 1) + "列的参数内容找不到对应的自定义参数";
                            logger.warn(validationInfo);
                            validationInfoList.add(Constants.MSG_WARN_PREFIX + validationInfo);
                            globalFlag = false;
                        }
                        valsBuilder.append(paramValue).append(Constants.PARAMS_SEPARATOR);
                    }
                    valsBuilder.setLength(valsBuilder.length() - 1);
                    // SQL语句
                    row = lastRow + 1;
                    xssfRow = sheet.getRow(row);
                    String sql = getCellValue(xssfRow.getCell(column));

                    if (!validateSQL(sql)) {
                        String validationInfo = TESTDATA_SHEET_NAME + "Sheet第" + (row + 1) + "行第" + CommonUtils.toRadix(column + 1) + "列的SQL语句没有限制返回记录数量";
                        logger.warn(validationInfo);
                        validationInfoList.add(Constants.MSG_WARN_PREFIX + validationInfo);
                        globalFlag = false;
                    }
                    sql = replaceSql(sql, row, column);
                    // SQL期望值
                    row = lastRow + 2;
                    xssfRow = sheet.getRow(row);
                    String sqlResult = getCellValue(xssfRow.getCell(column));
                    String[] sqlResultArray = sqlResult.split(";");
                    boolean flag = true;
                    if (sqlResultArray.length > 1) {
                        for (String resultStr : sqlResultArray) {
                            flag = validateSqlExpectResult(resultStr);
                        }
                        if (!flag) {
                            String validationInfo = TESTDATA_SHEET_NAME + "Sheet第" + (row + 1) + "行第" + CommonUtils.toRadix(column + 1) + "列的SQL期望结果格式有误";
                            logger.warn(validationInfo);
                            validationInfoList.add(Constants.MSG_WARN_PREFIX + validationInfo);
                            globalFlag = false;
                        }
                    } else {
                        if (!validateSqlExpectResult(sqlResult)) {
                            String validationInfo = TESTDATA_SHEET_NAME + "Sheet第" + (row + 1) + "行第" + CommonUtils.toRadix(column + 1) + "列的SQL期望结果格式有误";
                            logger.warn(validationInfo);
                            validationInfoList.add(Constants.MSG_WARN_PREFIX + validationInfo);
                            globalFlag = false;
                        }
                    }
                    // 动态参数
                    row = lastRow + 3;
                    List<MstbDynamicParam> dynamicParamList = getDynamicParamList(sheet, row, column);
                    IftbTestData testData = new IftbTestData();
                    testData.setItdName(tdName);
                    testData.setItdCols(cols);
                    testData.setItdValues(valsBuilder.toString());
                    testData.setItdParamTypes(types);
                    testData.setItdExpectResult(expectResult);
                    testData.setItdSql(sql);
                    testData.setItdSqlExpectResult(sqlResult);
                    testData.setItdNumber(description);
                    Map<String, Object> testDataMap = new HashMap<String, Object>();
                    testDataMap.put("testData", testData);
                    testDataMap.put("depend", depend);
                    testDataMap.put("dynamicParam", dynamicParamList);
                    testDataMap.put("firstRow", firstRow);
                    testDataMap.put("lastRow", lastRow);
                    testDataList.add(testDataMap);
                } else {
                    if (13 == (column + 1)) {
                        String validationInfo = TESTDATA_SHEET_NAME + "Sheet第" + (row + 1) + "行第" + CommonUtils.toRadix(column + 1) + "列可能没有填写测试数据名称";
                        logger.warn(validationInfo);
                        validationInfoList.add(Constants.MSG_WARN_PREFIX + validationInfo);
                    }
                    logger.info("第" + (row + 1) + "行第" + CommonUtils.toRadix(column + 1) + "列为空，该组测试数据解析结束...");
                    break;
                }
            }
            return testDataList;
        } catch (Exception e) {
            logger.info("测试数据sheet第" + (row + 1) + "行第" +
                    CommonUtils.toRadix(column + 1) + "列出错", e);
            throw new SystemException("测试数据sheet第" + (row + 1) + "行第" +
                    CommonUtils.toRadix(column + 1) + "列出错", e);
        }
    }

    /**
     * 根据特定的格式组装返回值期望结果：
     * [True]
     * [Data]
     * token=abcd,
     * [Error]
     * errorCode=ef,
     * errorMsgCN=gh
     *
     *   -->
     *
     * {
     *   resultType:true,
     *   data:{
     *      token=abcd
     *   },
     *   error:[{
     *     errorCode=ef,
     *     errorMsgCN=gh
     *   ]}
     * }
     *
     * @param expectResult 返回值期望结果
     * @return
     */
    public String combineExpectResult(String expectResult) {
        StringBuilder builder = new StringBuilder();
        builder.append("{resultType:");
        String upperCase = expectResult.toUpperCase();
        if (upperCase.contains("[TRUE]")) {
            builder.append("true");
        } else if (upperCase.contains("[FALSE]")) {
            builder.append("false");
        }
        builder.append(",");
        int dataIndex = upperCase.indexOf("[DATA]");
        String data = expectResult.substring(dataIndex + 6, upperCase.indexOf("[", dataIndex + 6));
        builder.append("data:{").append(data);
        builder.append("},");
        int errorIndex = upperCase.indexOf("[ERROR]");
        String error = expectResult.substring(errorIndex + 7);
        if (StringUtils.isBlank(error)) {
            builder.append("error:[]");
            builder.append("}");
        } else {
            builder.append("error:[{").append(error);
            builder.append("}]");
            builder.append("}");
        }
        return builder.toString();
    }

    /**
     * 用测试参数替换SQL中的数据库名称
     * @param sql
     * @return
     */
    private String replaceSql(String sql, int row, int column) {
        while (sql.contains("[")) {
            int firstIndex = sql.indexOf("[");
            int secondIndex = sql.indexOf("]");
            String param = sql.substring(firstIndex + 1, secondIndex);
            if (globalParamSheetMap.containsKey(param.trim())) {
                String value = globalParamSheetMap.get(param);
                String target = sql.substring(firstIndex, secondIndex + 1);
                sql = sql.replace(target, value);
            } else {
                String validationInfo = TESTDATA_SHEET_NAME + "Sheet第" + (row + 1) + "行第" + CommonUtils.toRadix(column + 1) + "列数据库名参数" + param
                        + "在“测试参数设置”sheet页没有对应值";
                logger.warn(validationInfo);
                validationInfoList.add(Constants.MSG_WARN_PREFIX + validationInfo);
                throw new IllegalArgumentException(validationInfo);
            }
        }
        return sql;
    }

    /**
     * 验证参数值使用的“自定义参数”是否合理
     * @param paramValue 参数值
     * @return true合理，false不合理
     */
    private boolean validateParamValue(String paramValue) {
        // 如果参数值没有使用"自定义参数"，直接返回true
        if (!paramValue.contains("[?")) {
            return true;
        }
        if (paramValue.contains("&")) {
            int index = paramValue.indexOf("&");
            paramValue = paramValue.substring(0, index + 1);
        }
        paramValue = StringUtils.deleteWhitespace(paramValue);
        paramValue = paramValue.substring(2, paramValue.length() - 1);
        return globalDynamicParamMap.containsKey(paramValue);
    }

    /**
     * 验证SQL期望结果是否符合Map.toString()的格式，如：{mc_id='24',mc_status='0'}
     * @param sqlResult SQL期望结果
     * @return true符合, false不符合
     */
    private boolean validateSqlExpectResult(String sqlResult) {
        if (StringUtils.isBlank(sqlResult)) {
            return true;
        }
        String trimStr = sqlResult.trim();
        if (!trimStr.startsWith("{")) {
            return false;
        }
        if (!trimStr.endsWith("}")) {
            return false;
        }
        if (trimStr.contains(",")) {
            String[] splitStrs = trimStr.split(",");
            for (String str : splitStrs) {
                String[] secendSplitStrs = str.split("=");
                if (secendSplitStrs.length > 2) {
                    return false;
                }
            }
        } else {
            String[] splitStrs = trimStr.split("=");
            if (splitStrs.length > 2) {
                return false;
            }
        }
        return true;
    }

    /**
     * 验证SQL是否限制返回记录为1条
     * @param sql 待执行的SQL语句
     * @return true是, false否
     */
    private boolean validateSQL(String sql) {
        if (StringUtils.isBlank(sql)) {
            return true;
        }
        // 验证SQL是否包含限制语句
        String validateSql = sql.toUpperCase();
        return validateSql.contains("LIMIT 1");
    }

    /**
     * 验证期望结果是否符合格式
     * @param expectResult 期望结果
     * @return true符合格式， false不符合格式
     */
    private boolean validateExpectResult(String expectResult, int row, int column) {
        if ("S_TRUE".equalsIgnoreCase(expectResult)) {
            return true;
        }
        if ("success".equalsIgnoreCase(expectResult)) {
            return true;
        }
        if (expectResult.startsWith("[")) {
            return true;
        }
        try {
            validateJson(expectResult);
            return true;
        } catch (JSONException e) {
            String validationInfo = TESTDATA_SHEET_NAME + "Sheet第" + (row + 1) + "行第" + CommonUtils.toRadix(column + 1) + "列的期望结果不符合JSON格式";
            logger.warn(validationInfo);
            validationInfoList.add(Constants.MSG_WARN_PREFIX + validationInfo);
            return false;
        }
    }

    /**
     * 验证字符串是否为Json格式
     * @param expectResult 待验证字符串
     * @return
     * @throws JSONException
     */
    public void validateJson(String expectResult) throws JSONException {
        expectResult = handleExpectResult(expectResult);
        expectResult = expectResult.replaceAll("“", "\"");
        expectResult = expectResult.replaceAll("”", "\"");
        expectResult = removeDoubleQuotation(expectResult);
        JSONCompare.compareJSON(expectResult, "{}", JSONCompareMode.LENIENT);
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
     * 处理测试数据期望返回值内容中的“系统参数”和“自定义参数”
     * @param itdExpectResult 测试数据期望返回值
     * @return 处理后的测试数据期望返回值
     */
    public String handleExpectResult(String itdExpectResult) {
        itdExpectResult = StringUtils.deleteWhitespace(itdExpectResult);
        // 将###替换成"###"
        Pattern pattern = Pattern.compile("(:)###(,|}|])");
        Matcher matcher = pattern.matcher(itdExpectResult);
        while (matcher.find()) {
            String group = matcher.group();
            String replacement = group.replace("###", "\"###\"");
            itdExpectResult = itdExpectResult.replace(group, replacement);
        }
        while (itdExpectResult.contains("[*")) {
            int firstIndex = itdExpectResult.indexOf("[*");
            String firstStr = itdExpectResult.substring(firstIndex, itdExpectResult.length());
            int secondIndex = firstStr.indexOf("]");
            if (secondIndex < 0) {
                logger.info("处理测试数据期望返回值出错，系统参数格式有误: " + itdExpectResult);
            }
            String systemParam = firstStr.substring(0, secondIndex + 1);
            itdExpectResult = itdExpectResult.replace(systemParam, "\"###\"");
        }
        while (itdExpectResult.contains("[?")) {
            int firstIndex = itdExpectResult.indexOf("[?");
            String firstStr = itdExpectResult.substring(firstIndex, itdExpectResult.length());
            int secondIndex = firstStr.indexOf("]");
            if (secondIndex < 0) {
                logger.info("处理测试数据期望返回值出错，系统参数格式有误: " + itdExpectResult);
            }
            String customParam = firstStr.substring(0, secondIndex + 1);
            itdExpectResult = itdExpectResult.replace(customParam, "\"###\"");
        }
        if (itdExpectResult.contains("\"\"###\"\"")) {
            itdExpectResult = itdExpectResult.replace("\"\"###\"\"", "\"###\"");
        }
        return itdExpectResult;
    }


    /**
     * 从指定单元格获取动态参数信息
     * @param sheet sheet对象
     * @param startRow 行号
     * @param colNum 列序号
     * @return 动态参数信息集合
     */
    private List<MstbDynamicParam> getDynamicParamList(XSSFSheet sheet, int startRow, int colNum){
        try {
            int row = startRow;
            XSSFRow dynamicParamRow = sheet.getRow(row);
            String dynamicParamLine = getCellValue(dynamicParamRow.getCell(colNum)).trim();
            boolean valid = true;
            if (!validateDynamicParamLine(dynamicParamLine)) {
                valid = false;
                String validationInfo = TESTDATA_SHEET_NAME + "Sheet第" + (row + 1) + "行第" + CommonUtils.toRadix(colNum + 1) + "的动态参数存在格式错误";
                logger.warn(validationInfo);
                validationInfoList.add(Constants.MSG_WARN_PREFIX + validationInfo);
                globalFlag = false;
            }
            row = startRow + 1;
            XSSFRow formulaRow = sheet.getRow(row);
            String formulaLine = getCellValue(formulaRow.getCell(colNum)).trim();
            if (!validateFormulaLine(formulaLine)) {
                valid = false;
                String validationInfo = TESTDATA_SHEET_NAME + "Sheet第" + (row + 1) + "行第" + CommonUtils.toRadix(colNum + 1) + "的赋值公式存在格式错误";
                logger.warn(validationInfo);
                validationInfoList.add(Constants.MSG_WARN_PREFIX + validationInfo);
                globalFlag = false;
            }
            if (StringUtils.isBlank(dynamicParamLine) || StringUtils.isBlank(formulaLine)) {
                return new ArrayList<MstbDynamicParam>();
            }
            if (!valid) {
                return new ArrayList<MstbDynamicParam>();
            }
            return createDynamicParam(dynamicParamLine, formulaLine, row, colNum);
        } catch (Exception e) {
            logger.error("解析数据出错", e);
            throw new SystemException(e);
        }
    }

    /**
     * 验证赋值公式的内容是否符合格式
     * @param formulaLine 赋值公式
     * @return true符合, false不符合
     */
    private boolean validateFormulaLine(String formulaLine) {
        if (StringUtils.isBlank(formulaLine)) {
            return true;
        }
        formulaLine = formulaLine.replace("；", ";");
        String upperCase = formulaLine.toUpperCase();
        String[] formulas = upperCase.split(";");
        Pattern pattern = Pattern.compile("^(\\[.*?:(SQL|RET_PARAM|INPUT_PARAM)])[\\s\\S]*$");
        for (String formula : formulas) {
            String trimFormula = formula.trim();
            Matcher matcher = pattern.matcher(trimFormula);
            if (!matcher.matches()) {
                return false;
            }
        }
        return true;
    }

    /**
     * 验证动态参数的内容是否符合格式
     * @param dynamicParamLine 动态参数的内容
     * @return true符合, false不符合
     */
    public boolean validateDynamicParamLine(String dynamicParamLine) {
        if (StringUtils.isBlank(dynamicParamLine)) {
            return true;
        }
        dynamicParamLine = dynamicParamLine.replace("；", ";");
        String[] dynamicParams = dynamicParamLine.split(";");
        Pattern pattern = Pattern.compile("^(\\[.*?])&(.*?)&$");
        for (String param : dynamicParams) {
            Matcher matcher = pattern.matcher(param.trim());
            if (!matcher.matches()) {
                return false;
            }
        }
        return true;
    }

    /**
     * 根据参数单元格内容和赋值公式单元格内容，获取动态参数
     * @param dynamicParamLine 参数单元格内容
     * @param formulaLine 赋值公式单元格内容
     * @return 动态参数集合
     */
    private List<MstbDynamicParam> createDynamicParam(String dynamicParamLine, String formulaLine, int row, int column){
        try {
            String[] params = dynamicParamLine.split(";");
            String[] formulaLineSplits = formulaLine.split(";");
            if (params.length != formulaLineSplits.length) {
                String validationInfo = TESTDATA_SHEET_NAME + "Sheet第" + (row + 1) + "行第" + CommonUtils.toRadix(column + 1) + "动态参数数量与赋值公式数量不一致";
                logger.warn(validationInfo);
                validationInfoList.add(Constants.MSG_WARN_PREFIX + validationInfo);
                globalFlag = false;
                return new ArrayList<MstbDynamicParam>();
            }
            Map<String, MstbDynamicParam> dynamicParamMap = new HashMap<String, MstbDynamicParam>(params.length);
            for (String param : params) {
                MstbDynamicParam mstbDynamicParam = new MstbDynamicParam();
                String name = StringUtils.substringBetween(param, "[", "]");
                String description = StringUtils.substringBetween(param, "&", "&");
                if (globalDynamicParamMap.containsKey(name)) {
                    String validationInfo = TESTDATA_SHEET_NAME + "Sheet第" + (row + 1) + "行第" + CommonUtils.toRadix(column + 1) + "动态参数重复赋值: " + name;
                    logger.warn(validationInfo);
                    validationInfoList.add(Constants.MSG_WARN_PREFIX + validationInfo);
                    globalFlag = false;
                    return new ArrayList<MstbDynamicParam>();
                }
                mstbDynamicParam.setMdpName(name);
                mstbDynamicParam.setMdpDescription(description);
                dynamicParamMap.put(name, mstbDynamicParam);
                globalDynamicParamMap.put(name, mstbDynamicParam);
            }
            List<MstbDynamicParam> dynamicParamList = new ArrayList<MstbDynamicParam>();
            for (String splitStr : formulaLineSplits) {
                String nameAndType = StringUtils.substringBetween(splitStr.trim(), "[", "]");
                String name = nameAndType.split(":")[0].trim();
                String type = nameAndType.split(":")[1].trim();
                String formula = splitStr.substring(splitStr.indexOf("]") + 1, splitStr.length());
                formula = formula.replace(";", "");
                if (!dynamicParamMap.containsKey(name)) {
                    String validationInfo = TESTDATA_SHEET_NAME + "Sheet第" + (row + 1) + "行第" + CommonUtils.toRadix(column + 1) + "赋值公式没有对应的动态参数: " + name;
                    logger.warn(validationInfo);
                    validationInfoList.add(Constants.MSG_WARN_PREFIX + validationInfo);
                    globalFlag = false;
                    return new ArrayList<MstbDynamicParam>();
                }
                MstbDynamicParam mstbDynamicParam = dynamicParamMap.get(name);
                mstbDynamicParam.setMdpType(DynamicParamTypeEnum.getValue(type.toUpperCase()));
                formula = replaceSql(formula, row, column);
                mstbDynamicParam.setMdpFormula(formula);
                dynamicParamList.add(mstbDynamicParam);
            }
            return dynamicParamList;
        } catch (Exception e) {
            logger.error("解析数据出错", e);
            throw new SystemException("解析数据出错", e);
        }
    }

    /**
     * 根据指定分隔符分割字符串
     * @param value 输入字符串
     * @return 分割后字符串数组
     */
    public String[] splitStrs(String value) {
        String noWhitespace = StringUtils.deleteWhitespace(value);
        return noWhitespace.split(SEPARATOR);
    }

    /**
     * 解析用例行记录
     * @param sheet 用例sheet对象
     * @param markColNums 标志位所在列序号
     * @param firstRowNum 首条记录行序号
     * @param listCombineCell 合并单元格集合
     * @return 用例Map对象
     * keys: tcNum, tc, mumNums, lastRowNum
     * values: 用例编号, 用例对象, 接口编号集合, 末行记录行序号
     */
    private Map<String, Object> parseTestCaseRow(XSSFSheet sheet, int[] markColNums, int firstRowNum, List<CellRangeAddress> listCombineCell) {
        XSSFRow xssfRow = sheet.getRow(firstRowNum);
        // 当前用例记录第末行序号
        int lastRowNum = getLastRowNum(listCombineCell, xssfRow.getCell(TESTCASE_START_COLUMN));
        if (lastRowNum == 0) { // 说明该单元格不是合并单元格
            lastRowNum = firstRowNum;
        }

        MstbTestCase tc = new MstbTestCase();
        // 用例编号
        String tcNum = getCellValue(xssfRow.getCell(markColNums[0]));
        // 用例名称
        String mtcName = getCellValue(xssfRow.getCell(markColNums[1]));
        // 用例依赖
        String dependency = getCellValue(xssfRow.getCell(markColNums[2]));
        // 暂停时间
        String stopTimeValue = getCellValue(xssfRow.getCell(markColNums[3]));
        if (StringUtils.isNotBlank(stopTimeValue)) {
            if (CommonUtils.isNotNumeric(stopTimeValue)) {
                String validationInfo = TESTDATA_SHEET_NAME + "Sheet第" + (firstRowNum + 1) + "行第" +
                        CommonUtils.toRadix(markColNums[3] + 1) + "列的暂停时间不是数字";
                validationInfoList.add(validationInfo);
                logger.warn(validationInfo);
            } else {
                tc.setStopTime(Integer.parseInt(stopTimeValue));
            }
        }
        tc.setMtcName(mtcName);
        tc.setMtcDependency(dependency);

        // 接口编号集合
        List<String> mumNums = new ArrayList<String>();
        for (int i = firstRowNum; i <= lastRowNum; i++) {
            xssfRow = sheet.getRow(i);
            String mumNum = getCellValue(xssfRow.getCell(markColNums[4]));
            if (StringUtils.isNotBlank(mumNum)) {
                mumNums.add(mumNum);
            }
        }
        Map<String, Object> testCaseMap = new HashMap<String, Object>();
        testCaseMap.put("tcNum", tcNum); // 用例编号
        testCaseMap.put("tc", tc); // 用例对象
        testCaseMap.put("mumNums", mumNums); // 接口编号集合
        testCaseMap.put("lastRowNum", lastRowNum); // 当前用例记录第末行序号
        return testCaseMap;
    }

    /**
     * 解析sheet中接口记录
     * @param firstRowNum 当前接口记录首行序号
     * @return Map对象
     * keys: mumNum, url, parametersList, lastRowNum
     * values: 接口编号, 接口对象, 接口参数集合, 当前接口末行记录行序号
     */
    public Map<String,Object> parseInterfaceRow(XSSFSheet sheet,int[] markColNums, int firstRowNum, List<CellRangeAddress> listCombineCell) {
        XSSFRow xssfRow = sheet.getRow(firstRowNum);
        int lastRowNum;
        if (isCombineCell(listCombineCell, xssfRow.getCell(INTERFACE_START_COLUMN))){
            // 当前接口记录第末行序号
            lastRowNum = getLastRowNum(listCombineCell, xssfRow.getCell(INTERFACE_START_COLUMN));
        }else {
            //当前接口记录只有一个参数即只有一行，不存在合并单元格的情况
            lastRowNum = firstRowNum;
        }
        // 接口编号
        String mumNum = getCellValue(xssfRow.getCell(markColNums[0]));
        // 接口对象
        MstbURLManagement url = new MstbURLManagement();
        url.setMumName(getCellValue(xssfRow.getCell(markColNums[1])));
        url.setMumUrlPath(getCellValue(xssfRow.getCell(markColNums[2])));
        url.setMumMethodType(getCellValue(xssfRow.getCell(markColNums[3])));
        // 接口参数对象集合
        List<MstbURLParameters> parametersList = new ArrayList<MstbURLParameters>();
        for (int i = firstRowNum; i <= lastRowNum; i++) {
            xssfRow = sheet.getRow(i);
            MstbURLParameters parameters = new MstbURLParameters();
            parameters.setMupName(getCellValue(xssfRow.getCell(markColNums[4])));
            parameters.setMupType(getCellValue(xssfRow.getCell(markColNums[5])));
            // 添加业务说明
            parametersList.add(parameters);
        }
        Map<String, Object> interfaceMap = new HashMap<String, Object>();
        interfaceMap.put("mumNum", mumNum); // 接口编号
        interfaceMap.put("url", url); // 接口对象
        interfaceMap.put("parametersList", parametersList); // 接口参数集合
        interfaceMap.put("lastRowNum", lastRowNum); // 当前接口记录第末行序号
        return interfaceMap;
    }

    /**
     * 获取指定合并单元格最后一行的行号
     * @param xssfCell 指定单元格
     * @return 最后一行行号
     */
    public static int getLastRowNum(List<CellRangeAddress> listCombineCell, XSSFCell xssfCell) {
        int firstRow, lastRow, firstCol, lastCol;
        int rowNum = 0;
        for (CellRangeAddress cra : listCombineCell) {
            firstRow = cra.getFirstRow();
            lastRow = cra.getLastRow();
            firstCol = cra.getFirstColumn();
            lastCol = cra.getLastColumn();
            if (xssfCell.getRowIndex() >= firstRow && xssfCell.getRowIndex() <= lastRow &&
                    xssfCell.getColumnIndex() >= firstCol && xssfCell.getColumnIndex() <= lastCol) {
                rowNum = lastRow;
            }
        }
        return rowNum;
    }

    /**
     * 获取sheet中所有合并单元格
     * @return 合并单元格列表
     */
    public static List<CellRangeAddress> getCombineCell(XSSFSheet sheet) {
        List<CellRangeAddress> list = new ArrayList<CellRangeAddress>();
        //获得一个 sheet 中合并单元格的数量
        int sheetMergerCount = sheet.getNumMergedRegions();
        for(int i = 0; i<sheetMergerCount;i++)
        {
            //获得合并单元格保存进list中
            CellRangeAddress ca = sheet.getMergedRegion(i);
            list.add(ca);
        }
        return list;
    }

    /**
     * 根据实际信息设置标志位列序号
     * @return 对应常量INTERFACE_MARK的标识列序号数组
     */
    public static int[] setMarkColumnNumber(XSSFSheet sheet, String[] marks, int markRow, int start, int end) {
        logger.info("设置标志位列序号, 标识位所在行为" + markRow + ", 开始列为" + start + ", 结束列为" + end);
        int[] markColumnNumbers = new int[marks.length];
        Map<String, Integer> markColNum = new HashMap<String, Integer>();
        for (int i = start; i <= end; i++) {
            String value = getCellValue(getCell(sheet, markRow, i));
            markColNum.put(value, i);
        }
        for (int i = 0; i < marks.length; i++) {
            markColumnNumbers[i] = markColNum.get(marks[i]);
        }
        return markColumnNumbers;
    }

    /**
     * 获取单元格内容
     * @param cell 单元格
     * @return 单元格内容
     */
    public static String getCellValue(XSSFCell cell) {
        if(cell == null) {
            return "";
        }
        if(cell.getCellType() == XSSFCell.CELL_TYPE_STRING){
            return cell.getStringCellValue().trim();
        }else if(cell.getCellType() == XSSFCell.CELL_TYPE_BOOLEAN){
            return String.valueOf(cell.getBooleanCellValue()).trim();
        }else if(cell.getCellType() == XSSFCell.CELL_TYPE_FORMULA){
            return cell.getCellFormula().trim();
        }else if(cell.getCellType() == XSSFCell.CELL_TYPE_NUMERIC){
            cell.setCellType(XSSFCell.CELL_TYPE_STRING);
            return cell.getStringCellValue().trim();
        }
        return "";
    }

    /**
     * 根据指定行与列获取sheet中单元格
     * @param sheet sheet页
     * @param rowNum 行序号 从0开始
     * @param colNum 列序号 从0开始
     * @return 单元格对象
     */
    public static XSSFCell getCell(XSSFSheet sheet, Integer rowNum, Integer colNum) {
        XSSFCell xssfCell;
        if (rowNum <= sheet.getLastRowNum() && rowNum >= sheet.getFirstRowNum()) {
            XSSFRow xssfRow = sheet.getRow(rowNum);
            xssfCell = xssfRow.getCell(colNum);
        } else {
            throw new IllegalArgumentException("行号超出有值存在的范围，" + "超出行：" + rowNum);
        }
        return xssfCell;
    }

    /**
     * 判断单元格是否为合并单元格
     * @param listCombineCell 存放合并单元格的list
     * @param cell 需要判断的单元格
     * @return true 合并   false 非合并
     */
    public static Boolean isCombineCell(List<CellRangeAddress> listCombineCell, XSSFCell cell) {
        int firstC = 0;
        int lastC = 0;
        int firstR = 0;
        int lastR = 0;
        for (CellRangeAddress ca : listCombineCell) {
            // 获得合并单元格的起始行, 结束行, 起始列, 结束列
            firstC = ca.getFirstColumn();
            lastC = ca.getLastColumn();
            firstR = ca.getFirstRow();
            lastR = ca.getLastRow();
            if (cell.getColumnIndex() <= lastC&& cell.getColumnIndex()>= firstC) {
                if (cell.getRowIndex() <= lastR && cell.getRowIndex() >= firstR) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * sheet中项目名称所在行
     */
    public static final Integer PROJECT_ROW_NUM = 0;

    /**
     * sheet中项目名称所在列
     */
    public static final Integer PROJECT_COL_NUM = 2;

    /**
     * 数据名称单元格分隔符
     */
    private static final String SEPARATOR = ">>";

    /*#################################参数##########################################*/
    /**
     * 参数sheet名称
     */
    public static final String PARAM_SHEET_NAME = "测试参数设置";

    /**
     *  接口执行成功标准返回Json
     */
    public static final String PARAM_STANDARD_TRUE = "s_true";

    /*#################################接口##########################################*/
    /**
     * 接口sheet名称
     */
    public static final String INTERFACE_SHEET_NAME = "业务功能_系统接口";

    /**
     * 接口sheet中标识所在行
     */
    public static final Integer INTERFACE_MARK_ROW_NUM = 3;

    /**
     * 接口sheet中记录开始行
     */
    public static final Integer INTERFACE_START_ROW = 5;

    /**
     * 接口sheet中记录开始列
     */
    public static final Integer INTERFACE_START_COLUMN = 1;

    /**
     * 接口sheet中记录结束列
     */
    public static final Integer INTERFACE_END_COLUMN = 7;

    /**
     * 接口标识
     * mumNum: 接口ID
     * mumName: 接口名称
     * mumURL: 相对路径（URL）
     * mumMethodType: 请求方式
     * mumParam: 参数名称
     * mumParamType: 数据类型
     * dataDescribe: 数据业务说明
     * mumRequirementID: 对应需求ID
     */
    public static final String[] INTERFACE_MARK = {"mumNum", "mumName", "mumURL", "mumMethodType",
            "mumParam", "mumParamType", "dataDescribe"};

    /*#################################用例##########################################*/
    /**
     * 用例sheet名称
     */
    public static final String TESTCASE_SHEET_NAME = "系统接口_测试用例";

    /**
     * 用例sheet中标识所在行
     */
    public static final Integer TESTCASE_MARK_ROW_NUM = 3;

    /**
     * 用例sheet中记录开始行
     */
    public static final Integer TESTCASE_START_ROW = 5;

    /**
     * 用例sheet中记录开始列
     */
    public static final Integer TESTCASE_START_COLUMN = 1;

    /**
     * 用例sheet中记录结束列
     */
    public static final Integer TESTCASE_END_COLUMN = 6;

    /**
     * 用例标识
     * tcNum: 用例ID
     * tcName: 用例名称
     * mumNum: 接口ID
     */
    public static final String[] TESTCASE_MARK = {"tcNum", "tcName", "dependency", "stopTime", "mumNum"};

    /*#################################数据##########################################*/
    /**
     * 数据sheet名称
     */
    public static final String TESTDATA_SHEET_NAME = "测试用例_数据";

    /**
     * 数据记录总数
     */
    public static final Integer TESTDATA_TOTAL = 100;

    /**
     * 数据sheet中标识所在行
     */
    public static final Integer TESTDATA_MARK_ROW_NUM = 3;

    /**
     * 数据sheet中记录开始行
     */
    public static final Integer TESTDATA_START_ROW = 5;

    /**
     * 数据sheet中记录开始列
     */
    public static final Integer TESTDATA_START_COLUMN = 1;

    /**
     * 数据sheet中记录结束列
     */
    public static final Integer TESTDATA_END_COLUMN = 9;

    /**
     * 数据标识
     * tcNum: 用例ID
     * mumNum: 接口ID
     * mumParam: 参数名称
     * mumParamType: 参数类型
     */
    public static final String[] TESTDATA_MARK = {"tcNum", "mumNum", "mumParam", "mumParamType"};

}
enum DynamicParamTypeEnum {
    SQL("SQL", (byte) 1), RET_PARAM("RET_PARAM", (byte) 2), INPUT_PARAM("INPUT_PARAM", (byte) 3);

    private String name;
    private byte value;

    DynamicParamTypeEnum(String name, byte value) {
        this.name = name;
        this.value = value;
    }

    public static byte getValue(String name) {
        for (DynamicParamTypeEnum d : DynamicParamTypeEnum.values()) {
            if (d.getName().equalsIgnoreCase(name)) {
                return d.getValue();
            }
        }
        return (byte) 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte getValue() {
        return value;
    }

    public void setValue(byte value) {
        this.value = value;
    }
}
