package blk.interfacetesting.dao.data;

import blk.interfacetesting.dao.IBaseMapper;
import blk.interfacetesting.modle.data.MstbDynamicParam;
import blk.interfacetesting.modle.data.MstbDynamicParamCriteria;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("dynamicParamMapper")
public interface MstbDynamicParamMapper extends IBaseMapper<MstbDynamicParam, MstbDynamicParamCriteria> {
    List<MstbDynamicParam> getDynamicParamListByItdId(int itdId);
}