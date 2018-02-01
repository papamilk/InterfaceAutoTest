package blk.interfacetesting.dao.result;

import blk.interfacetesting.dao.IBaseDao;
import blk.interfacetesting.modle.result.TstbResultTestData;
import blk.interfacetesting.modle.result.TstbResultTestDataCriteria;

import java.util.List;
import java.util.Map;

public interface TstbResultTestDataDao extends IBaseDao<TstbResultTestData, TstbResultTestDataCriteria> {
    /**
     * 根据场景序号生成测试数据报告
     * @param iemId 执行场景序号
     * @return
     */
    List<Map> generateResultReport(int iemId);

    /**
     * 查询未执行测试数据记录
     * @param iemId 执行场景序号
     * @return
     */
    List<Map> findUnexecutedTestData(int iemId);

    /**
     * 查询总测试数据数量
     * @param iemId 执行场景序号
     * @return
     */
    int findTotalTestDataCount(int iemId);

    /**
     * 查询已执行测试数据数量
     * @param iemId 执行场景序号
     * @return
     */
    int findExecutedDataCount(int iemId);

    /**
     * 通过测试的测试数据数量
     * @param iemId 执行场景序号
     * @return
     */
    int findPassedTestDataCount(int iemId);

    /**
     * 失败的测试数据数量
     * @param iemId 执行场景序号
     * @return
     */
    int findFailedTestDataCount(int iemId);

    /**
     * 总测试用例数量
     * @param iemId 执行场景序号
     * @return
     */
    int findTotalTestCaseCount(int iemId);

    /**
     * 通过的测试用例数量
     * @param iemId 执行场景序号
     * @return
     */
    int findPassededTestCaseCount(int iemId);

    /**
     * 失败的测试用例数量
     * @param iemId 执行场景序号
     * @return
     */
    int findFailedTestCaseCount(int iemId);

    /**
     * 未执行的测试用例数量
     * @param iemId 执行场景序号
     * @return
     */
    int findUnexecutedTestCaseCount(int iemId);
}
