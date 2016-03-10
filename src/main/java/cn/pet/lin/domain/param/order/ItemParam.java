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

package cn.pet.lin.domain.param.order;

import cn.pet.lin.domain.BaseParam;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * 《订单项》 查询参数实体
 * @author 林伟樘
 *
 */
public class ItemParam extends BaseParam<Integer> {
	private static final long serialVersionUID = 1L;
	
	/**
	*字段常量——
	*/
	public static final String F_Code="code";
	/**
	*字段常量——
	*/
	public static final String F_OrderCode="orderCode";
	/**
	*字段常量——
	*/
	public static final String F_PetCode="petCode";
	/**
	*字段常量——数量
	*/
	public static final String F_Quantity="quantity";
	/**
	*字段常量——总价
	*/
	public static final String F_TotalPrice="totalPrice";
	
	private String code; //
	private String orderCode; //
	private String petCode; //
	private Integer quantity; //数量
	private Long totalPrice; //总价
    
	/**
	 *默认空构造函数
	 */
	public ItemParam() {
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
	
}
