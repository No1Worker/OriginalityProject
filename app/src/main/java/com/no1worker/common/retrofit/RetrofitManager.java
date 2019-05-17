package com.no1worker.common.retrofit;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import okhttp3.logging.HttpLoggingInterceptor;

/**
 * retrofit 管理类
 * Created by yuzhiyong on 2019/5/17.
 */

public class RetrofitManager {

    private static Map<Class<?>, Object> serviceCache = new ConcurrentHashMap<Class<?>, Object>();

    private static HttpLoggingInterceptor getLogInterceptor(){
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        // set your desired log level
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        return logging;
    }

    public static void clearServiceCache(){
        serviceCache.clear();
    }
}
