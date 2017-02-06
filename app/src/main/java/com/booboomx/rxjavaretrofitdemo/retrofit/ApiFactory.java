package com.booboomx.rxjavaretrofitdemo.retrofit;

/**
 * Created by booboomx on 17/2/6.
 */

public class ApiFactory {


    public static  ApiService mApiService=null;
    public static final Object monitor = new Object();



    public static ApiService getApiService() {
        synchronized (monitor) {
            if (mApiService== null) {
                mApiService = new ApiRetrofit().getApiService();
            }
            return mApiService;
        }
    }





}
