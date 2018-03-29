package com.xprogect.api;

import com.xprogect.api.init.BeanFactory;
import com.xprogect.bean.HomeBean;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by Administrator on 2018/3/21
 * function：
 */

public interface FindClick {

//    {{host}}getInfo?channel=APP&is_tj=0&page=1&num=10&types=1001

//    @GET("getInfo/")
//    Observable<BeanFactory<HomeBean>> getUrl(@Query("channel") String channel,
//                                             @Query("is_tj") int is_tj,
//                                             @Query("num") int num,
//                                             @Query("types") int types,
//                                             @Query("page") int page);

    @GET("index")
    Observable<BeanFactory<HomeBean>> getUrl(@Query("ep") String ep);

    @GET("index")
    Observable<HomeBean> getUrl2(@Query("ep") String ep);
}
