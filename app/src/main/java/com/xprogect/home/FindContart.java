package com.xprogect.home;

import com.xprogect.bean.HomeBean;

/**
 * Created by Administrator on 2018/3/21
 * function：
 */

public interface FindContart {
    interface View {

        void requestSuccess(HomeBean bean);

        void requestError();
    }

    interface Presenter {
        void getFindUrl();
    }
}
