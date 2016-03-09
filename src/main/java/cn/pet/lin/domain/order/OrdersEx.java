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

import java.util.List;

/**
 * 《订单表》扩展实体
 * @author 林伟樘
 *
 */
public class OrdersEx extends Orders {
	private static final long serialVersionUID = 1L;

	private String userName;
	private String phone;
	private List<ItemEx> itemExs;
	
	//针对Orders实体在这里增加额外的属性和对应的get和set方法


	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public List<ItemEx> getItemExs() {
		return itemExs;
	}

	public void setItemExs(List<ItemEx> itemExs) {
		this.itemExs = itemExs;
	}
}
