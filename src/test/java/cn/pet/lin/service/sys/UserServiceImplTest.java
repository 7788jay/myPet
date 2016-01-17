package cn.pet.lin.service.sys;

import cn.pet.lin.domain.param.sys.UserParam;
import cn.pet.lin.domain.sys.User;
import cn.pet.lin.utils.SqlOrderEnum;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by lwt on 2016/1/17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-service.xml"})
public class UserServiceImplTest extends UserServiceImpl {

    @Test
    public void testInsert(){
        User user = new User();
        user.setCode("111");
        user.setUsername("1111");
        user.setPassword("55555");
        user.setPhone("55555");
        user.setLocked(1);
        super.insert(user);
    }
    @Test
    public void testQuery(){

        List<User> users =super.queryList(new UserParam().toMap(),"id", SqlOrderEnum.ASC.getAction());
        for (User user :users){
            System.out.println(user.toString());
        }
    }

}