package blk.interfacetesting.dao.data;

import blk.interfacetesting.dao.IBaseMapper;
import blk.interfacetesting.modle.data.IftbTestDataDependency;
import blk.interfacetesting.modle.data.IftbTestDataDependencyCriteria;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("testDataDependencyMapper")
public interface IftbTestDataDependencyMapper  extends IBaseMapper<IftbTestDataDependency, IftbTestDataDependencyCriteria> {
    List<IftbTestDataDependency> getDependencyDatas();

    List<IftbTestDataDependency> getDependencyDataOne(Integer itddId);
}