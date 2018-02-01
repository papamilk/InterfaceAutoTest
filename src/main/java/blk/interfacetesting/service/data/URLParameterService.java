package blk.interfacetesting.service.data;

import blk.interfacetesting.modle.data.MstbURLParameters;
import blk.interfacetesting.modle.data.MstbURLParametersCriteria;
import blk.interfacetesting.service.IBaseService;

import java.util.List;

public interface URLParameterService extends IBaseService<MstbURLParameters, MstbURLParametersCriteria> {
    /**
     * 分页查询参数信息集合
     * @param begin 分页开始记录
     * @param length 长度
     * @return 参数信息集合
     */
    List<MstbURLParameters> getList(int begin, int length);

    /**
     * 查询参数信息集合
     * @return
     */
    List<MstbURLParameters> getList();
}
