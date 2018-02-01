package blk.interfacetesting.dao.data;

import blk.interfacetesting.dao.IBaseDao;
import blk.interfacetesting.modle.data.IftbExecuteMain;
import blk.interfacetesting.modle.data.IftbExecuteMainCriteria;

import java.util.List;
import java.util.Map;


public interface IftbExecuteMainDao extends IBaseDao<IftbExecuteMain, IftbExecuteMainCriteria> {
    void deleteAll(Integer iemId);
}
