package blk.interfacetesting.service.data;

import blk.interfacetesting.modle.data.IftbExecuteTestCase;
import blk.interfacetesting.modle.data.IftbExecuteTestCaseCriteria;
import blk.interfacetesting.service.IBaseService;

import java.util.List;

public interface ExecuteTestCaseService extends IBaseService<IftbExecuteTestCase, IftbExecuteTestCaseCriteria> {
    List<IftbExecuteTestCase> getExecuteTestCases();

    List<IftbExecuteTestCase> getExecuteTestCaseOne(Integer ietcId);
}
