package com.booboomx.rxjavaretrofitdemo.ui.adapter;

import com.booboomx.rxjavaretrofitdemo.R;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * Created by booboomx on 17/tree2/6.
 */

public class StringAdapter extends BaseQuickAdapter<String,BaseViewHolder> {

    public StringAdapter(List<String> data) {
        super(R.layout.item_list,data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {

        helper.setText(R.id.tv_title,item);

    }
}
