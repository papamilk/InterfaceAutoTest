package blk.interfacetesting.component;

import blk.common.util.Constants;
import blk.interfacetesting.dao.IBaseDao;
import blk.interfacetesting.dao.data.*;
import blk.interfacetesting.modle.data.*;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.RegionUtil;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * 测试数据文件验证类
 * @author Mark
 * @date 2018/1/25
 */
@Component
public class TestDataFileValidator {
    private Map<String, IBaseDao> daoMap;

    @Autowired
    public TestDataFileValidator(Map<String, IBaseDao> daoMap) {
        this.daoMap = daoMap;
    }

    /**
     * 接口参数变更影响的测试用例集合
     */
    private HashMap<String, String> modifiedTestCaseMap;

    /**
     * 基本单元格样式
     */
    private CellStyle baseStyle;

    private CellStyle foregroundStyle;

    private CellStyle alignRightStyle;

    private CellStyle wrapTextStyle;

    private CellStyle highLightStyle;

    public void initBaseStyle(Workbook workbook) {
        CellStyle style = workbook.createCellStyle();
        // 设置边框样式
        style.setBorderBottom(CellStyle.BORDER_THIN);
        style.setBorderTop(CellStyle.BORDER_THIN);
        style.setBorderLeft(CellStyle.BORDER_THIN);
        style.setBorderRight(CellStyle.BORDER_THIN);
        style.setBottomBorderColor(IndexedColors.BLACK.getIndex());
        style.setTopBorderColor(IndexedColors.BLACK.getIndex());
        style.setRightBorderColor(IndexedColors.BLACK.getIndex());
        style.setLeftBorderColor(IndexedColors.BLACK.getIndex());
        // 设置垂直居中
        style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);

        this.baseStyle = style;
    }

    public void initForegroundStyle(Workbook workbook) {
        if (null == baseStyle) {
            initBaseStyle(workbook);
        }
        CellStyle style = workbook.createCellStyle();
        style.cloneStyleFrom(baseStyle);
        // 设置居中
        style.setAlignment(CellStyle.ALIGN_CENTER);
        // 设置自动换行
        style.setWrapText(true);
        // 设置填充样式
        style.setFillPattern(CellStyle.SOLID_FOREGROUND);
        style.setFillForegroundColor(IndexedColors.LIGHT_TURQUOISE.getIndex());
        // 设置粗体
        Font font = workbook.createFont();
        font.setBoldweight(Font.BOLDWEIGHT_BOLD);
        style.setFont(font);


        foregroundStyle = style;
    }

    public void initAlignRightSytle(Workbook workbook) {
        if (null == baseStyle) {
            initBaseStyle(workbook);
        }
        CellStyle style = workbook.createCellStyle();
        style.cloneStyleFrom(baseStyle);
        // 设置居中
        style.setAlignment(CellStyle.ALIGN_CENTER);
        // 设置靠右对齐
        style.setAlignment(CellStyle.ALIGN_RIGHT);
        // 设置自动换行
        style.setWrapText(true);
        // 设置粗体
        Font font = workbook.createFont();
        font.setBoldweight(Font.BOLDWEIGHT_BOLD);
        style.setFont(font);

        alignRightStyle = style;
    }

    public void initWrapTextStyle(Workbook workbook) {
        if (null == baseStyle) {
            initBaseStyle(workbook);
        }
        CellStyle style = workbook.createCellStyle();
        style.cloneStyleFrom(baseStyle);
        // 设置居中
        style.setAlignment(CellStyle.ALIGN_CENTER);
        // 设置自动换行
        style.setWrapText(true);

        wrapTextStyle = style;
    }

    public void initHighLightStyle(Workbook workbook) {
        if (null == baseStyle) {
            initBaseStyle(workbook);
        }
        CellStyle style = workbook.createCellStyle();
        style.cloneStyleFrom(baseStyle);
        // 设置填充样式
        style.setFillPattern(CellStyle.SOLID_FOREGROUND);
        style.setFillForegroundColor(IndexedColors.YELLOW.getIndex());

        highLightStyle = style;
    }

    /**
     *
     * @param mpId
     * @param iemId
     * @return
     * @throws Exception
     */
    public Workbook validate(int mpId, int iemId) throws Exception {
        MstbTestCaseDao testCaseDao = (MstbTestCaseDao) daoMap.get("testCaseDao");
        List<MstbTestCase> testCases = testCaseDao.getTestCase(mpId, iemId);

        MstbURLManagementDao urlManagementDao = (MstbURLManagementDao) daoMap.get("urlManagementDao");
        List<Map<String, Object>> interfaceMapList = urlManagementDao.getInterfaceMapList(mpId, iemId);

        IftbTestDataDao testDataDao = (IftbTestDataDao) daoMap.get("testDataDao");
        IftbTestDataCriteria criteria = new IftbTestDataCriteria();
        criteria.createCriteria().andIemIdEqualTo(iemId);
        List<IftbTestData> testDataList = testDataDao.ReadAll(criteria);

        IftbURLTestCaseDao urlTestCaseDao = (IftbURLTestCaseDao) daoMap.get("urlTestCaseDao");
        List<IftbURLTestCase> urlTestCaseList = urlTestCaseDao.getURLTestCases();

        Map<String, Map<String, Object>> interfaceMap = handleInterfaceMapList(interfaceMapList);
        Map<String, Map<String, Object>> testDataMap = handleTestDataMapList(testDataList);
        Map<String, String> urlTestCaseMap = handleURLTestCaseList(urlTestCaseList);

        List<TestDataSheetRecord> list = compare(testCases, interfaceMap, testDataMap, urlTestCaseMap);

        MstbProjectDao projectDao = (MstbProjectDao) daoMap.get("projectDao");
        MstbProject mstbProject = projectDao.ReadByID(mpId);
        String projectName = mstbProject.getMpName();

        Workbook workbook = new XSSFWorkbook();
        initStyle(workbook);

        String orderSrcibe = validateTestDataOrder(testCases, testDataList);

        generateErrorTipsSheet(workbook, modifiedTestCaseMap, orderSrcibe);

        generateTestDataSheet(workbook, list, projectName);

        return workbook;

    }

    /**
     * 遍历，返回mtcId与mumId的映射关系
     * @param urlTestCaseList
     * @return
     */
    private Map<String,String> handleURLTestCaseList(List<IftbURLTestCase> urlTestCaseList) {
        Map<String, String> map = new HashMap<String, String>(urlTestCaseList.size());
        for (IftbURLTestCase urlTestCase : urlTestCaseList) {
            map.put(urlTestCase.getMtcId() + "", urlTestCase.getMumId() + "");
        }
        return map;
    }


    /**
     * 验证测试数据的顺序
     * @param testCases
     * @param testDataList
     */
    private String validateTestDataOrder(List<MstbTestCase> testCases, List<IftbTestData> testDataList) {
        List<Integer> orderList = new ArrayList<Integer>(testCases.size());
        for (MstbTestCase testCase : testCases) {
            orderList.add(testCase.getMtcId());
        }
        int mtcId = 0;
        List<Integer> testDataOrderList = new ArrayList<Integer>();
        for (IftbTestData testData : testDataList) {
            if (mtcId != testData.getMtcId()) {
                mtcId = testData.getMtcId();
                testDataOrderList.add(mtcId);
            }
        }
        if (orderList.size() != testDataOrderList.size()) {
            return "测试用例数量：" + orderList.size() + "，测试用例数据数量：" + testDataOrderList.size();
        }
        for (int i = 0; i < orderList.size(); i++) {
            if (!orderList.get(i).equals(testDataOrderList.get(i))) {
                return "测试数据的顺序与测试用例不一致";
            }
        }
        return "";
    }


    /**
     * 将测试数据的参数和值转换成Map对象
     * @param cols 参数名
     * @param vals 参数值
     * @return
     */
    public Map<String, String> handleParams(String cols, String vals) {
        Map<String, String> map = new LinkedHashMap<String, String>();
        if (StringUtils.isBlank(cols)) {
            return map;
        }
        String[] names = cols.split(Constants.PARAMS_SEPARATOR);
        if (names.length == 1) {
            map.put(cols, vals);
            return map;
        }
        String[] values = StringUtils.splitByWholeSeparatorPreserveAllTokens(vals, Constants.PARAMS_SEPARATOR, names.length);

        for (int i = 0; i < names.length; i++) {
            map.put(names[i], values[i]);
        }
        return map;
    }

    private void generateErrorTipsSheet(Workbook workbook, Map<String, String> modifiedTestCaseMap, String orderSrcibe) {
        Sheet newSheet = workbook.createSheet("错误提示");
        newSheet.setColumnWidth(0, 20 * 256);
        newSheet.setColumnWidth(1, 20 * 256);
        newSheet.setColumnWidth(2, 2 * 256);
        newSheet.setColumnWidth(3, 40 * 256);
        int mtcNumColumn = 0;
        Row firstRow = newSheet.createRow(0);
        Cell errorTipCell = firstRow.createCell(mtcNumColumn);
        CellStyle errorTipStyle = initErrorTipStyle(workbook);
        errorTipCell.setCellStyle(errorTipStyle);
        errorTipCell.setCellValue("错误提示");
        CellRangeAddress cra = new CellRangeAddress(0, 0, 0, 3);
        newSheet.addMergedRegion(cra);

        CellStyle titleStyle = initTitleSytle(workbook);
        Row secondeRow = newSheet.createRow(1);
        Cell firstTitleCell = secondeRow.createCell(0);
        firstTitleCell.setCellValue("系统接口参数 对应 测试用例数据 错误");
        firstTitleCell.setCellStyle(titleStyle);
        cra = new CellRangeAddress(1, 1, 0, 1);
        newSheet.addMergedRegion(cra);
        int otherErrorTipColumn = 3;
        Cell secondTitleCell = secondeRow.createCell(otherErrorTipColumn);
        secondTitleCell.setCellValue("其它错误提示");
        secondTitleCell.setCellStyle(titleStyle);

        CellStyle cellStyle = initCellStyle(workbook);
        Row thirdRow = newSheet.createRow(2);
        Cell firstCell = thirdRow.createCell(0);
        firstCell.setCellValue("用例ID");
        firstCell.setCellStyle(cellStyle);
        Cell secondCell = thirdRow.createCell(1);
        secondCell.setCellValue("用例名称");
        secondCell.setCellStyle(cellStyle);

        int rowNum = 3;
        for (Map.Entry<String, String> entry: modifiedTestCaseMap.entrySet()) {
            Row row = newSheet.createRow(rowNum++);
            Cell mtcNumCell = row.createCell(0);
            mtcNumCell.setCellValue(entry.getKey());

            Cell mtcNameCell = row.createCell(1);
            mtcNameCell.setCellValue(entry.getValue());
        }

        Cell orderScribeCell = thirdRow.createCell(otherErrorTipColumn);
        orderScribeCell.setCellValue(orderSrcibe);
    }

    private CellStyle initCellStyle(Workbook workbook) {
        CellStyle style = workbook.createCellStyle();
        // 设置居中
        style.setAlignment(CellStyle.ALIGN_CENTER);
        // 设置垂直居中
        style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
        // 设置粗体
        Font font = workbook.createFont();
        font.setBoldweight(Font.BOLDWEIGHT_BOLD);
        style.setFont(font);
        return style;
    }


    private CellStyle initTitleSytle(Workbook workbook) {
        CellStyle style = workbook.createCellStyle();
        // 设置居中
        style.setAlignment(CellStyle.ALIGN_CENTER);
        // 设置垂直居中
        style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
        // 设置粗体
        Font font = workbook.createFont();
        font.setBoldweight(Font.BOLDWEIGHT_BOLD);
        font.setFontHeightInPoints((short) 12);
        style.setFont(font);
        return style;
    }

    private CellStyle initErrorTipStyle(Workbook workbook) {
        CellStyle style = workbook.createCellStyle();
        // 设置居中
        style.setAlignment(CellStyle.ALIGN_CENTER);
        // 设置垂直居中
        style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
        // 设置粗体
        Font font = workbook.createFont();
        font.setBoldweight(Font.BOLDWEIGHT_BOLD);
        font.setFontHeightInPoints((short) 16);
        style.setFont(font);
        return style;
    }

    /**
     * 生成测试数据sheet页
     * @param list
     */
    public void generateTestDataSheet(Workbook workbook, List<TestDataSheetRecord> list, String projectName) {
        Sheet newSheet = workbook.createSheet("测试用例_数据_平台验证");
        createFiveRow(workbook, newSheet);
        createFirstRow(workbook, newSheet, projectName);

        int headRowNumber = 5;
        int orderNumber = 1;
        for (TestDataSheetRecord record : list) {
            int mumSize = record.getMumParam().size();
            // 记录首行
            Row headRow = newSheet.createRow(headRowNumber);
            // 设置序号
            int orderNumberColumn = 0;
            Cell orderNumberCell = headRow.createCell(orderNumberColumn);
            orderNumberCell.setCellValue(orderNumber);
            setCellStyle(orderNumberCell, foregroundStyle);

            // 设置用例ID
            int tcNumColumn = 1;
            Cell tcNumCell = headRow.createCell(tcNumColumn);
            tcNumCell.setCellValue(record.getTcNum());
            setCellStyle(tcNumCell, foregroundStyle);

            // 设置用例名称
            int tcNameColumn = 2;
            Cell tcNameCell = headRow.createCell(tcNameColumn);
            tcNameCell.setCellValue(record.getTcName());
            setCellStyle(tcNameCell, foregroundStyle);

            // 测试数据编号
            int testDataOrderNumberColumn = 3;
            Cell testDataOrderNumberCell = headRow.createCell(testDataOrderNumberColumn);
            testDataOrderNumberCell.setCellValue("测试数据编号");
            setCellStyle(testDataOrderNumberCell, foregroundStyle);
            setMergedRegion(workbook, newSheet, headRowNumber, headRowNumber, 3, 9);

            // 记录接口信息首行
            int mumFirstRowNumber = headRowNumber + 1;
            Row mumFirstRow = newSheet.createRow(mumFirstRowNumber);

            // 设置接口ID
            int mumNumColumn = 3;
            Cell mumNumCell = mumFirstRow.createCell(mumNumColumn);
            mumNumCell.setCellValue(record.getMumNum());
            setCellStyle(mumNumCell, wrapTextStyle);
            setMergedRegion(workbook, newSheet, mumFirstRowNumber, headRowNumber + mumSize, mumNumColumn, mumNumColumn);

            // 设置接口名称
            int mumNameColumn = 4;
            Cell mumNameCell = mumFirstRow.createCell(mumNameColumn);
            mumNameCell.setCellValue(record.getMumName());
            setCellStyle(mumNameCell, wrapTextStyle);
            setMergedRegion(workbook, newSheet, mumFirstRowNumber, headRowNumber + mumSize, mumNameColumn, mumNameColumn);

            // 设置请求相对路径
            int mumURLColumn = 5;
            Cell mumURLCell = mumFirstRow.createCell(mumURLColumn);
            mumURLCell.setCellValue(record.getMumURL());
            setCellStyle(mumURLCell, wrapTextStyle);
            setMergedRegion(workbook, newSheet, mumFirstRowNumber, headRowNumber + mumSize, mumURLColumn, mumURLColumn);

            // 设置请求方式
            int mumMethodColumn = 6;
            Cell mumMethodCell = mumFirstRow.createCell(mumMethodColumn);
            mumMethodCell.setCellValue(record.getMumMethod());
            setCellStyle(mumMethodCell, wrapTextStyle);
            setMergedRegion(workbook, newSheet, mumFirstRowNumber, headRowNumber + mumSize, mumMethodColumn, mumMethodColumn);

            // 设置参数名称
            int mumParamColumn = 7;
            List<String> mumParams = record.getMumParam();
            setMultiRow(mumParams, newSheet, mumFirstRowNumber, mumParamColumn);

            // 设置数据类型
            int mumParamTypeColumn = 8;
            List<String> mumParamTypes = record.getMumParamType();
            setMultiRow(mumParamTypes, newSheet, mumFirstRowNumber, mumParamTypeColumn);

            // 设置数据业务说明
            int mumDataDescribeColulmn = 9;
            List<String> mumDataDescribeList = record.getDataDescribe();
            setMultiRow(mumDataDescribeList, newSheet, mumFirstRowNumber, mumDataDescribeColulmn);

            // 设置SQL验证
            int sqlRowNumber = mumFirstRowNumber + mumSize;
            Row sqlRow = newSheet.createRow(sqlRowNumber);
            int sqlColumn = 3;
            Cell sqlCell = sqlRow.createCell(sqlColumn);
            sqlCell.setCellValue("SQL验证");
            setCellStyle(sqlCell, alignRightStyle);
            setMergedRegion(workbook, newSheet, sqlRowNumber, sqlRowNumber, 3, 9);

            // 设置SQL返回数据集
            Row sqlExpecttRow = newSheet.createRow(sqlRowNumber + 1);
            int sqlExpectColumn = 3;
            Cell sqlExpectCell = sqlExpecttRow.createCell(sqlExpectColumn);
            sqlExpectCell.setCellValue("SQL返回数据集");
            setCellStyle(sqlExpectCell, alignRightStyle);
            setMergedRegion(workbook, newSheet, sqlRowNumber + 1, sqlRowNumber + 1, 3, 9);

            // 设置参数
            Row dynamicParamRow = newSheet.createRow(sqlRowNumber + 2);
            int dynamicParamColumn = 3;
            Cell dynamicParamCell = dynamicParamRow.createCell(dynamicParamColumn);
            dynamicParamCell.setCellValue("参数");
            setCellStyle(dynamicParamCell, alignRightStyle);
            setMergedRegion(workbook, newSheet, sqlRowNumber + 2, sqlRowNumber + 2, 3, 9);

            // 设置参数赋值公式
            Row formulaRow = newSheet.createRow(sqlRowNumber + 3);
            int formulaColumn = 3;
            Cell formulaCell = formulaRow.createCell(formulaColumn);
            formulaCell.setCellValue("参数赋值公式");
            setCellStyle(formulaCell, alignRightStyle);
            setMergedRegion(workbook, newSheet, sqlRowNumber + 3, sqlRowNumber + 3, 3, 9);

            // 合并序号单元格
            setMergedRegion(workbook, newSheet, headRowNumber, headRowNumber + mumSize + 4, orderNumberColumn, orderNumberColumn);
            // 合并用例ID单元格
            setMergedRegion(workbook, newSheet, headRowNumber, headRowNumber + mumSize + 4, tcNumColumn, tcNumColumn);
            // 合并用例名称单元格
            setMergedRegion(workbook, newSheet, headRowNumber, headRowNumber + mumSize + 4, tcNameColumn, tcNameColumn);

            // 设置数据
            List<Map<String, Object>> testDataList = record.getTestDataList();
            if (null != testDataList) {
                int testDataColumn = 10;
                int count = 0;
                for (Map<String, Object> map : testDataList) {
                    int firstColumn = testDataColumn + count * 3;
                    int secondColumn = testDataColumn + count * 3 + 1;
                    int lastColumn = testDataColumn + count * 3 + 2;
                    // 设置测试数据编号
                    String head = (String) map.get("head");
                    Cell headCell = headRow.createCell(testDataColumn + count * 3);
                    headCell.setCellValue(head);
                    setCellStyle(headCell, foregroundStyle);
                    setMergedRegion(workbook, newSheet, headRowNumber, headRowNumber, firstColumn, lastColumn);

                    // 设置测试数据值
                    List<String> values = (List<String>) map.get("values");
                    setMultiRow(values, newSheet, mumFirstRowNumber, firstColumn);

                    // 设置参数名:值
                    for (int i = mumFirstRowNumber; i <= mumFirstRowNumber + mumSize; i++) {
                        Row row = newSheet.getRow(i);
                        Cell cell = row.createCell(secondColumn);
                        String formula = toRadix(mumParamColumn + 1) + (i + 1) + "&\":\"&" + toRadix(firstColumn + 1) + (i + 1);
                        cell.setCellFormula(formula);
                    }

                    // 设置期望结果
                    String expectResult = (String) map.get("expectResult");
                    Cell expectResultCell = mumFirstRow.createCell(lastColumn);
                    expectResultCell.setCellValue(expectResult);
                    setCellStyle(expectResultCell, baseStyle);
                    setMergedRegion(workbook, newSheet, mumFirstRowNumber, headRowNumber + mumSize, lastColumn, lastColumn);

                    // 设置SQL验证
                    String sql = (String) map.get("sql");
                    sqlCell = sqlRow.createCell(firstColumn);
                    sqlCell.setCellValue(sql);
                    setMergedRegion(workbook, newSheet, sqlRowNumber, sqlRowNumber, firstColumn, lastColumn);

                    // 设置SQL返回数据集
                    String sqlExpect = (String) map.get("sqlExpect");
                    sqlExpectCell = sqlExpecttRow.createCell(firstColumn);
                    sqlExpectCell.setCellValue(sqlExpect);
                    setMergedRegion(workbook, newSheet, sqlRowNumber + 1, sqlRowNumber + 1, firstColumn, lastColumn);

                    // 设置参数
                    String dynamicParam = (String) map.get("dynamicParam");
                    dynamicParamCell = dynamicParamRow.createCell(firstColumn);
                    dynamicParamCell.setCellValue(dynamicParam);
                    setMergedRegion(workbook, newSheet, sqlRowNumber + 2, sqlRowNumber + 2, firstColumn, lastColumn);

                    // 设置赋值公式
                    String dynamicFormula = (String) map.get("dynamicFormula");
                    formulaCell = formulaRow.createCell(firstColumn);
                    formulaCell.setCellValue(dynamicFormula);
                    setMergedRegion(workbook, newSheet, sqlRowNumber + 3, sqlRowNumber + 3, firstColumn, lastColumn);

                    count++;
                }
            } else {
                highLightWholeTestCase(newSheet, mumFirstRowNumber, headRowNumber + mumSize);
            }


            orderNumber++;
            headRowNumber = headRowNumber + mumSize + 4 + 1;
        }
    }

    /**
     * 高亮整个测试用例数据
     * @param sheet
     * @param firstRow
     * @param lastRow
     */
    private void highLightWholeTestCase(Sheet sheet, int firstRow, int lastRow) {
        for (int i = firstRow; i <= lastRow; i++) {
            Row row = sheet.getRow(i);
            row.setRowStyle(highLightStyle);
        }
    }

    /**
     * 创建sheet页前5行
     * @param newSheet
     */
    private void createFiveRow(Workbook workbook, Sheet newSheet) {
        createSecondRow(newSheet);
        createTitleRow(workbook, newSheet);
        createMarkRow(newSheet);
        createBlankRow(newSheet);
    }

    private void createBlankRow(Sheet newSheet) {
        Row row = newSheet.createRow(4);
        row.setZeroHeight(true);
        for (int i = 0; i < 30; i++) {
            Cell cell = row.createCell(i);
            cell.setCellValue("");
            cell.setCellStyle(baseStyle);
        }
    }

    private void createMarkRow(Sheet newSheet) {
        Row row = newSheet.createRow(3);
        row.setZeroHeight(true);
        Cell orderNumCell = row.createCell(0);
        orderNumCell.setCellValue("");
        orderNumCell.setCellStyle(baseStyle);

        Cell tcNumCell = row.createCell(1);
        tcNumCell.setCellValue("tcNum");
        tcNumCell.setCellStyle(baseStyle);

        Cell tcNameCell = row.createCell(2);
        tcNameCell.setCellValue("tcName");
        tcNameCell.setCellStyle(baseStyle);

        Cell mumNumCell = row.createCell(3);
        mumNumCell.setCellValue("mumNum");
        mumNumCell.setCellStyle(baseStyle);

        Cell mumNameCell = row.createCell(4);
        mumNameCell.setCellValue("mumName");
        mumNameCell.setCellStyle(baseStyle);

        Cell mumURLCell = row.createCell(5);
        mumURLCell.setCellValue("mumURL");
        mumURLCell.setCellStyle(baseStyle);

        Cell methodCell = row.createCell(6);
        methodCell.setCellValue("mumMethodType");
        methodCell.setCellStyle(baseStyle);

        Cell mumParamCell = row.createCell(7);
        mumParamCell.setCellValue("mumParam");
        mumParamCell.setCellStyle(baseStyle);

        Cell typeCell = row.createCell(8);
        typeCell.setCellValue("mumParamType");
        typeCell.setCellStyle(baseStyle);

        Cell dataDescribeCell = row.createCell(9);
        dataDescribeCell.setCellValue("dataDescribe");
        dataDescribeCell.setCellStyle(baseStyle);
    }

    private void createTitleRow(Workbook workbook, Sheet newSheet) {
        CellStyle style = workbook.createCellStyle();
        // 设置边框样式
        style.setBorderBottom(CellStyle.BORDER_THIN);
        style.setBorderTop(CellStyle.BORDER_THIN);
        style.setBorderLeft(CellStyle.BORDER_THIN);
        style.setBorderRight(CellStyle.BORDER_THIN);
        style.setBottomBorderColor(IndexedColors.BLACK.getIndex());
        style.setTopBorderColor(IndexedColors.BLACK.getIndex());
        style.setRightBorderColor(IndexedColors.BLACK.getIndex());
        style.setLeftBorderColor(IndexedColors.BLACK.getIndex());
        // 设置垂直居中
        style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
        // 设置居中
        style.setAlignment(CellStyle.ALIGN_CENTER);
        // 设置填充样式
        style.setFillPattern(CellStyle.SOLID_FOREGROUND);
        style.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
        // 设置粗体
        Font font = workbook.createFont();
        font.setBoldweight(Font.BOLDWEIGHT_BOLD);
        style.setFont(font);

        Row row = newSheet.createRow(2);
        Cell orderNumCell = row.createCell(0);
        orderNumCell.setCellValue("序号");
        orderNumCell.setCellStyle(style);

        Cell tcNumCell = row.createCell(1);
        tcNumCell.setCellValue("用例ID");
        tcNumCell.setCellStyle(style);

        Cell tcNameCell = row.createCell(2);
        tcNameCell.setCellValue("用例名称");
        tcNameCell.setCellStyle(style);

        Cell mumNumCell = row.createCell(3);
        mumNumCell.setCellValue("接口ID");
        mumNumCell.setCellStyle(style);

        Cell mumNameCell = row.createCell(4);
        mumNameCell.setCellValue("接口名称");
        mumNameCell.setCellStyle(style);

        Cell mumURLCell = row.createCell(5);
        mumURLCell.setCellValue("相对路径（URL）");
        mumURLCell.setCellStyle(style);

        Cell methodCell = row.createCell(6);
        methodCell.setCellValue("请求方式");
        methodCell.setCellStyle(style);

        Cell mumParamCell = row.createCell(7);
        mumParamCell.setCellValue("参数名称");
        mumParamCell.setCellStyle(style);

        Cell typeCell = row.createCell(8);
        typeCell.setCellValue("数据类型");
        typeCell.setCellStyle(style);

        Cell dataDescribeCell = row.createCell(9);
        dataDescribeCell.setCellValue("数据业务说明");
        dataDescribeCell.setCellStyle(style);
    }

    private void createSecondRow(Sheet newSheet) {
        Row row = newSheet.createRow(1);
        for (int i = 0; i < 100; i++) {
            Cell cell = row.createCell(i);
            cell.setCellValue(i);
            cell.setCellStyle(baseStyle);
        }
    }

    private void createFirstRow(Workbook workbook, Sheet newSheet, String projectName) {
        CellStyle style = workbook.createCellStyle();
        // 设置粗体
        Font font = workbook.createFont();
        font.setBoldweight(Font.BOLDWEIGHT_BOLD);
        font.setFontHeightInPoints((short) 16);
        font.setFontName("宋体");
        style.setFont(font);
        // 设置居中
        style.setAlignment(CellStyle.ALIGN_CENTER);
        // 设置垂直居中
        style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);

        Row row = newSheet.createRow(0);
        Cell firstCell = row.createCell(1);
        firstCell.setCellValue("项目名称：");
        firstCell.setCellStyle(style);

        Cell secondCell = row.createCell(2);
        secondCell.setCellValue(projectName);
        secondCell.setCellStyle(style);
    }

    /**
     * 将Excel列数值转换为字母
     * @param num
     * @return
     */
    public static String toRadix(int num) {
        String[] array = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
        int count = 26;
        String out;
        if(num/count != 0){
            out = array[num/count - 1];
            if(num%count == 0){
                out = out + array[num%count];
            }else{
                out = out + array[num%count - 1];
            }
        }else{
            out = array[num -1 ];
        }
        return out;
    }

    /**
     * 初始化样式
     * @param workbook
     */
    private void initStyle(Workbook workbook) {
        initBaseStyle(workbook);
        initForegroundStyle(workbook);
        initAlignRightSytle(workbook);
        initWrapTextStyle(workbook);
        initHighLightStyle(workbook);
    }

    private void setCellStyle(Cell cell, CellStyle cellStyle) {
        cell.setCellStyle(cellStyle);
    }

    /**
     * 设置合并单元格
     * @param sheet
     * @param firstRow
     * @param lastRow
     * @param firstColumn
     * @param lastColumn
     */
    private void setMergedRegion(Workbook workbook, Sheet sheet, int firstRow, int lastRow, int firstColumn, int lastColumn) {
        if (firstRow == lastRow && firstColumn == lastColumn) {
            return;
        }
        CellRangeAddress cra = new CellRangeAddress(firstRow, lastRow, firstColumn, lastColumn);
        sheet.addMergedRegion(cra);
        RegionUtil.setBorderTop(1, cra, sheet, workbook);
        RegionUtil.setBorderBottom(1, cra, sheet, workbook);
        RegionUtil.setBorderLeft(1, cra, sheet, workbook);
        RegionUtil.setBorderRight(1, cra, sheet, workbook);
    }

    /**
     * 设置多行数据
     * @param dataList
     * @param sheet
     * @param firstRow
     * @param column
     */
    private void setMultiRow(List<String> dataList, Sheet sheet, int firstRow, int column) {
        int rowNumber = firstRow;
        for (String data : dataList) {
            Row row = sheet.getRow(rowNumber);
            if (null == row) {
                row = sheet.createRow(rowNumber);
            }
            if (Constants.VALIDATE_XLSX.equals(data)) {
                row.setRowStyle(highLightStyle);
            } else {
                Cell cell = row.createCell(column);
                cell.setCellValue(data);
                setCellStyle(cell, baseStyle);
            }
            rowNumber++;
        }
    }

    private List<TestDataSheetRecord> compare(List<MstbTestCase> testCases, Map<String,
            Map<String, Object>> interfaceMap, Map<String, Map<String, Object>> testDataMap,
                                              Map<String, String> urlTestCaseMap) {
        modifiedTestCaseMap = new LinkedHashMap<String, String>();
        List<TestDataSheetRecord> list = new ArrayList<TestDataSheetRecord>();

        for (MstbTestCase testCase : testCases) {
            TestDataSheetRecord record = new TestDataSheetRecord();
            record.setTcNum(testCase.getMtcNumber());
            record.setTcName(testCase.getMtcName());
            int mtcId = testCase.getMtcId();
            Map<String, Object> dataMap = testDataMap.get(mtcId + "");
            String mumId;
            if (null != dataMap) {
                mumId = String.valueOf(dataMap.get("mumId"));
            } else {
                mumId = urlTestCaseMap.get(mtcId + "");
            }
            Map<String, Object> interfaceDataMap = interfaceMap.get(mumId);
            String mumNum = String.valueOf(interfaceDataMap.get("mumNum"));
            String mumName = String.valueOf(interfaceDataMap.get("mumName"));
            String urlPath = String.valueOf(interfaceDataMap.get("urlPath"));
            String method = String.valueOf(interfaceDataMap.get("method"));
            record.setMumNum(mumNum);
            record.setMumName(mumName);
            record.setMumURL(urlPath);
            record.setMumMethod(method);
            record.setDataDescribe(new ArrayList<String>());

            Set<String> paramNameSet = (Set<String>) interfaceDataMap.get("paramNameSet");
            List<String> paramTypeList = (List<String>) interfaceDataMap.get("paramTypeList");

            if (null == record.getMumParamType()) {
                record.setMumParamType(paramTypeList);
            }
            if (null == record.getMumParam()) {
                List<String> paramList = new ArrayList<String>();
                paramList.addAll(paramNameSet);
                record.setMumParam(paramList);
            }

            if (null != dataMap) {
                List<Map<String, Object>> valueMapList = (List<Map<String, Object>>) dataMap.get("valueMapList");

                for (Map<String, Object> valueMap : valueMapList) {
                    Map<String, String> paramMap = (Map<String, String>) valueMap.get("paramMap");
                    List<String> values = new ArrayList<String>(paramNameSet.size());
                    for (String paramName : paramNameSet) {
                        if (paramMap.containsKey(paramName)) {
                            values.add(paramMap.get(paramName));
                        } else {
                            modifiedTestCaseMap.put(testCase.getMtcNumber(), testCase.getMtcName());
                            values.add(Constants.VALIDATE_XLSX);
                        }
                    }
                    valueMap.put("values", values);
                }
                record.setTestDataList(valueMapList);
            }
            list.add(record);
        }
        return list;
    }

    /**
     * 处理测试数据sheet页数据
     * @param testDataList
     * @return
     */
    private Map<String, Map<String, Object>> handleTestDataMapList(List<IftbTestData> testDataList) {
        Map<String, Map<String, Object>> resultMap = new HashMap<String, Map<String, Object>>();

        List<Map<String, Object>> dataMapList = new ArrayList<Map<String, Object>>();
        for (IftbTestData testData : testDataList) {
            Map<String, Object> dataMap = new HashMap<String, Object>();
            dataMap.put("mtcId", testData.getMtcId() + "");
            dataMap.put("mumId", testData.getMumId() + "");
            String depend = "null";
            String head = testData.getItdName() + ">>" + depend;
            dataMap.put("head", head);
            String sql = testData.getItdSql();
            dataMap.put("sql", sql);
            String sqlExpect = testData.getItdSqlExpectResult();
            dataMap.put("sqlExpect", sqlExpect);
            String expectResult = testData.getItdExpectResult();
            dataMap.put("expectResult", expectResult);
            // 参数名与参数值
            String cols = testData.getItdCols();
            String vals = testData.getItdValues();
            Map<String, String> paramMap = handleParams(cols, vals);
            dataMap.put("paramMap", paramMap);
            // 自定义参数
            MstbDynamicParamDao dynamicParamDao = (MstbDynamicParamDao) daoMap.get("dynamicParamDao");
            List<MstbDynamicParam> dynamicParamList = dynamicParamDao.getDynamicParamListByItdId(testData.getItdId());
            StringBuilder paramBuilder = new StringBuilder();
            StringBuilder formulaBuilder = new StringBuilder();
            for (MstbDynamicParam dynamicParam : dynamicParamList) {
                String dynamicName = dynamicParam.getMdpName();
                String description = dynamicParam.getMdpDescription();
                paramBuilder.append("[").append(dynamicName).append("]").append("&").append(description).append("&;");
                String type;
                switch (dynamicParam.getMdpType()) {
                    case 1: type = "SQL";break;
                    case 2: type = "Ret_Param";break;
                    case 3: type = "Input_Param";break;
                    default: type = ""; break;
                }
                String formula = dynamicParam.getMdpFormula();
                formulaBuilder.append("[").append(dynamicName).append(":").append(type).append("] ").append(formula).append(";");
            }
            dataMap.put("dynamicParam", paramBuilder.toString());
            dataMap.put("dynamicFormula", formulaBuilder.toString());
            dataMapList.add(dataMap);
        }

        String mtcId = "";
        String mumId = "";
        Map<String, Object> map;
        List<Map<String, Object>> valueMapList = new ArrayList<Map<String, Object>>();
        for (Map<String, Object> dataMap : dataMapList) {
            if (mtcId.equals(dataMap.get("mtcId")) && mumId.equals(dataMap.get("mumId"))) {
                dataMap.remove("mtcId");
                dataMap.remove("mumId");
                valueMapList.add(dataMap);
            } else {
                map = new HashMap<String, Object>();
                valueMapList = new ArrayList<Map<String, Object>>();
                mtcId = (String) dataMap.get("mtcId");
                mumId = (String) dataMap.get("mumId");
                dataMap.remove("mtcId");
                dataMap.remove("mumId");
                valueMapList.add(dataMap);
                map.put("mtcId", mtcId);
                map.put("mumId", mumId);
                map.put("valueMapList", valueMapList);
                resultMap.put(mtcId, map);
            }
        }

        return resultMap;
    }

    /**
     * 处理接口sheet页数据
     * @param interfaceMapList
     * @return
     */
    private Map<String, Map<String, Object>> handleInterfaceMapList(List<Map<String, Object>> interfaceMapList) {
        Map<String, Map<String, Object>> map = new HashMap<String, Map<String, Object>>(interfaceMapList.size());
        for (Map<String, Object> interfaceMap : interfaceMapList) {
            Map<String, Object> valueMap = new HashMap<String, Object>();

            MstbURLManagement url = (MstbURLManagement) interfaceMap.get("url");
            valueMap.put("mumName", url.getMumName());
            valueMap.put("urlPath", url.getMumUrlPath());
            valueMap.put("method", url.getMumMethodType());
            valueMap.put("mumNum", url.getMumNumber());

            int mumId = url.getMumId();
            MstbURLParametersCriteria criteria = new MstbURLParametersCriteria();
            criteria.createCriteria().andMumIdEqualTo(mumId);
            MstbURLParametersDao urlParametersDao = (MstbURLParametersDao) daoMap.get("urlParametersDao");
            List<MstbURLParameters> parameters  = urlParametersDao.ReadByProperty(criteria);

            Set<String> paramNameSet = new LinkedHashSet<String>(parameters.size());
            List<String> paramTypeList = new ArrayList<String>(parameters.size());
            for (MstbURLParameters param : parameters) {
                paramNameSet.add(param.getMupName());
                paramTypeList.add(param.getMupType());
            }
            valueMap.put("paramNameSet", paramNameSet);
            valueMap.put("paramTypeList", paramTypeList);
            map.put(mumId + "", valueMap);
        }
        return map;
    }

    /**
     * 展开testCases，返回tcNum与tcName的映射
     * @param testCases
     * @return
     */
    private Map<String, MstbTestCase> handleTestCaseMapList(List<MstbTestCase> testCases) {
        Map<String, MstbTestCase> map = new HashMap<String, MstbTestCase>(testCases.size());
        for (MstbTestCase testCase : testCases) {
            map.put(testCase.getMtcId() + "", testCase);
        }
        return map;
    }

}
