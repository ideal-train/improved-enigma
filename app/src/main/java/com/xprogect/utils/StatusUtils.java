package com.xprogect.utils;


import com.xprogect.contests.RequestCons;

/**
 * Created by mango on 2016/10/8.
 */
public class StatusUtils {

    public static class StatusResult {
        private int status;
        private String desc;
        private boolean isSuccess;

        public String getException() {
            return "错误码：" + mStatusResult.status +
                    "错误信息：" + mStatusResult.desc;
        }
    }

    private static StatusResult mStatusResult = new StatusResult();

    public static StatusResult judgeStatus(int status, String message) {

        String desc = "";
        boolean isSuccess = false;
        switch (status) {
            case RequestCons.STATUS_SUCCESS:
                desc = RequestCons.SUCCESS_MSG;
                isSuccess = true;
                break;
            case RequestCons.STATU_1000:
                desc = RequestCons.FAILURE_1000;
                break;
            default:
                desc = message;
                break;

        }
        mStatusResult.status = status;
        mStatusResult.desc = desc;
        mStatusResult.isSuccess = isSuccess;
        return mStatusResult;
    }}

