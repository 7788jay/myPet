/*
{*****************************************************************************
{  宠物商店 v1.0																		
{  模块：宠物分类; InnoDB free: 10240 kB											
{  功能描述:										
{															
{  ---------------------------------------------------------------------------	
{  维护历史:													
{  日期        维护人        维护类型						
{  ---------------------------------------------------------------------------	
{  2016-02-11  林伟樘        新建	
{ 	                                                                     
{*****************************************************************************	
*/

package cn.pet.lin.service.pet;

import cn.pet.lin.dao.pet.ICategoryDAO;
import cn.pet.lin.pet.Category;
import cn.pet.lin.pet.CategoryEx;
import cn.pet.lin.service.IBaseService;

/**
 * 《宠物分类》 业务逻辑服务接口
 *
 * @author 林伟樘
 */
public interface ICategoryService extends IBaseService<ICategoryDAO, Category> {
    /**
     * 获取一个有物种名称的分类
     *
     * @param code
     * @return
     */
    public CategoryEx queryOneAndName(String code);
}