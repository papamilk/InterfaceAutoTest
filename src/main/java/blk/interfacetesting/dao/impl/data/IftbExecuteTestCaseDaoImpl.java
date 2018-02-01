package blk.interfacetesting.dao.impl.data;

import blk.interfacetesting.dao.data.IftbExecuteTestCaseDao;
import blk.interfacetesting.dao.data.IftbExecuteTestCaseMapper;
import blk.interfacetesting.dao.impl.IBaseDaoImpl;
import blk.interfacetesting.modle.data.IftbExecuteTestCase;
import blk.interfacetesting.modle.data.IftbExecuteTestCaseCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("executeTestCaseDao")
public class IftbExecuteTestCaseDaoImpl extends IBaseDaoImpl<IftbExecuteTestCase, IftbExecuteTestCaseCriteria> implements IftbExecuteTestCaseDao {

    @Autowired
    public void setiBaseMapper(IftbExecuteTestCaseMapper executeTestCaseMapper){super.setiBaseMapper(executeTestCaseMapper);}

    @Override
    public List<IftbExecuteTestCase> getExecuteTestCases(){
        IftbExecuteTestCaseMapper executeTestCaseMapper = (IftbExecuteTestCaseMapper)this.getiBaseMapper();
        return executeTestCaseMapper.getExecuteTestCases();
    }

    @Override
    public List<IftbExecuteTestCase> getExecuteTestCaseOne(Integer ietcId){
        IftbExecuteTestCaseMapper executeTestCaseMapper = (IftbExecuteTestCaseMapper)this.getiBaseMapper();
        return executeTestCaseMapper.getExecuteTestCaseOne(ietcId);
    }
}
