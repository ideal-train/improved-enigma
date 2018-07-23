package com.xprogect.function;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.xprogect.adapter.FunctionAdapter;
import com.xprogect.application.R;
import com.xprogect.dagger.Dagger2Activity;
import com.xprogect.x_library.base.BaseTooBarActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class FunctionActivity extends BaseTooBarActivity {


    @BindView(R.id.recy_list)
    RecyclerView mRecyclerView;

    FunctionAdapter mAdapter;
    List<String> data;

    @Override
    public int setContentViewID() {
        return R.layout.activity_function;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        setTitle("干好你们不回来吃列表");
        data = new ArrayList<>();
        data.add("Dagger2");
        mAdapter = new FunctionAdapter(this, R.layout.item_function, data);
        mAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                switch (position) {
                    case 0:
                        startActivity(new Intent(FunctionActivity.this, Dagger2Activity.class));
                        break;
                    default:
                        break;
                }
            }
        });
        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 1));
        mRecyclerView.setAdapter(mAdapter);
    }

}
