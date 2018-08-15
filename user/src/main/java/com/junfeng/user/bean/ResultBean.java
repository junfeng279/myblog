package com.junfeng.user.bean;

import lombok.Getter;
import lombok.Setter;

/**
 * @Author junfeng
 * @Date 2018/8/3 21:34
 * Created by adminstor on 2018/8/3.
 */
@Setter
@Getter
public class ResultBean<T> {
    private T data;
    private String msg;
    private String code;
    private boolean success;
    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
