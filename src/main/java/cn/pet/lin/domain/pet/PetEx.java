/*
{*****************************************************************************
{  宠物商店 v1.0																		
{  模块：宠物表; InnoDB free: 10240 kB											
{  功能描述:										
{															
{  ---------------------------------------------------------------------------	
{  维护历史:													
{  日期        维护人        维护类型						
{  ---------------------------------------------------------------------------	
{  2016-02-14  林伟樘        新建	
{ 	                                                                     
{*****************************************************************************	
*/

package cn.pet.lin.domain.pet;

/**
 * 《宠物表》扩展实体
 * @author 林伟樘
 *
 */
public class PetEx extends Pet {
	private static final long serialVersionUID = 1L;

	private int orderSum;   //销量统计
	
	//针对Pet实体在这里增加额外的属性和对应的get和set方法

	public int getOrderSum() {
		return orderSum;
	}

	public void setOrderSum(int orderSum) {
		this.orderSum = orderSum;
	}
}
