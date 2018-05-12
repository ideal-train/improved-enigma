package com.xprogect.contests;

/**
 * 常量池
 */
public class RequestCons {

    /**
     * 主机IP(域名)
	 请求协议://IP+端口/接口地址/接口参数/参数值
     */
    public static final String DOMAIN = "https://www.rongtousky.com/";
    /**
     * 接口版本
     */
    public static final String BASE_URL_V1 = "api/client/v1/";
    /**
     * 访问地址
     */
    public static final String BASE_URL = DOMAIN + BASE_URL_V1;

    public static final String APP_TAG = "android";

//  ------------------------网络请求相关Start-----------------------------------
    /**
     * 超时时间
     */
    public static final int DEFAULT_TIME_OUT = 30;

    public static final int STATUS_SUCCESS = 1001;
    public static final String SUCCESS_MSG = "成功";

    public static final int STATU_1000 = 1000;
    public static final String FAILURE_1000 = "调用权限失败";
//  ------------------------网络请求相关End-----------------------------------
}
