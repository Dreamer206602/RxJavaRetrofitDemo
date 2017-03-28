package com.booboomx.rxjavaretrofitdemo.intel;

import android.content.Context;
import android.content.Intent;

import com.booboomx.rxjavaretrofitdemo.ui.activity.ImageActivity;

/**
 * Created by booboomx on 17/3/28.
 */
//  js通信的接口
public class JavascriptInterface {


    private Context mContext;

    public JavascriptInterface(Context context){
        this.mContext=context;
    }


    @android.webkit.JavascriptInterface
    public void openImage(String img){

        Intent intent=new Intent();
        intent.putExtra("img",img);
        intent.setClass(mContext, ImageActivity.class);
        mContext.startActivity(intent);

    }



}
