package com.booboomx.rxjavaretrofitdemo.app;

import android.app.Application;

/**
 * Created by booboomx on 17/2/6.
 */

public class BaseApplication extends Application {
    public static  BaseApplication mInstance;

    public static BaseApplication getInstance(){
        return mInstance;
    }


    @Override
    public void onCreate() {
        super.onCreate();
        mInstance=this;
    }
}
