package blk.interfacetesting.service.impl;


import blk.common.util.Page;
import blk.interfacetesting.dao.IBaseDao;
import blk.interfacetesting.service.IBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by Saul on 22/01/2017.
 */
@Service
public abstract class BaseServiceImpl<T, F> implements IBaseService<T, F> {
	@Autowired(required = false)
	public Map<String, IBaseService> serviceMap;
	private IBaseDao<T, F> baseDao;

	public Map<String, IBaseService> getServiceMap() {
		return serviceMap;
	}

	public IBaseDao<T, F> getBaseDao() {
		return baseDao;
	}

	public void setBaseDao(IBaseDao<T, F> baseDao) {
		this.baseDao = baseDao;
	}

	@Override
	public int add(T t) {
		return baseDao.save(t);
	}

	@Override
	public int delete(F obj) {
		return baseDao.delete(obj);
	}

	@Override
	public int update(T t) {
		return baseDao.update(t);
	}

	@Override
	public int update(T t, F find) {
		return baseDao.updatewithoutNull(t, find);
	}

	@Override
	public T query(int id) {
		return baseDao.ReadByID(id);
	}

	@Override
	public T query(F find) {
		return baseDao.ReadSingle(find);
	}

	@Override
	public List<T> queryForAll(F find) {
		return baseDao.ReadAll(find);
	}

	@Override
	public List<T> queryForAll(F find, Page page) {
		return baseDao.ReadLimitedByOrder(find, page);
	}
}
