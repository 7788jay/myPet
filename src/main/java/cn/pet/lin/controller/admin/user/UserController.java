package cn.pet.lin.controller.admin.user;

import cn.pet.lin.domain.BizData4Page;
import cn.pet.lin.domain.common.ResultDTO;
import cn.pet.lin.domain.param.user.UserParam;
import cn.pet.lin.domain.user.User;
import cn.pet.lin.service.user.IUserService;
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
 * Created by lwt on 2016/2/9.
 */
@Controller
@RequestMapping("/admin/user/user")
public class UserController {
    @Autowired
    IUserService userService;

    /**
     * 查询用户分页
     *
     * @param param
     * @param PageNo
     * @param PageSize
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/queryPage")
    public BizData4Page<User> queryPage(UserParam param, @RequestParam(defaultValue = "1") int PageNo, @RequestParam(defaultValue = "10") int PageSize) {
        List<User> users = userService.queryPage(param.toSearchFieldMap(MatchTypeEnum.ALL_FUZZY), (PageNo - 1) * PageSize, PageSize);
        int record = userService.count(param.toSearchFieldMap());
        return PageUtils.toBizData4Page(users, PageNo, PageSize, record);
    }

    /**
     * 添加用户
     *
     * @param user
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/add")
    public ResultDTO add(User user) {
        user.setCreateTime(System.currentTimeMillis());
        user.setLocked(0);
        int count = userService.insert(user);
        if (count != 1) {
            return new ResultDTO(false, ERRORMSG.ADD_ERROR.getMessage());
        }
        return new ResultDTO(true, SUCCESSMSG.ADD_COMPLETE.getMessage());
    }

    /**
     * 单个获取用户信息
     *
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/queryOne")
    public User queryOne(int id) {
        return userService.fetch(id);
    }

    /**
     * 更新用户信息
     *
     * @param user
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/update")
    public ResultDTO update(User user) {
        User queryUser = userService.fetch(user.getId());
        queryUser.setCode(user.getCode());
        queryUser.setUserName(user.getUserName());
        queryUser.setPassword(user.getPassword());
        queryUser.setPhone(user.getPhone());

        userService.update(queryUser);
        return new ResultDTO(true,"更新成功！");
    }

    /**
     * 单个删除
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/delete")
    public ResultDTO delete(Integer id) {
        userService.delete(id);
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
        userService.deleteByIds(Arrays.asList(ids));
        return new ResultDTO(true,"删除成功！");
    }
}
