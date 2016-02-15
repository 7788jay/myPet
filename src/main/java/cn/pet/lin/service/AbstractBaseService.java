package cn.pet.lin.service;


import cn.pet.lin.dao.IBaseDAO;
import cn.pet.lin.domain.BaseDomain;
import cn.pet.lin.utils.enums.SqlOrderEnum;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;
import java.util.Map;

/**
 * 服务抽象类
 * <p/>
 * 创建时间: 14-9-22 下午5:51<br/>
 *
 * @author qyang
 * @since v0.0.1
 */
@CacheConfig(cacheNames={"allunused"})
public abstract class AbstractBaseService<D extends IBaseDAO,T extends BaseDomain> implements IBaseService<D,T>, IDaoAware<D,T> {

    @Override
    @CacheEvict(key = "#entity.id")
    public final int edit(T entity) {
        return getDao().update(entity);
    }

    @Override
    @CacheEvict(key = "#id")
    public final int delete(Object id) {
        return getDao().deleteById(id);
    }

    @Override
    public final int deleteByIds(List list) {
        return getDao().deleteByIds(list);
    }

    @Override
    @Cacheable(key = "#id")
    public final T view(Object id) {
        return (T)getDao().fetch(id);
    }

    @Override
    public final int insert(T entity) {
        return getDao().insert(entity);
    }

    @Override
    @CacheEvict(key = "#entity.id")
    public final int update(T entity) {
        return getDao().update(entity);
    }


    @Override
    @CacheEvict(key = "#entity.id")
    public final int deleteById(Object id) {

        return getDao().deleteById(id);
    }

    @Override
    @CacheEvict(allEntries = true)
    public final int deleteByProperty(String property, Object value) {
        return getDao().deleteByProperty(property,value);

    }

    @Override
    @Cacheable(key = "#id")
    public final T fetch(Object id) {
        return (T)getDao().fetch(id);
    }

    @Override
    @Cacheable()
    public final T findOne(String property, Object value) {
        return (T)getDao().findOne(property,value, null, null);
    }

    @Override
    @Cacheable()
    public final List findList(String property, Object value) {
        return getDao().findList(property, value, null, null);
    }

    @Override
    @Cacheable()
    public final List findList(String property, Object value, String orderBy, SqlOrderEnum sqlOrderEnum) {
        return getDao().findList(property, value, orderBy, sqlOrderEnum.getAction());
    }

    @Override
    public final List findAll() {
        return getDao().findAll(null, null);
    }

    @Override
    public final List findAll(String orderBy, SqlOrderEnum sqlOrderEnum) {
        return getDao().findAll(orderBy, sqlOrderEnum.getAction());
    }

    @Override
    @Cacheable()
    public final List like(Map<String, Object> condition) {
        return getDao().like(condition, null, null);
    }

    @Override
    @Cacheable()
    public final List like(Map<String, Object> condition, String orderBy, SqlOrderEnum sqlOrderEnum) {
        return getDao().like(condition, orderBy, sqlOrderEnum.getAction());
    }

    @Override
    public final Object selectMaxId() {
        return getDao().selectMaxId();
    }


    @Override
    public final int count(Map condition) {
        return getDao().count(condition);
    }

    @Override
    public final T queryOne(Map condition) {
        return (T)getDao().queryOne(condition, null, null,null);
    }

    @Override
    public final T queryOne(Map condition, String orderBy, SqlOrderEnum sqlOrderEnum) {
        return (T)getDao().queryOne(condition, orderBy, sqlOrderEnum.getAction(),null);
    }

    @Override
    public final List queryList(Map condition, String orderBy, String sortBy) {
        return getDao().queryList(condition, orderBy, sortBy);
    }

    @Override
    public final List queryPage(Map condition, int offset, int rows) {
        return getDao().queryPage(condition, offset, rows, null, null);
    }

    public List<T> queryPage(Map<String, Object> condition, int offset, int rows, String orderBy, SqlOrderEnum sqlOrderEnum){
        return getDao().queryPage(condition, offset, rows, orderBy, sqlOrderEnum.getAction());
    }

    @Override
    @CacheEvict(allEntries = true) //失效本对象所有缓存  尽量不要调用该方法
    public final int deleteByCondition(Map condition) {
        return getDao().deleteByCondition(condition);
    }

    @Override
    @CacheEvict(allEntries = true)
    public final int updateMap(Map entityMap) {
        enhanceCreateBaseDomain(entityMap);
        return getDao().updateMap(entityMap);
    }

    @Override
    public final int insertMap(Map entityMap) {
        enhanceNewCreateBaseDomain(entityMap);
        return getDao().insertMap(entityMap);
    }

    @Override
    public final List listByPage(Map condition, int offset, int rows) {
        return getDao().queryPage(condition, offset, rows, null, null);
    }

    @Override
    public final List listByPage(Map condition, int offset, int rows, String orderBy, SqlOrderEnum sqlOrderEnum) {
        return getDao().queryPage(condition, offset, rows, orderBy, sqlOrderEnum.getAction());
    }



    private final Map enhanceCreateBaseDomain(Map entityMap){
        entityMap.put("lastModDate", System.currentTimeMillis());

        return entityMap;
    }

    private final Map enhanceNewCreateBaseDomain(Map entityMap){
        entityMap.put("createDate", System.currentTimeMillis());

        return entityMap;
    }

    // ---------------- 后加接口，在这里默认做空实现，避免实现类报错，如果需要使用这些特性，需要重载 -----------------//

    /**
     * 通用的更新操作
     * @param updateMap 需要更新的值
     * @param conditionMap 需要被更新的条件
     */
    public int updateByCondition(Map<String, Object> updateMap, Map<String, Object> conditionMap)
    {
        return getDao().updateByCondition(updateMap,conditionMap);
    }

}

