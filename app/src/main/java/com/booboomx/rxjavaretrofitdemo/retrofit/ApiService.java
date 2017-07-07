package com.booboomx.rxjavaretrofitdemo.retrofit;

import com.booboomx.rxjavaretrofitdemo.bean.NewsTimeLineBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by booboomx on 17/2/6.
 */

public interface ApiService {


    @GET("news/latest")
    Observable<NewsTimeLineBean> getLatestNews();



}
