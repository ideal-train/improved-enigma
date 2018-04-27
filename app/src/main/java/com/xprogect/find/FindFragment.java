package com.xprogect.find;


import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.xprogect.application.R;
import com.xprogect.bean.HomeBean;
import com.xprogect.enums.OhterWay;
import com.xprogect.x_library.base.BaseFragment;
import com.xprogect.x_library.utils.MyLog;
import com.xprogect.x_library.utils.SPUtil;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 发现
 */
public class FindFragment extends BaseFragment implements FindContart.View {
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
        fg_tv.setText(OhterWay.getFlavour(bundle.getInt("home")) + "--点击进行网络请求");
        mPresenter = new FindperesenterImpl(this);
    }


    private void otherWay(@OhterWay.Flavour int type) {

    }

    @OnClick(R.id.fg_tv)
    protected void mClick() {
        mPresenter.getFindUrl();
    }

    @Override
    public void requestSuccess(HomeBean bean) {
        SPUtil config = SPUtil.getInstance(getActivity());
        SPUtil.getInstance(getActivity(),"test").put("test","test");
        if (config.saveObjectToShare("HomeBean", bean)) {
            HomeBean mHomeBean=config.getObjectFromShare("HomeBean");
            toast(mHomeBean.getHotProductList().get(0).getName());

        }

        if(config.contains("test")){
            MyLog.d("test", "");
        }

    }

    @Override
    public void requestError() {

    }
}
