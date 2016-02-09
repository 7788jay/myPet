package cn.pet.lin.service;

import cn.pet.lin.dao.IBaseDAO;
import cn.pet.lin.domain.BaseDomain;
import cn.pet.lin.utils.SqlOrderEnum;

import java.util.List;
import java.util.Map;

/**
 * TODO 一句话描述该类用途
 */
public interface IBaseService<D extends IBaseDAO, T extends BaseDomain> {


    /**
     * 修改一条数据
     *
     * @param entity 要更新的实体对象
     */
    public int edit(T entity);

    /**
     * 删除一条数据
     *
     * @param id
     */
    public int delete(Object id);

    /**
     * 查看一条确定的数据
     *
     * @param id
     * @return
     */
    public T view(Object id);

    /**
     * 根据条件集合进行分页查询
     *
     * @param condition 查询条件
     * @param offset    偏移
     * @param rows      查询条数
     * @return 返回Pager对象
     */
    public List<T> listByPage(Map<String, Object> condition, int offset, int rows);

    public List<T> listByPage(Map<String, Object> condition, int offset, int rows, String orderBy, SqlOrderEnum sqlOrderEnum);

    /**
     * 保存单一对象
     *
     * @param entity
     */
    public int insert(T entity);

    /**
     * 更新对象,如果属性为空，则不会进行对应的属性值更新}
     *
     * @param entity 要更新的实体对象
     */
    public int update(T entity);


    public int insertMap(Map<String, Object> entityMap);

    public int updateMap(Map<String, Object> entityMap);

    /**
     * 根据id删除对象
     *
     * @param id
     */
    public int deleteById(Object id);

    /**
     * 根据list(ids)删除对象
     *
     * @param list
     */
    public int deleteByIds(List list);

    /**
     * 根据条件集合删除对象
     *
     * @param condition
     */
    public int deleteByCondition(Map<String, Object> condition);

    /**
     * 根据属性和属性值删除对象
     *
     * @param property
     * @param value
     */
    public int deleteByProperty(String property, Object value);

    /**
     * 根据id进行对象查询
     *
     * @param id
     * @return
     */
    public T fetch(Object id);

    /**
     * 根据任意属性和属性值进行对象查询，如果返回多个对象，将抛出异常
     *
     * @param property 进行对象匹配的属性
     * @param value    进行对象匹配的属性值
     * @return 返回泛型参数类型对象
     */
    public T findOne(String property, Object value);

    /**
     * 根据任意（单一）属性和属性值进行集合查询
     *
     * @param property 进行对象匹配的属性
     * @param value    进行对象匹配的属性值
     * @return 返回泛型参数类型的对象集合
     */
    public List<T> findList(String property, Object value);

    public List<T> findList(String property, Object value, String orderBy, SqlOrderEnum sqlOrderEnum);

    /**
     * 根据传入的泛型参数类型查询该类型对应表中的所有数据，返回一个集合对象
     *
     * @return 返回泛型参数类型的对象集合
     */
    public List<T> findAll();

    public List<T> findAll(String orderBy, SqlOrderEnum sqlOrderEnum);

    /**
     * 根据条件集合进行分页查询
     *
     * @param condition 查询条件
     * @param offset    偏移
     * @param rows      查询条数
     * @return 返回Pager对象
     */
    public List<T> queryPage(Map<String, Object> condition, int offset, int rows);

    public List<T> queryPage(Map<String, Object> condition, int offset, int rows, String orderBy, SqlOrderEnum sqlOrderEnum);

    /**
     * 根据任意属性和属性值进行对象模糊查询
     *
     * @param condition 条件
     * @return
     */
    public List<T> like(Map<String, Object> condition);

    public List<T> like(Map<String, Object> condition, String orderBy, SqlOrderEnum sqlOrderEnum);

    /**
     * 根据条件集合进行指定类型对象集合查询
     *
     * @param condition 进行查询的条件集合
     * @return 返回泛型参数类型的对象集合
     */
    public List<T> queryList(Map<String, Object> condition, String orderBy, String sortBy);

    /**
     * 根据条件集合进行指定类型单一对象查询
     *
     * @param condition 进行查询的条件集合
     * @return 返回泛型参数类型的对象
     */
    public T queryOne(Map<String, Object> condition);

    public T queryOne(Map<String, Object> condition, String orderBy, SqlOrderEnum sqlOrderEnum);

    /**
     * 根据条件进行数量的查询
     *
     * @param condition
     * @return 返回符合条件的泛型参数对应表中的数量
     */
    public int count(Map<String, Object> condition);

    /**
     * 该方法只有在主键为long时才有用，如果主键为其他数据类型进行使用，则会抛出异常
     *
     * @return 返回泛型参数对应表的主键最大值
     * @name selectMaxId
     * @active 查询实体对应表最大Id
     * @time 上午10:04:05
     * @exception/throws 如果主键类型不为long，会抛出类型转换异常
     */
    public Object selectMaxId();

    /**
     * 通用的更新操作
     *
     * @param updateMap    需要更新的值
     * @param conditionMap 需要被更新的条件
     */
    public int updateByCondition(Map<String, Object> updateMap, Map<String, Object> conditionMap);

}
