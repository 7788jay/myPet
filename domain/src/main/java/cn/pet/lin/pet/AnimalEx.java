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

package cn.pet.lin.pet;

import java.util.List;

/**
 * 《动物种类》扩展实体
 * @author 林伟樘
 *
 */
public class AnimalEx extends Animal {
	private static final long serialVersionUID = 1L;

	private List<Category> categories;
	
	//针对Animal实体在这里增加额外的属性和对应的get和set方法

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}
}
