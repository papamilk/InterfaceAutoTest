package blk.interfacetesting.dao.data;


import blk.interfacetesting.dao.IBaseDao;
import blk.interfacetesting.modle.data.MstbProject;
import blk.interfacetesting.modle.data.MstbProjectCriteria;

public interface MstbProjectDao extends IBaseDao<MstbProject, MstbProjectCriteria> {
    MstbProject getProject(Integer iemId);
}
