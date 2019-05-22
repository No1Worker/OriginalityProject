package com.no1worker.common.retrofit.callback;

import android.util.Log;

import com.google.gson.JsonSyntaxException;
import com.no1worker.common.retrofit.response.ErrorInfo;
import com.no1worker.common.retrofit.response.OriginalityBase;

import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * 网络请求回调
 * Created by yuzhiyong on 2019/5/22.
 */

public abstract class OriginalityCallBack<T> implements Callback<OriginalityBase<T>> {

    @Override
    public void onResponse(Call<OriginalityBase<T>> call, Response<OriginalityBase<T>> response) {
        if(response.isSuccessful()){
            if (response.body() != null) {
                if (1 == response.body().getStatus()) {
                    onSuccess(response.body());
                } else {
                    onFailure(response.body());
                }
            }
        }else{
            onFailure(generateHttpErrorResponse(response.code()));
        }
        onFinish();
    }

    @Override
    public void onFailure(Call<OriginalityBase<T>> call, Throwable t) {
        if (t instanceof ConnectException || t instanceof SocketTimeoutException || t instanceof UnknownHostException) {
            onFailure(generateErrorResponse(ErrorInfo.NETWORK_CONNECT_ERROR));
        } else if(t instanceof JsonSyntaxException){
            onFailure(generateErrorResponse(ErrorInfo.JSON_PARSE_ERROR));
        } else {
            onFailure(generateErrorResponse(ErrorInfo.UNKNOWN));
        }
        onFinish();
    }

    /**
     * onSuccess 与 onFailure 方法结束之后都用调用此方法
     */
    public void onFinish(){

    }

    /**
     * 如果 Http响应码为200，且OriginalityBase中status为1，则回调此方法
     * @param retMsgInfo 为了更好兼容之前的网络请求
     */
    public abstract void onSuccess(OriginalityBase<T> retMsgInfo);

    /**
     * 如果 Http响应吗非200，或OriginalityBase中status为0，或JSON转对象发生异常，则回调此方法
     * @param retMsgInfo
     */
    public abstract void onFailure(OriginalityBase<T> retMsgInfo);

    private OriginalityBase<T> generateHttpErrorResponse(int responseCode){
        OriginalityBase<T> originalityBase = new OriginalityBase<>();
        originalityBase.setStatus(0);
        originalityBase.setErrorCode(responseCode + "");
        originalityBase.setMsg(String.format("请求失败（%s）",responseCode));
        return originalityBase;
    }

    private OriginalityBase<T> generateErrorResponse(ErrorInfo errorInfo){
        OriginalityBase<T> originalityBase = new OriginalityBase<>();
        originalityBase.setStatus(0);
        originalityBase.setErrorCode(errorInfo.getValue());
        originalityBase.setMsg(errorInfo.getStrValue());
        return originalityBase;
    }

}
