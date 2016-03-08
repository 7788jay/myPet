package cn.pet.lin.controller.front;

import cn.pet.lin.domain.common.ResultDTO;
import cn.pet.lin.domain.order.Cart;
import cn.pet.lin.domain.order.CartItem;
import cn.pet.lin.domain.order.Item;
import cn.pet.lin.domain.order.Orders;
import cn.pet.lin.domain.user.User;
import cn.pet.lin.service.order.IItemService;
import cn.pet.lin.service.order.IOrdersService;
import cn.pet.lin.service.pet.IPetService;
import cn.pet.lin.utils.CommonUtils;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
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

    @ResponseBody
    @RequestMapping(value = "/createOrder")
    public ResultDTO createOrder(Orders orders, HttpSession session) {
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        Cart cart = (Cart) session.getAttribute("cart");
        //订单
        orders.setCode(CommonUtils.makeUUID());
        orders.setUserCode(user.getCode());
        orders.setCreateTime(System.currentTimeMillis());
        orders.setTotalPrice(cart.getTotalPrice());
        Map<String, CartItem> cartItemMap = cart.getCartItems();
        if (cartItemMap.size() <= 0) {
            return new ResultDTO(false, "购物车为空！");
        }
        for (Map.Entry<String, CartItem> entry : cartItemMap.entrySet()) {
            CartItem cartItem = entry.getValue();
            //订单项
            Item item = new Item();
            item.setCode(CommonUtils.makeUUID());
            item.setOrderCode(orders.getCode());
            item.setPetCode(cartItem.getPet().getCode());
            item.setQuantity(cartItem.getQuantity());
            item.setTotlalPrice((long) (cartItem.getQuantity() * cartItem.getPet().getPrice()));

            itemService.insert(item);
        }
        ordersService.insert(orders);
        return new ResultDTO(true, "创建成功！");
    }
}
