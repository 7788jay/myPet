package controller.admin.order;

import cn.pet.lin.BizData4Page;
import cn.pet.lin.common.ResultDTO;
import cn.pet.lin.domain.order.ItemEx;
import cn.pet.lin.domain.order.Orders;
import cn.pet.lin.domain.order.OrdersEx;
import cn.pet.lin.domain.param.order.OrdersParam;
import cn.pet.lin.service.order.IItemService;
import cn.pet.lin.service.order.IOrdersService;
import cn.pet.lin.utils.PageUtils;
import cn.pet.lin.utils.enums.SqlOrderEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by lin on 2016/3/9.
 */
@Controller
@RequestMapping("/admin/pet/order")
public class OrdersController {
    @Autowired
    IOrdersService ordersService;
    @Autowired
    IItemService itemService;

    /**
     * 分页查询订单
     * @param param
     * @param pageNo
     * @param PageSize
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/queryPage")
    public BizData4Page<OrdersEx> queryPage(OrdersParam param, @RequestParam(defaultValue = "1") int pageNo, @RequestParam(defaultValue = "10")int PageSize) {
        List<OrdersEx> orders = ordersService.queryPageEx(param.toMap(),(pageNo-1)*PageSize,PageSize,param.F_CreateTime, SqlOrderEnum.DESC.getAction());
        int record = ordersService.count(param.toSearchFieldMap());
        return PageUtils.toBizData4Page(orders,pageNo,PageSize,record);
    }

    /**
     * 查询订单详情
     * @param orderCode
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/queryOne")
    public OrdersEx queryOne(String orderCode) {
        //查询订单信息
        OrdersEx ordersEx = ordersService.queryOneEx(orderCode);

        //查询订单项信息
        List<ItemEx> itemExs = itemService.queryByOrderCode(orderCode);
        //封装订单项信息到订单中
        ordersEx.setItemExs(itemExs);
        return ordersEx;
    }

    /**
     * 修改状态
     * @param type      类型
     * @param orderCode 订单code
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/update")
    public ResultDTO update(int type,String orderCode){
        Orders orders = ordersService.findOne(OrdersParam.F_Code,orderCode);
        String msg = "修改成功！";
        orders.setStatus(type);
        switch (type){
            //通过审核
            case 1:{
                msg = "审核成功！";
            };break;
            //确认发货
            case 2:{
                orders.setSendTime(System.currentTimeMillis());
                msg = "已成功发货！";
            };break;
            //确认完成
            case 3:{
                orders.setCompleteTime(System.currentTimeMillis());
                msg = "已确认完成整个交易流程！";
            };break;
            //取消
            case 4:{
                msg = "已取消！";
            };break;
        }
        ordersService.update(orders);
        return new ResultDTO(true,msg);
    }
}
