package com.xprogect.api;

import android.content.Context;

import com.xprogect.MyApplication;
import com.xprogect.api.init.ApiException;
import com.xprogect.api.init.BeanFactory;
import com.xprogect.api.init.CenterParameterInterceptor;
import com.xprogect.bean.HomeBean;
import com.xprogect.contests.RequestCons;
import com.xprogect.x_library.BuildConfig;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.functions.Func1;

import static com.xprogect.contests.RequestCons.DEFAULT_TIME_OUT;
import static com.xprogect.contests.RequestCons.STATUS_SUCCESS;


/**
 * 创建retrofit对象和modelService对象
 * 以及状态码的判断
 * Created by mango on 16/8/18.
 */
public class ServiceGenerator<T> {
    private static String baseUrl;
    private static Retrofit mRetrofit;
    private static Context mContext;

    public static void initRetrofit() {
        baseUrl = RequestCons.BASE_URL;

        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        if (BuildConfig.DEBUG) {
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        } else {
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.NONE);
        }


        CenterParameterInterceptor parameterInterceptor = new CenterParameterInterceptor(MyApplication.getContext());


        OkHttpClient client = new OkHttpClient.Builder()
                //连接超时时间
                .connectTimeout(DEFAULT_TIME_OUT, TimeUnit.SECONDS)
                //写操作 超时时间
                .writeTimeout(DEFAULT_TIME_OUT, TimeUnit.SECONDS)
                //读操作超时时间
                .readTimeout(DEFAULT_TIME_OUT, TimeUnit.SECONDS)
                .addInterceptor(loggingInterceptor)
                .addInterceptor(parameterInterceptor)
                .build();
        mRetrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(client)
                //增加返回值为Gson的支持(以实体类返回)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
    }

    public static <S> S createRetrofitService(Class<S> mDataClick, Context context) {
        mContext=context;
        return createRetrofitService(mDataClick);
    }

    public static <S> S createRetrofitService(Class<S> mDataClick) {
        return mRetrofit.create(mDataClick);
    }

    /**
     * 给返回结果去掉状态码等属性,
     * 如果是查询出错,则返回状态码对应的描述给用户
     *
     * @param observable
     * @return
     */
    public static Observable filterStatus(Observable<BeanFactory<HomeBean>> observable) {
        return observable.map(new ResultFilter());
    }

    private static class ResultFilter<T> implements Func1<BeanFactory<T>, T> {
        @Override
        public T call(BeanFactory<T> tHttpBean) {
            if (tHttpBean.getStatus() == STATUS_SUCCESS) {
                return tHttpBean.getData();
            } else {
                throw new ApiException(tHttpBean.getStatus(),tHttpBean.getMsg());
            }
        }
    }

}
