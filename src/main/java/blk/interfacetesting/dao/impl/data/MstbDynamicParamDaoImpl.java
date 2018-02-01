package blk.interfacetesting.dao.impl.data;

import blk.interfacetesting.dao.data.MstbDynamicParamDao;
import blk.interfacetesting.dao.data.MstbDynamicParamMapper;
import blk.interfacetesting.dao.impl.IBaseDaoImpl;
import blk.interfacetesting.modle.data.MstbDynamicParam;
import blk.interfacetesting.modle.data.MstbDynamicParamCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("dynamicParamDao")
public class MstbDynamicParamDaoImpl extends IBaseDaoImpl<MstbDynamicParam, MstbDynamicParamCriteria> implements MstbDynamicParamDao {
    @Autowired
    public void setiBaseMapper(MstbDynamicParamMapper dynamicParamMapper) {
        super.setiBaseMapper(dynamicParamMapper);
    }

    @Override
    public List<MstbDynamicParam> getDynamicParamListByItdId(int itdId){
        MstbDynamicParamMapper dynamicParamMapper = (MstbDynamicParamMapper) getiBaseMapper();
        return dynamicParamMapper.getDynamicParamListByItdId(itdId);
    }
}
