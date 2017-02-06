package com.booboomx.rxjavaretrofitdemo.widget.jd;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.support.annotation.AttrRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.booboomx.rxjavaretrofitdemo.R;

import in.srain.cube.views.ptr.PtrFrameLayout;
import in.srain.cube.views.ptr.PtrUIHandler;
import in.srain.cube.views.ptr.indicator.PtrIndicator;

/**
 * Created by booboomx on 17/tree2/6.
 */

/**
 * 下拉刷新的header
 */
public class JdRefreshHeader extends FrameLayout implements PtrUIHandler {
    public static final String TAG="JdRefreshHeader";

    private TextView mTvRemind;

    /**
     * 快递员的logo
     */
    private ImageView mIvMain;

    private ImageView mIvGoods;

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

    public static final int MARGIN_RIGHT=100;


    /**
     * 动画
     */
    private AnimationDrawable mAnimation;



    public JdRefreshHeader(@NonNull Context context) {
        super(context);
        initView();
    }


    public JdRefreshHeader(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public JdRefreshHeader(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    private void initView() {

        View view= LayoutInflater.from(getContext()).inflate(R.layout.tree_refresh_head_view,this,false);

        mTvRemind= (TextView) view.findViewById(R.id.tv_remain);
        mIvMain= (ImageView) view.findViewById(R.id.iv_man);
//        mIvGoods= (ImageView) view.findViewById(R.id.iv_goods);
        addView(view);

    }


    @Override
    public void onUIReset(PtrFrameLayout frame) {
        mState=STATE_RESET;
        Log.i(TAG, "onUIReset: ");

    }

    @Override
    public void onUIRefreshPrepare(PtrFrameLayout frame) {
        mState=STATE_PREPARE;
        Log.i(TAG, "onUIRefreshPrepare: ");

    }

    @Override
    public void onUIRefreshBegin(PtrFrameLayout frame) {
        Log.i(TAG, "onUIRefreshBegin: ");
        mState=STATE_BEGIN;
        // 隐藏商品的logo，开启跑步的动画
        // TODO
//        mIvGoods.setVisibility(GONE);
//        mIvMain.setBackgroundResource(R.drawable.runningman);
        mIvMain.setBackgroundResource(R.drawable.runningtree);
        mAnimation= (AnimationDrawable) mIvMain.getBackground();
        if(!mAnimation.isRunning()){
            mAnimation.start();
        }


    }

    @Override
    public void onUIRefreshComplete(PtrFrameLayout frame) {
        Log.i(TAG, "onUIRefreshComplete: ");
        mState=STATE_FINISH;
        // TODO
//        mIvGoods.setVisibility(VISIBLE);
        //停止动画
        if(mAnimation.isRunning()){
            mAnimation.stop();
        }
//        mIvMain.setBackgroundResource(R.mipmap.a2a);
        mIvMain.setBackgroundResource(R.mipmap.tree5);

    }

    @Override
    public void onUIPositionChange(PtrFrameLayout frame, boolean isUnderTouch, byte status, PtrIndicator ptrIndicator) {

        Log.i(TAG, "onUIPositionChange: "+ptrIndicator.getCurrentPercent());
        switch (mState){
            case STATE_PREPARE:
                Log.i(TAG, "onUIPositionChange: STATE_PREPARE");
                // logo设置
                mIvMain.setAlpha(ptrIndicator.getCurrentPercent());
//                mIvGoods.setAlpha(ptrIndicator.getCurrentPercent());
                FrameLayout.LayoutParams mIvMainLayoutParams = (LayoutParams) mIvMain.getLayoutParams();
                if(ptrIndicator.getCurrentPercent()<=1){
                    mIvMain.setScaleX(ptrIndicator.getCurrentPercent());
                    mIvMain.setScaleY(ptrIndicator.getCurrentPercent());

//                    mIvGoods.setScaleX(ptrIndicator.getCurrentPercent());
//                    mIvGoods.setScaleY(ptrIndicator.getCurrentPercent());

                    int marginRight= (int) (MARGIN_RIGHT-MARGIN_RIGHT*ptrIndicator.getCurrentPercent());
                    mIvMainLayoutParams.setMargins(0,0,marginRight,0);
                    mIvMain.setLayoutParams(mIvMainLayoutParams);
                }

                if(ptrIndicator.getCurrentPercent()<1.2){
                    mTvRemind.setText("下拉刷新...");
                }else{
                    mTvRemind.setText("松开刷新...");
                }
                break;
            case STATE_BEGIN:
                Log.i(TAG, "onUIPositionChange: STATE_BEGIN");
                mTvRemind.setText("更新中...");
                break;
            case STATE_FINISH:
                Log.i(TAG, "onUIPositionChange: STATE_FINISH");
                mTvRemind.setText("更新完成...");
                break;

        }

    }
}
