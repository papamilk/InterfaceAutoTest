package blk.interfacetesting.dao.data;

import blk.interfacetesting.dao.IBaseMapper;
import blk.interfacetesting.modle.data.MstbTestCase;
import blk.interfacetesting.modle.data.MstbTestCaseCriteria;
import org.apache.ibatis.annotations.Param;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("testCaseMapper")
public interface MstbTestCaseMapper extends IBaseMapper<MstbTestCase, MstbTestCaseCriteria> {
    List<MstbTestCase> getTestCase(@Param("mpId") int mpId, @Param("iemId") int iemId);
}