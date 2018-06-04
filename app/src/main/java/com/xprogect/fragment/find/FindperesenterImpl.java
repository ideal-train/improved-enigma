package com.xprogect.fragment.find;


import com.xprogect.api.FindClick;
import com.xprogect.api.ServiceGenerator;
import com.xprogect.api.init.SubscriberFactory;
import com.xprogect.bean.HomeBean;

import rx.Observable;

/**
 * Created by Administrator on 2018/3/21
 * function：
 */

public class FindperesenterImpl implements FindContart.Presenter {

    private FindContart.View mView;
    private FindClick mTestClick;

    public FindperesenterImpl(FindContart.View mView) {
        this.mView = mView;
        mTestClick = ServiceGenerator.createRetrofitService(FindClick.class);
    }


    @Override
    public void getFindUrl() {
        Observable<HomeBean> observable = ServiceGenerator.filterStatus(mTestClick.getUrl(null));

        observable
                .subscribe(new SubscriberFactory<HomeBean>(mView._getContext()) {
                    @Override
                    public void onNext(HomeBean data) {
                        mView.requestSuccess(data);
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        mView.requestError();
                    }
                });

        //    mTestClick.getUrl2(null)
//            .subscribeOn(Schedulers.io())
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribe(new Subscriber<HomeBean>() {
//        @Override
//        public void onCompleted() {
//
//        }
//
//        @Override
//        public void onError(Throwable e) {
//
//        }
//
//        @Override
//        public void onNext(HomeBean homeBean) {
//
//        }
//    });
    }
}
