package blk.interfacetesting.service.impl.data;

import blk.interfacetesting.dao.data.IftbExecuteTestCaseDao;
import blk.interfacetesting.modle.data.IftbExecuteTestCase;
import blk.interfacetesting.modle.data.IftbExecuteTestCaseCriteria;
import blk.interfacetesting.service.data.ExecuteTestCaseService;
import blk.interfacetesting.service.impl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("executeTestCaseService")
public class ExecuteTestCaseServiceImpl extends BaseServiceImpl<IftbExecuteTestCase, IftbExecuteTestCaseCriteria> implements ExecuteTestCaseService {

    @Autowired
    public void setBaseDao(IftbExecuteTestCaseDao executeTestCaseDao){
        super.setBaseDao(executeTestCaseDao);
    }

    @Override
    public List<IftbExecuteTestCase> getExecuteTestCases(){
        IftbExecuteTestCaseDao executeTestCaseDao = (IftbExecuteTestCaseDao) this.getBaseDao();
        return executeTestCaseDao.getExecuteTestCases();
    }

    @Override
    public List<IftbExecuteTestCase> getExecuteTestCaseOne(Integer ietcId){
        IftbExecuteTestCaseDao executeTestCaseDao = (IftbExecuteTestCaseDao) this.getBaseDao();
        return executeTestCaseDao.getExecuteTestCaseOne(ietcId);
    }
}
