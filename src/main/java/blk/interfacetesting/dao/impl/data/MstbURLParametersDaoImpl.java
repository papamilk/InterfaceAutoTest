package blk.interfacetesting.dao.impl.data;

import blk.interfacetesting.dao.data.MstbURLParametersDao;
import blk.interfacetesting.dao.data.MstbURLParametersMapper;
import blk.interfacetesting.dao.impl.IBaseDaoImpl;
import blk.interfacetesting.modle.data.MstbURLParameters;
import blk.interfacetesting.modle.data.MstbURLParametersCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository("urlParametersDao")
public class MstbURLParametersDaoImpl extends IBaseDaoImpl<MstbURLParameters, MstbURLParametersCriteria> implements MstbURLParametersDao {

    @Autowired
    public void setiBaseMapper(MstbURLParametersMapper urlParametersMapper) {
        super.setiBaseMapper(urlParametersMapper);
    }
}
