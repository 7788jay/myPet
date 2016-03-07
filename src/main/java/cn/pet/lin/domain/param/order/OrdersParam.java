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

package cn.pet.lin.domain.param.order;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import cn.pet.lin.domain.BaseParam;

import java.util.*;

/**
 * 《订单表》 查询参数实体
 * @author 林伟樘
 *
 */
public class OrdersParam extends BaseParam<Integer> {
	private static final long serialVersionUID = 1L;
	
	/**
	*字段常量——用户账号
	*/
	public static final String F_UserCode="userCode";
	/**
	*字段常量——订单编号
	*/
	public static final String F_Code="code";
	/**
	*字段常量——下单时间
	*/
	public static final String F_CreateTime="createTime";
	/**
	*字段常量——支付时间
	*/
	public static final String F_PayTime="payTime";
	/**
	*字段常量——支付类型
	*/
	public static final String F_PayType="payType";
	/**
	*字段常量——发货时间
	*/
	public static final String F_SendTime="sendTime";
	/**
	*字段常量——完成时间
	*/
	public static final String F_CompleteTime="completeTime";
	/**
	*字段常量——配送方式
	*/
	public static final String F_DeliveryType="deliveryType";
	/**
	*字段常量——配送时间
	*/
	public static final String F_DeliveryTime="deliveryTime";
	/**
	*字段常量——收货人地址
	*/
	public static final String F_DeliveryCode="deliveryCode";
	/**
	*字段常量——总价
	*/
	public static final String F_TotalPrice="totalPrice";
	/**
	*字段常量——供应商编号
	*/
	public static final String F_SupplyCode="supplyCode";
	/**
	*字段常量——描述
	*/
	public static final String F_Description="description";
	/**
	*字段常量——订单状态
	*/
	public static final String F_Status="status";
	
	private String userCode; //用户账号
	private String code; //订单编号
	private Long createTime; //下单时间
	private Long payTime; //支付时间
	private Integer payType; //支付类型
	private Long sendTime; //发货时间
	private Long completeTime; //完成时间
	private Integer deliveryType; //配送方式
	private Long deliveryTime; //配送时间
	private String deliveryCode; //收货人地址
	private Integer totalPrice; //总价
	private String supplyCode; //供应商编号
	private String description; //描述
	private Integer status; //订单状态
    
	/**
	 *默认空构造函数
	 */
	public OrdersParam() {
		super();
	}
	 
	/**
	 * @return userCode 用户账号
	 */
	public String getUserCode(){
		return this.userCode;
	}
	/**
	 * @param userCode 用户账号
	 */
	public void setUserCode(String userCode){
		this.userCode = userCode;
	}
	/**
	 * @return code 订单编号
	 */
	public String getCode(){
		return this.code;
	}
	/**
	 * @param code 订单编号
	 */
	public void setCode(String code){
		this.code = code;
	}
	/**
	 * @return createTime 下单时间
	 */
	public Long getCreateTime(){
		return this.createTime;
	}
	/**
	 * @param createTime 下单时间
	 */
	public void setCreateTime(Long createTime){
		this.createTime = createTime;
	}
	/**
	 * @return payTime 支付时间
	 */
	public Long getPayTime(){
		return this.payTime;
	}
	/**
	 * @param payTime 支付时间
	 */
	public void setPayTime(Long payTime){
		this.payTime = payTime;
	}
	/**
	 * @return payType 支付类型
	 */
	public Integer getPayType(){
		return this.payType;
	}
	/**
	 * @param payType 支付类型
	 */
	public void setPayType(Integer payType){
		this.payType = payType;
	}
	/**
	 * @return sendTime 发货时间
	 */
	public Long getSendTime(){
		return this.sendTime;
	}
	/**
	 * @param sendTime 发货时间
	 */
	public void setSendTime(Long sendTime){
		this.sendTime = sendTime;
	}
	/**
	 * @return completeTime 完成时间
	 */
	public Long getCompleteTime(){
		return this.completeTime;
	}
	/**
	 * @param completeTime 完成时间
	 */
	public void setCompleteTime(Long completeTime){
		this.completeTime = completeTime;
	}
	/**
	 * @return deliveryType 配送方式
	 */
	public Integer getDeliveryType(){
		return this.deliveryType;
	}
	/**
	 * @param deliveryType 配送方式
	 */
	public void setDeliveryType(Integer deliveryType){
		this.deliveryType = deliveryType;
	}
	/**
	 * @return deliveryTime 配送时间
	 */
	public Long getDeliveryTime(){
		return this.deliveryTime;
	}
	/**
	 * @param deliveryTime 配送时间
	 */
	public void setDeliveryTime(Long deliveryTime){
		this.deliveryTime = deliveryTime;
	}
	/**
	 * @return deliveryCode 收货人地址
	 */
	public String getDeliveryCode(){
		return this.deliveryCode;
	}
	/**
	 * @param deliveryCode 收货人地址
	 */
	public void setDeliveryCode(String deliveryCode){
		this.deliveryCode = deliveryCode;
	}
	/**
	 * @return totalPrice 总价
	 */
	public Integer getTotalPrice(){
		return this.totalPrice;
	}
	/**
	 * @param totalPrice 总价
	 */
	public void setTotalPrice(Integer totalPrice){
		this.totalPrice = totalPrice;
	}
	/**
	 * @return supplyCode 供应商编号
	 */
	public String getSupplyCode(){
		return this.supplyCode;
	}
	/**
	 * @param supplyCode 供应商编号
	 */
	public void setSupplyCode(String supplyCode){
		this.supplyCode = supplyCode;
	}
	/**
	 * @return description 描述
	 */
	public String getDescription(){
		return this.description;
	}
	/**
	 * @param description 描述
	 */
	public void setDescription(String description){
		this.description = description;
	}
	/**
	 * @return status 订单状态
	 */
	public Integer getStatus(){
		return this.status;
	}
	/**
	 * @param status 订单状态
	 */
	public void setStatus(Integer status){
		this.status = status;
	}
	
	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("id",getId())
			.append("userCode",getUserCode())
			.append("code",getCode())
			.append("createTime",getCreateTime())
			.append("payTime",getPayTime())
			.append("payType",getPayType())
			.append("sendTime",getSendTime())
			.append("completeTime",getCompleteTime())
			.append("deliveryType",getDeliveryType())
			.append("deliveryTime",getDeliveryTime())
			.append("deliveryCode",getDeliveryCode())
			.append("totalPrice",getTotalPrice())
			.append("supplyCode",getSupplyCode())
			.append("description",getDescription())
			.append("status",getStatus())
			.toString();
	}
	
}
