package cn.pet.lin.controller.front;

import cn.pet.lin.domain.common.ResultDTO;
import cn.pet.lin.domain.param.user.DeliveryParam;
import cn.pet.lin.domain.user.Delivery;
import cn.pet.lin.domain.user.User;
import cn.pet.lin.service.user.IDeliveryService;
import cn.pet.lin.service.user.IUserService;
import cn.pet.lin.utils.CommonUtils;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by lwt on 2016/3/6.
 * 前台用户
 */
@Controller
@RequestMapping("/pet/front/user")
public class FrontUserController {
    @Autowired
    IDeliveryService deliveryService;
    @Autowired
    IUserService userService;

    @ResponseBody
    @RequestMapping(value = "addAddress")
    public ResultDTO addAddress(Delivery delivery) {
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        delivery.setUserCode(user.getCode());
        delivery.setCode(CommonUtils.makeUUID());
        deliveryService.insert(delivery);
        return new ResultDTO(true, "添加成功！");
    }

    @ResponseBody
    @RequestMapping(value = "queryAllAddress")
    public List<Delivery> queryAllAddress() {
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        DeliveryParam deliveryParam = new DeliveryParam();
        deliveryParam.setUserCode(user.getCode());
        return deliveryService.queryList(deliveryParam.toMap(),null,null);
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
        User currentUser = (User) SecurityUtils.getSubject().getPrincipal();
        User queryUser = userService.fetch(currentUser.getId());
        queryUser.setUserName(user.getUserName());
        queryUser.setPassword(user.getPassword());
        queryUser.setPhone(user.getPhone());
        userService.update(queryUser);
        return new ResultDTO(true,"更新成功！");
    }
}
