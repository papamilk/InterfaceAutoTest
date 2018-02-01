package blk.interfacetesting.dao.data;

import blk.interfacetesting.dao.IBaseDao;
import blk.interfacetesting.modle.data.MstbDynamicParam;
import blk.interfacetesting.modle.data.MstbDynamicParamCriteria;

import java.util.List;

public interface MstbDynamicParamDao extends IBaseDao<MstbDynamicParam, MstbDynamicParamCriteria> {
    List<MstbDynamicParam> getDynamicParamListByItdId(int itdId);
}
