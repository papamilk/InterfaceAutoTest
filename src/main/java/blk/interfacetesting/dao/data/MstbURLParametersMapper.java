package blk.interfacetesting.dao.data;

import blk.interfacetesting.dao.IBaseMapper;
import blk.interfacetesting.modle.data.MstbURLParameters;
import blk.interfacetesting.modle.data.MstbURLParametersCriteria;
import org.springframework.stereotype.Repository;

@Repository("urlParametersMapper")
public interface MstbURLParametersMapper extends IBaseMapper<MstbURLParameters, MstbURLParametersCriteria> {
}