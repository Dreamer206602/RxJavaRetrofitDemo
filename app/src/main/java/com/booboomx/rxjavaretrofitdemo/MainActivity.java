package com.booboomx.rxjavaretrofitdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.booboomx.rxjavaretrofitdemo.ui.activity.JdActivity;
import com.booboomx.rxjavaretrofitdemo.ui.activity.RxJavaActivity;

public class MainActivity extends AppCompatActivity {

    private Button  mButtonJD,mButtonTmall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mButtonJD= (Button) findViewById(R.id.btn_jd);
        mButtonTmall= (Button) findViewById(R.id.btn_Tmall);

        mButtonJD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, JdActivity.class));
            }
        });
        mButtonTmall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, RxJavaActivity.class));


            }
        });
    }
}
