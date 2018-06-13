package com.xprogect.x_library.base;


import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.StringRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xprogect.x_library.basemvp.BaseView;
import com.xprogect.x_library.utils.SoftKeyGoardUtil;
import com.xprogect.x_library.utils.ToastUtil;

import butterknife.ButterKnife;
import butterknife.Unbinder;


/**
 * Fragment 的大基类
 */
public abstract class BaseFragment extends Fragment implements BaseView {

    public String TAG = getClass().getSimpleName();

    private SoftKeyGoardUtil softKeyGoardUtil;
    private Unbinder unbinder;
    protected View view;
    private static final String STATE_SAVE_IS_HIDDEN = "STATE_SAVE_IS_HIDDEN";

    public BaseFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(setContentView(), container, false);
        unbinder = ButterKnife.bind(this, view);
//        if (savedInstanceState != null) {
//            boolean isSupportHidden = savedInstanceState.getBoolean(STATE_SAVE_IS_HIDDEN);
//
//            FragmentTransaction ft = getFragmentManager().beginTransaction();
//            if (isSupportHidden) {
//                ft.hide(this);
//            } else {
//                ft.show(this);
//            }
//            ft.commit();
//        }
        initView(view);
        return view;
    }


    private void initSoft() {
        softKeyGoardUtil = SoftKeyGoardUtil.initInstance(getActivity());
    }


    /**
     * 设置Fragment要显示的布局
     *
     * @return 布局的layoutId
     */
    protected abstract @LayoutRes
    int setContentView();

    /**
     * 初始化控件操作
     */
    protected abstract void initView(View view);

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    public void toast(@SuppressLint("SupportAnnotationUsage") @StringRes String msg) {
        ToastUtil.show(getActivity(), msg);
    }

    public void toast(@IdRes int resId) {
        ToastUtil.show(getActivity(), resId);
    }

    /**
     * @param ids      fragement id
     * @param fragment 添加的Fragment
     * @param bundle   传递的参数
     */
    public void switchFragment(@IdRes int ids, Fragment fragment, Bundle bundle) {
        try {
            FragmentManager manager = getChildFragmentManager();
            FragmentTransaction ft = manager.beginTransaction();
            if (bundle != null) {
                fragment.setArguments(bundle);
            }
            ft.replace(ids, fragment);
            ft.commit();
        } catch (Exception exceptione) {
        }
    }


    /**
     * 弹出 关闭软键盘 双操作
     */
    protected void automaticKeyBoard() {
        initSoft();
        softKeyGoardUtil.automaticKeyBoard();
    }


    /**
     * 此方法只是关闭软键盘
     */
    protected void justHintKeyBoard() {
        initSoft();
        softKeyGoardUtil.hideSoftInput();
    }

    @Override
    public Context _getContext() {
        return getActivity();
    }
}
