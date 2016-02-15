/*
{*****************************************************************************
{  宠物商店 v1.0																		
{  模块：用户表; InnoDB free: 10240 kB											
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

package cn.pet.lin.domain.param.sys;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import cn.pet.lin.domain.BaseParam;

import java.util.*;

/**
 * 《用户表》 查询参数实体
 * @author 林伟樘
 *
 */
public class UserParam extends BaseParam<Integer> {
	private static final long serialVersionUID = 1L;
	
	/**
	*字段常量——账号
	*/
	public static final String F_Code="code";
	/**
	*字段常量——用户名
	*/
	public static final String F_UserName="userName";
	/**
	*字段常量——密码
	*/
	public static final String F_Password="password";
	/**
	*字段常量——手机号
	*/
	public static final String F_Phone="phone";
	/**
	*字段常量——创建时间
	*/
	public static final String F_CreateTime="createTime";
	/**
	*字段常量——盐
	*/
	public static final String F_Salt="salt";
	/**
	*字段常量——是否锁定
	*/
	public static final String F_Locked="locked";
	
	private String code; //账号
	private String userName; //用户名
	private String password; //密码
	private String phone; //手机号
	private Long createTime; //创建时间
	private String salt; //盐
	private Integer locked; //是否锁定
    
	/**
	 *默认空构造函数
	 */
	public UserParam() {
		super();
	}
	 
	/**
	 * @return code 账号
	 */
	public String getCode(){
		return this.code;
	}
	/**
	 * @param code 账号
	 */
	public void setCode(String code){
		this.code = code;
	}
	/**
	 * @return userName 用户名
	 */
	public String getUserName(){
		return this.userName;
	}
	/**
	 * @param userName 用户名
	 */
	public void setUserName(String userName){
		this.userName = userName;
	}
	/**
	 * @return password 密码
	 */
	public String getPassword(){
		return this.password;
	}
	/**
	 * @param password 密码
	 */
	public void setPassword(String password){
		this.password = password;
	}
	/**
	 * @return phone 手机号
	 */
	public String getPhone(){
		return this.phone;
	}
	/**
	 * @param phone 手机号
	 */
	public void setPhone(String phone){
		this.phone = phone;
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
	 * @return salt 盐
	 */
	public String getSalt(){
		return this.salt;
	}
	/**
	 * @param salt 盐
	 */
	public void setSalt(String salt){
		this.salt = salt;
	}
	/**
	 * @return locked 是否锁定
	 */
	public Integer getLocked(){
		return this.locked;
	}
	/**
	 * @param locked 是否锁定
	 */
	public void setLocked(Integer locked){
		this.locked = locked;
	}
	
	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("id",getId())
			.append("code",getCode())
			.append("userName",getUserName())
			.append("password",getPassword())
			.append("phone",getPhone())
			.append("createTime",getCreateTime())
			.append("salt",getSalt())
			.append("locked",getLocked())
			.toString();
	}
	
}
