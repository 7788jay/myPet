package cn.pet.lin.controller.admin.order;

import cn.pet.lin.domain.BizData4Page;
import cn.pet.lin.domain.order.ItemEx;
import cn.pet.lin.domain.order.OrdersEx;
import cn.pet.lin.domain.param.order.ItemParam;
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
@RequestMapping("/pet/admin/order")
public class OrdersController {
    @Autowired
    IOrdersService ordersService;
    @Autowired
    IItemService itemService;

    /**
     * 分页查询订单
     * @param param
     * @param PageNo
     * @param PageSize
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/queryPage")
    public BizData4Page<OrdersEx> queryPage(OrdersParam param, @RequestParam(defaultValue = "1") int PageNo, @RequestParam(defaultValue = "10")int PageSize) {
        List<OrdersEx> animals = ordersService.queryPageEx(param.toMap(),(PageNo-1)*PageSize,PageSize,param.F_CreateTime, SqlOrderEnum.DESC.getAction());
        int record = ordersService.count(param.toSearchFieldMap());
        return PageUtils.toBizData4Page(animals,PageNo,PageSize,record);
    }

    @ResponseBody
    @RequestMapping(value = "/queryOne")
    public OrdersEx queryOne(String orderCode) {
        //查询订单信息
        OrdersEx ordersEx = ordersService.queryOneEx(orderCode);

        //查询订单项信息
        ItemParam itemParam = new ItemParam();
        itemParam.setOrderCode(orderCode);
        List<ItemEx> itemExs = itemService.queryByOrderCode(orderCode);

        return null;
    }
}
