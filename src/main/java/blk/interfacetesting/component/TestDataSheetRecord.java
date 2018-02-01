package blk.interfacetesting.component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

/**
 * 测试数据Sheet页记录对象
 * @author Mark
 * @date 2017/12/29
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TestDataSheetRecord {
    private String tcNum;

    private String tcName;

    private String mumNum;

    private String mumName;

    private String mumURL;

    private String mumMethod;

    private List<String> mumParam;

    private List<String> mumParamType;

    private List<String> dataDescribe;

    private List<Map<String, Object>> testDataList;
}
