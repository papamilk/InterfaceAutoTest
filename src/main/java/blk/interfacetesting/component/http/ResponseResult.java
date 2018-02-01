package blk.interfacetesting.component.http;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * @author Mark 7/20/2017 10:34 AM
 */
@Component
@Data
public class ResponseResult {
    private int status; // 状态：0表示成功，1表示数据不符，2表示Http状态异常，3表示超时连接，4权限认证失败
    private String description; // 执行结果描述
    private String statusCode; // http状态码
    private long time; // 请求运行时间
    private String executeResult; // 执行结果
}
