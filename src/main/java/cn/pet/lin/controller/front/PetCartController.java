package cn.pet.lin.controller.front;

import cn.pet.lin.domain.common.ResultDTO;
import cn.pet.lin.domain.order.Cart;
import cn.pet.lin.domain.param.pet.PetParam;
import cn.pet.lin.domain.pet.Pet;
import cn.pet.lin.service.pet.IPetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * Created by lwt on 2016/3/2.
 */
@Controller
@RequestMapping("/pet/front/cart")
public class PetCartController {

    @Autowired
    IPetService petService;

    @ResponseBody
    @RequestMapping(value = "/add")
    public ResultDTO add(String code, HttpSession session) {
        PetParam petParam = new PetParam();
        petParam.setCode(code);
        Pet pet = petService.queryOne(petParam.toMap());
        Cart cart = (Cart) session.getAttribute("cart");
//        if(carts == null){
//            carts = new HashMap<Pet,Integer>();
//        }
        cart = cart == null ? new Cart() : cart;
        cart.add(pet);
        session.setAttribute("cart", cart);
        return new ResultDTO(true, "添加成功！");
    }

    @ResponseBody
    @RequestMapping(value = "/queryCart")
    public Cart queryCart(HttpSession session) {
        Cart cart = (Cart) session.getAttribute("cart");
        return cart == null ? new Cart() : cart;
    }

    @ResponseBody
    @RequestMapping(value = "/changeNum")
    public Cart changeNum(String code, int quantity, HttpSession session) {
        Cart cart = (Cart) session.getAttribute("cart");
        cart.changeNum(code,quantity);
        return cart;
    }
    @ResponseBody
    @RequestMapping(value = "/remove")
    public Cart remove(String code,HttpSession session) {
        Cart cart = (Cart) session.getAttribute("cart");
        cart.remove(code);
        return cart;
    }
}
