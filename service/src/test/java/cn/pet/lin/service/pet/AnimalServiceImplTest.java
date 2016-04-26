package cn.pet.lin.service.pet;

import cn.pet.lin.pet.AnimalEx;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by lin on 2016/3/15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-service.xml"})
public class AnimalServiceImplTest extends AnimalServiceImpl {

    @Test
    public void testGetAnimalAndCategory() throws Exception {
        List<AnimalEx> animalExList = this.getAnimalAndCategory();
        for (AnimalEx animalEx : animalExList) {
            System.out.println(animalEx.getCode());
        }

    }
}