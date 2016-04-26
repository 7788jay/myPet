package controller.front;

import cn.pet.lin.param.pet.PetParam;
import cn.pet.lin.pet.Pet;
import cn.pet.lin.service.pet.IPetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by lwt on 2016/3/2.
 */
@Controller
@RequestMapping("/pet/front/item")
public class PetItemController {
    @Autowired
    IPetService petService;

    @ResponseBody
    @RequestMapping(value = "/queryOne")
    public Pet queryOne(String code){
        PetParam petParam = new PetParam();
        petParam.setCode(code);
        return petService.queryOne(petParam.toMap());
    }
}
