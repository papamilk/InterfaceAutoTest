package blk.interfacetesting.service.impl.data;

import blk.interfacetesting.dao.data.MstbDynamicParamDao;
import blk.interfacetesting.modle.data.MstbDynamicParam;
import blk.interfacetesting.modle.data.MstbDynamicParamCriteria;
import blk.interfacetesting.service.data.DynamicParamService;
import blk.interfacetesting.service.impl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Mark
 * @date 2017/11/22
 */
@Service("dynamicParamService")
public class DynamicParamServiceImpl extends BaseServiceImpl<MstbDynamicParam, MstbDynamicParamCriteria> implements DynamicParamService {
    @Autowired
    public void setBaseDao(MstbDynamicParamDao dynamicParamDao) {
        super.setBaseDao(dynamicParamDao);
    }

    @Override
    public List<MstbDynamicParam> getDynamicParamListByItdId(int itdId){
        MstbDynamicParamDao dynamicParamDao = (MstbDynamicParamDao) getBaseDao();
        return dynamicParamDao.getDynamicParamListByItdId(itdId);
    }
}
