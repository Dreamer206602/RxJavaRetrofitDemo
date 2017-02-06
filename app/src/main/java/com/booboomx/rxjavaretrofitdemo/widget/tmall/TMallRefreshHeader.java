package com.booboomx.rxjavaretrofitdemo.widget.tmall;

import android.content.Context;
import android.support.annotation.AttrRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.booboomx.rxjavaretrofitdemo.R;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import in.srain.cube.views.ptr.PtrFrameLayout;
import in.srain.cube.views.ptr.PtrUIHandler;
import in.srain.cube.views.ptr.indicator.PtrIndicator;

/**
 * Created by booboomx on 17/2/6.
 */

public class TMallRefreshHeader extends FrameLayout implements PtrUIHandler {

//    private SimpleDraweeView mSimpleDraweeView;
    private TextView mTvRemind;

    private int mState;
    /**
     * 重置
     * 准备
     * 开始刷新
     * 结束刷新
     */
    public static final int STATE_RESET=-1;
    public static final int STATE_PREPARE=0;
    public static final int STATE_BEGIN=1;
    public static final int STATE_FINISH=2;



    public TMallRefreshHeader(@NonNull Context context) {
        super(context);
        initView();
    }

    public TMallRefreshHeader(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public TMallRefreshHeader(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    private void  initView(){
        View view= LayoutInflater.from(getContext()).inflate(R.layout.tmall_refresh_head_view,this,false);

        mTvRemind= (TextView) view.findViewById(R.id.tv_remind);

        ImageView imageView= (ImageView) view.findViewById(R.id.iv_tmall_logo);
        Glide.with(getContext())
                .load(R.drawable.tm_mui_bike)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(imageView);

        addView(view);


    }

    @Override
    public void onUIReset(PtrFrameLayout frame) {

        mState=STATE_RESET;

    }

    @Override
    public void onUIRefreshPrepare(PtrFrameLayout frame) {
        mState=STATE_PREPARE;


    }

    @Override
    public void onUIRefreshBegin(PtrFrameLayout frame) {
        mState=STATE_BEGIN;


    }

    @Override
    public void onUIRefreshComplete(PtrFrameLayout frame) {
        mState=STATE_FINISH;

    }

    @Override
    public void onUIPositionChange(PtrFrameLayout frame, boolean isUnderTouch, byte status, PtrIndicator ptrIndicator) {

        switch (mState){
            case STATE_PREPARE:
                if(ptrIndicator.getCurrentPercent()<1.2){
                    mTvRemind.setText("下拉刷新...");
                }else{
                    mTvRemind.setText("松开立即刷新...");
                }
                break;

            case STATE_BEGIN:
                mTvRemind.setText("正在刷新...");
                break;
            case STATE_FINISH:
                mTvRemind.setText("刷新完成...");
                break;



        }


    }
}
