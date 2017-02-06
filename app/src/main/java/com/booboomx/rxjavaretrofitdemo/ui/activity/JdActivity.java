package com.booboomx.rxjavaretrofitdemo.ui.activity;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import com.booboomx.rxjavaretrofitdemo.R;
import com.booboomx.rxjavaretrofitdemo.ui.adapter.StringAdapter;
import com.booboomx.rxjavaretrofitdemo.widget.jd.JdRefreshLayout;

import java.util.ArrayList;

import in.srain.cube.views.ptr.PtrDefaultHandler;
import in.srain.cube.views.ptr.PtrFrameLayout;

public class JdActivity extends AppCompatActivity {

    private JdRefreshLayout mJdRefreshLayout;
    private RecyclerView mRecyclerView;

    private StringAdapter mAdapter;
    private ArrayList<String>mStrings=new ArrayList<>();
    private ArrayList<String>mNewStrings=new ArrayList<>();

    private Handler mHandler=new Handler();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jd);

        mJdRefreshLayout= (JdRefreshLayout) findViewById(R.id.refreshLayout);
        mRecyclerView= (RecyclerView) findViewById(R.id.recyclerView);


        for (int i = 0; i < 20; i++) {
            mStrings.add("I Love Android "+i);
        }

        mAdapter=new StringAdapter(mStrings);
        mRecyclerView.setAdapter(mAdapter);


        mJdRefreshLayout.setPtrHandler(new PtrDefaultHandler() {
            @Override
            public void onRefreshBegin(PtrFrameLayout frame) {

                doString();

            }
        });


    }


    private void  doString(){
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                mNewStrings.clear();
                for (int i = 0; i < 5; i++) {
                    mNewStrings.add(0,"I hate Android"+i);
                }
                mAdapter.addData(0,mNewStrings);
                mJdRefreshLayout.refreshComplete();

            }
        },3000);



    }










}
