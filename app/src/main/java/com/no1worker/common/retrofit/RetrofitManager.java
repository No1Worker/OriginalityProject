package com.no1worker.common.retrofit;

import com.no1worker.common.retrofit.service.OriginalityService;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * retrofit 管理类
 * Created by yuzhiyong on 2019/5/17.
 */

public class RetrofitManager {

    private static Map<Class<?>, Object> serviceCache = new ConcurrentHashMap<Class<?>, Object>();

    public static OriginalityService createOriginalService(){
        OriginalityService originalityService = (OriginalityService) serviceCache.get(OriginalityService.class);
        if (originalityService == null) {
            OkHttpClient client = new OkHttpClient.Builder()
                    .addInterceptor(getLogInterceptor())
                    .build();

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("")
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(client)
                    .build();

            originalityService = retrofit.create(OriginalityService.class);
            serviceCache.put(OriginalityService.class, originalityService);
        }
        return originalityService;
    }

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
