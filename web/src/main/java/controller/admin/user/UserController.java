package controller.admin.user;

import cn.pet.lin.BizData4Page;
import cn.pet.lin.common.ResultDTO;
import cn.pet.lin.param.user.UserParam;
import cn.pet.lin.user.User;
import cn.pet.lin.service.user.IUserService;
import cn.pet.lin.utils.PageUtils;
import cn.pet.lin.utils.enums.ERRORMSG;
import cn.pet.lin.utils.enums.MatchTypeEnum;
import cn.pet.lin.utils.enums.SUCCESSMSG;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    IUserService userService;

    /**
     * 查询用户分页
     *
     * @param param
     * @param pageNo
     * @param PageSize
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/queryPage")
    public BizData4Page<User> queryPage(UserParam param, @RequestParam(defaultValue = "1") int pageNo, @RequestParam(defaultValue = "10") int PageSize) {
        logger.error("This is Error message", new Exception("Testing"));
        List<User> users = userService.queryPage(param.toSearchFieldMap(MatchTypeEnum.ALL_FUZZY), (pageNo - 1) * PageSize, PageSize);
        int record = userService.count(param.toSearchFieldMap(MatchTypeEnum.ALL_FUZZY));
        return PageUtils.toBizData4Page(users, pageNo, PageSize, record);
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
        //创建之前查看是否重名
        User queryUser = userService.findOne(UserParam.F_Code, user.getCode());
        if (queryUser != null) {
            return new ResultDTO(false, "账号重复请重试");
        }
        user.setCreateTime(System.currentTimeMillis());
        //设置状态
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
        //根据id获取用户信息
        User queryUser = userService.fetch(user.getId());
        //设置要修改的用户信息
        queryUser.setCode(user.getCode());
        queryUser.setUserName(user.getUserName());
        queryUser.setPassword(user.getPassword());
        queryUser.setPhone(user.getPhone());
        queryUser.setUserType(user.getUserType());
        //更新用户信息
        userService.update(queryUser);
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
        userService.delete(id);
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
        userService.deleteByIds(Arrays.asList(ids));
        return new ResultDTO(true, "删除成功！");
    }
    /**
     * 锁定或解锁
     *
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/lock")
    public ResultDTO lock(Integer id) {
        //根据id获取用户信息
        User queryUser = userService.fetch(id);
        int lock = queryUser.getLocked() == 0 ? 1 : 0;
        queryUser.setLocked(lock);
        userService.update(queryUser);
        return new ResultDTO(true, "修改成功！");
    }

    /**
     * 注册用户
     *
     * @param user
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/register")
    public ResultDTO register(User user) {
        user.setUserType(0);
        return this.add(user);
    }
}
