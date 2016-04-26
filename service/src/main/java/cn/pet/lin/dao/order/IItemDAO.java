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

package cn.pet.lin.dao.order;

import cn.pet.lin.dao.IBaseDAO;
import cn.pet.lin.order.Item;
import cn.pet.lin.order.ItemEx;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 《订单项》 数据访问接口
 *
 * @author 林伟樘
 */
public interface IItemDAO extends IBaseDAO<Item> {

    /**
     * 根据orderCode获取订单项
     *
     * @param orderCode 订单编号
     * @return
     */
    List<ItemEx> queryByOrderCode(@Param("orderCode") String orderCode);
}