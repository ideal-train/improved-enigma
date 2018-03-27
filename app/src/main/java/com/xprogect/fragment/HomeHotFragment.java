package com.xprogect.fragment;


import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.xprogect.application.R;
import com.xprogect.enums.OhterWay;
import com.xprogect.x_library.base.BaseFragment;

import butterknife.BindView;

/**
 * 热门
 */
public class HomeHotFragment extends BaseFragment {
    @BindView(R.id.fg_tv)
    TextView fg_tv;

    private static HomeHotFragment myFragment;

    public static HomeHotFragment getInstance() {
        myFragment = new HomeHotFragment();
        return myFragment;
    }

    public HomeHotFragment() {
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
        fg_tv.setText(bundle.getString("home"));

        OhterWay.getFlavour(OhterWay.CHOCOLATE);
        otherWay(OhterWay.CHOCOLATE);


    }


    private void otherWay(@OhterWay.Flavour int type){

    }
}
