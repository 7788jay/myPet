package cn.pet.lin.service.order;

import cn.pet.lin.order.OrdersEx;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by lwt on 2016/3/12.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-service.xml"})
public class OrdersServiceImplTest extends OrdersServiceImpl {

    @Test
    public void testQueryOneEx() throws Exception {
        OrdersEx ordersEx = this.queryOneEx("528ba6a50a2f4f339a999038afd116ad");
        System.out.println(ordersEx.getDelivery().getCity());
    }
}