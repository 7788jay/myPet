package cn.pet.lin.controller.admin.order;

import cn.pet.lin.domain.BizData4Page;
import cn.pet.lin.domain.order.Orders;
import cn.pet.lin.domain.order.OrdersEx;
import cn.pet.lin.domain.param.order.OrdersParam;
import cn.pet.lin.service.order.IOrdersService;
import cn.pet.lin.utils.PageUtils;
import cn.pet.lin.utils.enums.MatchTypeEnum;
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

    /**
     * 分页查询订单
     * @param param
     * @param PageNo
     * @param PageSize
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/queryPage")
    public BizData4Page<Orders> queryPage(OrdersParam param, @RequestParam(defaultValue = "1") int PageNo, @RequestParam(defaultValue = "10")int PageSize) {
        List<Orders> animals = ordersService.queryPage(param.toSearchFieldMap(MatchTypeEnum.ALL_FUZZY),(PageNo-1)*PageSize,PageSize);
        int record = ordersService.count(param.toSearchFieldMap());
        return PageUtils.toBizData4Page(animals,PageNo,PageSize,record);
    }

    @ResponseBody
    @RequestMapping(value = "/queryOne")
    public OrdersEx queryOne(String orderCode) {
        //查询订单信息
        Orders orders = ordersService.findOne(OrdersParam.F_Code,orderCode);

        //查询订单项信息


        //查询用户信息
        return null;
    }
}
