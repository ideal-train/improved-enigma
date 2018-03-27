package com.xprogect.x_library.utils;

import android.view.View;

import rx.Observable;
import rx.Subscriber;

/**
 * Created by Administrator on 2018/3/27
 * function：
 */

public class RxOnSubscribe implements Observable.OnSubscribe<View>{
    public RxOnSubscribe(View view) {
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("我被狂点中...");
                //发布通知
                mSubscriber.onNext(view);
            }
        });
    }
    private Subscriber mSubscriber;

    @Override
    public void call(Subscriber<? super View> subscriber) {
        mSubscriber = subscriber;
    }
}
