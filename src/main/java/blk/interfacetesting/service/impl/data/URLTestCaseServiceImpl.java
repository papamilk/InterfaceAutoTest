package blk.interfacetesting.service.impl.data;

import blk.common.util.Page;
import blk.interfacetesting.dao.data.IftbURLTestCaseDao;
import blk.interfacetesting.modle.data.IftbURLTestCase;
import blk.interfacetesting.modle.data.IftbURLTestCaseCriteria;
import blk.interfacetesting.service.data.URLTestCaseService;
import blk.interfacetesting.service.impl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("urlTestCaseService")
public class URLTestCaseServiceImpl extends BaseServiceImpl<IftbURLTestCase, IftbURLTestCaseCriteria> implements URLTestCaseService {
    @Autowired
    public void setBaseDao(IftbURLTestCaseDao urlTestCaseDao){
        super.setBaseDao(urlTestCaseDao);
    }

    @Override
    public List<IftbURLTestCase> getList() {
        IftbURLTestCaseCriteria criteria = new IftbURLTestCaseCriteria();
        criteria.setMergedSearch(true);
        return getBaseDao().ReadAll(criteria);
    }

    @Override
    public List<IftbURLTestCase> getList(int begin, int length) {
        Page page = new Page(begin, length);
        IftbURLTestCaseCriteria criteria = new IftbURLTestCaseCriteria();
        criteria.setPage(page);
        criteria.setMergedSearch(true);
        return getBaseDao().ReadAll(criteria);
    }
}
