package com.xprogect.api.init;

/**
 * Created by Administrator on 2018/3/28
 * function：
 */

import android.support.annotation.NonNull;

import com.xprogect.MyApplication;
import com.xprogect.x_library.utils.NetWorkUtil;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Response;

/**
 * Retrofit 拦截器 检查是否连接上网络
 */
public class NetWorkInterceptor implements Interceptor {

    @Override
    public Response intercept(@NonNull Chain chain) throws IOException {
        boolean connected = NetWorkUtil.isNetworkConnected(MyApplication.getContext());
        if (connected) {
            return chain.proceed(chain.request());
        }
        throw new NoNetworkException();
    }

    /**
     * 自定义异常  无网络连接是抛出
     */
    public static class NoNetworkException extends IOException {
    }
}
