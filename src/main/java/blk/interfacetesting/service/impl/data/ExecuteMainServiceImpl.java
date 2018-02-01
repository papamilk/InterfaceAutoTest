package blk.interfacetesting.service.impl.data;

import blk.common.util.Page;
import blk.interfacetesting.dao.data.IftbExecuteMainDao;
import blk.interfacetesting.modle.data.IftbExecuteMain;
import blk.interfacetesting.modle.data.IftbExecuteMainCriteria;
import blk.interfacetesting.service.data.ExecuteMainService;
import blk.interfacetesting.service.impl.BaseServiceImpl;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("executeMainService")
public class ExecuteMainServiceImpl extends BaseServiceImpl<IftbExecuteMain, IftbExecuteMainCriteria> implements ExecuteMainService {

    @Autowired
    public void setBaseDao(IftbExecuteMainDao executeMainDao){
        super.setBaseDao(executeMainDao);
    }

    @Override
    public List<IftbExecuteMain> getListWithMpName(Integer begin, Integer length) {
        Page page = new Page(begin, length);
        IftbExecuteMainCriteria criteria = new IftbExecuteMainCriteria();
        criteria.setPage(page);
        criteria.setAddMpName(true);
        return getBaseDao().ReadAll(criteria);
    }

    @Override
    public List<IftbExecuteMain> getListWithMpName() {
        IftbExecuteMainCriteria criteria = new IftbExecuteMainCriteria();
        criteria.setAddMpName(true);
        return getBaseDao().ReadAll(criteria);
    }

    @Override
    public boolean checkName(String iemName) {
        IftbExecuteMainCriteria criteria = new IftbExecuteMainCriteria();
        criteria.createCriteria().andIemNameEqualTo(iemName);
        List<IftbExecuteMain> resultList = getBaseDao().ReadAll(criteria);
        return CollectionUtils.isEmpty(resultList);
    }
}
