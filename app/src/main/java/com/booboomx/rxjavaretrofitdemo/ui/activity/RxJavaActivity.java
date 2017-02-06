package com.booboomx.rxjavaretrofitdemo.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.booboomx.rxjavaretrofitdemo.R;
import com.booboomx.rxjavaretrofitdemo.bean.NewsTimeLineBean;
import com.booboomx.rxjavaretrofitdemo.retrofit.ApiFactory;
import com.booboomx.rxjavaretrofitdemo.retrofit.RxSubscribe;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class RxJavaActivity extends AppCompatActivity {

    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rx_java);

        mTextView= (TextView) findViewById(R.id.tv_content);


        ApiFactory.getApiService().getLatestNews()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new RxSubscribe<NewsTimeLineBean>(this) {
                    @Override
                    public void _onNext(NewsTimeLineBean newsTimeLineBean) {
                        mTextView.setText(newsTimeLineBean.getDate());
                    }
                    @Override
                    public void _onError(String msg) {

                    }
                });



    }
}
