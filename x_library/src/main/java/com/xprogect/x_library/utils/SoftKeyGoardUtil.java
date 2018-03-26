package com.xprogect.x_library.utils;

import android.app.Activity;
import android.app.Service;
import android.os.Handler;
import android.view.inputmethod.InputMethodManager;

import static android.content.Context.INPUT_METHOD_SERVICE;

/**
 * Created by lijiafu on 2017/12/19.
 * 功能：软键盘工具类
 */

public class SoftKeyGoardUtil {


    private static SoftKeyGoardUtil config;
    private Activity mContext;


    public static SoftKeyGoardUtil initInstance() {
        if (config == null) {
            config = new SoftKeyGoardUtil();
        }
        return config;
    }

    public static SoftKeyGoardUtil initInstance(Activity context) {
        if (config == null) {
            config = new SoftKeyGoardUtil();
        }
        config.mContext = context;
        return config;
    }


    /**
     * 单项功能--显示软键盘
     */
    public void showInputMethod() {
//        if (mContext.getCurrentFocus() != null) {
        InputMethodManager imm = (InputMethodManager) mContext.getSystemService(INPUT_METHOD_SERVICE);
        if (imm != null) {
            imm.showSoftInputFromInputMethod(mContext.getCurrentFocus().getWindowToken(), 0);
        }
    }

    /**
     * 单项功能--隐藏软件盘
     */
    public void hideSoftInput() {
        InputMethodManager imm = (InputMethodManager) mContext.getSystemService(INPUT_METHOD_SERVICE);
        if (imm != null) {
            imm.hideSoftInputFromWindow(mContext.getCurrentFocus().getWindowToken(), 0);
        }
    }


//----------------------------------------------------------------------------

    /**
     * 自动 弹出 关闭软键盘 双操作
     */
    public void automaticKeyBoard() {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                InputMethodManager imm = (InputMethodManager) mContext.getSystemService(Service.INPUT_METHOD_SERVICE);
                imm.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);
            }
        }, 0);
    }
}
