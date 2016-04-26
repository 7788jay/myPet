package cn.pet.lin.utils.enums;

/**
 * Created by lwt on 2016/3/9.
 */
public enum OrderStatusEnum {
    NO_CHECKED(0,"未审核"),
    CHECKED(1,"已确认"),
    SEND(2,"已发货"),
    COMPLETE(3,"完成"),
    CANCEL(4,"已取消");

    private final int status;
    private final String msg;

    OrderStatusEnum(int status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    public int getStatus() {
        return status;
    }


    public String getMsg() {
        return msg;
    }

}
