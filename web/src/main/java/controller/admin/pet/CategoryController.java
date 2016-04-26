package controller.admin.pet;

import cn.pet.lin.BizData4Page;
import cn.pet.lin.common.ResultDTO;
import cn.pet.lin.param.pet.CategoryParam;
import cn.pet.lin.pet.Category;
import cn.pet.lin.service.pet.ICategoryService;
import cn.pet.lin.utils.CommonUtils;
import cn.pet.lin.utils.PageUtils;
import cn.pet.lin.utils.enums.ERRORMSG;
import cn.pet.lin.utils.enums.MatchTypeEnum;
import cn.pet.lin.utils.enums.SUCCESSMSG;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;

/**
 * Created by lwt on 2016/2/13.
 * 宠物分类
 */
@Controller
@RequestMapping("admin/pet/category")
public class CategoryController {
    @Autowired
    ICategoryService categoryService;

    /**
     * 查询宠物分类分页
     * @param param
     * @param pageNo
     * @param PageSize
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/queryPage")
    public BizData4Page<Category> queryPage(CategoryParam param, @RequestParam(defaultValue = "1") int pageNo, @RequestParam(defaultValue = "10")int PageSize) {
        List<Category> animals = categoryService.queryPage(param.toSearchFieldMap(MatchTypeEnum.ALL_FUZZY),(pageNo-1)*PageSize,PageSize);
        int record = categoryService.count(param.toSearchFieldMap(MatchTypeEnum.ALL_FUZZY));
        return PageUtils.toBizData4Page(animals,pageNo,PageSize,record);
    }

    /**
     * 获取所有宠物分类
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/queryAll")
    public List<Category> queryAll(){
        return categoryService.findAll();
    }

    /**
     * 根据动物获取其分类
     * @param animalCode
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/queryByAnimalCode")
    public List<Category> queryByAnimalCode(String animalCode){
        return categoryService.findList(CategoryParam.F_AnimalCode,animalCode);
    }

    /**
     * 添加物种
     * @param category
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/add")
    public ResultDTO add(Category category){
        try {
            category.setCode(CommonUtils.makeUUID());
            category.setCreateTime(System.currentTimeMillis());
            categoryService.insert(category);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultDTO(false, ERRORMSG.ADD_ERROR.getMessage());
        }
        return new ResultDTO(true, SUCCESSMSG.ADD_COMPLETE.getMessage());
    }

    /**
     * 单个获取宠物分类信息
     *
     * @param code
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/queryOne")
    public Category queryOne(String code) {
        return categoryService.findOne(CategoryParam.F_Code,code);
    }

    /**
     * 更新宠物分类信息
     *
     * @param category
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/update")
    public ResultDTO update(Category category) {
        Category queryCategory = categoryService.findOne(CategoryParam.F_Code,category.getCode());
        queryCategory.setName(category.getName());
        queryCategory.setDescription(category.getDescription());
        queryCategory.setAnimalCode(category.getAnimalCode());

        categoryService.update(queryCategory);
        return new ResultDTO(true,"更新成功！");
    }
    /**
     * 单个删除
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/deleteOne")
    public ResultDTO deleteOne(Integer id) {
        categoryService.delete(id);
        return new ResultDTO(true,"删除成功！");
    }

    /**
     * 批量删除
     * @param ids
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/deleteByIds")
    public ResultDTO deleteByIds(Integer[] ids) {
        categoryService.deleteByIds(Arrays.asList(ids));
        return new ResultDTO(true,"删除成功！");
    }
}
