package com.xprogect.api.init;


import com.xprogect.utils.StatusUtils;

/**
 * Created by mango on 16/8/18.
 */
public class ApiException extends RuntimeException {

    public ApiException(int status, String message) {
        super(getErrorDesc(status, message));
    }

    private static String getErrorDesc(int status, String message) {
        return StatusUtils.judgeStatus(status, message).getException();
    }
}
