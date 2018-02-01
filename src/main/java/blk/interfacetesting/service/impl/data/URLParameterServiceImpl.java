package blk.interfacetesting.service.impl.data;

import blk.common.util.Page;
import blk.interfacetesting.dao.data.MstbURLParametersDao;
import blk.interfacetesting.modle.data.MstbURLParameters;
import blk.interfacetesting.modle.data.MstbURLParametersCriteria;
import blk.interfacetesting.service.data.URLParameterService;
import blk.interfacetesting.service.impl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("urlParameterService")
public class URLParameterServiceImpl extends BaseServiceImpl<MstbURLParameters, MstbURLParametersCriteria> implements URLParameterService {

    @Autowired
    public void setBaseDao(MstbURLParametersDao urlParametersDao){
        super.setBaseDao(urlParametersDao);
    }

    @Override
    public List<MstbURLParameters> getList(int begin, int length) {
        Page page = new Page();
        MstbURLParametersCriteria criteria = new MstbURLParametersCriteria();
        criteria.setPage(page);
        return getBaseDao().ReadAll(criteria);
    }

    @Override
    public List<MstbURLParameters> getList() {
        return getBaseDao().ReadAll(new MstbURLParametersCriteria());
    }
}
