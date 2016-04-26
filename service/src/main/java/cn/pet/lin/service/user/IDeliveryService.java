/*
{*****************************************************************************
{  宠物商店 v1.0																		
{  模块：用户收货地址表; InnoDB free: 10240 kB											
{  功能描述:										
{															
{  ---------------------------------------------------------------------------	
{  维护历史:													
{  日期        维护人        维护类型						
{  ---------------------------------------------------------------------------	
{  2016-03-06  林伟樘        新建	
{ 	                                                                     
{*****************************************************************************	
*/

package cn.pet.lin.service.user;

import cn.pet.lin.user.Delivery;
import cn.pet.lin.dao.user.IDeliveryDAO;
import cn.pet.lin.service.IBaseService;

 /**
 * 《用户收货地址表》 业务逻辑服务接口
 * @author 林伟樘
 *
 */
public interface IDeliveryService extends IBaseService<IDeliveryDAO, Delivery>{

}