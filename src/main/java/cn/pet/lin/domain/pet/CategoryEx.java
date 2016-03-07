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

import java.util.*;

/**
 * 《宠物分类》扩展实体
 * @author 林伟樘
 *
 */
public class CategoryEx extends Category {
	private static final long serialVersionUID = 1L;
	
	//针对Category实体在这里增加额外的属性和对应的get和set方法
}
