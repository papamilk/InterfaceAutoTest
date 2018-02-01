package blk.interfacetesting.service.impl.data;

import blk.common.util.Page;
import blk.interfacetesting.dao.data.IftbTestDataDao;
import blk.interfacetesting.modle.data.IftbTestData;
import blk.interfacetesting.modle.data.IftbTestDataCriteria;
import blk.interfacetesting.service.data.TestDataService;
import blk.interfacetesting.service.impl.BaseServiceImpl;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author Mark
 * @date 2018/1/18
 */
@Service("testDataService")
public class TestDataServiceImpl extends BaseServiceImpl<IftbTestData, IftbTestDataCriteria> implements TestDataService {
    @Autowired
    public void setBaseDao(IftbTestDataDao testDataDao) {
        super.setBaseDao(testDataDao);
    }

    @Override
    public List<IftbTestData> specialSearchList(int begin, int length) {
        Page page = new Page(begin, length);
        IftbTestDataCriteria criteria = new IftbTestDataCriteria();
        criteria.setPage(page);
        criteria.setSpecialSearch(true);
        return getBaseDao().ReadAll(criteria);
    }

    @Override
    public List<IftbTestData> specialSearchList() {
        IftbTestDataCriteria criteria = new IftbTestDataCriteria();
        criteria.setSpecialSearch(true);
        return getBaseDao().ReadAll(criteria);
    }

    @Override
    public boolean checkName(String itdName) {
        IftbTestDataCriteria criteria = new IftbTestDataCriteria();
        criteria.createCriteria().andItdNameEqualTo(itdName);
        List<IftbTestData> testDataList = queryForAll(criteria);
        return CollectionUtils.isEmpty(testDataList);
    }

    @Override
    public List<IftbTestData> getListByMtcId(Integer mtcId) {
        IftbTestDataDao testDataDao = (IftbTestDataDao) this.getBaseDao();
        return testDataDao.getListByMtcId(mtcId);
    }

    @Override
    public List<IftbTestData> getExecuteList(int iemId) {
        IftbTestDataCriteria iftbTestDataCriteria = new IftbTestDataCriteria();
        iftbTestDataCriteria.createCriteria().andIemIdEqualTo(iemId);
        iftbTestDataCriteria.setAddDependency(true);
        iftbTestDataCriteria.setOrderByClause("d.itd_id asc");
        return getBaseDao().ReadAll(iftbTestDataCriteria);
    }
}
