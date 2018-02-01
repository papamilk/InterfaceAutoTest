package blk.interfacetesting.dao.impl.data;

import blk.interfacetesting.dao.data.MstbURLManagementDao;
import blk.interfacetesting.dao.data.MstbURLManagementMapper;
import blk.interfacetesting.dao.impl.IBaseDaoImpl;
import blk.interfacetesting.modle.data.MstbURLManagement;
import blk.interfacetesting.modle.data.MstbURLManagementCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository("urlManagementDao")
public class MstbURLManagementDaoImpl extends IBaseDaoImpl<MstbURLManagement, MstbURLManagementCriteria> implements MstbURLManagementDao {

    @Autowired
    public void setiBaseMapper(MstbURLManagementMapper urlManagementMapper){
        super.setiBaseMapper(urlManagementMapper);
    }

    @Override
    public List<Map<String, Object>> getInterfaceMapList(int mpId, int iemId) {
        MstbURLManagementMapper urlManagementMapper = (MstbURLManagementMapper) this.getiBaseMapper();
        return urlManagementMapper.getInterfaceMapList(mpId, iemId);
    }
}
