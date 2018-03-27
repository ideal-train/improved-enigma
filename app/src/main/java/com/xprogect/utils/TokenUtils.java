package com.xprogect.utils;

import android.content.Context;
import android.text.TextUtils;

import com.xprogect.x_library.utils.SharePreUtils;


/**
 * Created by Administrator on 2017/8/31    14:56
 * <p>
 * 用户认证相关
 */

public class TokenUtils {

    private static final String TOKEN_KEY = "token";
    private static String token;

    public static void saveToken(Context context, String tokenValue) {
        if (context != null && !TextUtils.isEmpty(tokenValue)) {
            SharePreUtils.put(context, TOKEN_KEY, tokenValue);
        }
        token = tokenValue;
    }

    public static String getToken(Context context) {
        if (TextUtils.isEmpty(token) && context != null) {
            token = (String) SharePreUtils.get(context, TOKEN_KEY, "");
        }
        return token;
    }

    public static void cleanToken(Context context) {
        token = null;
        if (context != null) {
            SharePreUtils.remove(context, TOKEN_KEY);
        }
    }

}
