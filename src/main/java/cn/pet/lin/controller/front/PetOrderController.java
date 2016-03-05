package cn.pet.lin.controller.front;

import cn.pet.lin.domain.order.Cart;
import cn.pet.lin.domain.pet.Pet;
import cn.pet.lin.service.pet.IPetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by lwt on 2016/3/2.
 */
@Controller
@RequestMapping("/pet/front/order")
public class PetOrderController {
    @Autowired
    IPetService petService;

    @ResponseBody
    @RequestMapping(value = "/createOrder")
    public Pet createOrder(Cart cart){

        return null;
    }
}
