package com.no1worker.originalityproject.bean;

/**
 * 登录信息
 * Created by yuzhiyong on 2019/5/22.
 */

public class LoginInfo {

    private String phone;
    private String password;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "LoginInfo{" +
                "phone='" + phone + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
