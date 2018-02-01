package blk.interfacetesting.dao.data;

import blk.interfacetesting.dao.IBaseDao;
import blk.interfacetesting.modle.data.IftbTestData;
import blk.interfacetesting.modle.data.IftbTestDataCriteria;

import java.util.List;

/**
 * @author Mark
 * @date 2018/1/18
 */
public interface IftbTestDataDao extends IBaseDao<IftbTestData, IftbTestDataCriteria> {
    List<IftbTestData> getListByMtcId(Integer mtcId);
}
