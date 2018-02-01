package blk.interfacetesting.dao.data;

import blk.interfacetesting.dao.IBaseMapper;
import blk.interfacetesting.modle.data.IftbExecuteMain;
import blk.interfacetesting.modle.data.IftbExecuteMainCriteria;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository("executeMainMapper")
public interface IftbExecuteMainMapper extends IBaseMapper<IftbExecuteMain, IftbExecuteMainCriteria> {
    List<Map> getExecuteList(Integer iemId);

    List<IftbExecuteMain> getExecutes(IftbExecuteMainCriteria executeMainCriteria);

    List<IftbExecuteMain> getExecuteOne(Integer iemId);

    void deleteAll(Integer iemId);
}