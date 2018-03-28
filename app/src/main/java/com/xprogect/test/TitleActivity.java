package com.xprogect.test;

import com.xprogect.application.R;
import com.xprogect.enums.OhterWay;
import com.xprogect.x_library.base.BaseTooBarActivity;

/**
 * Created by Administrator on 2018/3/28
 * function：
 */
public class TitleActivity extends BaseTooBarActivity {
    @OhterWay.Flavour
    private int page;

    @Override
    public int setContentViewID() {
        return R.layout.fragment_home_hot;
    }

    @Override
    public void initView() {
        page = getIntent().getIntExtra("page", 0);
        switch (page) {
            case OhterWay.CHAT_2:
                setRightTxtTitleBar(OhterWay.getFlavour(page),"发布");
                break;
            case OhterWay.FIND_1:
                break;
            case OhterWay.HOME_0:
                setTitle(OhterWay.getFlavour(page));
                break;
            case OhterWay.MINE_3:
                getLayoutInflater().inflate(R.layout.bottom_bar, getBaseToolBar());
                break;
            default:
                break;
        }
    }

    @Override
    public void rightAction() {
        super.rightAction();
        toast("点击了右上角");
    }
}
