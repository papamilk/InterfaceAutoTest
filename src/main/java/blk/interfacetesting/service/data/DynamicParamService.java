package blk.interfacetesting.service.data;

import blk.interfacetesting.modle.data.MstbDynamicParam;
import blk.interfacetesting.modle.data.MstbDynamicParamCriteria;
import blk.interfacetesting.service.IBaseService;

import java.util.List;

public interface DynamicParamService extends IBaseService<MstbDynamicParam, MstbDynamicParamCriteria> {
    List<MstbDynamicParam> getDynamicParamListByItdId(int itdId);
}
