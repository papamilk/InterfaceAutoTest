package blk.common.bean;

import blk.common.util.Constants;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Mark
 * @date 2018/1/18
 */
@Data
@NoArgsConstructor
public class PageResultBean<T> implements Serializable{
    private static final long serialVersionUID = 1L;

    private boolean resultType;

    private Map<String, Object> data;

    private Object error;

    private long timeStamp;

    public PageResultBean(T data) {
        List dataList = (List) data;
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("Rows", data);
        map.put("Total", dataList.size());
        this.data = map;
        setResultType(true);
        setTimeStamp(System.currentTimeMillis());
        setError(Constants.EMPTY_MAP);
    }
}
