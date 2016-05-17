package controller.front;

import cn.pet.lin.common.ResultDTO;
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

    /**
     * 添加收货地址
     * @param delivery
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "addAddress")
    public ResultDTO addAddress(Delivery delivery) {
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        delivery.setUserCode(user.getCode());
        delivery.setCode(CommonUtils.makeUUID());
        deliveryService.insert(delivery);
        return new ResultDTO(true, "添加成功！");
    }

    /**
     * 添加收货地址
     * @param delivery
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "updateAddress")
    public ResultDTO updateAddress(Delivery delivery) {
        Delivery queryDelivery = deliveryService.fetch(delivery.getId());
        queryDelivery.setName(delivery.getName());
        queryDelivery.setProvince(delivery.getProvince());
        queryDelivery.setCity(delivery.getCity());
        queryDelivery.setArea(delivery.getArea());
        queryDelivery.setDetail(delivery.getDetail());
        queryDelivery.setPostCode(delivery.getPostCode());
        queryDelivery.setPhone(delivery.getPhone());
        return new ResultDTO(true, "修改成功！");
    }

    /**
     * 查询全部地址
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "queryAllAddress")
    public List<Delivery> queryAllAddress() {
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        DeliveryParam deliveryParam = new DeliveryParam();
        deliveryParam.setUserCode(user.getCode());
        return deliveryService.queryList(deliveryParam.toMap(),null,null);
    }

    /**
     * 查询地址
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "queryOneAddress")
    public Delivery queryOneAddress(int id) {
        return deliveryService.fetch(id);
    }

    /**
     * 删除地址
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "deleteAddress")
    public ResultDTO deleteAddress(int id) {
        deliveryService.delete(id);
        return new ResultDTO(true, "删除成功！");
    }
    /**
     * 更新用户信息
     *
     * @param user
     * @param originPassword 原密码
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/update")
    public ResultDTO update(User user,String originPassword) {
        User currentUser = (User) SecurityUtils.getSubject().getPrincipal();
        if(!originPassword.equals(currentUser.getPassword())){
            return new ResultDTO(false,"原密码错误，请重试！");
        }
        User queryUser = userService.fetch(currentUser.getId());
        queryUser.setUserName(user.getUserName());
        queryUser.setPassword(user.getPassword());
        queryUser.setPhone(user.getPhone());
        userService.update(queryUser);
        return new ResultDTO(true,"更新成功！");
    }
}
