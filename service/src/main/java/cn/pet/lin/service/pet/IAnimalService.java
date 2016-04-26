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

package cn.pet.lin.service.pet;

import cn.pet.lin.pet.Animal;
import cn.pet.lin.dao.pet.IAnimalDAO;
import cn.pet.lin.pet.AnimalEx;
import cn.pet.lin.service.IBaseService;

import java.util.List;

/**
 * 《动物种类》 业务逻辑服务接口
 *
 * @author 林伟樘
 */
public interface IAnimalService extends IBaseService<IAnimalDAO, Animal> {

    /**
     * 获取物种及其分类
     *
     * @return
     */
    public List<AnimalEx> getAnimalAndCategory();
}