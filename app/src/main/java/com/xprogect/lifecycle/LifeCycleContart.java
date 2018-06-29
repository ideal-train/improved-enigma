package com.xprogect.lifecycle;

import com.xprogect.bean.HomeBean;
import com.xprogect.x_library.basemvp.BaseView;

/**
 * Created by Administrator on 2018/3/21
 * function：
 */

public interface LifeCycleContart  {
    interface View extends BaseView{

        void requestSuccess(HomeBean bean);

        void requestError();
    }

    interface Presenter {
        void getFindUrl();
    }
}
