package com.xprogect.x_library.base;

import android.os.Bundle;
import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.LayoutRes;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.util.Util;
import com.jakewharton.rxbinding2.view.RxView;
import com.xprogect.x_library.R;
import com.xprogect.x_library.utils.StatusBarUtil;
import com.xprogect.x_library.utils.XConstants;

import java.util.concurrent.TimeUnit;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import io.reactivex.functions.Consumer;

/**
 * Created by JFL on 2017/12/19
 * Email：WarwG1@163.com
 * function：自带一套默认 TooBar
 */
public abstract class BaseTooBarActivity extends BaseActivity {


    private LinearLayout rootLayout;
    private Toolbar mToolbar;

    //状态栏颜色
    protected TextView tvStatusBar;
    //toobar 是否可隐藏
    protected RelativeLayout mToobarView;
    //左侧 点击区域
    RelativeLayout leftView;
    //左侧 图片
    ImageView leftimg;
    //左侧 文字
    TextView leftTv;
    //标题部分
    TextView mToolTarTitle;
    //右侧 点击区域
    RelativeLayout rightView;
    //    右侧 图片
    ImageView rightimg;
    //右侧文字
    protected TextView righTv;
    private Unbinder unbinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_base_too_bar);
        // 初始化toolbar
        initBaseToolbar();
        setContentView(View.inflate(this, setContentViewID(), null));
        unbinder=ButterKnife.bind(this);
        initView();
        //初始化状态栏透明
        setStatusBar();
    }

    public abstract
    @LayoutRes
    int setContentViewID();

    public abstract void initView();

    protected void setStatusBar() {
//        有颜色全透状态栏
        StatusBarUtil.setColor(this, getResources().getColor(R.color.toolbar_color), 0);
//        浸入式状态栏
//      StatusBarUtil.setTranslucentForImageView(this, 0, null);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
        if (Util.isOnMainThread() && !this.isFinishing()) {
            Glide.with(this).pauseRequests();
        }
    }

    @Override
    public void setContentView(View view) {
//        子布局加入到父布局中
        rootLayout = (LinearLayout) findViewById(R.id.activity_base_too_bar);
        if (rootLayout != null) {
            rootLayout.addView(view, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
            initBaseToolbar();
        }
    }

    /**
     * 初始化toolbar
     */
    private void initBaseToolbar() {
        mToolbar = (Toolbar) findViewById(R.id.base_toolbar);
        if (mToolbar != null) {
//            Toolbar即能取代原本的 actionbar 了
            setSupportActionBar(mToolbar);
        }
    }


    /**
     * 设置TooBarColor
     *
     * @param mColor
     */
    protected void setTooBarColor(@ColorRes int mColor) {
        mToolbar.setBackgroundColor(getResources().getColor(mColor));
    }

    /**
     * 加入默认toobar
     */
    private void initBaseTooBarContent() {
//        getLayoutInflater().inflate(R.layout.toolbar_layout_default, getBaseToolBar());
        getLayoutInflater().inflate(R.layout.toolbar_layout_default, mToolbar);

        mToobarView = (RelativeLayout) findViewById(R.id.toobar_view);

        leftView = (RelativeLayout) findViewById(R.id.left_view);
        leftimg = (ImageView) findViewById(R.id.toolbar_left_iv);
        leftTv = (TextView) findViewById(R.id.toolbar_left_tv);

        mToolTarTitle = (TextView) findViewById(R.id.toolbar_title);

        rightView = (RelativeLayout) findViewById(R.id.right_view);
        rightimg = (ImageView) findViewById(R.id.toolbar_right_iv);
        righTv = (TextView) findViewById(R.id.toolbar_right_tv);
    }

    /**
     * 获取toolbar
     *
     * @return
     */
    public Toolbar getBaseToolBar() {
        return mToolbar;
    }


    /**
     * 隐藏toolbar
     */
    public void hitToolBar() {
        mToolbar.setVisibility(View.GONE);
    }

    public void setLeftImg(@DrawableRes int leftimgs) {
        initBaseTooBarContent();
        leftimg.setImageResource(leftimgs);
    }

    public void setTitle(String title) {
        initBaseTooBarContent();
        if (mToolTarTitle == null)
            return;
        mToolTarTitle.setText(title);
        mLeftClick();
    }


    //返回事件
    private void mLeftClick() {
        leftView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                leftAction();
            }
        });
    }

    private void mRightClick() {
//        rightView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                rightAction();
//            }
//        });
        RxView.clicks(rightView)
                // 3秒钟之内只取一个点击事件，防抖操作
                .throttleFirst(XConstants.RX_REPEAT_TIME, TimeUnit.SECONDS)
                .subscribe(new Consumer<Object>() {
                    @Override
                    public void accept(Object o) throws Exception {
                        rightAction();
                    }
                });

    }


    public void rightAction() {
    }

    //只需要返回的情况下不需要覆写
    public void leftAction() {
        finish();
    }

    //左侧返回 中间标题 右侧文字
    public void setRightTxtTitleBar(String title, String lImg) {
        initBaseTooBarContent();

        mToolTarTitle.setText(title);

        rightimg.setVisibility(View.GONE);
        righTv.setVisibility(View.VISIBLE);
        righTv.setText(lImg);
        mLeftClick();
        mRightClick();
    }
}
