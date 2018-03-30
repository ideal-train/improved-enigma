package com.xprogect.x_library.utils;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.Window;


public class DialogUtil {
// ((Activity) context).finish();

    public static AlertDialog getAlertDialog(Context context, String msg, String btName) {
        final AlertDialog alert = new AlertDialog.Builder(context).create();
        alert.setMessage(msg);
        alert.setButton(DialogInterface.BUTTON_NEGATIVE, btName, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                alert.dismiss();
            }
        });
        return alert;
    }

    public static AlertDialog getAlertDialog(Context context, String msg, String btName,
                                             DialogInterface.OnClickListener onclickListener) {
        final AlertDialog alert = new AlertDialog.Builder(context).create();
        alert.setMessage(msg);
        alert.setCancelable(false);
        alert.setButton(DialogInterface.BUTTON_POSITIVE, btName, onclickListener);
        return alert;
    }


    /**
     * 错误提示
     *
     * @param content 提示内容无标题
     */
    public static void errorDialog(Context context, String content) {
        // TODO Auto-generated method stub
        // // THEME_DEVICE_DEFAULT_LIGHT THEME_HOLO_LIGHT
        new AlertDialog.Builder(context, AlertDialog.THEME_HOLO_LIGHT)
                .setTitle("\n" + content + "\n")
                .setIcon(android.R.drawable.ic_dialog_info)
                .setNegativeButton("确认", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // 点击“返回”后的操作,这里不设置没有任何操作
                    }
                }).show();
    }

    /**
     * 成功提示
     *
     * @param title 提示标题
     */
    public static void successDialog(final Context context, String title, DialogInterface.OnClickListener onclickListener) {
        new AlertDialog.Builder(context)
                .setTitle(" \n" + title + " \n")
                .setIcon(android.R.drawable.ic_dialog_info)
                .setNegativeButton("确认",onclickListener)
                .setPositiveButton("取消",
                        new DialogInterface.OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialog,
                                                int which) {
                                // 点击“确认”后的操作
                                ((Activity) context).finish();
                            }
                        }).show();

    }



    /**
     * 网络请求默认的加载框(返回键dialog不消失)
     *
     * @param context
     * @param msg
     * @return
     */
    public static ProgressDialog getProgressDialog(Context context, String msg) {
        return getProgressDialog(context, msg, false);
    }

    /**
     * 网络请求默认的加载框
     *
     * @param context
     * @param msg
     * @param isCancelable
     * @return
     */
    public static ProgressDialog getProgressDialog(Context context, String msg, boolean isCancelable) {
        ProgressDialog progressDialog = new ProgressDialog(context);
        progressDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        progressDialog.setMessage(msg);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
//      false-->dialog弹出后会点击屏幕或物理返回键，dialog不消失
        progressDialog.setCancelable(isCancelable);
//        dialog弹出后会点击屏幕，dialog不消失；点击物理返回键dialog消失
//        progressDialog.setCanceledOnTouchOutside(false);

        return progressDialog;
    }
}
