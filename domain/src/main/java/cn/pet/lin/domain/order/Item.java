/*
{*****************************************************************************
{  宠物商店 v1.0																		
{  模块：订单项											
{  功能描述:										
{															
{  ---------------------------------------------------------------------------	
{  维护历史:													
{  日期        维护人        维护类型						
{  ---------------------------------------------------------------------------	
{  2016-03-11  林伟樘        新建	
{ 	                                                                     
{*****************************************************************************	
*/

package cn.pet.lin.domain.order;

import cn.pet.lin.BaseDomain;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * 《订单项》 实体
 * @author 林伟樘
 *
 */
public class Item extends BaseDomain<Integer> {
	private static final long serialVersionUID = 1L;
	
	private String code; //
	private String orderCode; //
	private String petCode; //
	private Integer quantity; //数量
	private Long totalPrice; //总价
    
	/**
	 *默认空构造函数
	 */
	public Item() {
		super();
	}
	 
	/**
	 * @return code 
	 */
	public String getCode(){
		return this.code;
	}
	/**
	 * @param code 
	 */
	public void setCode(String code){
		this.code = code;
	}
	/**
	 * @return orderCode 
	 */
	public String getOrderCode(){
		return this.orderCode;
	}
	/**
	 * @param orderCode 
	 */
	public void setOrderCode(String orderCode){
		this.orderCode = orderCode;
	}
	/**
	 * @return petCode 
	 */
	public String getPetCode(){
		return this.petCode;
	}
	/**
	 * @param petCode 
	 */
	public void setPetCode(String petCode){
		this.petCode = petCode;
	}
	/**
	 * @return quantity 数量
	 */
	public Integer getQuantity(){
		return this.quantity;
	}
	/**
	 * @param quantity 数量
	 */
	public void setQuantity(Integer quantity){
		this.quantity = quantity;
	}
	/**
	 * @return totalPrice 总价
	 */
	public Long getTotalPrice(){
		return this.totalPrice;
	}
	/**
	 * @param totalPrice 总价
	 */
	public void setTotalPrice(Long totalPrice){
		this.totalPrice = totalPrice;
	}
	
	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("id",getId())
			.append("code",getCode())
			.append("orderCode",getOrderCode())
			.append("petCode",getPetCode())
			.append("quantity",getQuantity())
			.append("totalPrice",getTotalPrice())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getId())
			.append(getCode())
			.append(getOrderCode())
			.append(getPetCode())
			.append(getQuantity())
			.append(getTotalPrice())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof Item == false) return false;
		if(this == obj) return true;
		Item other = (Item)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}
}
