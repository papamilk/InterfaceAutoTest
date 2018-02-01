package blk.interfacetesting.dao.data;

import blk.interfacetesting.dao.IBaseMapper;
import blk.interfacetesting.modle.data.IftbURLTestCase;
import blk.interfacetesting.modle.data.IftbURLTestCaseCriteria;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("urlTestCaseMapper")
public interface IftbURLTestCaseMapper extends IBaseMapper<IftbURLTestCase, IftbURLTestCaseCriteria> {
    List<IftbURLTestCase> getURLTestCases();

    List<IftbURLTestCase> getURLTestCaseOne(Integer iutcId);
}