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

import cn.pet.lin.domain.user.Delivery;

import java.util.List;

/**
 * 《订单表》扩展实体
 * @author 林伟樘
 *
 */
public class OrdersEx extends Orders {
	private static final long serialVersionUID = 1L;

	private Delivery delivery;//收货人信息
	private String userName;  //下单用户名
	private String phone;     //下单用户手机号
	private List<ItemEx> itemExs;  //订单项集合
	
	//针对Orders实体在这里增加额外的属性和对应的get和set方法


	public Delivery getDelivery() {
		return delivery;
	}

	public void setDelivery(Delivery delivery) {
		this.delivery = delivery;
	}

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
