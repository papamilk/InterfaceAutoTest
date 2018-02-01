package blk.interfacetesting.service.data;

import blk.interfacetesting.modle.data.MstbProject;
import blk.interfacetesting.modle.data.MstbProjectCriteria;
import blk.interfacetesting.service.IBaseService;

import java.util.List;
import java.util.Map;

public interface ProjectService extends IBaseService<MstbProject, MstbProjectCriteria> {
    /**
     * 查询项目信息集合
     * @return 项目信息集合
     */
    List<MstbProject> getList();

    /**
     * 分页查询项目信息
     * @param begin 分页开始记录
     * @param length 长度
     * @return 项目信息集合
     */
    List<MstbProject> getList(Integer begin, Integer length);

    /**
     * 验证项目名称的唯一性
     * @param mpName 项目名称
     * @return true验证通过，指该项目名称是唯一的
     */
    boolean checkName(String mpName);
}
