package com.xprogect.x_library.utils;

import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;

/**
 * Created by ly on 2017/12/7.
 * 注释：
 */

public class ToolUtil {
    /**
     * 判断当前焦点是否是EditText及触摸区域。
     */
    public static boolean isShouldHideInput(View v, MotionEvent event) {
        if (v != null && (v instanceof EditText)) {
            int[] l = {0, 0};
            v.getLocationInWindow(l);
            int left = l[0], top = l[1], bottom = top + v.getHeight(), right = left
                    + v.getWidth();
            if (event.getRawY() > top && event.getRawY() < bottom) {
            // 点击EditText的事件，忽略它
                return false;
            } else {
                return true;
            }

        }
        return false;
    }
    //(x,y)是否在view的区域内
    public static boolean isTouchPointInView(View view, int x, int y) {
        if (view == null) {
            return false;
        }
        int[] location = new int[2];
        view.getLocationOnScreen(location);
        int left = location[0];
        int top = location[1];
        int right = left + view.getMeasuredWidth();
        int bottom = top + view.getMeasuredHeight();
        //view.isClickable() &&
        if (y >= top && y <= bottom && x >= left
                && x <= right) {
            return true;
        }
        return false;
    }
    public static View getTouchTarget(View view, int x, int y) {
        View targetView = null;
        // 判断view是否可以聚焦
        ArrayList<View> TouchableViews = view.getTouchables();
        for (View child : TouchableViews) {
            if (isTouchPointInView(child, x, y)) {
                targetView = child;
                break;
            }
        }
        return targetView;
    }


}
