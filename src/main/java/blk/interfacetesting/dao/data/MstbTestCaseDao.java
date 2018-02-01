package blk.interfacetesting.dao.data;


import blk.interfacetesting.dao.IBaseDao;
import blk.interfacetesting.modle.data.MstbTestCase;
import blk.interfacetesting.modle.data.MstbTestCaseCriteria;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MstbTestCaseDao extends IBaseDao<MstbTestCase, MstbTestCaseCriteria> {
    List<MstbTestCase> getTestCase(@Param("mpId") int mpId, @Param("iemId") int iemId);
}
