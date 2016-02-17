package cn.pet.lin.controller.admin.pet;

import cn.pet.lin.domain.BizData4Page;
import cn.pet.lin.domain.common.ResultDTO;
import cn.pet.lin.domain.param.pet.CategoryParam;
import cn.pet.lin.domain.pet.Category;
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
     * @param PageNo
     * @param PageSize
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/queryPage")
    public BizData4Page<Category> queryPage(CategoryParam param, @RequestParam(defaultValue = "1") int PageNo, @RequestParam(defaultValue = "10")int PageSize) {
        List<Category> animals = categoryService.queryPage(param.toSearchFieldMap(MatchTypeEnum.ALL_FUZZY),(PageNo-1)*PageSize,PageSize);
        int record = categoryService.count(param.toSearchFieldMap());
        return PageUtils.toBizData4Page(animals,PageNo,PageSize,record);
    }

    @ResponseBody
    @RequestMapping(value = "/queryAll")
    public List<Category> queryAll(){
        return categoryService.findAll();
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
}