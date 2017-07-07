package com.booboomx.rxjavaretrofitdemo.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import com.booboomx.rxjavaretrofitdemo.R;
import com.booboomx.rxjavaretrofitdemo.ui.adapter.StringAdapter;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewLinearActivity extends AppCompatActivity {

    private StringAdapter mAdapter=new StringAdapter(null);
    private RecyclerView mRecyclerView;
    private List<String>mStrings=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view_linear);

        mRecyclerView= (RecyclerView) findViewById(R.id.recyclerView);


        for (int i = 0; i < 20; i++) {

            mStrings.add("Android===>"+i);
        }

        mAdapter.addData(mStrings);
        mRecyclerView.setAdapter(mAdapter);




    }
}
