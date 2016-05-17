/*
{*****************************************************************************
{  宠物商店 v1.0																		
{  模块：订单项; InnoDB free: 10240 kB											
{  功能描述:										
{															
{  ---------------------------------------------------------------------------	
{  维护历史:													
{  日期        维护人        维护类型						
{  ---------------------------------------------------------------------------	
{  2016-03-07  林伟樘        新建	
{ 	                                                                     
{*****************************************************************************	
*/

package cn.pet.lin.service.order;

import cn.pet.lin.dao.order.IItemDAO;
import cn.pet.lin.domain.order.Item;
import cn.pet.lin.domain.order.ItemEx;
import cn.pet.lin.service.IBaseService;

import java.util.List;

/**
 * 《订单项》 业务逻辑服务接口
 *
 * @author 林伟樘
 */
public interface IItemService extends IBaseService<IItemDAO, Item> {

    List<ItemEx> queryByOrderCode(String orderCode);
}