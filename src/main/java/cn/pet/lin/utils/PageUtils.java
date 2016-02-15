package cn.pet.lin.utils;

import cn.pet.lin.domain.BizData4Page;

import java.util.List;

/**
 * Created by linjingjie on 2015/11/28.
 */
public class PageUtils {
    public static BizData4Page toBizData4Page(List data, int pageNo, int pageSize, int records) {
        BizData4Page bizData4Page = new BizData4Page();
        bizData4Page.setRows(data);
        bizData4Page.setPage(pageNo);
        bizData4Page.setRecords(records);
        int total = records / pageSize;
        int mod = records % pageSize;
        if (mod > 0) {
            total = total + 1;
        }
        bizData4Page.setTotal(total);
        return bizData4Page;
    }
}
