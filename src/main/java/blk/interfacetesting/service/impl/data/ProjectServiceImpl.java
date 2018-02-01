package blk.interfacetesting.service.impl.data;

import blk.common.util.Page;
import blk.interfacetesting.dao.data.MstbProjectDao;
import blk.interfacetesting.modle.data.MstbProject;
import blk.interfacetesting.modle.data.MstbProjectCriteria;
import blk.interfacetesting.service.data.ProjectService;
import blk.interfacetesting.service.impl.BaseServiceImpl;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("projectService")
public class ProjectServiceImpl extends BaseServiceImpl<MstbProject, MstbProjectCriteria> implements ProjectService {

    @Autowired
    public void setBaseDao(MstbProjectDao projectDao){
        super.setBaseDao(projectDao);
    }

    @Override
    public boolean checkName(String mpName) {
        MstbProjectCriteria criteria = new MstbProjectCriteria();
        criteria.createCriteria().andMpNameEqualTo(mpName);
        List<MstbProject> projectList = queryForAll(criteria);
        return CollectionUtils.isEmpty(projectList);
    }

    @Override
    public List<MstbProject> getList() {
        return getBaseDao().ReadAll(new MstbProjectCriteria());
    }

    @Override
    public List<MstbProject> getList(Integer begin, Integer length) {
        Page page = new Page(begin, length);
        MstbProjectCriteria criteria = new MstbProjectCriteria();
        criteria.setPage(page);
        return getBaseDao().ReadAll(criteria);
    }
}
