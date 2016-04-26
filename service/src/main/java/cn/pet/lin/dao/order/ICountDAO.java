package cn.pet.lin.dao.order;

import cn.pet.lin.order.Count;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by lwt on 2016/4/9.
 */
public interface ICountDAO {

    /**
     * 根据天数获取最近订单统计
     *
     * @param num 最近天数
     * @return
     */
    List<Count> CountOrderByDays(@Param("num") int num);
}
