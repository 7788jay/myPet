package cn.pet.lin.service;

import cn.pet.lin.dao.IBaseDAO;
import cn.pet.lin.domain.BaseDomain;
import cn.pet.lin.domain.BizData4Page;
import cn.pet.lin.utils.SqlOrderEnum;

import java.util.Map;

/**
 * 进行分页数据查询的service
 */
public interface IPageService<D extends IBaseDAO,T extends BaseDomain> {
    /**
     * 数据权限后的分页数据获取
     * @param resUri
     * @param conditions
     * @param offset
     * @param rows
     * @return
     */
    public BizData4Page queryPageByDataPerm(String resUri, Map<String, Object> conditions, int curPage, int offset, int rows);

    /**
     * 条件查询包含各种查询
     * @return
     */
    public void queryPageByDataPerm(BizData4Page bizData4Page);

    /***
     * 条件查询包含各种查询
     * baseDAO 主要为扩展exdao
     * @param baseDAO
     * @param bizData4Page
     */
    void queryPageByDataPerm(IBaseDAO baseDAO,BizData4Page bizData4Page);


    /**
     * 条件查询包含各种查询
     * @return
     */
    public void queryPageByDataPerm(BizData4Page bizData4Page, String orderBy, SqlOrderEnum sqlOrderEnum);


    /**
     * 具有排序的分页
     * @param resUri
     * @param conditions
     * @param curPage
     * @param offset
     * @param rows
     * @param orderBy
     * @param sqlOrderEnum
     * @return
     */
    public BizData4Page queryPageByDataPerm(String resUri, Map<String, Object> conditions, int curPage, int offset, int rows, String orderBy, SqlOrderEnum sqlOrderEnum);



    /**
     * 条件查询包含各种查询
     * @return
     */
    public void queryPageByDataPerm(BizData4Page bizData4Page, String orderBy, SqlOrderEnum sqlOrderEnum, Map<String, Object> selector);

    public void queryPageByDataPerm(IBaseDAO dao,BizData4Page bizData4Page, String orderBy, SqlOrderEnum sqlOrderEnum, Map<String, Object> selector);

    /**
     * 具有排序的分页
     * @param dao
     * @param conditions
     * @param curPage
     * @param offset
     * @param rows
     * @param orderBy
     * @param sqlOrderEnum
     * @return
     */
    public BizData4Page queryPageByDataPerm(IBaseDAO dao, Map<String, Object> conditions, int curPage, int offset, int rows, String orderBy, SqlOrderEnum sqlOrderEnum, Map<String, Object> selector);

}
