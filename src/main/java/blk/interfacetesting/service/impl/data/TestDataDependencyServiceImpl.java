package blk.interfacetesting.service.impl.data;

import blk.common.util.Page;
import blk.interfacetesting.dao.data.IftbTestDataDependencyDao;
import blk.interfacetesting.modle.data.IftbTestData;
import blk.interfacetesting.modle.data.IftbTestDataDependency;
import blk.interfacetesting.modle.data.IftbTestDataDependencyCriteria;
import blk.interfacetesting.service.data.TestDataDependencyService;
import blk.interfacetesting.service.data.TestDataService;
import blk.interfacetesting.service.impl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("testDataDependencyService")
public class TestDataDependencyServiceImpl extends BaseServiceImpl<IftbTestDataDependency, IftbTestDataDependencyCriteria> implements TestDataDependencyService {

    @Autowired
    public void setBaseDao(IftbTestDataDependencyDao testDataDependencyDao){
        super.setBaseDao(testDataDependencyDao);
    }

    @Override
    public List<IftbTestDataDependency> getListWithItdName() {
        IftbTestDataDependencyCriteria criteria = new IftbTestDataDependencyCriteria();
        criteria.setAddItdName(true);
        return transformDependency(getBaseDao().ReadAll(criteria));
    }

    @Override
    public List<IftbTestDataDependency> getListWithItdName(int begin, int length) {
        Page page = new Page(begin, length);
        IftbTestDataDependencyCriteria criteria = new IftbTestDataDependencyCriteria();
        criteria.setPage(page);
        criteria.setAddItdName(true);
        return transformDependency(getBaseDao().ReadAll(criteria));
    }

    /**
     * 将被依赖数据序号转换成数据名称
     * @param dependencyList 依赖数据集合
     * @return
     */
    public List<IftbTestDataDependency> transformDependency(List<IftbTestDataDependency> dependencyList) {
        for (IftbTestDataDependency dataDependency : dependencyList) {
            String dependency = dataDependency.getItddDependency();
            String[] dependenIds = dependency.split("#");
            StringBuilder nameBuilder = new StringBuilder();
            for (String dependenId : dependenIds) {
                IftbTestData testData = ((TestDataService) getServiceMap().get("testDataService")).query(Integer.valueOf(dependenId));
                nameBuilder.append(testData.getItdName()).append("#");
            }
            nameBuilder.setLength(nameBuilder.length() - 1);
            dataDependency.setItddDependency(nameBuilder.toString());
        }
        return dependencyList;
    }
}
