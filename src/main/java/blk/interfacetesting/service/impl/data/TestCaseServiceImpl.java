package blk.interfacetesting.service.impl.data;

import blk.common.util.Page;
import blk.interfacetesting.dao.data.MstbTestCaseDao;
import blk.interfacetesting.modle.data.MstbTestCase;
import blk.interfacetesting.modle.data.MstbTestCaseCriteria;
import blk.interfacetesting.service.data.TestCaseService;
import blk.interfacetesting.service.impl.BaseServiceImpl;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("testCaseService")
public class TestCaseServiceImpl extends BaseServiceImpl<MstbTestCase, MstbTestCaseCriteria> implements TestCaseService {

    @Autowired
    public void setBaseDao(MstbTestCaseDao testCaseDao){
        super.setBaseDao(testCaseDao);
    }

    @Override
    public List<MstbTestCase> getList(int begin, int length) {
        Page page = new Page(begin, length);
        MstbTestCaseCriteria criteria = new MstbTestCaseCriteria();
        criteria.setPage(page);
        return getBaseDao().ReadAll(criteria);
    }

    @Override
    public List<MstbTestCase> getList() {
        return getBaseDao().ReadAll(new MstbTestCaseCriteria());
    }

    @Override
    public boolean checkName(String mtcName) {
        MstbTestCaseCriteria criteria = new MstbTestCaseCriteria();
        criteria.createCriteria().andMtcNameEqualTo(mtcName);
        List<MstbTestCase> resultList = getBaseDao().ReadAll(criteria);
        return CollectionUtils.isEmpty(resultList);
    }
}
