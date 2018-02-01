package blk.interfacetesting.dao.impl;

import blk.common.util.Page;
import blk.interfacetesting.dao.IBaseDao;
import blk.interfacetesting.dao.IBaseMapper;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by Saul on 22/01/2017.
 * 通用DAO实现
 *
 * @param <T>
 * @param <F>
 */
@SuppressWarnings("unused")
@Repository("baseDao")
public abstract class IBaseDaoImpl<T, F> implements IBaseDao<T, F> {

    @Autowired
    public Map<String, IBaseDao> daoMap;

    private IBaseMapper<T, F> iBaseMapper;

    public IBaseMapper<T, F> getiBaseMapper() {
        return iBaseMapper;
    }

    public void setiBaseMapper(IBaseMapper<T, F> iBaseMapper) {
        this.iBaseMapper = iBaseMapper;
    }

    @Override
    public int save(T object){
        return iBaseMapper.insert(object);
    }

    @Override
    public int saveBatch(List<T> object){
        return iBaseMapper.sqlBatchInsert(object);
    }

    @Override
    public int update(T object) {
        return iBaseMapper.updateByPrimaryKey(object);
    }

    @Override
    public int savewithoutNull(T object) {
        return iBaseMapper.insertSelective(object);
    }

    @Override
    public int updatewithoutNull(T object, F find) {
        return iBaseMapper.updateByExampleSelective(object, find);
    }

    @Override
    public int delete(F object) {
            return iBaseMapper.deleteByExample(object);
    }

    @Override
    public T ReadSingle(F exampleCriteria) {
        List<T> tList = iBaseMapper.selectByExample(exampleCriteria);
        if (CollectionUtils.isNotEmpty(tList)) {
            return iBaseMapper.selectByExample(exampleCriteria).get(0);
        } else {
            return null;
        }
    }

    @Override
    public List<T> ReadAll(F exampleCriteria) {
        return iBaseMapper.selectByExample(exampleCriteria);
    }

    @Override
    public List<T> ReadAllByOrder(F exampleCriteria) {
        return iBaseMapper.selectByExample(exampleCriteria);
    }

    @Override
    public List ReadByProperty(F exampleCriteria) {
        return iBaseMapper.selectByExample(exampleCriteria);
    }

    @Override
    public List ReadByPropertyList(F exampleCriteria) {
        return iBaseMapper.selectByExample(exampleCriteria);
    }

    @Override
    public List<T> ReadLimitedByOrder(F exampleCriteria, Page page) {
        return iBaseMapper.selectByExample(exampleCriteria);
    }


    @Override
    public int ReadCount(F exampleCriteria) {
            return iBaseMapper.countByExample(exampleCriteria);
    }

    @Override
    public T ReadByID(Integer id) {
        return iBaseMapper.selectByPrimaryKey(id);
    }

    @Override
    public T ReadByID(String id) {
        return iBaseMapper.selectByPrimaryKey(id);
    }
}
