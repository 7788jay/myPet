package controller;

import cn.pet.lin.common.ResultDTO;
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

    /**
     * 登录验证
     *
     * @param user
     * @return
     */
    @ResponseBody
    @RequestMapping
    public ResultDTO login(User user) {
        //获取主体
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(user.getCode(), user.getPassword());
        try {
            //采用shiro验证框架进行验证登录
            subject.login(token);
        } catch (AuthenticationException e) {
            e.printStackTrace();
            //验证不通过做相应的提示
            if (e.getClass().getName().equals(UnknownAccountException.class.getName())) {
                return new ResultDTO(false, "账号不存在！");
            }
            if (e.getClass().getName().equals(IncorrectCredentialsException.class.getName())) {
                return new ResultDTO(false, "密码错误！");
            }
        }
        String msg = "";
        //获取登陆后的相应用户信息
        user = (User) SecurityUtils.getSubject().getPrincipal();
        if (user.getLocked() == 1) {
            return new ResultDTO(false, "账号已锁定，请联系管理员！");
        }
        if (user.getUserType() == 1) {
            //跳转到管理平台
            msg = "/html/admin/index.html";
        } else {
            //普通用户跳转到销售平台
            msg = "/html/front/index.html";
        }
        return new ResultDTO(true, msg);
    }
}
