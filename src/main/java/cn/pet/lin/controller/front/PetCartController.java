package cn.pet.lin.controller.front;

import cn.pet.lin.domain.common.ResultDTO;
import cn.pet.lin.domain.param.pet.PetParam;
import cn.pet.lin.domain.pet.Pet;
import cn.pet.lin.service.pet.IPetService;
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
@RequestMapping("/pet/front/cart")
public class PetCartController {

    @Autowired
    IPetService petService;

    @ResponseBody
    @RequestMapping(value = "/add")
    public ResultDTO add(String code, HttpSession session){
        PetParam petParam = new PetParam();
        petParam.setCode(code);
        Pet pet = petService.queryOne(petParam.toMap());
        Map<Pet,Integer> carts = (Map<Pet, Integer>) session.getAttribute("carts");
//        if(carts == null){
//            carts = new HashMap<Pet,Integer>();
//        }
        int count = carts.get(pet);
        carts.put(pet,count+1);
        session.setAttribute("cart",carts);
        return new ResultDTO(true,"添加成功！");
    }
}
