package blk.interfacetesting.dao.data;

import blk.interfacetesting.dao.IBaseMapper;
import blk.interfacetesting.modle.data.IftbTestData;
import blk.interfacetesting.modle.data.IftbTestDataCriteria;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("testDataMapper")
public interface IftbTestDataMapper extends IBaseMapper<IftbTestData, IftbTestDataCriteria> {
    List<IftbTestData> getListByMtcId(Integer mtcId);
}