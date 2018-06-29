package com.xprogect.x_library.base;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.annotation.BoolRes;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import com.orhanobut.logger.Logger;
import com.xprogect.x_library.basemvp.BaseView;
import com.xprogect.x_library.utils.SoftKeyGoardUtil;
import com.xprogect.x_library.utils.ToastUtil;
import com.xprogect.x_library.utils.ToolUtil;

import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by lijiafu on 2017/12/19.
 * 功能：Activity的基类 一般页面不直接使用该基类（仅仅作为一个功能集合页面，不参与过多逻辑）
 */

public class BaseActivity extends AppCompatActivity implements BaseView {

    public String TAG = getClass().getSimpleName();
    private SoftKeyGoardUtil softKeyGoardUtil;
    /**
     * 固定竖屏?
     * true,竖屏；false，横屏。
     **/
    private boolean isAlwaysVertical = true;

    /**
     * 所有已存在的Activity
     */
    protected static ConcurrentLinkedQueue<Activity> allActivity = new ConcurrentLinkedQueue<Activity>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setScreenVertical(true);
        allActivity.add(this);
    }

    private void initSoft() {
        softKeyGoardUtil = SoftKeyGoardUtil.initInstance(this);
    }

    /**
     * 固定竖屏?
     * true,竖屏；false，横屏。
     *
     * @param isAllowScreenRoate true，竖屏；false，横屏。
     */
    @SuppressLint("SupportAnnotationUsage")
    public void setScreenVertical(@BoolRes boolean isAllowScreenRoate) {
        if (isAlwaysVertical) {
            //禁止横竖屏切换 固定竖屏
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        } else {
            //横屏
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        }
    }

    /**
     * 结束所有activity
     */
    public static void finishAll() {
        // 结束Activity
        for (Activity act : allActivity) {
            act.finish();
        }
        allActivity.clear();
    }

    @SuppressLint("SupportAnnotationUsage")
    public void toast(@StringRes String text) {
        ToastUtil.show(getApplicationContext(), text);
    }

    @SuppressLint("SupportAnnotationUsage")
    public void toast(@StringRes String text, @Nullable int duration) {
        if (duration == 0) {
            ToastUtil.show(getApplicationContext(), text, Toast.LENGTH_SHORT);
        } else {
            ToastUtil.show(getApplicationContext(), text, Toast.LENGTH_LONG);
        }
    }

    public void toast(@IdRes int resId) {
        ToastUtil.show(getApplicationContext(), resId);
    }


    /**
     * 显示软键盘
     */
    public void showInputMethod() {
        initSoft();
        softKeyGoardUtil.showInputMethod();
    }

    /**
     * 隐藏软件盘
     */
    public void hideSoftInput() {
        initSoft();
        softKeyGoardUtil.hideSoftInput();
    }

    /**
     * 点击软键盘之外的空白处，隐藏软件盘
     *
     * @param ev
     * @return
     */
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (ev.getAction() == MotionEvent.ACTION_DOWN) {
            View v = getCurrentFocus();
            if (ToolUtil.isShouldHideInput(v, ev)) {

                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                if (imm != null) {
                    imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
                }
            }
            return super.dispatchTouchEvent(ev);
        }
        // 必不可少，否则所有的组件都不会有TouchEvent了
        if (getWindow().superDispatchTouchEvent(ev)) {
            return true;
        }
        return onTouchEvent(ev);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Logger.d(this);
    }

    @Override
    public Context _getContext() {
        return this;
    }
}
