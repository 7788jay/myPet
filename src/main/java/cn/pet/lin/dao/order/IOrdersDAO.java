/*
{*****************************************************************************
{  宠物商店 v1.0																		
{  模块：订单表; InnoDB free: 10240 kB											
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
import cn.pet.lin.domain.order.Orders;
import cn.pet.lin.domain.order.OrdersEx;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 《订单表》 数据访问接口
 *
 * @author 林伟樘
 */
public interface IOrdersDAO extends IBaseDAO<Orders> {


    /**
     * 分页拓展
     *
     * @param condition
     * @param offset
     * @param rows
     * @return
     */
    List<OrdersEx> queryPageEx(@Param("condition") Map<String, Object> condition, @Param("offset") int offset
            , @Param("rows")int rows,@Param("orderBy")String orderBy, @Param("sortBy")String sortBy);

    /**
     * 单个获取拓展
     * @param orderCode 订单编号
     * @return
     */
    OrdersEx queryOneEx(@Param("orderCode") String orderCode);
}