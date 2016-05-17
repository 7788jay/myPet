package controller.admin.pet;

import cn.pet.lin.BizData4Page;
import cn.pet.lin.common.ResultDTO;
import cn.pet.lin.domain.param.pet.CategoryParam;
import cn.pet.lin.domain.param.pet.PetParam;
import cn.pet.lin.domain.pet.Category;
import cn.pet.lin.domain.pet.Pet;
import cn.pet.lin.domain.pet.PetEx;
import cn.pet.lin.service.pet.ICategoryService;
import cn.pet.lin.service.pet.IPetService;
import cn.pet.lin.utils.CommonUtils;
import cn.pet.lin.utils.PageUtils;
import cn.pet.lin.utils.enums.ERRORMSG;
import cn.pet.lin.utils.enums.MatchTypeEnum;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;

/**
 * Created by lwt on 2016/2/10.
 */
@Controller
@RequestMapping("/admin/pet/pet")
public class PetController {
    @Autowired
    IPetService petService;
    @Autowired
    ICategoryService categoryService;

    /**
     * 查询宠物分页
     *
     * @param param
     * @param pageNo
     * @param PageSize
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/queryPage")
    public BizData4Page<Pet> queryPage(PetParam param, @RequestParam(defaultValue = "1") int pageNo, @RequestParam(defaultValue = "10") int PageSize) {
        List<Pet> pets = petService.queryPage(param.toSearchFieldMap(MatchTypeEnum.ALL_FUZZY), (pageNo - 1) * PageSize, PageSize);
        int record = petService.count(param.toSearchFieldMap(MatchTypeEnum.ALL_FUZZY));
        return PageUtils.toBizData4Page(pets, pageNo, PageSize, record);
    }

    @ResponseBody
    @RequestMapping(value = "/queryAll")
    public List<Pet> queryAll() {
        return petService.findAll();
    }

    /**
     * 添加宠物
     *
     * @param pet
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/add")
    public ResultDTO add(Pet pet) {
        try {
            pet.setCode(CommonUtils.makeUUID());
            pet.setCreateTime(System.currentTimeMillis());
            pet.setStatus(0);
            petService.insert(pet);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultDTO(false, ERRORMSG.ADD_ERROR.getMessage());
        }
        return new ResultDTO(true, "保存成功，请修改状态为上架！");
    }

    /**
     * 单个获取宠物信息
     *
     * @param code
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/queryOne")
    public PetEx queryOne(String code) {
        //查找宠物
        Pet pet = (Pet) petService.findOne(PetParam.F_Code, code);
        PetEx petEx = new PetEx();
        BeanUtils.copyProperties(pet, petEx);
        //查询分类获取物种信息
        Category category = categoryService.findOne(CategoryParam.F_Code, pet.getCategoryCode());
        petEx.setAnimalCode(category.getAnimalCode());
        return petEx;
    }

    /**
     * 更新宠物分类信息
     *
     * @param pet
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/update")
    public ResultDTO update(Pet pet) {
        Pet queryPet = petService.findOne(PetParam.F_Code, pet.getCode());
        queryPet.setName(pet.getName());
        queryPet.setCategoryCode(pet.getCategoryCode());
        queryPet.setSex(pet.getSex());
        queryPet.setWeight(pet.getWeight());
        queryPet.setAge(pet.getAge());
        queryPet.setPrice(pet.getPrice());
        queryPet.setQuantity(pet.getQuantity());
        queryPet.setImage(pet.getImage());
        queryPet.setDescription(pet.getDescription());

        petService.update(queryPet);
        return new ResultDTO(true, "更新成功！");
    }

    /**
     * 单个删除
     *
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/deleteOne")
    public ResultDTO deleteOne(Integer id) {
        petService.delete(id);
        return new ResultDTO(true, "删除成功！");
    }

    /**
     * 批量删除
     *
     * @param ids
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/deleteByIds")
    public ResultDTO deleteByIds(Integer[] ids) {
        petService.deleteByIds(Arrays.asList(ids));
        return new ResultDTO(true, "删除成功！");
    }

    /**
     * 状态更新
     *
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/updateStatus")
    public ResultDTO updateStatus(Integer id) {
        Pet pet = petService.fetch(id);
        pet.setStatus(pet.getStatus() == 1 ? 0 : 1);
        petService.update(pet);
        return new ResultDTO(true, "更新成功！");
    }
}
