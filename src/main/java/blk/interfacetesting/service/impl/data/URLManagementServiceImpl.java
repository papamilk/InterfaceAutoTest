package blk.interfacetesting.service.impl.data;

import blk.common.util.Page;
import blk.interfacetesting.dao.data.MstbURLManagementDao;
import blk.interfacetesting.modle.data.MstbURLManagement;
import blk.interfacetesting.modle.data.MstbURLManagementCriteria;
import blk.interfacetesting.service.data.URLManagementService;
import blk.interfacetesting.service.impl.BaseServiceImpl;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Transactional
@Service("urlManagementService")
public class URLManagementServiceImpl extends BaseServiceImpl<MstbURLManagement, MstbURLManagementCriteria> implements URLManagementService {
    @Autowired
    public void setBaseDao(MstbURLManagementDao urlManagementDao){
        super.setBaseDao(urlManagementDao);
    }

    @Override
    public List<MstbURLManagement> getList(int begin, int length) {
        Page page = new Page(begin, length);
        MstbURLManagementCriteria criteria = new MstbURLManagementCriteria();
        criteria.setPage(page);
        return getBaseDao().ReadAll(criteria);
    }

    @Override
    public List<MstbURLManagement> getList() {
        return getBaseDao().ReadAll(new MstbURLManagementCriteria());
    }

    @Override
    public boolean checkName(String mumName) {
        MstbURLManagementCriteria criteria = new MstbURLManagementCriteria();
        criteria.createCriteria().andMumNameEqualTo(mumName);
        List<MstbURLManagement> resultList = getBaseDao().ReadAll(criteria);
        return CollectionUtils.isEmpty(resultList);
    }
}
