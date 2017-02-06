package com.booboomx.rxjavaretrofitdemo.widget.tmall;

import android.content.Context;
import android.util.AttributeSet;

import in.srain.cube.views.ptr.PtrFrameLayout;

/**
 * Created by booboomx on 17/2/6.
 */

public class TMallRefreshLayout extends PtrFrameLayout {
    private TMallRefreshHeader mTMallRefreshHeader;

    public TMallRefreshLayout(Context context) {
        super(context);
        initView();
    }

    public TMallRefreshLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }



    public TMallRefreshLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initView();
    }

    private void initView(){
        mTMallRefreshHeader=new TMallRefreshHeader(getContext());
        setHeaderView(mTMallRefreshHeader);
        addPtrUIHandler(mTMallRefreshHeader);


    }
}
