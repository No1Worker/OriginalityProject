package com.no1worker.common.retrofit.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * 接口返回基础对象
 * Created by yuzhiyong on 2019/5/22.
 */

public class OriginalityBase<T> implements Serializable{

    @Expose
    @SerializedName("status")
    private int status;

    @Expose
    @SerializedName("msg")
    private String msg;

    @Expose
    @SerializedName("data")
    private T data;

    @Expose
    @SerializedName("errorCode")
    private String errorCode;

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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    @Override
    public String toString() {
        return "OriginalityBase{" +
                "status=" + status +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                ", errorCode='" + errorCode + '\'' +
                '}';
    }
}
