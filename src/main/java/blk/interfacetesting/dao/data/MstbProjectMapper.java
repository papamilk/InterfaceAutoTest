package blk.interfacetesting.dao.data;

import blk.interfacetesting.dao.IBaseMapper;
import blk.interfacetesting.modle.data.MstbProject;
import blk.interfacetesting.modle.data.MstbProjectCriteria;
import org.springframework.stereotype.Repository;

@Repository("projectMapper")
public interface MstbProjectMapper extends IBaseMapper<MstbProject, MstbProjectCriteria> {
    MstbProject getProject(Integer iemId);
}