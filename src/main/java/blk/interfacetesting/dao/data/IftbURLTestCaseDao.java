package blk.interfacetesting.dao.data;


import blk.interfacetesting.dao.IBaseDao;
import blk.interfacetesting.modle.data.IftbURLTestCase;
import blk.interfacetesting.modle.data.IftbURLTestCaseCriteria;

import java.util.List;

public interface IftbURLTestCaseDao extends IBaseDao<IftbURLTestCase, IftbURLTestCaseCriteria> {
    List<IftbURLTestCase> getURLTestCases();

    List<IftbURLTestCase> getURLTestCaseOne(Integer iutcId);
}
