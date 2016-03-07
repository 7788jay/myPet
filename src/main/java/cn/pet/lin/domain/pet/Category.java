/*
{*****************************************************************************
{  宠物商店 v1.0																		
{  模块：宠物分类; InnoDB free: 10240 kB											
{  功能描述:										
{															
{  ---------------------------------------------------------------------------	
{  维护历史:													
{  日期        维护人        维护类型						
{  ---------------------------------------------------------------------------	
{  2016-02-11  林伟樘        新建	
{ 	                                                                     
{*****************************************************************************	
*/

package cn.pet.lin.domain.pet;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import cn.pet.lin.domain.BaseDomain;

import java.util.*;

/**
 * 《宠物分类》 实体
 * @author 林伟樘
 *
 */
public class Category extends BaseDomain<Integer> {
	private static final long serialVersionUID = 1L;
	
	private String code; //分类code
	private String name; //分类名
	private String animalCode; //动物种类
	private String description; //描述
	private Long createTime; //创建时间
    
	/**
	 *默认空构造函数
	 */
	public Category() {
		super();
	}
	 
	/**
	 * @return code 分类code
	 */
	public String getCode(){
		return this.code;
	}
	/**
	 * @param code 分类code
	 */
	public void setCode(String code){
		this.code = code;
	}
	/**
	 * @return name 分类名
	 */
	public String getName(){
		return this.name;
	}
	/**
	 * @param name 分类名
	 */
	public void setName(String name){
		this.name = name;
	}
	/**
	 * @return animalCode 动物种类
	 */
	public String getAnimalCode(){
		return this.animalCode;
	}
	/**
	 * @param animalCode 动物种类
	 */
	public void setAnimalCode(String animalCode){
		this.animalCode = animalCode;
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
			.append("animalCode",getAnimalCode())
			.append("description",getDescription())
			.append("createTime",getCreateTime())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getId())
			.append(getCode())
			.append(getName())
			.append(getAnimalCode())
			.append(getDescription())
			.append(getCreateTime())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof Category == false) return false;
		if(this == obj) return true;
		Category other = (Category)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}
}
