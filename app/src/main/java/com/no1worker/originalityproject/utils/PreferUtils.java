package com.no1worker.originalityproject.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.no1worker.common.retrofit.bean.UserInfo;
import com.no1worker.originalityproject.bean.LoginInfo;

/**
 * SharedPreferences 工具类
 * Created by yuzhiyong on 2019/5/22.
 */

public class PreferUtils {

    /**
     * 保存登录状态
     * @param context
     */
    public static void saveIsLogin(Context context){
        SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(context).edit();
        editor.putBoolean("islogin", true);
        editor.commit();
    }

    /**
     * 获取登录状态
     * @param context
     * @return
     */
    public static boolean getIsLogin(Context context){
        SharedPreferences spf = PreferenceManager.getDefaultSharedPreferences(context);
        return spf.getBoolean("islogin", false);
    }

    /**
     * 保存登录信息
     * @param Info
     * @param context
     */
    public static void  saveLoginCheckInfo(LoginInfo Info, Context context){
        SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(context).edit();
        editor.putString("phone", Info.getPhone());
        editor.putString("password", Info.getPassword());
        editor.putBoolean("islogin", true);
        editor.commit();
    }

    /**
     * 获取登录信息
     * @param context
     * @return
     */
    public static LoginInfo getLoginCheckByPfM(Context context){
        LoginInfo loginInfo = new LoginInfo();
        SharedPreferences spf = PreferenceManager.getDefaultSharedPreferences(context);
        loginInfo.setPhone(spf.getString("phone", ""));
        loginInfo.setPassword(spf.getString("password", ""));
        return loginInfo;
    }

    /**
     * 存储用户信息
     * @param info
     * @param context
     */
    public static void  saveUserInfoCheckInfo(UserInfo info, Context context){
        SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(context).edit();
        editor.putString("id", info.getId());
        editor.putString("username", info.getUsername());
        editor.putString("email", info.getEmail());
        editor.putString("phone", info.getPhone());
        editor.putLong("createTime", info.getCreateTime());
        editor.putLong("updateTime", info.getUpdateTime());
        editor.commit();
    }

    /**
     * 获取用户信息
     * @param context
     * @return
     */
    public static UserInfo getUserInfoCheckByPfM(Context context){
        UserInfo userInfo = new UserInfo();
        SharedPreferences spf = PreferenceManager.getDefaultSharedPreferences(context);
        userInfo.setId(spf.getString("id",""));
        userInfo.setUsername(spf.getString("username",""));
        userInfo.setEmail(spf.getString("email",""));
        userInfo.setPhone(spf.getString("phone",""));
        userInfo.setCreateTime(spf.getLong("createTime",0));
        userInfo.setUpdateTime(spf.getLong("updateTime",0));
        return userInfo;
    }
}
