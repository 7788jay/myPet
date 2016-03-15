package cn.pet.lin.controller.front;

import cn.pet.lin.domain.BizData4Page;
import cn.pet.lin.domain.param.pet.PetParam;
import cn.pet.lin.domain.pet.CategoryEx;
import cn.pet.lin.domain.pet.Pet;
import cn.pet.lin.service.pet.ICategoryService;
import cn.pet.lin.service.pet.IPetService;
import cn.pet.lin.utils.PageUtils;
import cn.pet.lin.utils.enums.MatchTypeEnum;
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
     * @param param
     * @param PageNo
     * @param PageSize
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/queryPetList")
    public BizData4Page<Pet> queryPage(PetParam param, @RequestParam(defaultValue = "1") int PageNo, @RequestParam(defaultValue = "12") int PageSize) {
        List<Pet> pets = petService.queryPage(param.toSearchFieldMap(MatchTypeEnum.ALL_FUZZY), (PageNo - 1) * PageSize, PageSize);
        int record = petService.count(param.toSearchFieldMap());
        return PageUtils.toBizData4Page(pets, PageNo, PageSize, record);
    }

    @ResponseBody
    @RequestMapping(value = "/queryOneAndName")
    public CategoryEx queryOneAndName(@RequestParam(defaultValue = "") String code) {
        return categoryService.queryOneAndName(code);
    }
}
