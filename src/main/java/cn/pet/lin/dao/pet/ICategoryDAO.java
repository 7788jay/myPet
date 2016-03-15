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

package cn.pet.lin.dao.pet;

import cn.pet.lin.dao.IBaseDAO;
import cn.pet.lin.domain.pet.Category;
import cn.pet.lin.domain.pet.CategoryEx;
import org.apache.ibatis.annotations.Param;

/**
 * 《宠物分类》 数据访问接口
 *
 * @author 林伟樘
 */
public interface ICategoryDAO extends IBaseDAO<Category> {
    /**
     * 获取一个有物种名称的分类
     *
     * @param code
     * @return
     */
    public CategoryEx queryOneAndName(@Param("code") String code);
}