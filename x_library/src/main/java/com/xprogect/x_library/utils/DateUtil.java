package com.xprogect.x_library.utils;

import android.annotation.SuppressLint;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SuppressLint("SimpleDateFormat")
public class DateUtil {

    public static String getcurrentTime(String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        String date = sdf.format(new Date(System.currentTimeMillis()));
        return date;
    }

    /**
     * @return 当前标准时间 yyyy-MM-dd HH:mm:ss
     */
    public static String getTime() {
        return getcurrentTime("yyyy-MM-dd  HH:mm:ss");

    }

    /**
     * @return 当前时间  毫秒
     */
    public static Long getCurTime() {
        Date curDate = new Date(System.currentTimeMillis());
        return curDate.getTime();

    }

    /**
     * 获取字符中的数字
     */
    public static String getNumber(CharSequence value) {
        String regEx = "[^0-9]";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(value);
        regEx = m.replaceAll("").trim();
        return regEx.equals("") ? "-1" : regEx;
    }

    public static Date getMessageSendingDateTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String date1 = sdf.format(new Date(System.currentTimeMillis()));
        Date date = Date.valueOf(date1);
        return date;

    }

    /**
     * 按照给定的格式化字符串格式化日期
     *
     * @param dateStr   时间字符串
     * @param formatStr yyyy-MM-dd  HH:mm:ss
     * @return
     * @throws ParseException
     */
    public static String formatDate(String dateStr, String formatStr)
            throws ParseException {
        java.util.Date date = null;
        date = parseDate(getNumber(dateStr));
        SimpleDateFormat sdf = new SimpleDateFormat(formatStr);
        return sdf.format(date);
    }


    /**
     * 按照给定的格式化字符串解析日期
     * @param dateStr   时间字符串
     * @param formatStr yyyy-MM-dd  HH:mm:ss
     * @return
     * @throws ParseException
     */
    public static java.util.Date parseDate(String dateStr, String formatStr)
            throws ParseException {
        java.util.Date date = null;
        if (dateStr != null) {
            SimpleDateFormat sdf = new SimpleDateFormat(formatStr);
            date = sdf.parse(dateStr);
        }
        return date;
    }

    /**
     * 时间戳转换成日期格式字符串
     *
     * @param seconds 精确到秒的字符串
     * @return
     */
    public static String timeStamp2Date(String seconds, String format) {
        if (seconds == null || seconds.isEmpty() || seconds.equals("null")) {
            return "";
        }
        if (format == null || format.isEmpty())
            format = "yyyy-MM-dd HH:mm:ss";
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(new Date(Long.valueOf(seconds + "000")));
    }

    /**
     * 日期格式字符串转换成时间戳
     *
     * @param date_str   字符串日期
     * @param format 如：yyyy-MM-dd HH:mm:ss
     * @return
     */
    public static String date2TimeStamp(String date_str, String format) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            return String.valueOf(sdf.parse(date_str).getTime() / 1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    // 从字符串中分析日期
    public static java.util.Date parseDate(String dateStr)
            throws ParseException {
        java.util.Date date = null;
        if (dateStr != null) {
            String[] dateArray = dateStr.split("\\D+"); // +防止多个非数字字符在一起时导致解析错误
            int dateLen = dateArray.length;
            int dateStrLen = dateStr.length();
            if (dateLen > 0) {
                if (dateLen == 1 && dateStrLen > 4) {
                    if (dateStrLen == "yyyyMMddHHmmss".length()) {
                        // 如果字符串长度为14位并且不包含其他非数字字符，则按照（yyyyMMddHHmmss）格式解析
                        date = parseDate(dateStr, "yyyyMMddHHmmss");
                    } else if (dateStrLen == "yyyyMMddHHmm".length()) {
                        date = parseDate(dateStr, "yyyyMMddHHmm");
                    } else if (dateStrLen == "yyyyMMddHH".length()) {
                        date = parseDate(dateStr, "yyyyMMddHH");
                    } else if (dateStrLen == "yyyyMMdd".length()) {
                        date = parseDate(dateStr, "yyyyMMdd");
                    } else if (dateStrLen == "yyyyMM".length()) {
                        date = parseDate(dateStr, "yyyyMM");
                    } else if (dateStrLen == "yyyy-MM-dd HH:MM".length()) {
                        date = parseDate(dateStr, "yyyy-MM-dd HH:MM");
                    }
                } else {
                    String fDateStr = dateArray[0];
                    for (int i = 1; i < dateLen; i++) {
                        // 左补齐是防止十位数省略的情况
                        fDateStr += leftPad(dateArray[i], "0", 2);
                    }

                    if (dateStr.trim().matches(
                            "^\\d{1,2}:\\d{1,2}(:\\d{1,2})?$")) {
                        // 补充年月日3个字段
                        dateLen += 3;
                        fDateStr = formatDate(new java.util.Date(), "yyyyMMdd")
                                + fDateStr;
                    }

                    date = parseDate(fDateStr, "yyyyMMddHHmmss".substring(0,
                            (dateLen - 1) * 2 + 4));
                }
            }
        }

        return date;
    }
    // 按照给定的格式化字符串格式化日期
    public static String formatDate(java.util.Date date, String formatStr) {
        if (date != null) {
            SimpleDateFormat sdf = new SimpleDateFormat(formatStr);
            return sdf.format(date);
        } else {
            return null;
        }
    }
    // 左补齐
    public static String leftPad(String str, String pad, int len) {
        String newStr = (str == null ? "" : str);
        while (newStr.length() < len) {
            newStr = pad + newStr;
        }
        if (newStr.length() > len) {
            newStr = newStr.substring(newStr.length() - len);
        }
        return newStr;
    }


}
