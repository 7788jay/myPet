package controller.front;

import cn.pet.lin.common.ResultDTO;
import cn.pet.lin.domain.order.Cart;
import cn.pet.lin.domain.param.pet.PetParam;
import cn.pet.lin.domain.pet.Pet;
import cn.pet.lin.service.pet.IPetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    /**
     * 添加宠物到购物车
     *
     * @param code
     * @param num
     * @param session
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/add")
    public ResultDTO add(String code, @RequestParam(defaultValue = "1") int num, HttpSession session) {
        PetParam petParam = new PetParam();
        petParam.setCode(code);
        //查询到对应的宠物
        Pet pet = petService.queryOne(petParam.toMap());
        //从session获取到购物车信息
        Cart cart = (Cart) session.getAttribute("cart");
        cart = cart == null ? new Cart() : cart;
        //添加到购物车
        cart.add(pet,num);
        //保存到session中
        session.setAttribute("cart", cart);
        return new ResultDTO(true, "添加成功！");
    }

    /**
     * 查询购物车
     *
     * @param session
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/queryCart")
    public Cart queryCart(HttpSession session) {
        //从session中获取到之前保存的购物车信息
        Cart cart = (Cart) session.getAttribute("cart");
        return cart == null ? new Cart() : cart;
    }

    @ResponseBody
    @RequestMapping(value = "/changeNum")
    public Cart changeNum(String code, int quantity, HttpSession session) {
        Cart cart = (Cart) session.getAttribute("cart");
        cart.changeNum(code, quantity);
        return cart;
    }

    @ResponseBody
    @RequestMapping(value = "/remove")
    public Cart remove(String code, HttpSession session) {
        Cart cart = (Cart) session.getAttribute("cart");
        cart.remove(code);
        return cart;
    }
}
