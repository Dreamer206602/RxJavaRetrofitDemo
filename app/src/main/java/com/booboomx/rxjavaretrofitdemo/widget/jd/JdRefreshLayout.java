package com.booboomx.rxjavaretrofitdemo.widget.jd;

import android.content.Context;
import android.util.AttributeSet;

import in.srain.cube.views.ptr.PtrFrameLayout;

/**
 * Created by booboomx on 17/2/6.
 */

public class JdRefreshLayout extends PtrFrameLayout {
    private JdRefreshHeader mJdRefreshHeader;
    public JdRefreshLayout(Context context) {
        super(context);
        initView();
    }

    public JdRefreshLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public JdRefreshLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initView();
    }

    private void initView() {
        mJdRefreshHeader=new JdRefreshHeader(getContext());
        setHeaderView(mJdRefreshHeader);
        addPtrUIHandler(mJdRefreshHeader);

    }
}
