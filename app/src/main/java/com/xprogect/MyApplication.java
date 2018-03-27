package com.xprogect;

import android.app.Application;
import android.content.Context;

import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;
import com.xprogect.api.ServiceGenerator;


/**
 * Created by Administrator on 2018/3/23
 * function：
 * 尽量少使用全局变量
 *
 * @author Administrator
 */
public class MyApplication extends Application {
    private static Context mContext;
    private MyApplication mMyApplication;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
        mMyApplication = this;
        initLogger();
        initRetrofit();
    }

    public static Context getContext() {
        return mContext;
    }

    /**
     * 初始化Log相关
     */
    private void initLogger() {
        Logger.addLogAdapter(new AndroidLogAdapter());
        Logger.d("初始化");
    }


    /**
     * 初始化Retrofit配置
     */
    private void initRetrofit() {
        ServiceGenerator.initRetrofit();
    }
}

