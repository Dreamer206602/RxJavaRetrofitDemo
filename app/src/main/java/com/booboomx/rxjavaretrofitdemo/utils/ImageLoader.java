package com.booboomx.rxjavaretrofitdemo.utils;

/**
 * Created by booboomx on 17/3/28.
 */

import android.app.Activity;
import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

/**
 * 使用glide加载网络图片的工具类
 */
public class ImageLoader {


    /**
     * 使用Glide 加载ImageView（头像）不要使用占位图
     * @param context
     * @param url
     * @param iv
     */
    public static void load(Context context, String url, ImageView iv){
        Glide.with(context).load(url).crossFade().diskCacheStrategy(DiskCacheStrategy.SOURCE).into(iv);

    }


    public static void load(Activity activity, String url, ImageView iv){
        if(!activity.isDestroyed()){
            Glide.with(activity).load(url).crossFade().diskCacheStrategy(DiskCacheStrategy.SOURCE).into(iv);

        }

    }


    public static void loadAllImage(Activity activity, String url, ImageView iv){
        if(!activity.isDestroyed()){
            Glide.with(activity).load(url).diskCacheStrategy(DiskCacheStrategy.SOURCE).into(iv);

        }

    }


}
