package blk.interfacetesting.service.common;

import blk.common.exception.SystemException;
import blk.common.util.CommonUtils;
import blk.common.util.Constants;
import blk.interfacetesting.dao.result.TstbResultTestDataDao;
import blk.interfacetesting.modle.ResultReport;
import org.apache.commons.lang3.StringUtils;
import org.jxls.common.Context;
import org.jxls.util.JxlsHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Mark
 * @date 2018/1/26
 */
@Service("downloadService")
public class DownloadService {
    private TstbResultTestDataDao resultTestDataDao;

    @Autowired
    public DownloadService(TstbResultTestDataDao resultTestDataDao) {
        this.resultTestDataDao = resultTestDataDao;
    }

    /**
     * 资源文件路径
     */
    private final String templatePath = "/excel_template/";

    public boolean logFile(HttpServletResponse response) {
        try {
            response.setContentType("text/plain");
            response.setHeader("Content-Disposition","attachment; filename=info.log");
            response.setCharacterEncoding("UTF-8");
            response.setHeader("Pragma", "No-cache");
            response.setHeader("Cache-Control", "No-cache");
            response.setDateHeader("Expires", 0);
            String path = CommonUtils.getProperties(Constants.SYSTEM_PROPERTIES, Constants.INFO_LOG_PATH);
            FileInputStream fis = new FileInputStream(new File(path));
            BufferedInputStream bufferedInputStream = new BufferedInputStream(fis);
            byte[] b = new byte[bufferedInputStream.available()];
            bufferedInputStream.read(b);
            OutputStream outputStream = response.getOutputStream();
            outputStream.write(b);
            bufferedInputStream.close();
            outputStream.flush();
            outputStream.close();
        } catch (Exception e) {
            throw new SystemException("下载日志文件出错", e);
        }
        return true;
    }

    /**
     * 获取自动化导入模板文件流
     * @return 文件流
     * @throws FileNotFoundException e
     */
    public void getTemplate(HttpServletResponse response) {
        try {
            response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
            response.setHeader("Content-Disposition","attachment; filename=BLK_AT_Template.xlsm");
            response.setCharacterEncoding("UTF-8");
            response.setHeader("Pragma", "No-cache");
            response.setHeader("Cache-Control", "No-cache");
            response.setDateHeader("Expires", 0);
            InputStream fis = getClass().getClassLoader().getResourceAsStream(templatePath + "BLK_AT_Template.xlsm");
            BufferedInputStream bufferedInputStream = new BufferedInputStream(fis);
            byte[] b = new byte[bufferedInputStream.available()];
            bufferedInputStream.read(b);
            OutputStream outputStream = response.getOutputStream();
            outputStream.write(b);
            bufferedInputStream.close();
            outputStream.flush();
            outputStream.close();
        } catch (Exception e) {
            throw new SystemException("获取导入数据模板出错", e);
        }
    }

    /**
     * 创建测试报告Excel
     * @param iemId 场景id
     */
    public void generateResultReportExcel(int iemId, HttpServletResponse response) {
        final Map<String, Object> dataMap = handleResultList(iemId);
        final String suffix = "xls"; // 文件后缀
        final String templateName = "result_report";
        try {
            response.setContentType("application/vnd.ms-excel");
            response.setHeader("Content-Disposition","attachment; filename=result-report.xls");
            response.setCharacterEncoding("UTF-8");
            response.setHeader("Pragma", "No-cache");
            response.setHeader("Cache-Control", "No-cache");
            response.setDateHeader("Expires", 0);

            InputStream is = getClass().getClassLoader().getResourceAsStream(templatePath + templateName + "." + suffix);
            OutputStream os = response.getOutputStream();
            Context context = new Context(dataMap);
            JxlsHelper.getInstance().processTemplate(is, os, context);
            response.flushBuffer();
            is.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 根据执行测试结果封装数据
     * @param iemId 场景id
     * @return Map对象
     * key: successList, failureList
     * value: 成功记录集合, 失败记录集合
     */
    @SuppressWarnings("unchecked")
    private Map<String,Object> handleResultList(int iemId) {
        List<Map> resultList = resultTestDataDao.generateResultReport(iemId);
        List<Map> unexecutedList = resultTestDataDao.findUnexecutedTestData(iemId);
        int id = 1;
        for (Map map : unexecutedList) {
            map.put("id", id);
            id++;
        }
        List<ResultReport> successList = new ArrayList<ResultReport>(); // 结果为成功的数据集合
        List<ResultReport> failureList = new ArrayList<ResultReport>(); // 结果为失败的数据集合
        for (Map resultMap : resultList) {
            ResultReport report = new ResultReport();
            report.setRtdId(String.valueOf(resultMap.get("rtdId"))); // 序号
            if (resultMap.get("result") == null) { // 执行结果
                report.setResult("");
            } else {
                report.setResult(resultMap.get("result").toString());
            }
            if (resultMap.get("description") == null) { // 执行结果描述

            } else {
                report.setDescription(resultMap.get("description").toString());
            }
            // 处理返回值
            if (resultMap.get("comparedResult") == null) { // 返回值结果
                report.setComparedResult("");
                report.setSqlResult("");
            } else {
                int comparedResult = Integer.valueOf(resultMap.get("comparedResult").toString());
                if (resultMap.get("sqlResult") == null) { // SQL结果
                    report.setSqlResult("");
                } else {
                    int sqlResult = Integer.valueOf(resultMap.get("sqlResult").toString());
                    if (comparedResult == 0 && sqlResult == 0) {
                        report.setComparedResult("成功");
                        report.setSqlResult("成功");
                        report.setDescription("成功");
                    } else if (comparedResult == 0 && sqlResult == 1) {
                        report.setComparedResult("成功");
                        report.setSqlResult("失败");
                        report.setDescription("返回值结果与预期结果一致但SQL执行结果与预期结果不一致");
                    } else {
                        report.setComparedResult("失败");
                        report.setSqlResult("失败");
                        report.setDescription("返回值结果与预期结果不一致");
                    }
                }
            }
            report.setRequirementId(""); // 需求ID
            report.setMtcNum(resultMap.get("mtcNum").toString()); // 用例编号
            report.setMtcName(resultMap.get("mtcName").toString()); // 用例名称
            report.setMumName(resultMap.get("mumName").toString()); // 接口名称
            report.setUrl(resultMap.get("url").toString()); // url
            report.setItdNum(resultMap.get("itdNum").toString()); // 数据编号
            // 录入数据
            String data;
            if (resultMap.get("itdCols").toString().indexOf(Constants.PARAMS_SEPARATOR) > 0){
                //多个参数以“#”分隔
                data = combineData(resultMap.get("itdCols").toString(), resultMap.get("itdVals").toString());
            }else {
                //单个参数直接拼接
                data = resultMap.get("itdCols").toString() + ":" + resultMap.get("itdVals").toString();
            }
            report.setData(data);
            if (resultMap.get("sql") == null) { // SQL
                report.setSql("");
            } else {
                report.setSql(resultMap.get("sql").toString());
            }
            if (resultMap.get("expectResult") == null) { // 返回值预期结果
                report.setExpectResult("");
            } else {
                report.setExpectResult(resultMap.get("expectResult").toString());
            }
            if (resultMap.get("executeResult") == null) { // 返回值执行结果
                report.setExecuteResult("");
            } else {
                report.setExecuteResult(resultMap.get("executeResult").toString());
            }
            if (resultMap.get("sqlExpectResult") == null) { // SQL预期结果
                report.setSqlExpectResult("");
            } else {
                report.setSqlExpectResult(resultMap.get("sqlExpectResult").toString());
            }
            if (resultMap.get("sqlExecuteResult") == null) { // SQL执行结果
                report.setSqlExecuteResult("");
            } else {
                report.setSqlExecuteResult(resultMap.get("sqlExecuteResult").toString());
            }
            if (resultMap.get("statusCode") == null) { // 状态码
                report.setStatusCode("");
            } else {
                report.setStatusCode(resultMap.get("statusCode").toString());
            }
            if (resultMap.get("executeTime") == null) { // 执行时间
                report.setStatusCode("");
                report.setTimeout("");
            } else {
                String time = resultMap.get("executeTime").toString();
                report.setExecuteTime(time);
                // 是否超时
                if (isTimeout(time)) {
                    report.setTimeout("是");
                } else {
                    report.setTimeout("否");
                }
            }
            if ("失败".equals(report.getResult())) {
                if (resultMap.get("errorDetail") == null) {
                    report.setErrorDetail("");
                } else {
                    report.setErrorDetail(resultMap.get("errorDetail").toString());
                }
                if (resultMap.get("trtdData") == null) {
                    report.setTrtdData("");
                } else {
                    report.setTrtdData(resultMap.get("trtdData").toString());
                }
                if (resultMap.get("dependName") == null) {
                    report.setDependName("");
                } else {
                    report.setDependName(resultMap.get("dependName").toString());
                }
                failureList.add(report);
            } else if ("成功".equals(report.getResult())) {
                successList.add(report);
            }
        }
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("successList", successList);
        map.put("failureList", failureList);
        map.put("unexecutedList", unexecutedList);
        // 测试用例统计数据
        Map<String, String> statisticsMap = findStatistic(iemId);
        map.put("stat", statisticsMap);
        return map;
    }

    /**
     * 测试报告统计结果
     * @param iemId 场景Id
     * @return
     */
    public Map<String,String> findStatistic(int iemId) {
        Map<String, String> statisticsMap = new HashMap<String, String>();
        // 总测试用例数量
        int totalTestCaseCount = resultTestDataDao.findTotalTestCaseCount(iemId);
        // 通过测试用例数量
        int passedTestCaseCount = resultTestDataDao.findPassededTestCaseCount(iemId);
        // 未通过测试用例数量
        int failedTestCaseCount = resultTestDataDao.findFailedTestCaseCount(iemId);
        // 已执行测试用例数量
        int executedTestCaseCount = passedTestCaseCount + failedTestCaseCount;
        // 未执行测试用例数量
        int unexecutedTestCaseCount = resultTestDataDao.findUnexecutedTestCaseCount(iemId);

        // 总测试数据数量
        int totalTestDataCount = resultTestDataDao.findTotalTestDataCount(iemId);
        // 已执行测试数据数量
        int executedTestDataCount = resultTestDataDao.findExecutedDataCount(iemId);
        // 通过测试数据数量
        int passedTestDataCount = resultTestDataDao.findPassedTestDataCount(iemId);
        // 失败的测试数据数量
        int failedTestDataCount = resultTestDataDao.findFailedTestDataCount(iemId);
        // 未执行测试数据数据
        List<Map> unexecutedTestDataList = resultTestDataDao.findUnexecutedTestData(iemId);
        int unexecutedTestDataCount = unexecutedTestDataList.size();
        // 执行失败测试数据数量
        int executFailTestDataCount = executedTestDataCount - passedTestDataCount;

        // 执行测试数量比例
        float executedTestDataRate = (float) executedTestDataCount / totalTestDataCount;
        // 总通过测试数量比例
        float totalPassedTestDataRate = (float) passedTestDataCount / totalTestDataCount;
        // 通过测试数据比例
        float passedTestDataRate = (float) passedTestDataCount / executedTestDataCount;
        // 失败测试数量比例
        float failedTestDataRate = (float) failedTestDataCount / executedTestDataCount;
        // 未执行测试数量比例
        float unexecutedTestDataRate = (float) unexecutedTestDataCount / totalTestDataCount;

        statisticsMap.put("totalTestCaseCount", totalTestCaseCount + "");
        statisticsMap.put("executedTestCaseCount", executedTestCaseCount + "");
        statisticsMap.put("passedTestCaseCount", passedTestCaseCount + "");
        statisticsMap.put("failedTestCaseCount", failedTestCaseCount + "");
        statisticsMap.put("unexecutedTestCaseCount", unexecutedTestCaseCount + "");
        statisticsMap.put("totalTestDataCount", totalTestDataCount + "");
        statisticsMap.put("executedTestDataCount", executedTestDataCount + "");
        statisticsMap.put("passedTestDataCount", passedTestDataCount + "");
        statisticsMap.put("failedTestDataCount", failedTestDataCount + "");
        statisticsMap.put("unexecutedTestDataCount", unexecutedTestDataCount + "");
        statisticsMap.put("executFailTestDataCount", executFailTestDataCount + "");

        DecimalFormat df = new DecimalFormat("#.##");
        statisticsMap.put("executedTestDataRate", df.format(executedTestDataRate));
        statisticsMap.put("totalPassedTestDataRate", df.format(totalPassedTestDataRate));
        statisticsMap.put("passedTestDataRate", df.format(passedTestDataRate));
        statisticsMap.put("failedTestDataRate", df.format(failedTestDataRate));
        statisticsMap.put("unexecutedTestDataRate", df.format(unexecutedTestDataRate));
        return statisticsMap;
    }

    /**
     * 判断执行时间是否超时
     * @param time 执行时间 格式：20:100
     * @return true 超时, false 未超时
     */
    private boolean isTimeout(String time) {
        String[] strs = time.split(":", 2);
        int expectTime = Integer.valueOf(strs[0]); // 期望时间
        int realTime = Integer.valueOf(strs[1]); // 实际时间
        return expectTime > 0 && realTime > expectTime;
    }

    /**
     * 合并参数名与参数值
     * @param itdCols 参数名
     * @param itdVals 参数值
     * @return 字符串
     */
    private String combineData(String itdCols, String itdVals) {
        String[] cols = itdCols.split("#");
        String[] vals = StringUtils.splitByWholeSeparatorPreserveAllTokens(itdVals, "#");
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < cols.length; i++) {
            builder.append(cols[i]).append(":").append(vals[i]).append(String.valueOf((char)10));
        }
        return builder.toString();
    }

}
