package cn.pet.lin.service;

import cn.pet.lin.dao.IBaseDAO;
import cn.pet.lin.BaseDomain;

/**
 * 业务主对象DAO注入
 */
public interface IDaoAware<D extends IBaseDAO,T extends BaseDomain> {
    public D getDao();
}
