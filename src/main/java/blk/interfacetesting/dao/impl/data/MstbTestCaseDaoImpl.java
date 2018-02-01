package blk.interfacetesting.dao.impl.data;

import blk.interfacetesting.dao.data.MstbTestCaseDao;
import blk.interfacetesting.dao.data.MstbTestCaseMapper;
import blk.interfacetesting.dao.impl.IBaseDaoImpl;
import blk.interfacetesting.modle.data.MstbTestCase;
import blk.interfacetesting.modle.data.MstbTestCaseCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("testCaseDao")
public class MstbTestCaseDaoImpl extends IBaseDaoImpl<MstbTestCase, MstbTestCaseCriteria> implements MstbTestCaseDao {

    @Autowired
    public void setiBaseMapper(MstbTestCaseMapper testCaseMapper) {
        super.setiBaseMapper(testCaseMapper);
    }

    @Override
    public List<MstbTestCase> getTestCase(int mpId, int iemId) {
        MstbTestCaseMapper testCaseMapper = (MstbTestCaseMapper) this.getiBaseMapper();
        return testCaseMapper.getTestCase(mpId, iemId);
    }
}
