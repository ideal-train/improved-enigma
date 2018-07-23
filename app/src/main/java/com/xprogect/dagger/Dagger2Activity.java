package com.xprogect.dagger;

import android.os.Bundle;

import com.orhanobut.logger.Logger;
import com.xprogect.application.R;
import com.xprogect.x_library.base.BaseTooBarActivity;

import javax.inject.Inject;

public class Dagger2Activity extends BaseTooBarActivity {

    @Inject
    Product product;

    @Override
    public int setContentViewID() {
        return R.layout.activity_dagger2;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        setTitle("Dagger2");
        //使用组件进行构造，注入
        DaggerProductComponent.create().inject(this);
        Logger.e("--------------"+product.hashCode());
    }
}
