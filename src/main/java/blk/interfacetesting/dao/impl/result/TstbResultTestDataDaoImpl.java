package blk.interfacetesting.dao.impl.result;

import blk.interfacetesting.dao.impl.IBaseDaoImpl;
import blk.interfacetesting.dao.result.TstbResultTestDataDao;
import blk.interfacetesting.dao.result.TstbResultTestDataMapper;
import blk.interfacetesting.modle.result.TstbResultTestData;
import blk.interfacetesting.modle.result.TstbResultTestDataCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository("resultTestDataDao")
public class TstbResultTestDataDaoImpl extends IBaseDaoImpl<TstbResultTestData, TstbResultTestDataCriteria> implements TstbResultTestDataDao {

    @Autowired
    public void setiBaseMapper(TstbResultTestDataMapper resultTestDataMapper){super.setiBaseMapper(resultTestDataMapper);}

    @Override
    public List<Map> generateResultReport(int iemId) {
        TstbResultTestDataMapper resultTestDataMapper = (TstbResultTestDataMapper) this.getiBaseMapper();
        return resultTestDataMapper.generateResultReport(iemId);
    }

    @Override
    public List<Map> findUnexecutedTestData(int iemId) {
        TstbResultTestDataMapper resultTestDataMapper = (TstbResultTestDataMapper) this.getiBaseMapper();
        return resultTestDataMapper.findUnexecutedTestData(iemId);
    }

    @Override
    public int findTotalTestDataCount(int iemId) {
        TstbResultTestDataMapper resultTestDataMapper = (TstbResultTestDataMapper) this.getiBaseMapper();
        return resultTestDataMapper.findTotalTestDataCount(iemId);
    }

    @Override
    public int findExecutedDataCount(int iemId) {
        TstbResultTestDataMapper resultTestDataMapper = (TstbResultTestDataMapper) this.getiBaseMapper();
        return resultTestDataMapper.findExecutedDataCount(iemId);
    }

    @Override
    public int findPassedTestDataCount(int iemId) {
        TstbResultTestDataMapper resultTestDataMapper = (TstbResultTestDataMapper) this.getiBaseMapper();
        return resultTestDataMapper.findPassedTestDataCount(iemId);
    }

    @Override
    public int findFailedTestDataCount(int iemId) {
        TstbResultTestDataMapper resultTestDataMapper = (TstbResultTestDataMapper) this.getiBaseMapper();
        return resultTestDataMapper.findFailedTestDataCount(iemId);
    }

    @Override
    public int findTotalTestCaseCount(int iemId) {
        TstbResultTestDataMapper resultTestDataMapper = (TstbResultTestDataMapper) this.getiBaseMapper();
        return resultTestDataMapper.findTotalTestCaseCount(iemId);
    }

    @Override
    public int findPassededTestCaseCount(int iemId) {
        TstbResultTestDataMapper resultTestDataMapper = (TstbResultTestDataMapper) this.getiBaseMapper();
        return resultTestDataMapper.findPassededTestCaseCount(iemId);
    }

    @Override
    public int findFailedTestCaseCount(int iemId) {
        TstbResultTestDataMapper resultTestDataMapper = (TstbResultTestDataMapper) this.getiBaseMapper();
        return resultTestDataMapper.findFailedTestCaseCount(iemId);
    }

    @Override
    public int findUnexecutedTestCaseCount(int iemId) {
        TstbResultTestDataMapper resultTestDataMapper = (TstbResultTestDataMapper) this.getiBaseMapper();
        return resultTestDataMapper.findUnexecutedTestCaseCount(iemId);
    }
}
