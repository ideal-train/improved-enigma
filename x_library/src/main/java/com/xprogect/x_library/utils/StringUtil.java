package com.xprogect.x_library.utils;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DecimalFormat;
import java.util.Random;


@SuppressLint("SimpleDateFormat")
public class StringUtil {
    private final static String HEX = "0123456789ABCDEF";

    public static String toMD5(String source) {
        if (null == source || "".equals(source)) return null;
        try {
            MessageDigest digest = MessageDigest.getInstance("MD5");
            digest.update(source.getBytes());
            return toHex(digest.digest());
        } catch (NoSuchAlgorithmException e) {
        }
        return null;
    }

    /**
     * 判断是否是null或长度为0
     *
     * @param str 要判断字符串
     * @return 空：true
     */
    public static boolean isNullOrEmpty(String str) {
        try {
            if (str == null)
                return true;
            if (str.length() == 0)
                return true;
            if (str.isEmpty())
                return true;
            if (str.replace(" ", "").equalsIgnoreCase("null"))
                return true;
            if ("".equals(str.replace(" ", "")))
                return true;
        } catch (Exception e) {
            return true;
        }
        return false;
    }


    public static String toHex(byte[] buf) {
        if (buf == null) return "";
        StringBuffer result = new StringBuffer(2 * buf.length);
        for (int i = 0; i < buf.length; i++) {
            appendHex(result, buf[i]);
        }
        return result.toString();
    }

    private static void appendHex(StringBuffer sb, byte b) {
        sb.append(HEX.charAt((b >> 4) & 0x0f)).append(HEX.charAt(b & 0x0f));
    }


    /**
     * 区间随机数
     *
     * @param min 区间最小值
     * @param max 区间最大值
     * @return 区间正随机 整数
     */
    public static int intRandom(int min, int max) {
//        Random random = new Random();
//        login_return random.nextInt(max) % (max - min + 1) + min;

        if (min > max) {
            return 0;
        }
        if (min == max) {
            return min;
        }
        return new Random().nextInt(max - min + 1) + min;
    }

    /**
     * 区间随机数
     * @param min 区间最小值
     * @param max 区间最大值
     * @return 区间正随机小数
     */
    public static String douRandom(int min, int max) {

        if (min > max) {
            return "0";
        }
        if (min == max) {
            return String.valueOf(min);
        }
        double money = (new Random().nextDouble() * (20 - 1) + 1);
        DecimalFormat df = new DecimalFormat("#.00");
        return df.format(money);
    }


    /**
     * 复制文本到剪贴板
     *
     * @param text 文本
     */
    public static void copyText(Context context,CharSequence text) {
        // 得到剪贴板管理器
        ClipboardManager clipboard = (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
        clipboard.setPrimaryClip(ClipData.newPlainText("text", text));
    }

}
