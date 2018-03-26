package com.xprogect.x_library.utils;

import android.content.Context;
import android.support.annotation.NonNull;
import android.widget.Toast;

/**
 * 吐司工具类
 */
public class ToastUtil {
    private static Toast TOAST;
    private static final String TAG = "ToastUtil";


    /**
     * 短时间吐司
     *
     * @param context
     * @param resourceID
     */
    public static void show(Context context, int resourceID) {
        show(context, resourceID, Toast.LENGTH_SHORT);
    }

    /**
     * 短时间吐司
     *
     * @param context
     * @param text
     */
    public static void show(Context context, String text) {
        show(context, text, Toast.LENGTH_SHORT);
    }

    //自定义时长吐司
    public static void show(Context context, Integer resourceID, int duration) {
        // 用于显示的文字
        String text = context.getResources().getString(resourceID);
        show(context, text, duration);
    }

    //自定义时长吐司
    public static void show(@NonNull final Context context, @NonNull final String text, final int duration) {

        if (TOAST == null) {
            TOAST = Toast.makeText(context, text, duration);
        } else {
            TOAST.setText(text);
            TOAST.setDuration(duration);
        }

        TOAST.show();
    }
}