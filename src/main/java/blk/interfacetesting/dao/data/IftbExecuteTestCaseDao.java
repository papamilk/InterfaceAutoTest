package blk.interfacetesting.dao.data;


import blk.interfacetesting.dao.IBaseDao;
import blk.interfacetesting.modle.data.IftbExecuteTestCase;
import blk.interfacetesting.modle.data.IftbExecuteTestCaseCriteria;

import java.util.List;

public interface IftbExecuteTestCaseDao extends IBaseDao<IftbExecuteTestCase, IftbExecuteTestCaseCriteria> {
    List<IftbExecuteTestCase> getExecuteTestCases();

    List<IftbExecuteTestCase> getExecuteTestCaseOne(Integer ietcId);
}
