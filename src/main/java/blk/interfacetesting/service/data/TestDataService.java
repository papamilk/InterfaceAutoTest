package blk.interfacetesting.service.data;

import blk.interfacetesting.modle.data.IftbTestData;
import blk.interfacetesting.modle.data.IftbTestDataCriteria;
import blk.interfacetesting.service.IBaseService;

import java.util.List;
import java.util.Map;

public interface TestDataService extends IBaseService<IftbTestData, IftbTestDataCriteria> {
    /**
     * 分页查询测试数据集合（包含mtcName, mumName）
     * @return 测试数据集合
     */
    List<IftbTestData> specialSearchList();

    /**
     * 分页查询测试数据集合（包含mtcName, mumName）
     * @param begin 分页开始记录
     * @param length 长度
     * @return 测试数据集合
     */
    List<IftbTestData> specialSearchList(int begin, int length);

    /**
     * 测试数据名称唯一性验证
     * @param itdName 测试数据名称
     * @return true验证通过，指测试数据名称是唯一的
     */
    boolean checkName(String itdName);

    /**
     * 根据mtcId查询测试数据集合
     * @param mtcId 测试用例序号
     * @return
     */
    List<IftbTestData> getListByMtcId(Integer mtcId);

    /**
     * 获取测试场景下待执行测试数据集合
     * @param iemId 场景序号
     * @return
     */
    List<IftbTestData> getExecuteList(int iemId);
}
