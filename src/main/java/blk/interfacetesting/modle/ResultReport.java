package blk.interfacetesting.modle;

import lombok.Data;

import java.io.Serializable;

/**
 * 测试结果记录模型类
 * Created by Mark on 2017/9/25.
 */
@Data
public class ResultReport implements Serializable {
    /**
     * 序号
     */
    private String rtdId;

    /**
     * 执行结果
     */
    private String result;

    /**
     * 执行结果描述
     */
    private String description;

    /**
     * 需求ID
     */
    private String requirementId;

    /**
     * 用例编号
     */
    private String mtcNum;

    /**
     * 用例名称
     */
    private String mtcName;

    /**
     * 接口名称
     */
    private String mumName;

    /**
     * url
     */
    private String url;

    /**
     * 数据编号
     */
    private String itdNum;

    /**
     * 前置数据
     */
    private String dependName;

    /**
     * 原录入数据
     */
    private String data;

    /**
     * 实际录入数据
     */
    private String trtdData;

    /**
     * SQL
     */
    private String sql;

    /**
     * 返回值预期结果
     */
    private String expectResult;

    /**
     * 返回值执行结果
     */
    private String executeResult;

    /**
     * 详细对比错误
     */
    private String errorDetail;

    /**
     * 返回值结果
     */
    private String comparedResult;

    /**
     * SQL预期结果
     */
    private String sqlExpectResult;

    /**
     * SQL执行结果
     */
    private String sqlExecuteResult;

    /**
     * SQL结果
     */
    private String sqlResult;

    /**
     * 执行时间
     */
    private String executeTime;

    /**
     * 状态码
     */
    private String statusCode;

    /**
     * 是否超时
     */
    private String timeout;
}
