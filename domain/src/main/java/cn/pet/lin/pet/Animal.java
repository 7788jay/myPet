/*
{*****************************************************************************
{  宠物商店 v1.0																		
{  模块：动物种类; InnoDB free: 10240 kB											
{  功能描述:										
{															
{  ---------------------------------------------------------------------------	
{  维护历史:													
{  日期        维护人        维护类型						
{  ---------------------------------------------------------------------------	
{  2016-02-10  林伟樘        新建	
{ 	                                                                     
{*****************************************************************************	
*/

package cn.pet.lin.pet;

import cn.pet.lin.BaseDomain;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * 《动物种类》 实体
 * @author 林伟樘
 *
 */
public class Animal extends BaseDomain<Integer> {
	private static final long serialVersionUID = 1L;
	
	private String code; //动物代码
	private String name; //动物名称
	private String description; //描述
	private Long createTime; //创建时间
    
	/**
	 *默认空构造函数
	 */
	public Animal() {
		super();
	}
	 
	/**
	 * @return code 动物代码
	 */
	public String getCode(){
		return this.code;
	}
	/**
	 * @param code 动物代码
	 */
	public void setCode(String code){
		this.code = code;
	}
	/**
	 * @return name 动物名称
	 */
	public String getName(){
		return this.name;
	}
	/**
	 * @param name 动物名称
	 */
	public void setName(String name){
		this.name = name;
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
	
	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("id",getId())
			.append("code",getCode())
			.append("name",getName())
			.append("description",getDescription())
			.append("createTime",getCreateTime())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getId())
			.append(getCode())
			.append(getName())
			.append(getDescription())
			.append(getCreateTime())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof Animal == false) return false;
		if(this == obj) return true;
		Animal other = (Animal)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}
}
