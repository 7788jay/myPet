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

package cn.pet.lin.domain.param.pet;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import cn.pet.lin.domain.BaseParam;

import java.util.*;

/**
 * 《宠物表》 查询参数实体
 * @author 林伟樘
 *
 */
public class PetParam extends BaseParam<Long> {
	private static final long serialVersionUID = 1L;
	
	/**
	*字段常量——宠物编号
	*/
	public static final String F_Code="code";
	/**
	*字段常量——宠物名
	*/
	public static final String F_Name="name";
	/**
	*字段常量——宠物图片
	*/
	public static final String F_Image="image";
	/**
	*字段常量——重量
	*/
	public static final String F_Weight="weight";
	/**
	*字段常量——寿命
	*/
	public static final String F_Life="life";
	/**
	*字段常量——售价
	*/
	public static final String F_Price="price";
	/**
	*字段常量——描述
	*/
	public static final String F_Description="description";
	/**
	*字段常量——创建时间
	*/
	public static final String F_CreateTime="createTime";
	/**
	*字段常量——宠物分类code
	*/
	public static final String F_CategoryCode="categoryCode";
	
	private String code; //宠物编号
	private String name; //宠物名
	private String image; //宠物图片
	private Integer weight; //重量
	private Integer life; //寿命
	private Integer price; //售价
	private String description; //描述
	private Long createTime; //创建时间
	private String categoryCode; //宠物分类code
    
	/**
	 *默认空构造函数
	 */
	public PetParam() {
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
	 * @return life 寿命
	 */
	public Integer getLife(){
		return this.life;
	}
	/**
	 * @param life 寿命
	 */
	public void setLife(Integer life){
		this.life = life;
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
	
	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("id",getId())
			.append("code",getCode())
			.append("name",getName())
			.append("image",getImage())
			.append("weight",getWeight())
			.append("life",getLife())
			.append("price",getPrice())
			.append("description",getDescription())
			.append("createTime",getCreateTime())
			.append("categoryCode",getCategoryCode())
			.toString();
	}
	
}
