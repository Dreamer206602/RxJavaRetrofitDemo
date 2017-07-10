package com.booboomx.rxjavaretrofitdemo.ui.activity;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.booboomx.rxjavaretrofitdemo.R;
import com.booboomx.rxjavaretrofitdemo.ui.widget.MoveView;

public class DragPhotoActivity extends AppCompatActivity {

    private ImageView mImageView;
    private MoveView mMoveView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drag_photo);
        mImageView= (ImageView) findViewById(R.id.image);



        mMoveView=new MoveView(this);

//        final Bitmap bitmap = ((BitmapDrawable)mImageView.getDrawable()).getBitmap();

        mImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mImageView.setDrawingCacheEnabled(true);
                final Bitmap bitmap = Bitmap.createBitmap(mImageView.getDrawingCache());
                mImageView.setDrawingCacheEnabled(false);
                mMoveView.setOriginView(mImageView,bitmap);
            }
        });
    }
}
