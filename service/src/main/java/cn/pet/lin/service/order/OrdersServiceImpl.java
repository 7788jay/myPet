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

package cn.pet.lin.service.order;

import cn.pet.lin.dao.order.IOrdersDAO;
import cn.pet.lin.domain.order.Orders;
import cn.pet.lin.domain.order.OrdersEx;
import cn.pet.lin.service.AbstractBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

 /**
 * 《订单表》 业务逻辑服务类
 * @author 林伟樘
 *
 */
@Service("OrdersServiceImpl")
public class OrdersServiceImpl extends AbstractBaseService<IOrdersDAO,Orders> implements IOrdersService{
    @Autowired
    private IOrdersDAO ordersDAO;

    @Override
    public IOrdersDAO getDao() {
        return ordersDAO;
    }

     @Override
     public List<OrdersEx> queryPageEx(Map<String, Object> condition, int offset, int rows,String orderBy, String sortBy) {
         return ordersDAO.queryPageEx(condition,offset,rows,orderBy,sortBy);
     }

     @Override
     public OrdersEx queryOneEx(String orderCode) {
         return ordersDAO.queryOneEx(orderCode);
     }

     @Override
     public int countEx(Map<String, Object> condition) {
         return ordersDAO.countEx(condition);
     }

//    @Override
//    public void insert(BaseDomain entity) {
//
//    }
//
//    @Override
//    public void update(BaseDomain entity) {
//
//    }
//
//    @Override
//    public void deleteById(Long id) {
//
//    }
//
//    @Override
//    public void deleteByProperty(String property, Object value) {
//
//    }
//
//    @Override
//    public BaseDomain fetch(Long id) {
//        return null;
//    }
//
//    @Override
//    public BaseDomain findOne(@Param("property") String property, @Param("value") Object value) {
//        return null;
//    }
//
//    @Override
//    public List findList(String property, Object value) {
//        return null;
//    }
//
//    @Override
//    public void deleteByCondition(Map condition) {
//
//    }
//
//    @Override
//    public void updateMap(@Param("map") Map entityMap) {
//
//    }
//
//    @Override
//    public List<Orders> findAll() {
//        return ordersDAO.findAll();
//    }
//
//    @Override
//    public List like(String property, Object value) {
//        return null;
//    }
//
//    @Override
//    public Long selectMaxId() {
//        return null;
//    }
//
//    @Override
//    public BaseDomain updateOrSave(BaseDomain baseDomain, Long id) {
//        return null;
//    }
//
//    @Override
//    public BaseDomain selectOne(String mapperId, Object obj) {
//        return null;
//    }
//
//    @Override
//    public List selectList(String mapperId, Object obj) {
//        return null;
//    }
//
//    @Override
//    public Class getEntityClass() {
//        return null;
//    }
//
//    @Override
//    public int count(Map condition) {
//        return 0;
//    }
//
//    @Override
//    public BaseDomain queryOne(Map condition) {
//        return null;
//    }
//
//    @Override
//    public List queryList(@Param("condition") Map condition, @Param("orderBy") String orderBy, @Param("sortBy") String sortBy) {
//        return null;
//    }
//
//    @Override
//    public List queryPage(@Param("condition") Map condition, @Param("offset") int offset, @Param("rows") int rows) {
//        return null;
//    }
//
//    @Override
//    protected OrdersDAO getDao() {
//        return ordersDAO;
//    }


}