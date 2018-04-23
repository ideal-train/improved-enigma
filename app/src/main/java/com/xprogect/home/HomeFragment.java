package com.xprogect.home;


import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.TextView;

import com.xprogect.application.R;
import com.xprogect.enums.OhterWay;
import com.xprogect.title.TitleActivity;
import com.xprogect.x_library.base.BaseFragment;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 首页
 */
public class HomeFragment extends BaseFragment {
    @BindView(R.id.fg_tv)
    TextView mFgtv;

    private int page = -1;
    private static HomeFragment myFragment;


    public static HomeFragment getInstance() {
        myFragment = new HomeFragment();
        return myFragment;
    }

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    protected int setContentView() {
        return R.layout.fragment_home_hot;
    }

    @Override
    protected void initView(View view) {
//getResources().geti
        Bundle bundle = this.getArguments();
        mFgtv.setText(OhterWay.getFlavour(page = bundle.getInt("home")));


//        otherWay(OhterWay.FIND_1);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            mFgtv.setTransitionName("ShowTitle");
        }
    }


    private void otherWay(@OhterWay.Flavour int type) {

    }

    @OnClick(R.id.ll_click)
    protected void mClick() {
        Intent mIntent = new Intent(getActivity(), TitleActivity.class).putExtra("page", page);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            android.util.Pair<View, String> pair1 = new Pair(mFgtv, mFgtv.getTransitionName());
//            平滑的将一个控件平移的过渡到第二个activity
            ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(getActivity(), pair1);
            startActivity(mIntent, options.toBundle());
        } else {
            startActivity(mIntent);
        }
    }


}
