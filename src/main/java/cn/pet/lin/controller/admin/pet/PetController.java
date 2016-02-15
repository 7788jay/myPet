package cn.pet.lin.controller.admin.pet;

import cn.pet.lin.domain.BizData4Page;
import cn.pet.lin.domain.common.ResultDTO;
import cn.pet.lin.domain.param.pet.PetParam;
import cn.pet.lin.domain.pet.Pet;
import cn.pet.lin.service.pet.IPetService;
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
 * Created by lwt on 2016/2/10.
 */
@Controller
@RequestMapping("/admin/pet/pet")
public class PetController {
    @Autowired
    IPetService petService;

    /**
     * 查询物种分页
     * @param param
     * @param PageNo
     * @param PageSize
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/queryPage")
    public BizData4Page<Pet> queryPage(PetParam param, @RequestParam(defaultValue = "1") int PageNo, @RequestParam(defaultValue = "10")int PageSize) {
        List<Pet> pets = petService.queryPage(param.toSearchFieldMap(MatchTypeEnum.ALL_FUZZY),(PageNo-1)*PageSize,PageSize);
        int record = petService.count(param.toSearchFieldMap());
        return PageUtils.toBizData4Page(pets,PageNo,PageSize,record);
    }

    @ResponseBody
    @RequestMapping(value = "/queryAll")
    public List<Pet> queryAll(){
        return petService.findAll();
    }

    /**
     * 添加物种
     * @param pet
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/add")
    public ResultDTO add(Pet pet){
        try {
            pet.setCode(CommonUtils.makeUUID());
            pet.setCreateTime(System.currentTimeMillis());
            petService.insert(pet);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultDTO(false, ERRORMSG.ADD_ERROR.getMessage());
        }
        return new ResultDTO(true, SUCCESSMSG.ADD_COMPLETE.getMessage());
    }
}
