package cn.pet.lin.domain.common;

import java.io.Serializable;

/**
 * 返回结果
 *
 * @author lin
 * @create 2016-01-05  15:46
 */
public class ResultDTO implements Serializable {
    //成功失败
    private boolean isSuccess;
    //信息
    private String msg;
    //值
    private String value;

    public ResultDTO(boolean isSuccess, String msg, String value) {
        this.isSuccess = isSuccess;
        this.msg = msg;
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public ResultDTO(boolean isSuccess, String msg) {
        this.isSuccess = isSuccess;
        this.msg = msg;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
