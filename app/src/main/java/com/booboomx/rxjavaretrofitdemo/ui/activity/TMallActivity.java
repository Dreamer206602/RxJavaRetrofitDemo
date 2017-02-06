package com.booboomx.rxjavaretrofitdemo.ui.activity;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.booboomx.rxjavaretrofitdemo.R;
import com.booboomx.rxjavaretrofitdemo.ui.adapter.StringAdapter;
import com.booboomx.rxjavaretrofitdemo.widget.tmall.TMallRefreshLayout;

import java.util.ArrayList;

import in.srain.cube.views.ptr.PtrDefaultHandler;
import in.srain.cube.views.ptr.PtrFrameLayout;

public class TMallActivity extends AppCompatActivity {

    private TMallRefreshLayout mTMallRefreshLayout;
    private RecyclerView mRecyclerView;

    private StringAdapter mAdapter;
    private ArrayList<String>mStrings=new ArrayList<>();
    private Handler mHandler=new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tmall);

        mTMallRefreshLayout= (TMallRefreshLayout) findViewById(R.id.refreshLayout_Tmall);
        mRecyclerView= (RecyclerView) findViewById(R.id.recyclerView);

        for (int i = 0; i < 30; i++) {
            mStrings.add("TMall");
        }

        mAdapter=new StringAdapter(mStrings);
        mRecyclerView.setAdapter(mAdapter);


        mTMallRefreshLayout.setPtrHandler(new PtrDefaultHandler() {
            @Override
            public void onRefreshBegin(PtrFrameLayout frame) {

                doString();

            }
        });




    }

    private void doString(){

        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                mTMallRefreshLayout.refreshComplete();

            }
        },3000);

    }
}
