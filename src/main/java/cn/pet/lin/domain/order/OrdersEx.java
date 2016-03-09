/*
{*****************************************************************************
{  宠物商店 v1.0																		
{  模块：订单表; InnoDB free: 10240 kB											
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

import cn.pet.lin.domain.user.User;

import java.util.List;

/**
 * 《订单表》扩展实体
 * @author 林伟樘
 *
 */
public class OrdersEx extends Orders {
	private static final long serialVersionUID = 1L;

	private User user;
	private List<ItemEx> itemExs;
	
	//针对Orders实体在这里增加额外的属性和对应的get和set方法

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<ItemEx> getItemExs() {
		return itemExs;
	}

	public void setItemExs(List<ItemEx> itemExs) {
		this.itemExs = itemExs;
	}
}
