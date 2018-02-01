package blk.interfacetesting.dao.impl.data;

import blk.interfacetesting.dao.data.IftbURLTestCaseDao;
import blk.interfacetesting.dao.data.IftbURLTestCaseMapper;
import blk.interfacetesting.dao.impl.IBaseDaoImpl;
import blk.interfacetesting.modle.data.IftbURLTestCase;
import blk.interfacetesting.modle.data.IftbURLTestCaseCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("urlTestCaseDao")
public class IftbURLTestCaseDaoImpl extends IBaseDaoImpl<IftbURLTestCase, IftbURLTestCaseCriteria> implements IftbURLTestCaseDao {

    @Autowired
    public void setiBaseMapper(IftbURLTestCaseMapper urlTestCaseMapper){
        super.setiBaseMapper(urlTestCaseMapper);
    }

    @Override
    public List<IftbURLTestCase> getURLTestCases(){
        IftbURLTestCaseMapper urlTestCaseMapper = (IftbURLTestCaseMapper)this.getiBaseMapper();
        return urlTestCaseMapper.getURLTestCases();
    }

    @Override
    public List<IftbURLTestCase> getURLTestCaseOne(Integer iutcId){
        IftbURLTestCaseMapper urlTestCaseMapper = (IftbURLTestCaseMapper)this.getiBaseMapper();
        return urlTestCaseMapper.getURLTestCaseOne(iutcId);
    }
}
