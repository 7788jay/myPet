package cn.pet.lin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by lin on 2016/1/8.
 */
@Controller
@RequestMapping("/login")
public class test {

    @ResponseBody
    @RequestMapping
    public String login(){
        return "ggggggggggggggggggggg";
    }
}
