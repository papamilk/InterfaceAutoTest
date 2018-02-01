package blk.interfacetesting.dao.data;


import blk.interfacetesting.dao.IBaseDao;
import blk.interfacetesting.modle.data.IftbTestDataDependency;
import blk.interfacetesting.modle.data.IftbTestDataDependencyCriteria;

import java.util.List;

public interface IftbTestDataDependencyDao extends IBaseDao<IftbTestDataDependency, IftbTestDataDependencyCriteria> {
    List<IftbTestDataDependency> getDependencyDatas();

    List<IftbTestDataDependency> getDependencyDataOne(Integer itddId);
}
