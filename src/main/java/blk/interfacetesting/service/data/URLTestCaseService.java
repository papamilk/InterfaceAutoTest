package blk.interfacetesting.service.data;


import blk.interfacetesting.modle.data.IftbURLTestCase;
import blk.interfacetesting.modle.data.IftbURLTestCaseCriteria;
import blk.interfacetesting.service.IBaseService;

import java.util.List;

public interface URLTestCaseService extends IBaseService<IftbURLTestCase, IftbURLTestCaseCriteria> {
    /**
     * 查询接口与测试用例映射集合
     * @return
     */
    List<IftbURLTestCase> getList();

    /**
     * 分页查询接口与测试用例映射集合
     * @param begin 分页开始记录
     * @param length 长度
     * @return 接口与测试用例映射集合
     */
    List<IftbURLTestCase> getList(int begin, int length);
}
