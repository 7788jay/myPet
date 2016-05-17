/*
{*****************************************************************************
{  宠物商店 v1.0																		
{  模块：用户收货地址表; InnoDB free: 10240 kB											
{  功能描述:										
{															
{  ---------------------------------------------------------------------------	
{  维护历史:													
{  日期        维护人        维护类型						
{  ---------------------------------------------------------------------------	
{  2016-03-06  林伟樘        新建	
{ 	                                                                     
{*****************************************************************************	
*/

package cn.pet.lin.domain.param.user;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import cn.pet.lin.BaseParam;

/**
 * 《用户收货地址表》 查询参数实体
 * @author 林伟樘
 *
 */
public class DeliveryParam extends BaseParam<Integer> {
	private static final long serialVersionUID = 1L;
	
	/**
	*字段常量——code
	*/
	public static final String F_Code="code";
	/**
	*字段常量——用户code
	*/
	public static final String F_UserCode="userCode";
	/**
	*字段常量——收货人
	*/
	public static final String F_Name="name";
	/**
	*字段常量——省
	*/
	public static final String F_Province="province";
	/**
	*字段常量——市
	*/
	public static final String F_City="city";
	/**
	*字段常量——区
	*/
	public static final String F_Area="area";
	/**
	*字段常量——详细地址
	*/
	public static final String F_Detail="detail";
	/**
	*字段常量——电话
	*/
	public static final String F_Phone="phone";
	/**
	*字段常量——邮编
	*/
	public static final String F_PostCode="postCode";
	/**
	*字段常量——是否为默认收货地址
	*/
	public static final String F_IsDefault="isDefault";
	
	private String code; //code
	private String userCode; //用户code
	private String name; //收货人
	private String province; //省
	private String city; //市
	private String area; //区
	private String detail; //详细地址
	private String phone; //电话
	private String postCode; //邮编
	private Boolean isDefault; //是否为默认收货地址
    
	/**
	 *默认空构造函数
	 */
	public DeliveryParam() {
		super();
	}
	 
	/**
	 * @return code code
	 */
	public String getCode(){
		return this.code;
	}
	/**
	 * @param code code
	 */
	public void setCode(String code){
		this.code = code;
	}
	/**
	 * @return userCode 用户code
	 */
	public String getUserCode(){
		return this.userCode;
	}
	/**
	 * @param userCode 用户code
	 */
	public void setUserCode(String userCode){
		this.userCode = userCode;
	}
	/**
	 * @return name 收货人
	 */
	public String getName(){
		return this.name;
	}
	/**
	 * @param name 收货人
	 */
	public void setName(String name){
		this.name = name;
	}
	/**
	 * @return province 省
	 */
	public String getProvince(){
		return this.province;
	}
	/**
	 * @param province 省
	 */
	public void setProvince(String province){
		this.province = province;
	}
	/**
	 * @return city 市
	 */
	public String getCity(){
		return this.city;
	}
	/**
	 * @param city 市
	 */
	public void setCity(String city){
		this.city = city;
	}
	/**
	 * @return area 区
	 */
	public String getArea(){
		return this.area;
	}
	/**
	 * @param area 区
	 */
	public void setArea(String area){
		this.area = area;
	}
	/**
	 * @return detail 详细地址
	 */
	public String getDetail(){
		return this.detail;
	}
	/**
	 * @param detail 详细地址
	 */
	public void setDetail(String detail){
		this.detail = detail;
	}
	/**
	 * @return phone 电话
	 */
	public String getPhone(){
		return this.phone;
	}
	/**
	 * @param phone 电话
	 */
	public void setPhone(String phone){
		this.phone = phone;
	}
	/**
	 * @return postCode 邮编
	 */
	public String getPostCode(){
		return this.postCode;
	}
	/**
	 * @param postCode 邮编
	 */
	public void setPostCode(String postCode){
		this.postCode = postCode;
	}
	/**
	 * @return isDefault 是否为默认收货地址
	 */
	public Boolean getIsDefault(){
		return this.isDefault;
	}
	/**
	 * @param isDefault 是否为默认收货地址
	 */
	public void setIsDefault(Boolean isDefault){
		this.isDefault = isDefault;
	}
	
	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("id",getId())
			.append("code",getCode())
			.append("userCode",getUserCode())
			.append("name",getName())
			.append("province",getProvince())
			.append("city",getCity())
			.append("area",getArea())
			.append("detail",getDetail())
			.append("phone",getPhone())
			.append("postCode",getPostCode())
			.append("isDefault",getIsDefault())
			.toString();
	}
	
}
