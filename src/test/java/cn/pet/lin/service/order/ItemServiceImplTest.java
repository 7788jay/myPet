package cn.pet.lin.service.order;

import cn.pet.lin.domain.order.ItemEx;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by lin on 2016/3/10.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-service.xml"})
public class ItemServiceImplTest extends ItemServiceImpl {

    @Test
    public void testQueryByOrderCode() throws Exception {
        List<ItemEx> itemExs = this.queryByOrderCode("3110c87b821d45b9bb6860a48aa5181e");
        for (ItemEx itemEx : itemExs) {
            System.out.println(itemEx.getTotlalPrice());
        }
    }
}