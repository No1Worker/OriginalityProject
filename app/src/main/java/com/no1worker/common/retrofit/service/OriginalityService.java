package com.no1worker.common.retrofit.service;

import com.no1worker.common.retrofit.bean.UserInfo;
import com.no1worker.common.retrofit.response.OriginalityBase;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.POST;

/**
 * 网络请求接口
 * Created by yuzhiyong on 2019/5/22.
 */

public interface OriginalityService {

    /**
     * 用户注册
     * @param phone
     * @param password
     * @param username
     * @param email
     * @param question
     * @param answer
     * @return
     */
    @POST("/user/register.do")
    Call<OriginalityBase<String>> registerUser(@Field("phone") String phone,
                                             @Field("password") String password,
                                             @Field("username") String username,
                                             @Field("email") String email,
                                             @Field("question") String question,
                                             @Field("answer") String answer);

    /**
     * 用户登录
     * @param phone
     * @param password
     * @return
     */
    @POST("/user/login.do")
    Call<OriginalityBase<UserInfo>> login(@Field("phone") String phone,
                                          @Field("password") String password);
}
