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
{  2016-01-17  林伟樘        新建	
{ 	                                                                     
{*****************************************************************************	
*/

package cn.pet.lin.service.sys;

import cn.pet.lin.domain.BaseDomain;
import cn.pet.lin.dao.IBaseDAO;
import cn.pet.lin.service.IBaseService;
import cn.pet.lin.service.IPageService;

 /**
 * 《用户表; InnoDB free: 10240 kB》 业务逻辑服务接口
 * @author 林伟樘
 *
 */
public interface IUserService<D extends IBaseDAO<T>, T extends BaseDomain> extends IBaseService<D, T>,IPageService<D, T>{

}