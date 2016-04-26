package controller.front;

import cn.pet.lin.param.pet.PetParam;
import cn.pet.lin.pet.Pet;
import cn.pet.lin.service.pet.IPetService;
import cn.pet.lin.utils.enums.SqlOrderEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by lwt on 2016/2/29.
 * 前台页面展示
 */
@Controller
@RequestMapping("/pet/front/index")
public class IndexController {
    @Autowired
    IPetService petService;

    /**
     * 根据数量获取最新的宠物
     * @param num 数量
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "getNewPets")
    public List<Pet> getNewPets(@RequestParam(defaultValue = "5") Integer num){
        PetParam petParam = new PetParam();
        return petService.queryPage(petParam.toSearchFieldMap(),0,num, PetParam.F_CreateTime, SqlOrderEnum.DESC);
    }
}
