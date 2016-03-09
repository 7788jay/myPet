package cn.pet.lin.utils.enums;

/**
 * Created by lwt on 2016/3/9.
 */
public enum OrderStatus {
    NO_CHECKED(0,"未审核");

    private int status;
    private String msg;

    OrderStatus(int status, String msg) {
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
