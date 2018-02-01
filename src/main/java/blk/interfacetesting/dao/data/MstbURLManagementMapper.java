package blk.interfacetesting.dao.data;

import blk.interfacetesting.dao.IBaseMapper;
import blk.interfacetesting.modle.data.MstbURLManagement;
import blk.interfacetesting.modle.data.MstbURLManagementCriteria;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository("urlManagementMapper")
public interface MstbURLManagementMapper extends IBaseMapper<MstbURLManagement, MstbURLManagementCriteria> {
    List<Map<String, Object>> getInterfaceMapList(@Param("mpId") int mpId, @Param("iemId") int iemId);
}