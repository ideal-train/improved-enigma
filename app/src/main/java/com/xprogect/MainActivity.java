package com.xprogect;

import android.widget.TextView;

import com.orhanobut.logger.Logger;
import com.xprogect.application.R;
import com.xprogect.x_library.base.BaseTooBarActivity;
import com.xprogect.x_library.utils.MyLog;

import butterknife.BindView;


public class MainActivity extends BaseTooBarActivity {

    @BindView(R.id.main_test)
    TextView mainTest;


    @Override
    public int setContentViewID() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        Logger.d("------------------------------------");
        MyLog.d("MainActivity", "onCreate:" + "");
        mainTest.setText("123123");
    }
}
