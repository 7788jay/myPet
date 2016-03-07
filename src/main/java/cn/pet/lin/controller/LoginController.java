package cn.pet.lin.controller;

import cn.pet.lin.domain.common.ResultDTO;
import cn.pet.lin.domain.user.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by lin on 2016/1/8.
 * 登录
 */
@Controller
@RequestMapping("/admin/login")
public class LoginController {

    @ResponseBody
    @RequestMapping
    public ResultDTO login(User user){
        //获取主体
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(user.getCode(),user.getPassword());
        try {
            //登录
            subject.login(token);
        } catch (AuthenticationException e) {
            e.printStackTrace();
            if(e.getClass().getName().equals(UnknownAccountException.class.getName())){
                return new ResultDTO(false,"账号不存在！");
            }
            if(e.getClass().getName().equals(IncorrectCredentialsException.class.getName())){
                return new ResultDTO(false,"密码错误！");
            }
        }
        return new ResultDTO(true,"");
    }
}
