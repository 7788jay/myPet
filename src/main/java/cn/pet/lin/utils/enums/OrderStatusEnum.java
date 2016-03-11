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

    private int status;
    private String msg;

    OrderStatusEnum(int status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
