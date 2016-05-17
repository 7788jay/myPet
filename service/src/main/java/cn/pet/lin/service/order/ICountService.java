package cn.pet.lin.service.order;

import cn.pet.lin.domain.order.Count;

import java.util.List;

/**
 * Created by lwt on 2016/4/9.
 */
public interface ICountService {

    /**
     * 根据天数获取最近订单统计
     *
     * @param num 最近天数
     * @return
     */
    List<Count> CountOrderByDays(int num);
}
