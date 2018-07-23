package com.xprogect.lifecycle;


import android.arch.lifecycle.LifecycleOwner;
import android.content.Context;
import android.util.Log;

import com.xprogect.fragment.find.FindContart;
import com.xprogect.x_library.basemvp.BasePresenter;

import org.jetbrains.annotations.NotNull;

/**
 * Created by Administrator on 2018/3/21
 * function：
 */

public class LifeCyclePeresenterImpl extends BasePresenter implements FindContart.Presenter  {

    private LifeCycleContart.View mView;

    public LifeCyclePeresenterImpl(Context mView) {
        super(mView);
        this.mView = (LifeCycleContart.View) mView;
    }


    private String dsf;

    @Override
    public void getFindUrl() {
    }

    @Override
    public void onCreate(@NotNull LifecycleOwner owner) {
        Log.d("tag", "BasePresenter.onCreate " + this.getClass().toString());
    }

    @Override
    public void onStart(@NotNull LifecycleOwner owner) {
        Log.d("tag", "BasePresenter.onStart " + this.getClass().toString());
    }

    @Override
    public void onDestroy(@NotNull LifecycleOwner owner) {
        Log.d("tag", "BasePresenter.onDestroy " + this.getClass().toString());
    }
}
