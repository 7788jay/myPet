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

package cn.pet.lin.domain.param.pet;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import cn.pet.lin.BaseParam;

/**
 * 《动物种类》 查询参数实体
 * @author 林伟樘
 *
 */
public class AnimalParam extends BaseParam<Integer> {
	private static final long serialVersionUID = 1L;
	
	/**
	*字段常量——动物代码
	*/
	public static final String F_Code="code";
	/**
	*字段常量——动物名称
	*/
	public static final String F_Name="name";
	/**
	*字段常量——描述
	*/
	public static final String F_Description="description";
	/**
	*字段常量——创建时间
	*/
	public static final String F_CreateTime="createTime";
	
	private String code; //动物代码
	private String name; //动物名称
	private String description; //描述
	private Long createTime; //创建时间
    
	/**
	 *默认空构造函数
	 */
	public AnimalParam() {
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
	
}
