package cn.pet.lin.service.order;

import cn.pet.lin.dao.order.ICountDAO;
import cn.pet.lin.order.Count;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lwt on 2016/4/9.
 */
@Service("ICountServiceImpl")
public class ICountServiceImpl implements ICountService {
    @Autowired
    ICountDAO countDAO;

    @Override
    public List<Count> CountOrderByDays(int num) {
        return countDAO.CountOrderByDays(num);
    }
}
