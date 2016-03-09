/*
{*****************************************************************************
{  宠物商店 v1.0																		
{  模块：订单项; InnoDB free: 10240 kB											
{  功能描述:										
{															
{  ---------------------------------------------------------------------------	
{  维护历史:													
{  日期        维护人        维护类型						
{  ---------------------------------------------------------------------------	
{  2016-03-07  林伟樘        新建	
{ 	                                                                     
{*****************************************************************************	
*/

package cn.pet.lin.domain.order;

import cn.pet.lin.domain.pet.Pet;

/**
 * 《订单项》扩展实体
 * @author 林伟樘
 *
 */
public class ItemEx extends Item {
	private static final long serialVersionUID = 1L;

	private Pet pet;
	
	//针对Item实体在这里增加额外的属性和对应的get和set方法

	public Pet getPet() {
		return pet;
	}

	public void setPet(Pet pet) {
		this.pet = pet;
	}
}
