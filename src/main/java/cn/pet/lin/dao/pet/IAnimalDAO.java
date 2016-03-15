/*
{*****************************************************************************
{  宠物商店 v1.0																		
{  模块：动物种类; InnoDB free: 10240 kB											
{  功能描述:										
{															
{  ---------------------------------------------------------------------------	
{  维护历史:													
{  日期        维护人        维护类型						
{  ---------------------------------------------------------------------------	
{  2016-02-10  林伟樘        新建	
{ 	                                                                     
{*****************************************************************************	
*/

package cn.pet.lin.dao.pet;

import cn.pet.lin.dao.IBaseDAO;
import cn.pet.lin.domain.pet.Animal;
import cn.pet.lin.domain.pet.AnimalEx;

import java.util.List;

/**
 * 《动物种类》 数据访问接口
 *
 * @author 林伟樘
 */
public interface IAnimalDAO extends IBaseDAO<Animal> {

    /**
     * 获取物种及其分类
     *
     * @return
     */
    public List<AnimalEx> getAnimalAndCategory();


}