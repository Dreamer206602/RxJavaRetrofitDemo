package com.booboomx.rxjavaretrofitdemo.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.booboomx.rxjavaretrofitdemo.R;
import com.booboomx.rxjavaretrofitdemo.utils.ImageLoader;

public class ImageActivity extends AppCompatActivity {

    private ImageView image;
    private String url;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);


        image= (ImageView) findViewById(R.id.imageView);

        url=getIntent().getStringExtra("img");

        ImageLoader.load(this,url,image);
    }
}
