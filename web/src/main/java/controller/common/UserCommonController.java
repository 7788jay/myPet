package controller.common;

import cn.pet.lin.domain.user.User;
import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by lwt on 2016/2/10.
 */
@Controller
@RequestMapping("/common/user")
public class UserCommonController {

    @ResponseBody
    @RequestMapping(value = "/getCurrentUser")
    public User getCurrentUser(){
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        return user;
    }
}
