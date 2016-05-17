package controller.front;

import cn.pet.lin.BizData4Page;
import cn.pet.lin.domain.param.pet.PetParam;
import cn.pet.lin.domain.param.pet.PetParamEx;
import cn.pet.lin.domain.pet.CategoryEx;
import cn.pet.lin.domain.pet.Pet;
import cn.pet.lin.domain.pet.PetEx;
import cn.pet.lin.service.pet.ICategoryService;
import cn.pet.lin.service.pet.IPetService;
import cn.pet.lin.utils.PageUtils;
import cn.pet.lin.utils.enums.SqlOrderEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by lwt on 2016/3/15.
 */
@Controller
@RequestMapping("/pet/front/petList")
public class FrontPetController {
    @Autowired
    IPetService petService;
    @Autowired
    ICategoryService categoryService;

    /**
     * 查询宠物分页
     *
     * @param paramEx
     * @param PageNo
     * @param PageSize
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/queryPetList")
    public BizData4Page<Pet> queryPage(PetParamEx paramEx, @RequestParam(defaultValue = "1") int PageNo, @RequestParam(defaultValue = "12") int PageSize) {
        List<Pet> pets = petService.queryPageEx(paramEx.toMap(), (PageNo - 1) * PageSize, PageSize, paramEx.F_CreateTime, null);
        int record = petService.countEx(paramEx.toMap());
        return PageUtils.toBizData4Page(pets, PageNo, PageSize, record);
    }

    /**
     * 获取分类名及物种名（面包屑）
     *
     * @param code
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/queryOneAndName")
    public CategoryEx queryOneAndName(@RequestParam(defaultValue = "") String code) {
        return categoryService.queryOneAndName(code);
    }

    /**
     * 查询销量高的宠物
     *
     * @param pageNo
     * @param pageSize
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/getHotPets")
    List<PetEx> getHotPets(@RequestParam(defaultValue = "1") int pageNo, @RequestParam(defaultValue = "5") int pageSize) {
        return petService.queryPetOrderSum((pageNo - 1) * pageSize, pageSize);
    }

    /**
     * 根据分类获取宠物
     *
     * @param categoryCode
     * @param num
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/queryByCategory")
    List<Pet> queryByCategory(String categoryCode, @RequestParam(defaultValue = "5") int num) {
        PetParam petParam = new PetParam();
        petParam.setCategoryCode(categoryCode);
        return petService.queryPage(petParam.toSearchFieldMap(), 0, num, petParam.F_CreateTime, SqlOrderEnum.DESC);
    }
}
