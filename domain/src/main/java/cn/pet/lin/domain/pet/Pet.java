/*
{*****************************************************************************
{  宠物商店 v1.0																		
{  模块：宠物表											
{  功能描述:										
{															
{  ---------------------------------------------------------------------------	
{  维护历史:													
{  日期        维护人        维护类型						
{  ---------------------------------------------------------------------------	
{  2016-03-28  林伟樘        新建	
{ 	                                                                     
{*****************************************************************************	
*/

package cn.pet.lin.domain.pet;

import cn.pet.lin.BaseDomain;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * 《宠物表》 实体
 * @author 林伟樘
 *
 */
public class Pet extends BaseDomain<Long> {
	private static final long serialVersionUID = 1L;
	
	private String code; //宠物编号
	private String name; //宠物名
	private String image; //宠物图片
	private Integer weight; //重量
	private Integer sex; //性别
	private Integer age; //年龄
	private String description; //描述
	private Integer price; //售价
	private Long quantity; //库存
	private String categoryCode; //宠物分类code
	private Long createTime; //创建时间
	private Integer status; //状态
    
	/**
	 *默认空构造函数
	 */
	public Pet() {
		super();
	}
	 
	/**
	 * @return code 宠物编号
	 */
	public String getCode(){
		return this.code;
	}
	/**
	 * @param code 宠物编号
	 */
	public void setCode(String code){
		this.code = code;
	}
	/**
	 * @return name 宠物名
	 */
	public String getName(){
		return this.name;
	}
	/**
	 * @param name 宠物名
	 */
	public void setName(String name){
		this.name = name;
	}
	/**
	 * @return image 宠物图片
	 */
	public String getImage(){
		return this.image;
	}
	/**
	 * @param image 宠物图片
	 */
	public void setImage(String image){
		this.image = image;
	}
	/**
	 * @return weight 重量
	 */
	public Integer getWeight(){
		return this.weight;
	}
	/**
	 * @param weight 重量
	 */
	public void setWeight(Integer weight){
		this.weight = weight;
	}
	/**
	 * @return sex 性别
	 */
	public Integer getSex(){
		return this.sex;
	}
	/**
	 * @param sex 性别
	 */
	public void setSex(Integer sex){
		this.sex = sex;
	}
	/**
	 * @return age 年龄
	 */
	public Integer getAge(){
		return this.age;
	}
	/**
	 * @param age 年龄
	 */
	public void setAge(Integer age){
		this.age = age;
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
	 * @return price 售价
	 */
	public Integer getPrice(){
		return this.price;
	}
	/**
	 * @param price 售价
	 */
	public void setPrice(Integer price){
		this.price = price;
	}
	/**
	 * @return quantity 库存
	 */
	public Long getQuantity(){
		return this.quantity;
	}
	/**
	 * @param quantity 库存
	 */
	public void setQuantity(Long quantity){
		this.quantity = quantity;
	}
	/**
	 * @return categoryCode 宠物分类code
	 */
	public String getCategoryCode(){
		return this.categoryCode;
	}
	/**
	 * @param categoryCode 宠物分类code
	 */
	public void setCategoryCode(String categoryCode){
		this.categoryCode = categoryCode;
	}
	/**
	 * @return createTime 创建时间
	 */
	public Long getCreateTime(){
		return this.createTime;
	}
	/**
	 * @param createTime 创建时间
	 */
	public void setCreateTime(Long createTime){
		this.createTime = createTime;
	}
	/**
	 * @return status 状态
	 */
	public Integer getStatus(){
		return this.status;
	}
	/**
	 * @param status 状态
	 */
	public void setStatus(Integer status){
		this.status = status;
	}
	
	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("id",getId())
			.append("code",getCode())
			.append("name",getName())
			.append("image",getImage())
			.append("weight",getWeight())
			.append("sex",getSex())
			.append("age",getAge())
			.append("description",getDescription())
			.append("price",getPrice())
			.append("quantity",getQuantity())
			.append("categoryCode",getCategoryCode())
			.append("createTime",getCreateTime())
			.append("status",getStatus())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getId())
			.append(getCode())
			.append(getName())
			.append(getImage())
			.append(getWeight())
			.append(getSex())
			.append(getAge())
			.append(getDescription())
			.append(getPrice())
			.append(getQuantity())
			.append(getCategoryCode())
			.append(getCreateTime())
			.append(getStatus())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof Pet == false) return false;
		if(this == obj) return true;
		Pet other = (Pet)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}
}
