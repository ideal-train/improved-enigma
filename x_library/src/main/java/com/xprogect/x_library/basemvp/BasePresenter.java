package com.xprogect.x_library.basemvp;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleOwner;
import android.content.Context;

import org.jetbrains.annotations.NotNull;

/**
 * @author Administrator
 * @since 2018/6/29
 * function：
 */
public abstract class  BasePresenter implements IPresenter {

    private static final String TAG = "BasePresenter";

    public BasePresenter(Context context){

    }

    @Override
    public void onLifecycleChanged(@NotNull LifecycleOwner owner, @NotNull Lifecycle.Event event) {

    }


}
