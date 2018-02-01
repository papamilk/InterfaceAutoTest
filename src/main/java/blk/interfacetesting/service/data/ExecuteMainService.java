package blk.interfacetesting.service.data;

import blk.interfacetesting.modle.data.IftbExecuteMain;
import blk.interfacetesting.modle.data.IftbExecuteMainCriteria;
import blk.interfacetesting.service.IBaseService;

import java.util.List;
import java.util.Map;


public interface ExecuteMainService extends IBaseService<IftbExecuteMain, IftbExecuteMainCriteria> {
    /**
     * 分页查询包含项目名称的测试场景集合
     * @param begin 分页开始记录
     * @param length 长度
     * @return 测试场景集合
     */
    List<IftbExecuteMain> getListWithMpName(Integer begin, Integer length);

    /**
     * 查询包含项目名称的测试场景集合
     * @return 测试场景集合
     */
    List<IftbExecuteMain> getListWithMpName();

    /**
     * 验证测试场景名称唯一性
     * @param iemName 测试场景名称
     * @return true验证通过，指该场景名称是唯一的
     */
    boolean checkName(String iemName);
}

