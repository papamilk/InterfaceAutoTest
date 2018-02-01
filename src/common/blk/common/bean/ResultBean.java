package blk.common.bean;

import blk.common.util.Constants;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Map;

/**
 * @author Mark
 * @date 2018/1/16
 */
@Data
@NoArgsConstructor
public class ResultBean<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    private boolean resultType;

    private T data;

    private Object error;

    private long timeStamp;

    public ResultBean(T data) {
        setData(data);
        setResultType(true);
        setTimeStamp(System.currentTimeMillis());
        setError(Constants.EMPTY_MAP);
    }

    public static ResultBean<Map<String, Object>> fail(Object error) {
        ResultBean<Map<String, Object>> resultBean = new ResultBean<Map<String, Object>>();
        resultBean.setResultType(false);
        resultBean.setData(Constants.EMPTY_MAP);
        resultBean.setError(error);
        resultBean.setTimeStamp(System.currentTimeMillis());
        return resultBean;
    }
}
