package blk.interfacetesting.service.data;

import blk.interfacetesting.modle.data.MstbTestCase;
import blk.interfacetesting.modle.data.MstbTestCaseCriteria;
import blk.interfacetesting.service.IBaseService;

import java.util.List;
import java.util.Map;

public interface TestCaseService extends IBaseService<MstbTestCase, MstbTestCaseCriteria> {
    /**
     * 查询测试用例集合
     * @return 测试用例集合
     */
    List<MstbTestCase> getList();

    /**
     * 分页查询测试用例集合
     * @param begin 分页开始记录
     * @param length 长度
     * @return 测试用例集合
     */
    List<MstbTestCase> getList(int begin, int length);

    /**
     * 验证测试用例名称唯一性
     * @param mtcName 测试用例名称
     * @return true验证通过，指测试用例名称是唯一的
     */
    boolean checkName(String mtcName);
}
