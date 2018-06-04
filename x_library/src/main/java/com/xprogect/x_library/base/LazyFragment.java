package com.xprogect.x_library.base;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by JFL on 2017/12/7
 * Email：WarwG1@163.com
 * function：设置Fragment模式为懒加载模式
 * 仅限于Viewpager中使用 不推荐你在普通的 Fragment中使用
 */
public abstract class LazyFragment extends BaseFragment {

    private boolean isInit;                  //初始化是否完成
    protected boolean isLoad = false;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        isInit = true;
        initPrepare();
        return view;
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    /*
     * 视图是否已经对用户可见---系统的方法
     *
     * 此方法在控件初始化前调用，所以不能在此方法中直接操作，控件会出现空指针
     * 为什么呢？
     * 是这样的：执行setAdapter的时候，会调用setUserVisibleHint()方法，
     * 并且，只有当setAdapter方法执行完之后，才会进入到Fragment到生命周期，
     * 因此setUserVisibleHint()方法在所有生命周期之前被调用。
     * 控件初始化前调用?那这个方法不就有问题么？
     * 那是因为当fragment显示时还会回调这个方法setUserVisibleHint
     */
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        /*
         所以要 先判断映射关系再判断 是否可见

         那 就有人说了 没初始化完毕肯定是不可见的啊，那怎么不在这里先if(isVisibleToUser)
         嗯。。。  是这样的 算了 看initPrepare的注释吧
         */
        initPrepare();
    }


    @SuppressLint("MissingSuperCall")
    @Override
    public void onDestroyView() {
        isInit = false;
        isLoad = false;
//        这个方法在这里没什么意义 非必须 看需求吧，以后有需求了再解开注释
        //        onBaseDestroyView();
        super.onDestroy();
    }

    /**
     * 同步锁
     * 或许你有个疑问，为什么把逻辑都写在这里？
     * 因为逻辑并不多，统一处理，方便后面回头看的时候容易找到懒加载实现的关键代码
     */
    private synchronized void initPrepare() {
        if (!isInit) {
            return;
        }
        if (getUserVisibleHint()) {
            onUserVisible();
            isLoad = true;
        } else {
            //不可见时执行操作
            if (isLoad) {
                onUserInvisible();
            }
        }
    }

    /**
     * 当视图初始化
     * 并且对用户可见
     * 时候去真正的加载数据
     */
    protected abstract void onUserVisible();

    /**
     * 页面不可见时操作(仅在Viewpager中有效)
     */
    protected abstract void onUserInvisible();

//    protected abstract void onBaseDestroyView();
}
