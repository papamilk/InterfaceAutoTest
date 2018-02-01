package blk.interfacetesting.dao.impl.data;

import blk.interfacetesting.dao.data.IftbExecuteMainDao;
import blk.interfacetesting.dao.data.IftbExecuteMainMapper;
import blk.interfacetesting.dao.impl.IBaseDaoImpl;
import blk.interfacetesting.modle.data.IftbExecuteMain;
import blk.interfacetesting.modle.data.IftbExecuteMainCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository("executeMainDao")
public class IftbExecuteMainDaoImpl extends IBaseDaoImpl<IftbExecuteMain, IftbExecuteMainCriteria> implements IftbExecuteMainDao {

    @Autowired
    public void setiBaseMapper(IftbExecuteMainMapper executeMainMapper) {
        super.setiBaseMapper(executeMainMapper);
    }

    @Override
    public void deleteAll(Integer iemId) {
        IftbExecuteMainMapper executeMainMapper = (IftbExecuteMainMapper) this.getiBaseMapper();
        executeMainMapper.deleteAll(iemId);
    }
}
