package cn.pet.lin.controller.admin.count;

import cn.pet.lin.domain.order.Count;
import cn.pet.lin.domain.pet.PetEx;
import cn.pet.lin.service.order.ICountService;
import cn.pet.lin.service.pet.IPetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lwt on 2016/4/7.
 */
@Controller
@RequestMapping("/admin/pet/count")
public class PetCountController {

    @Autowired
    IPetService petService;
    @Autowired
    ICountService countService;

    /**
     * 获取宠物销量
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "queryPetOrder")
    public Map<String, Object> queryPetOrder() {
        Map<String, Object> map = new HashMap<String, Object>();
        List<PetEx> petExs = petService.queryPetOrderSum(0,10);
        List<String> names = new ArrayList<String>();
        List<Integer> sums = new ArrayList<Integer>();
        for (PetEx petEx : petExs) {
            names.add(petEx.getName());
            sums.add(petEx.getOrderSum());
        }
        map.put("names",names);
        map.put("sums",sums);
        return map;
    }

    /**
     * 获取最近天数订单统计
     * @param num
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "CountOrderByDays")
    public Map CountOrderByDays(@RequestParam(defaultValue = "10") int num) {
        List<Count> counts = countService.CountOrderByDays(num);
        Map<String,Object> map = new HashMap<String,Object>();
        List<String> dates = new ArrayList<String>();
        List<Integer> sums = new ArrayList<Integer>();
        for (Count count : counts) {
            dates.add(count.getDate());
            sums.add(count.getOrderSum());
        }
        map.put("dates",dates);
        map.put("sums",sums);
        return map;
    }
}
