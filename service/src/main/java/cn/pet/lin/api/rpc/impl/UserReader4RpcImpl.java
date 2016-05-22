package cn.pet.lin.api.rpc.impl;

import cn.pet.lin.api.rpc.IUserReader4Rpc;
import cn.pet.lin.domain.param.user.UserParam;
import cn.pet.lin.domain.user.User;
import cn.pet.lin.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by lwt on 2016/5/21.
 */
public class UserReader4RpcImpl implements IUserReader4Rpc {
    @Autowired
    IUserService userService;


    @Override
    public User getUserByCode(String code) {
        return userService.findOne(UserParam.F_Code,code);
    }
}
