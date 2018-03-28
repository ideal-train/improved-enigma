package com.xprogect.find;


import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.xprogect.application.R;
import com.xprogect.bean.HomeBean;
import com.xprogect.enums.OhterWay;
import com.xprogect.x_library.base.BaseFragment;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 发现
 */
public class FindFragment extends BaseFragment implements FindContart.View{
    @BindView(R.id.fg_tv)
    TextView fg_tv;

    private static FindFragment myFragment;
    private FindContart.Presenter mPresenter;

    public static FindFragment getInstance() {
        myFragment = new FindFragment();
        return myFragment;
    }

    public FindFragment() {
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
        fg_tv.setText(OhterWay.getFlavour(bundle.getInt("home")));
        mPresenter = new FindperesenterImpl(this);
    }


    private void otherWay(@OhterWay.Flavour int type) {

    }

    @OnClick(R.id.fg_tv)
    protected void mClick(){
        mPresenter.getFindUrl();
    }

    @Override
    public void requestSuccess(HomeBean bean) {
        toast("---------------");

    }

    @Override
    public void requestError() {

    }
}
