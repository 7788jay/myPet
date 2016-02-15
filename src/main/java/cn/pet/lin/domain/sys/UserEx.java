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

package cn.pet.lin.domain.sys;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.util.*;

/**
 * 《用户表》扩展实体
 * @author 林伟樘
 *
 */
public class UserEx extends User {
	private static final long serialVersionUID = 1L;
	
	//针对User实体在这里增加额外的属性和对应的get和set方法
}
