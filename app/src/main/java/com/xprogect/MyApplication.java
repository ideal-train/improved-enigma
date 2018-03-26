package com.xprogect;

import android.app.Application;

import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;


/**
 * Created by Administrator on 2018/3/23
 * function：
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        initLogger();
    }

    private void initLogger() {
        Logger.addLogAdapter(new AndroidLogAdapter());
        Logger.d("初始化");
    }
}

