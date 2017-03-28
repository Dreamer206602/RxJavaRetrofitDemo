package com.booboomx.rxjavaretrofitdemo.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;

import com.booboomx.rxjavaretrofitdemo.R;

/**
 *  加载WebView的界面
 */
public class LoadWebViewActivity extends AppCompatActivity {

    private WebView mWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load_web_view);

        mWebView= (WebView) findViewById(R.id.webView);




    }
}
