package com.xprogect.adapter;

import android.content.Context;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.xprogect.application.R;

import java.util.List;
import java.util.Random;

/**
 * @author Administrator
 * @since 2018/7/18
 * function：
 */
public class FunctionAdapter extends BaseQuickAdapter<String, BaseViewHolder> {
    private Context mContext;
    private int mColor;
    public FunctionAdapter(Context context, int layoutResId, List<String> data) {
        super(layoutResId, data);
        this.mContext = context;
    }

    @Override
    protected void convert(final BaseViewHolder helper, String item) {
        Random random = new Random();
        mColor = 0xff000000 | random.nextInt(0xffffff);
        TextView mTextView=helper.getView(R.id.item_function);
        mTextView.setBackgroundColor(mColor);
        helper.setText(R.id.item_function, item);
    }

}