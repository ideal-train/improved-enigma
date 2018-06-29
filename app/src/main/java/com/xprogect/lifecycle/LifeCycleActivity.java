package com.xprogect.lifecycle;

import android.os.Bundle;

import com.xprogect.application.R;
import com.xprogect.bean.HomeBean;
import com.xprogect.x_library.base.BaseTooBarActivity;
import com.xprogect.x_library.basemvp.IPresenter;

public class LifeCycleActivity extends BaseTooBarActivity implements LifeCycleContart.View {


    private IPresenter mPresenter;

    @Override
    public int setContentViewID() {
        return R.layout.activity_life_cycle;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        setTitle("LifeCycleActivity");
        mPresenter = new LifeCyclePeresenterImpl(this);
        getLifecycle().addObserver(mPresenter);//添加LifecycleObserver
    }

    @Override
    public void requestSuccess(HomeBean bean) {

    }

    @Override
    public void requestError() {

    }
}
