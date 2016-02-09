package cn.pet.lin.dao;

import cn.pet.lin.domain.BaseDomain;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;


/**
 * 使用统一的接口定义 利于编码习惯统一
 * 因为使用autoscan,需要每个mapper.xml都有方法对应的声明
 */
public interface IBaseDAO<T extends BaseDomain> {

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

    public int updateMap(@Param("map") Map<String, Object> entityMap);

    /**
     * 通用的更新操作
     *
     * @param updateMap    需要更新的值
     * @param conditionMap 需要被更新的条件
     */
    public int updateByCondition(@Param("update") Map<String, Object> updateMap, @Param("condition") Map<String, Object> conditionMap);

    /**
     * map类型数据的新增
     *
     * @param entityMap
     */
    public int insertMap(@Param("map") Map<String, Object> entityMap);

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
    public int deleteByProperty(@Param("property") String property, @Param("value") Object value);

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
     * @param property
     * @param value
     * @param orderBy
     * @param sortBy
     * @return
     */
    public T findOne(@Param("property") String property, @Param("value") Object value, @Param("orderBy") String orderBy, @Param("sortBy") String sortBy);


    /**
     * 根据任意（单一）属性和属性值进行集合查询
     *
     * @param property 进行对象匹配的属性
     * @param value    进行对象匹配的属性值
     * @param orderBy
     * @param sortBy
     * @return 返回泛型参数类型的对象集合
     */
    public List<T> findList(@Param("property") String property, @Param("value") Object value, @Param("orderBy") String orderBy, @Param("sortBy") String sortBy);


    /**
     * 根据传入的泛型参数类型查询该类型对应表中的所有数据，返回一个集合对象
     *
     * @param orderBy
     * @param sortBy
     * @return
     */
    public List<T> findAll(@Param("orderBy") String orderBy, @Param("sortBy") String sortBy);

    /**
     * 根据条件集合进行分页查询
     *
     * @param condition 查询条件
     * @param offset    偏移
     * @param rows      查询条数
     * @param orderBy
     * @param sortBy
     * @return 返回Pager对象
     */
    public List<T> queryPage(@Param("condition") Map<String, Object> condition, @Param("offset") int offset, @Param("rows") int rows,
                             @Param("orderBy") String orderBy, @Param("sortBy") String sortBy);

    /**
     * 根据任意属性和属性值进行对象模糊查询
     *
     * @param condition 进行对象匹配的属性,进行对象匹配的模糊属性值
     * @param orderBy
     * @param sortBy
     * @return
     */
    public List<T> like(@Param("condition") Map<String, Object> condition, @Param("orderBy") String orderBy, @Param("sortBy") String sortBy);

    /**
     * 根据条件集合进行指定类型对象集合查询
     *
     * @param condition 进行查询的条件集合
     * @return 返回泛型参数类型的对象集合，如何取到泛型类型参数，请参看{@link #getEntityClass()}
     */
    public List<T> queryList(@Param("condition") Map<String, Object> condition, @Param("orderBy") String orderBy, @Param("sortBy") String sortBy);

    /**
     * 根据条件集合进行指定类型单一对象查询
     *
     * @param condition 进行查询的条件集合
     * @return 返回泛型参数类型的对象，如何取到泛型类型参数，请参看{@link #getEntityClass()}，
     */
    public T queryOne(@Param("condition") Map<String, Object> condition, @Param("orderBy") String orderBy, @Param("sortBy") String sortBy);

    /**
     * @param condition
     * @param orderBy
     * @param sortBy
     * @param selector  查询器，不进行不必要字段的查询，这样 生成的 model  在http传递给客户端时依赖fastjson的特性 就不会传递出去，减少带宽依赖
     * @return
     */
    public T queryOne(@Param("condition") Map<String, Object> condition, @Param("orderBy") String orderBy, @Param("sortBy") String sortBy, @Param("selector") Map<String, Object> selector);

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
     * @exception/throws 如果主键类型不为long，会抛出类型转换异常
     */
    public Object selectMaxId();

    /**
     * 取得泛型类型
     *
     * @return
     */
    public Class<T> getEntityClass();

}
