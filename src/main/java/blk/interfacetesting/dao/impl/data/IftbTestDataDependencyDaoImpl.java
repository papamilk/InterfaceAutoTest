package blk.interfacetesting.dao.impl.data;

import blk.interfacetesting.dao.data.IftbTestDataDependencyDao;
import blk.interfacetesting.dao.data.IftbTestDataDependencyMapper;
import blk.interfacetesting.dao.impl.IBaseDaoImpl;
import blk.interfacetesting.modle.data.IftbTestDataDependency;
import blk.interfacetesting.modle.data.IftbTestDataDependencyCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("testDataDependencyDao")
public class IftbTestDataDependencyDaoImpl extends IBaseDaoImpl<IftbTestDataDependency, IftbTestDataDependencyCriteria> implements IftbTestDataDependencyDao {

    @Autowired
    public void setiBaseMapper(IftbTestDataDependencyMapper testDataDependencyMapper) {
        super.setiBaseMapper(testDataDependencyMapper);
    }

    @Override
    public List<IftbTestDataDependency> getDependencyDatas(){
        IftbTestDataDependencyMapper testDataDependencyMapper = (IftbTestDataDependencyMapper) this.getiBaseMapper();
        return testDataDependencyMapper.getDependencyDatas();
    }

    @Override
    public List<IftbTestDataDependency> getDependencyDataOne(Integer itddId){
        IftbTestDataDependencyMapper testDataDependencyMapper = (IftbTestDataDependencyMapper) this.getiBaseMapper();
        return testDataDependencyMapper.getDependencyDataOne(itddId);
    }
}
