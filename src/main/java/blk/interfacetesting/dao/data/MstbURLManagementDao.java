package blk.interfacetesting.dao.data;


import blk.interfacetesting.dao.IBaseDao;
import blk.interfacetesting.modle.data.MstbURLManagement;
import blk.interfacetesting.modle.data.MstbURLManagementCriteria;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface MstbURLManagementDao extends IBaseDao<MstbURLManagement, MstbURLManagementCriteria> {
    List<Map<String, Object>> getInterfaceMapList(@Param("mpId") int mpId, @Param("iemId") int iemId);
}
