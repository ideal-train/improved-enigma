package com.xprogect.api.init;

import android.app.Dialog;
import android.content.Context;

import com.google.gson.JsonSyntaxException;
import com.xprogect.MyApplication;
import com.xprogect.x_library.utils.DialogUtil;
import com.xprogect.x_library.utils.MyLog;
import com.xprogect.x_library.utils.ToastUtil;

import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.util.concurrent.TimeoutException;

import rx.Subscriber;

public abstract class SubscriberFactory<T> extends Subscriber<T> {

    public String error;

    private boolean showProgressDialog = false;
    private Dialog dialog;

    @Override
    public void onStart() {
        super.onStart();
        showProgressDialog();
    }

    public SubscriberFactory() {
    }

    /**
     * 传入上下文即为 有加载框(无加载框不需传入上下文)
     *
     * @param context 上下文
     */
    public SubscriberFactory(Context context) {
        this.showProgressDialog = true;
        dialog = DialogUtil.getProgressDialog(context, "加载中...", true);
    }

    /**
     * @param context 上下文
     * @param loadString 提示内容
     */
    public SubscriberFactory(Context context, String loadString) {
        this.showProgressDialog = true;
        dialog = DialogUtil.getProgressDialog(context, loadString, true);
    }

    @Override
    public void onCompleted() {
        hideProgressDialog();
    }

    @Override
    public void onError(Throwable e) {
        hideProgressDialog();
        if (e instanceof NetWorkInterceptor.NoNetworkException) {
            error = "请链接网络";
            ToastUtil.show(MyApplication.getContext(), error);
        } else if (e instanceof TimeoutException || e instanceof SocketTimeoutException
                || e instanceof ConnectException) {
            error = "超时了";
        } else if (e instanceof JsonSyntaxException) {
            error = "Json格式出错了";
            //假如导致这个异常触发的原因是服务器的问题，那么应该让服务器知道，所以可以在这里
            //选择上传原始异常描述信息给服务器
        } else {
            error = e.getMessage();
        }
        MyLog.e("ApiException " + error);
    }

    private void showProgressDialog() {
        if (showProgressDialog && dialog != null) {
            dialog.show();
        }
    }

    private void hideProgressDialog() {
        if (showProgressDialog && dialog != null && dialog.isShowing()) {
            dialog.dismiss();
        }
    }
}
