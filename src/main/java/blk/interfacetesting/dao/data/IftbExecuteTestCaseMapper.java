package blk.interfacetesting.dao.data;

import blk.interfacetesting.dao.IBaseMapper;
import blk.interfacetesting.modle.data.IftbExecuteTestCase;
import blk.interfacetesting.modle.data.IftbExecuteTestCaseCriteria;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("executeTestCaseMapper")
public interface IftbExecuteTestCaseMapper extends IBaseMapper<IftbExecuteTestCase, IftbExecuteTestCaseCriteria> {
    List<IftbExecuteTestCase> getExecuteTestCases();

    List<IftbExecuteTestCase> getExecuteTestCaseOne(Integer ietcId);
}