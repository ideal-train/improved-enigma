package com.xprogect.api.init;

import android.content.Context;
import android.support.annotation.NonNull;

import com.xprogect.contests.RequestCons;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * 参数拦截器
 */

public class CenterParameterInterceptor implements Interceptor {

    private Context context;

    public CenterParameterInterceptor(Context context) {
        this.context = context;
    }

    @Override
    public Response intercept(@NonNull Chain chain) throws IOException {
        Request original = chain.request();
        HttpUrl url = addExtraParameters(original);
        Request.Builder requestBuilder = original.newBuilder().url(url);
        requestBuilder.header("access-agent", RequestCons.APP_TAG);
//        添加请求头
//        if (!TextUtils.isEmpty(TokenUtils.getToken(context)))
//            requestBuilder.header("auth-token", TokenUtils.getToken(context));
        Request request = requestBuilder
                .method(original.method(), original.body())
                .build();
        return chain.proceed(request);
    }

    private HttpUrl addExtraParameters(Request original) {
        HttpUrl originalHttpUrl = original.url();
        //添加自定义参数
        List<NameValuePair> nameValuePairs = new ArrayList<>();
        String time = String.valueOf(System.currentTimeMillis() / 1000);
        nameValuePairs.add(new BasicNameValuePair("_atype", "android"));
        nameValuePairs.add(new BasicNameValuePair("_app", "rttx"));
        nameValuePairs.add(new BasicNameValuePair("_vc", "1201"));
        nameValuePairs.add(new BasicNameValuePair("_vn", "1.2.0.1"));
        nameValuePairs.add(new BasicNameValuePair("_t", time));

        HttpUrl.Builder builder = originalHttpUrl.newBuilder();
        for (NameValuePair item : nameValuePairs) {
            builder.addQueryParameter(item.getName(), item.getValue());
        }
        return builder.build();
    }

}
