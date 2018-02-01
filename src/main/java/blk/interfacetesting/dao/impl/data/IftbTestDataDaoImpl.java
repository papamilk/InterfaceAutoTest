package blk.interfacetesting.dao.impl.data;

import blk.interfacetesting.dao.data.IftbTestDataDao;
import blk.interfacetesting.dao.data.IftbTestDataMapper;
import blk.interfacetesting.dao.impl.IBaseDaoImpl;
import blk.interfacetesting.modle.data.IftbTestData;
import blk.interfacetesting.modle.data.IftbTestDataCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Mark
 * @date 2018/1/18
 */
@Repository("testDataDao")
public class IftbTestDataDaoImpl extends IBaseDaoImpl<IftbTestData, IftbTestDataCriteria> implements IftbTestDataDao {
    @Autowired
    public void setiBaseMapper(IftbTestDataMapper testDataMapper) {
        super.setiBaseMapper(testDataMapper);
    }

    @Override
    public List<IftbTestData> getListByMtcId(Integer mtcId) {
        IftbTestDataMapper testDataMapper = (IftbTestDataMapper) this.getiBaseMapper();
        return testDataMapper.getListByMtcId(mtcId);
    }
}
