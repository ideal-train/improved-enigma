package com.xprogect.home;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.xprogect.application.R;
import com.xprogect.enums.OhterWay;
import com.xprogect.test.TitleActivity;
import com.xprogect.x_library.base.BaseFragment;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 首页
 */
public class HomeFragment extends BaseFragment {
    @BindView(R.id.fg_tv)
    TextView fg_tv;

    private int  page=-1;
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
        fg_tv.setText( OhterWay.getFlavour(page=bundle.getInt("home")));


//        otherWay(OhterWay.FIND_1);


    }


    private void otherWay(@OhterWay.Flavour int type){

    }

    @OnClick(R.id.fg_tv)
    protected void mClick(){
        startActivity(new Intent(getActivity(), TitleActivity.class).putExtra("page",page));
    }


}
