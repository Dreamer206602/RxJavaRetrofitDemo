package com.booboomx.rxjavaretrofitdemo.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.booboomx.rxjavaretrofitdemo.R;
import com.booboomx.rxjavaretrofitdemo.intel.JavascriptInterface;

import static com.booboomx.rxjavaretrofitdemo.R.id.webView;

/**
 *  加载WebView的界面
 */
public class LoadWebViewActivity extends AppCompatActivity {

    private WebView mWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load_web_view);

        mWebView= (WebView) findViewById(webView);


        WebSettings settings =
                mWebView.getSettings();


        /**
         * 设置和JS交互的权限
         */
        settings.setJavaScriptEnabled(true);

        /**
         * 允许JS弹窗
         */
        settings.setJavaScriptCanOpenWindowsAutomatically(true);


        //防止中文的乱码
        settings.setDefaultTextEncodingName("UTF-8");

        //载入js代码
        // 格式规定为:file:///android_asset/文件名.html
//        mWebView.loadUrl("file:///android_asset/image.html");

//        mWebView.loadUrl("http://www.toutiao.com/a6401738581286682881/#p=1");

        mWebView.loadUrl("http://www.toutiao.com/a6405658200192205058/");



        //载入js
        mWebView.addJavascriptInterface(new JavascriptInterface(this), "imagelistner");


        mWebView.setWebViewClient(new WebViewClient(){

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);


                //这段js函数的功能就是注册监听，遍历所有的img标签，并添加onClick函数，函数的功能是在图片点击的时候调用本地java接口并传递url过去
                mWebView.loadUrl("javascript:(function(){"
                        + "var objs = document.getElementsByTagName(\"img\"); "
                        + "for(var i=0;i<objs.length;i++)  " + "{"
                        + "    objs[i].onclick=function()  " + "    {  "
                        + "        window.imagelistner.openImage(this.src);  "
                        + "    }  " + "}" + "})()");



            }
        });


    }
}
