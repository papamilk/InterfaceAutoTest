package blk.interfacetesting.service.data;

import blk.interfacetesting.modle.data.MstbURLManagement;
import blk.interfacetesting.modle.data.MstbURLManagementCriteria;
import blk.interfacetesting.service.IBaseService;

import java.util.List;
import java.util.Map;

public interface URLManagementService extends IBaseService<MstbURLManagement, MstbURLManagementCriteria> {
    /**
     * 查询接口信息集合
     * @return
     */
    List<MstbURLManagement> getList();

    /**
     * 分页查询接口信息集合
     * @param begin 分页开始记录
     * @param length 长度
     * @return 接口信息集合
     */
    List<MstbURLManagement> getList(int begin, int length);

    /**
     * 验证接口名称唯一性
     * @param mumName 接口名称
     * @return true验证通过，指接口名称是唯一的
     */
    boolean checkName(String mumName);
}
