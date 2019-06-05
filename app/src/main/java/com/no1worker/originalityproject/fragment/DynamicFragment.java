package com.no1worker.originalityproject.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.no1worker.common.CommonFragment;
import com.no1worker.originalityproject.R;
import com.no1worker.originalityproject.activity.CreateDynamicActivity;
import com.no1worker.originalityproject.adapter.DynamicAdapter;
import com.shuyu.textutillib.SmileUtils;

import java.util.ArrayList;
import java.util.List;

import me.leefeng.lfrecyclerview.LFRecyclerView;
import me.leefeng.lfrecyclerview.OnItemClickListener;

/**
 * 动态页面
 * Created by yuzhiyong on 2019/5/21.
 */

public class DynamicFragment extends CommonFragment implements LFRecyclerView.LFRecyclerViewListener{

    private LFRecyclerView rcvDynamicList;

    private DynamicAdapter adapter;

    private TextView tvTitle;
    private Button btnRightButton;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View contentView = inflater.inflate(R.layout.fragment_dynamic,container,false);
        findViews(contentView);
        initViews();
        return contentView;
    }

    private void findViews(View contentView) {
        rcvDynamicList = contentView.findViewById(R.id.rcvDynamicList);
        tvTitle = contentView.findViewById(R.id.tvTitle);
        btnRightButton = contentView.findViewById(R.id.btnRightButton);
    }


    private void initViews() {
        tvTitle.setText("动态");
        btnRightButton.setText("发布");
        btnRightButton.setVisibility(View.VISIBLE);
        initEmoji();
        /*设置属性*/
        rcvDynamicList.setLoadMore(true);//设置为可上拉加载,默认false,调用这个方法false可以去掉底部的“加载更多”
        rcvDynamicList.setAutoLoadMore(true);//设置滑动到底部自动加载,默认false
        rcvDynamicList.setLFRecyclerViewListener(this);//下拉刷新上拉加载监听
        rcvDynamicList.hideTimeView();//隐藏时间,默认显示时间
        rcvDynamicList.setNoDateShow();//没有数据时,底部显示"没有数据"字样,默认不显示

        List<String> stringList = new ArrayList<>();
        for (int i = 0;i<10;i++){
            stringList.add("动态Item"+i);
        }
        adapter = new DynamicAdapter(activity,stringList);
        rcvDynamicList.setAdapter(adapter);

        btnRightButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity, CreateDynamicActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onRefresh() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                rcvDynamicList.stopRefresh(true);
            }
        },2000);
    }

    @Override
    public void onLoadMore() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                rcvDynamicList.stopLoadMore();
            }
        },2000);
    }

    /**
     * 处理自己的表情
     */
    private void initEmoji() {
        List<Integer> data = new ArrayList<>();
        List<String> strings = new ArrayList<>();
        for (int i = 1; i < 64; i++) {
            int resId = getResources().getIdentifier("e" + i, "drawable", activity.getPackageName());
            data.add(resId);
            strings.add("[e" + i + "]");
        }
        /**初始化为自己的**/
        SmileUtils.addPatternAll(SmileUtils.getEmoticons(), strings, data);
    }

}
