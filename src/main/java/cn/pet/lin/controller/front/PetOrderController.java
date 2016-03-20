package cn.pet.lin.controller.front;

import cn.pet.lin.domain.BizData4Page;
import cn.pet.lin.domain.common.ResultDTO;
import cn.pet.lin.domain.order.*;
import cn.pet.lin.domain.param.order.OrdersParam;
import cn.pet.lin.domain.user.User;
import cn.pet.lin.service.order.IItemService;
import cn.pet.lin.service.order.IOrdersService;
import cn.pet.lin.service.pet.IPetService;
import cn.pet.lin.utils.CommonUtils;
import cn.pet.lin.utils.PageUtils;
import cn.pet.lin.utils.enums.OrderStatusEnum;
import cn.pet.lin.utils.enums.SqlOrderEnum;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * Created by lwt on 2016/3/2.
 */
@Controller
@RequestMapping("/pet/front/order")
public class PetOrderController {
    @Autowired
    IPetService petService;
    @Autowired
    IOrdersService ordersService;
    @Autowired
    IItemService itemService;

    /**
     * 创建订单
     * @param orders
     * @param session
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/createOrder")
    public ResultDTO createOrder(Orders orders, HttpSession session) {
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        Cart cart = (Cart) session.getAttribute("cart");
        Map<String, CartItem> cartItemMap = cart.getCartItems();
        if (cartItemMap.size() <= 0) {
            return new ResultDTO(false, "购物车为空！");
        }
        //订单
        orders.setCode(CommonUtils.makeUUID());
        orders.setUserCode(user.getCode());
        orders.setCreateTime(System.currentTimeMillis());
        orders.setTotalPrice(cart.getTotalPrice());
        orders.setStatus(OrderStatusEnum.NO_CHECKED.getStatus());
        for (Map.Entry<String, CartItem> entry : cartItemMap.entrySet()) {
            CartItem cartItem = entry.getValue();
            //订单项
            Item item = new Item();
            item.setCode(CommonUtils.makeUUID());
            item.setOrderCode(orders.getCode());
            item.setPetCode(cartItem.getPet().getCode());
            item.setQuantity(cartItem.getQuantity());
            item.setTotalPrice((long) (cartItem.getQuantity() * cartItem.getPet().getPrice()));

            itemService.insert(item);
        }
        ordersService.insert(orders);
        //清空购物车
        session.setAttribute("cart",new Cart());
        return new ResultDTO(true, "订单创建成功！",orders.getCode());
    }

    /**
     * 根据用户来获取订单信息
     * @param param
     * @param PageNo
     * @param PageSize
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/queryByUser")
    public BizData4Page<OrdersEx> queryByUser(OrdersParam param, @RequestParam(defaultValue = "1") int PageNo, @RequestParam(defaultValue = "5")int PageSize) {
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        param.setUserCode(user.getCode());
        List<OrdersEx> orderExs = ordersService.queryPageEx(param.toMap(),(PageNo-1)*PageSize,PageSize,param.F_CreateTime, SqlOrderEnum.DESC.getAction());
        for (OrdersEx orderEx : orderExs) {
            List<ItemEx> itemExList = itemService.queryByOrderCode(orderEx.getCode());
            orderEx.setItemExs(itemExList);
        }
        int record = ordersService.countEx(param.toMap());
        return PageUtils.toBizData4Page(orderExs,PageNo,PageSize,record);
    }

    /**
     * 支付
     * @param orderCode
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/updatePayTime")
    public ResultDTO updatePayTime(String orderCode){
        Orders orders = ordersService.findOne(OrdersParam.F_Code,orderCode);
        orders.setPayTime(System.currentTimeMillis());
        ordersService.update(orders);
        return new ResultDTO(true,"支付成功！");
    }
}
