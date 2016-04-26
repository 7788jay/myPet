package cn.pet.lin.order;

/**
 * Created by lwt on 2016/4/9.
 */

//用于统计
public class Count {
    //时间
    private String date;
    //订单数
    private int orderSum;
    //宠物数
    private int petSum;

    public int getOrderSum() {
        return orderSum;
    }

    public void setOrderSum(int orderSum) {
        this.orderSum = orderSum;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getPetSum() {
        return petSum;
    }

    public void setPetSum(int petSum) {
        this.petSum = petSum;
    }
}
