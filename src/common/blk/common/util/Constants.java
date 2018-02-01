package blk.common.util;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Mark
 * @date 2018/1/18
 */
public class Constants {
    /**
     * 项目属性配置文件
     */
    public static final String SYSTEM_PROPERTIES = "system.properties";

    /**
     * info级别日志文件路径
     */
    public static final String INFO_LOG_PATH = "info.log.path";

    /**
     * 文件上传路径
     */
    public static final String UPLOAD_FILE_PATH = CommonUtils.getProperties(
            Constants.SYSTEM_PROPERTIES, "upload.file.path");

    /**
     * 空Map对象
     */
    public static final Map<String, Object> EMPTY_MAP = new HashMap<String, Object>();

    /**
     * 错误级别 Warn ，用于前台显示
     */
    public static final String MSG_WARN_PREFIX = "警告：";

    /**
     * 错误级别 Error ，用于前台显示
     */
    public static final String MSG_ERROR_PREFIX = "错误：";

    /**
     * 测试数据中 “参数名称、参数类型、参数值” 字符串所使用的分隔符
     */
    public static final String PARAMS_SEPARATOR = "#";

    /**
     * 成功
     */
    public static final int DATA_SUCCESS = 0;

    /**
     * 数据不符
     */
    public static final int DATA_FAILURE= 1;

    /**
     * 前置数据失败
     */
    public static final int DEPENDENCY_FAILURE = 2;

    /**
     * 请求失败
     */
    public static final int HTTP_ERROR = 3;

    /**
     * 超时
     */
    public static final int TIME_OUT = 4;

    /**
     * 认证失败
     */
    public static final int AUTHENTICATION_FAILURE = 5;

    /**
     * 其它错误
     */
    public static final int OTHER_ERROR = 6;

    /**
     * 连接超时，System.properties中属性
     */
    public static final String CONNECTION_TIMEOUT = "http.connection.timeout";

    /**
     * 读取超时，System.properties中属性
     */
    public static final String READ_TIMEOUT = "http.read.timeout";

    /**
     * 线程运行超时，System.properties中属性
     */
    public static final String THREAD_TIMEOUT = "thread.timeout";

    /**
     * Http工具类中请求返回值编码，System.properties中属性
     */
    public static final String ENCODING = "http.response.encoding";

    /**
     * URL的"?"
     */
    public static final String URL_QUESTION_MARK = "?";

    /**
     * 返回值通配符
     */
    public static final char NO_NEED_TO_COMPARE = '#';

    /**
     * URL的"="
     */
    public static final String URL_EQUAL_SIGN = "=";

    /**
     * URL的"&"
     */
    public static final String URL_AND_SIGN = "&";

    /**
     * 接口静态参数（秒数）
     */
    public static final String INTERFACE_STATIC_PARAM_SECOND = "[*NOW_TIME";

    /**
     * 接口静态参数（天数）
     */
    public static final String INTERFACE_STATIC_PARAM_DAY = "[*NOW_DATE";

    /**
     * 接口动态参数
     */
    public static final String INTERFACE_DYNAMIC_PARAM = "[?";

    /**
     * 接口静态参数
     */
    public static final String INTERFACE_STATIC_PARAM = "[*";

    /**
     * 动态参数
     */
    public static final String DYNAMIC_PARAM = "动态参数";

    /**
     * 静态参数
     */
    public static final String STATIC_PARAM = "静态参数";

    /**
     * 运行状态：未运行
     */
    public static final int SUCCESS = 0;

    /**
     * 运行状态：运行中
     */
    public static final int FAILURE = 1;

    /**
     * 运行状态：运行完成
     */
    public static final int NOT_EXECUTE = 2;

    /**
     * 验证测试数据文档中，高亮的标识符
     */
    public static final String VALIDATE_XLSX = "HighLight";
}
