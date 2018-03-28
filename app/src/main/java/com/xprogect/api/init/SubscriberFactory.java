package com.xprogect.api.init;

import com.google.gson.JsonSyntaxException;
import com.xprogect.x_library.utils.MyLog;

import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.util.concurrent.TimeoutException;

import rx.Subscriber;

/**
 * Created by mango on 16/8/18.
 */
public abstract class SubscriberFactory<T> extends Subscriber<T> {

    public String error;
    @Override
    public abstract void onCompleted();

    @Override
    public void onError(Throwable e) {
        if (e instanceof TimeoutException || e instanceof SocketTimeoutException
                || e instanceof ConnectException){
            error = "超时了";
        }else if (e instanceof JsonSyntaxException){
            error = "Json格式出错了";
            //假如导致这个异常触发的原因是服务器的问题，那么应该让服务器知道，所以可以在这里
            //选择上传原始异常描述信息给服务器
        }else {
            error = e.getMessage();
        }
        MyLog.e("ApiException "+error);
    }

    @Override
    public abstract void onNext(T data);
}
