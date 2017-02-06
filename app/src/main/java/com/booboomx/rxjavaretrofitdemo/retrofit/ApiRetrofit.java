package com.booboomx.rxjavaretrofitdemo.retrofit;

import android.util.Log;

import com.booboomx.rxjavaretrofitdemo.app.BaseApplication;

import java.io.File;
import java.io.IOException;

import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.ResponseBody;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by booboomx on 17/2/6.
 */

public class ApiRetrofit {


    public ApiService getApiService() {
        return mApiService;
    }

    private ApiService mApiService;

    public static final String  ZHIHU_BASE_URL="http://news-at.zhihu.com/api/4/";
    public static final String GANK_BASE_URL = "http://gank.io/api/";
    public static final String DAILY_BASE_URL="http://app3.qdaily.com/app3/";



    ApiRetrofit(){
        File httpCacheDirectory=new File(BaseApplication.getInstance().getCacheDir(),"response");
        int cacheSize=10*1024*1024;
        Cache cache=new Cache(httpCacheDirectory,cacheSize);

        OkHttpClient client=new OkHttpClient.Builder()
                .addInterceptor(new LogInterceptor())
                .cache(cache)
                .build();

        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(ZHIHU_BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        mApiService=retrofit.create(ApiService.class);



    }



//    static  class  mInterceptor implements Interceptor {
//        @Override
//        public Response intercept(Chain chain) throws IOException {
//            CacheControl.Builder cacheBuilder = new CacheControl.Builder();
//            cacheBuilder.maxAge(0, TimeUnit.SECONDS);
//            cacheBuilder.maxStale(365, TimeUnit.DAYS);
//            CacheControl cacheControl = cacheBuilder.build();
//
//            Request request = chain.request();
//            Log.i("嗷大喵来打印日志咯", "request:" + request.toString());
//            if (!StateUtils.isNetworkAvailable(BaseApplication.getInstance())) {
//                request = request.newBuilder()
//                        .cacheControl(cacheControl)
//                        .build();
//            }
//            Response originalResponse = chain.proceed(request);
//            String content = originalResponse.body().string();
//            Log.i("嗷大喵来打印日志咯", "response body:" + content);
//            if (StateUtils.isNetworkAvailable(BaseApplication.getInstance())) {
//                int maxAge = 0; // read from cache
//                return originalResponse.newBuilder()
//                        .removeHeader("Pragma")
//                        .header("Cache-Control", "public ,max-age=" + maxAge)
//                        .build();
//            } else {
//                int maxStale = 60 * 60 * 24 * 28; // tolerate 4-weeks stale
//                return originalResponse.newBuilder()
//                        .removeHeader("Pragma")
//                        .header("Cache-Control", "public, only-if-cached, max-stale=" + maxStale)
//                        .build();
//            }
//
//        }
//    };
    /**
     //cache
     Interceptor REWRITE_CACHE_CONTROL_INTERCEPTOR = chain -> {

     CacheControl.Builder cacheBuilder = new CacheControl.Builder();
     cacheBuilder.maxAge(0, TimeUnit.SECONDS);
     cacheBuilder.maxStale(365, TimeUnit.DAYS);
     CacheControl cacheControl = cacheBuilder.build();

     Request request = chain.request();
     if (!StateUtils.isNetworkAvailable(MyApp.mContext)) {
     request = request.newBuilder()
     .cacheControl(cacheControl)
     .build();

     }
     Response originalResponse = chain.proceed(request);
     if (StateUtils.isNetworkAvailable(MyApp.mContext)) {
     int maxAge = 0; // read from cache
     return originalResponse.newBuilder()
     .removeHeader("Pragma")
     .header("Cache-Control", "public ,max-age=" + maxAge)
     .build();
     } else {
     int maxStale = 60 * 60 * 24 * 28; // tolerate 4-weeks stale
     return originalResponse.newBuilder()
     .removeHeader("Pragma")
     .header("Cache-Control", "public, only-if-cached, max-stale=" + maxStale)
     .build();
     }
     };
     */



    private static class LogInterceptor implements Interceptor {
        @Override
        public okhttp3.Response intercept(Chain chain) throws IOException {
            Request request = chain.request();
            Log.i("嗷大喵来打印日志咯", "request:" + request.toString());
            okhttp3.Response response = chain.proceed(chain.request());
            okhttp3.MediaType mediaType = response.body().contentType();
            String content = response.body().string();
            Log.i("嗷大喵来打印日志咯", "response body:" + content);
            if (response.body() != null) {
                ResponseBody body = ResponseBody.create(mediaType, content);
                return response.newBuilder().body(body).build();
            } else {
                return response;
            }
        }
    }

}
