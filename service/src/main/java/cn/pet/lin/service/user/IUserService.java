/*
{*****************************************************************************
{  宠物商店 v1.0																		
{  模块：用户表											
{  功能描述:										
{															
{  ---------------------------------------------------------------------------	
{  维护历史:													
{  日期        维护人        维护类型						
{  ---------------------------------------------------------------------------	
{  2016-03-12  林伟樘        新建	
{ 	                                                                     
{*****************************************************************************	
*/

package cn.pet.lin.service.user;

import cn.pet.lin.domain.user.User;
import cn.pet.lin.dao.user.IUserDAO;
import cn.pet.lin.service.IBaseService;

 /**
 * 《用户表》 业务逻辑服务接口
 * @author 林伟樘
 *
 */
public interface IUserService extends IBaseService<IUserDAO, User>{

}