package blk.interfacetesting.component.http;

import blk.common.util.CommonUtils;
import blk.common.util.Constants;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

/**
 * 发送HTTP请求工具类
 * @author Mark
 * @date 7/18/2017 3:13 PM
 */
@Component
@Data
public class HttpRequestUtils {
    private static final Logger logger = LoggerFactory.getLogger(HttpRequestUtils.class);

    private HttpURLConnection connection;
    private OutputStream outputStream = null;
    private OutputStreamWriter outputStreamWriter = null;
    private InputStream inputStream = null;
    private InputStreamReader inputStreamReader = null;
    private BufferedReader reader = null;
    private String paramStr;
    private HttpMethodEnum method;
    private static final long threadTimeout;
    private static final int connectTimeout;
    private static final int readTimeout;
    private ResponseResult responseResult = new ResponseResult();

    // 从配置文件获取参数值
    static {
        try {
            threadTimeout = Long.valueOf(CommonUtils.getProperties("system.properties", Constants.THREAD_TIMEOUT));
            connectTimeout = Integer.valueOf(CommonUtils.getProperties("system.properties", Constants.CONNECTION_TIMEOUT));
            readTimeout = Integer.valueOf(CommonUtils.getProperties("system.properties", Constants.READ_TIMEOUT));
        } catch (Exception e) {
            throw new RuntimeException("初始化参数失败...", e);
        }
    }

    /**
     * 打开连接，获取结果
     * @param connection HttpURLConnection连接
     */
    private void openConnection(HttpURLConnection connection){
        try {
            if (method.equals(HttpMethodEnum.POST) || method.equals(HttpMethodEnum.PUT)) {
                outputStream = connection.getOutputStream(); // 建立连接
                outputStreamWriter = new OutputStreamWriter(outputStream, "UTF-8");
                outputStreamWriter.write(paramStr);
                outputStreamWriter.flush();
            }
            // 处理HTTP状态码
            if (!handlerStatus(connection.getResponseCode())) {
                return ;
            }
            inputStream = connection.getInputStream();
            inputStreamReader = new InputStreamReader(inputStream, "UTF-8");
            reader = new BufferedReader(inputStreamReader);
            StringBuilder resultBuffer = new StringBuilder();
            String tempLine;
            while ((tempLine = reader.readLine()) != null) {
                resultBuffer.append(tempLine);
            }
            responseResult.setExecuteResult(resultBuffer.toString());
        } catch (IOException e) {
            logger.error("打开HTTP连接时报错", e);
            throw new RuntimeException("打开HTTP连接时报错", e);
        } finally {
            // 关闭资源
            close();
        }
    }

    /**
     * 处理HTTP状态码
     * @param responseCode HTTP状态码
     */
    private boolean handlerStatus(int responseCode){
        // 成功则直接返回继续执行代码
        if (responseCode == HttpURLConnection.HTTP_OK) {
            responseResult.setStatusCode(String.valueOf(responseCode));
            return true;
        } else if (responseCode == HttpURLConnection.HTTP_MOVED_TEMP) {
            // 重定向则重新建立重定向连接
            connection = getConnection(connection.getHeaderField("Location"));
            openConnection(connection);
        } else {
            responseResult.setStatus(Constants.HTTP_ERROR);
            responseResult.setDescription("HTTP状态码为" + responseCode);
            responseResult.setStatusCode(String.valueOf(responseCode));
        }
        return false;
    }

    /**
     * 关闭连接
     */
    private void close() {
        try {
            if (getOutputStreamWriter() != null) {
                getOutputStreamWriter().close();
                setOutputStreamWriter(null);
            }
            if (getOutputStream() != null) {
                getOutputStream().close();
                setOutputStream(null);
            }
            if (getReader() != null) {
                getReader().close();
                setReader(null);
            }
            if (getInputStreamReader() != null) {
                getInputStreamReader().close();
                setInputStreamReader(null);
            }
            if (getInputStream() != null) {
                getInputStream().close();
                setInputStream(null);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 初始化Connection
     * @param url 请求地址
     * @return 返回connection
     */
    private HttpURLConnection getConnection(String url){
        try {
            // GET和DELETE参数设置
            StringBuilder builder;
            if (method.equals(HttpMethodEnum.GET) || method.equals(HttpMethodEnum.DELETE)) {
                builder = new StringBuilder(url);
                builder.append(Constants.URL_QUESTION_MARK).append(paramStr);
                url = builder.toString();
            }
            URL requestURL = new URL(url);
            connection = (HttpURLConnection) requestURL.openConnection();
            connection.setRequestMethod(method.getMethodType());
            connection.setConnectTimeout(connectTimeout); // 设置超时连接
            connection.setReadTimeout(readTimeout); // 设置超时读取
            connection.setInstanceFollowRedirects(false); // 设置不自动重定向
            connection.setRequestProperty("Accept-Charset", "UTF-8");
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8");
            // POST和PUT请求设置
            if (method.equals(HttpMethodEnum.POST) || method.equals(HttpMethodEnum.PUT)) {
                connection.setDoOutput(true);
                connection.setRequestProperty("Content-Length", String.valueOf(paramStr.length()));
            }
            return connection;
        } catch (Exception e) {
            logger.error("Http初始化连接出错", e);
            throw new RuntimeException("Http初始化连接出错", e);
        }
    }

    /**
     * 发送http请求
     * @param url url路径
     * @param params 请求参数
     * @param method 请求方式
     * @return
     */
    public ResponseResult sendHttpRequest(String url, Map<String, String> params, HttpMethodEnum method){
        setMethod(method);
        setParamStr(handlerParams(params));
        setConnection(getConnection(url));
        openConnection(connection);
        return responseResult;
    }

    /**
     * 处理请求参数
     * @param params 请求参数
     * @return 字符串，格式：a=1&b=2
     */
    private String handlerParams(Map<String, String> params){
        try {
            StringBuilder paramBuffer = new StringBuilder();
            if (params != null) {
                for (Map.Entry<String, String> entry : params.entrySet()) {
                    if (StringUtils.isNotBlank(entry.getKey()) && StringUtils.isNotBlank(entry.getValue())) {
                        String key = transformEscapeString(entry.getKey());
                        String value = transformEscapeString(entry.getValue());
                        paramBuffer.append(key).append(Constants.URL_EQUAL_SIGN).append(value)
                                .append(Constants.URL_AND_SIGN);
                    }
                }
            }
            if (StringUtils.isNoneBlank(paramBuffer)) {
                paramBuffer.setLength(paramBuffer.length() - 1);
                logger.info("请求参数:" + paramBuffer.toString());
                return paramBuffer.toString();
            }
            logger.info("请求参数:" + "");
            return "";
        } catch (Exception e) {
            logger.warn("发送请求时，参数处理出错" + params.toString(), e);
            throw new RuntimeException("发送请求时，参数处理出错" + params.toString(), e);
        }
    }

    /**
     * 处理URL中的转义字符
     * "+" -> "%2B"
     * " " -> "%20"
     * "/" -> "%2F"
     * "?" -> "%3F"
     * "%" -> "%25"
     * "#" -> "%23"
     * "&" -> "%26"
     * "=" -> "%3D"
     * @param string 需要转义的字符串
     * @return 转义后的字符串
     */
    private String transformEscapeString(String string) {
        if (string.contains("%")) {
            string = string.replace("%", "%25");
        }
        if (string.contains("+")) {
            string = string.replace("+", "%2B");
        }
        if (string.contains(" ")) {
            string = string.replace(" ", "%20");
        }
        if (string.contains("/")) {
            string = string.replace("/", "%2F");
        }
        if (string.contains("?")) {
            string = string.replace("?", "%3F");
        }
        if (string.contains("#")) {
            string = string.replace("#", "%23");
        }
        if (string.contains("&")) {
            string = string.replace("&", "%26");
        }
        if (string.contains("=")) {
            string = string.replace("=", "%3D");
        }
        return string;
    }
}
