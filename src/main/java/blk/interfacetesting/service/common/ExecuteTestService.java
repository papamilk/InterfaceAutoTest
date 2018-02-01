package blk.interfacetesting.service.common;

import java.util.List;
import java.util.Map;

/**
 * @author Mark
 * @date 2018/1/25
 */
public interface ExecuteTestService {
    /**
     * 执行测试，根据场景序号，获取数据
     * @param iemId 场景序号
     * @return
     */
    int execute(int iemId);

    List<Map<String, Object>> executeQuery(String sql);

    int executeUpdate(String sql);

    /**
     * 查询总测试数据数量，进度条显示
     * @param iemId 场景序号
     * @return
     */
    int findTotalTestDataCount(int iemId);

    /**
     * 查询已执行测试数据数量，进度条显示
     * @param iemId 场景序号
     * @return
     */
    int findExecutedDataCount(int iemId);
}
