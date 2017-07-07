package com.booboomx.rxjavaretrofitdemo.ui.activity;

import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.booboomx.rxjavaretrofitdemo.R;
import com.booboomx.rxjavaretrofitdemo.utils.DensityUtil;

public class BottomDialogActivity extends AppCompatActivity {

    private Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_dialog);

        mButton = (Button) findViewById(R.id.btn_dialog);


        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                show();
                show2();
            }
        });
    }

    public void show() {


        Dialog dialog = new Dialog(this, R.style.BottomDialog);

        View view = LayoutInflater.from(this).inflate(R.layout.item_dialog_normal, null);


        dialog.setContentView(view);
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();


        layoutParams.width = getResources().getDisplayMetrics().widthPixels;
        view.setLayoutParams(layoutParams);

        dialog.getWindow().setGravity(Gravity.BOTTOM);
        dialog.getWindow().setWindowAnimations(R.style.BottomDialog_Animation);

        dialog.show();


    }

    public void show2() {

        Dialog dialog = new Dialog(this, R.style.BottomDialog);

        View view = LayoutInflater.from(this).inflate(R.layout.item_dialog_circle, null);


        dialog.setContentView(view);
        //1
        ViewGroup.MarginLayoutParams layoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();

        // 2
        layoutParams.width = getResources().getDisplayMetrics().widthPixels - DensityUtil.dp2px(this, 16);
        //3
        layoutParams.bottomMargin = DensityUtil.dp2px(this, 8);
        view.setLayoutParams(layoutParams);

        dialog.getWindow().setGravity(Gravity.BOTTOM);
        dialog.getWindow().setWindowAnimations(R.style.BottomDialog_Animation);

        dialog.show();


    }
}
