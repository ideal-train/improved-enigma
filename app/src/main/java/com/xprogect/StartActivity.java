package com.xprogect;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.xprogect.application.R;
import com.xprogect.x_library.base.BaseTooBarActivity;

public class StartActivity extends BaseTooBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // 隐藏标题栏
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        // 隐藏状态栏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
    }

    @Override
    public int setContentViewID() {
        return R.layout.activity_start;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        hitToolBar();
        //这里是第二种方法 消除启动前黑白屏
        setTranslucentStatus(true);
        // TODO: 2018/3/26 初始化操作
        Intent intent = new Intent(StartActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }


    @TargetApi(19)
    protected void setTranslucentStatus(boolean on) {
        Window win = getWindow();
        WindowManager.LayoutParams winParams = win.getAttributes();
        final int bits = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
        if (on) {
            winParams.flags |= bits;
        } else {
            winParams.flags &= ~bits;
        }
        win.setAttributes(winParams);
    }

}
