package blk.interfacetesting.dao.result;

import blk.interfacetesting.dao.IBaseMapper;
import blk.interfacetesting.modle.result.TstbResultTestData;
import blk.interfacetesting.modle.result.TstbResultTestDataCriteria;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository("resultTestDataMapper")
public interface TstbResultTestDataMapper extends IBaseMapper<TstbResultTestData, TstbResultTestDataCriteria> {
    List<Map> generateResultReport(int iemId);

    List<Map> findUnexecutedTestData(int iemId);

    int findTotalTestDataCount(int iemId);

    int findExecutedDataCount(int iemId);

    int findPassedTestDataCount(int iemId);

    int findFailedTestDataCount(int iemId);

    int findTotalTestCaseCount(int iemId);

    int findPassededTestCaseCount(int iemId);

    int findFailedTestCaseCount(int iemId);

    int findUnexecutedTestCaseCount(int iemId);
}