package blk.interfacetesting.service.data;


import blk.interfacetesting.modle.data.IftbTestDataDependency;
import blk.interfacetesting.modle.data.IftbTestDataDependencyCriteria;
import blk.interfacetesting.service.IBaseService;

import java.util.List;

public interface TestDataDependencyService extends IBaseService<IftbTestDataDependency, IftbTestDataDependencyCriteria> {

    /**
     * 查询依赖数据集合
     * @return
     */
    List<IftbTestDataDependency> getListWithItdName();

    /**
     * 分页查询依赖数据集合
     * @param begin 分页开始记录
     * @param length 长度
     * @return 依赖数据集合
     */
    List<IftbTestDataDependency> getListWithItdName(int begin, int length);
}
