package blk.interfacetesting.dao.impl.data;

import blk.interfacetesting.dao.data.MstbProjectDao;
import blk.interfacetesting.dao.data.MstbProjectMapper;
import blk.interfacetesting.dao.impl.IBaseDaoImpl;

import blk.interfacetesting.modle.data.MstbProject;
import blk.interfacetesting.modle.data.MstbProjectCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("projectDao")
public class MstbProjectDaoImpl extends IBaseDaoImpl<MstbProject, MstbProjectCriteria> implements MstbProjectDao {

    @Autowired
    public void setiBaseMapper(MstbProjectMapper projectMapper){
        super.setiBaseMapper(projectMapper);
    }

    @Override
    public MstbProject getProject(Integer iemId) {
        MstbProjectMapper projectMapper = (MstbProjectMapper) this.getiBaseMapper();
        return projectMapper.getProject(iemId);
    }
}
