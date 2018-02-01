package blk.interfacetesting.dao;

import blk.common.util.Page;

import java.util.List;

/**
 * 定义泛型DAO对象,其他接口可以直接继承该对象
 * Created by Saul on 21/01/2017.
 *
 * @param <T> 泛型对象
 * @param <F> 查询条件对象
 */
@SuppressWarnings({"MybatisMapperInXmlInspection", "unused"})
public interface IBaseDao<T, F> {
    /**
     * 保存对象
     *
     * @param object 实体对象
     */
    int save(T object);

    /**
     * 保存对象,多个
     *
     * @param object 实体对象
     */
    int saveBatch(List<T> object);

    /**
     * 更新对象
     *
     * @param object 实体对象
     */
    int update(T object);

    /**
     * 保存对象,空的属性不进行插入
     *
     * @param object 实体对象
     */
    int savewithoutNull(T object);

    /**
     * 更新对象,空的属性不经更新
     *
     * @param object 实体对象
     * @param find   查找对象
     * @return 操作是否成功
     */
    int updatewithoutNull(T object, F find);

    /**
     * 删除对象
     *
     * @param object 查找对象
     * @return
     */
    int delete(F object);

    /**
     * 获取单个对象
     *
     * @param id 序号对象
     * @return
     */
    T ReadByID(Integer id);

    /**
     * 获取单个对象
     *
     * @param id 序号对象
     * @return
     */
    T ReadByID(String id);

    /**
     * 获取全部对象
     *
     * @param exampleCriteria 查询条件对象
     */
    List<T> ReadAll(F exampleCriteria);

    /**
     * @param exampleCriteria 查询条件对象
     */
    List ReadAllByOrder(F exampleCriteria);

    /**
     * 依据单独属性,获取对象,不分页
     *
     * @param exampleCriteria 查询条件对象
     */
    List ReadByProperty(F exampleCriteria);

    /**
     * 依据单独属性,获取对象,不分页
     *
     * @param exampleCriteria 查询条件对象
     */
    List ReadByPropertyList(F exampleCriteria);

    /**
     * 依据单独属性,获取对象,分页
     *
     * @param exampleCriteria 查询条件对象
     * @param page            分页对象
     */
    List<T> ReadLimitedByOrder(F exampleCriteria, Page page);

    /**
     * 依据属性,获取单独对象
     *
     * @param exampleCriteria
     * @return
     */
    T ReadSingle(F exampleCriteria);

    /**
     * 依据条件,获取统计的条数
     *
     * @param exampleCriteria 查询条件对象
     */
    int ReadCount(F exampleCriteria);
}
