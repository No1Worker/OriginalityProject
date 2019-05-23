package com.no1worker.originalityproject.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.no1worker.originalityproject.R;

import java.util.ArrayList;
import java.util.List;

import me.leefeng.lfrecyclerview.LFRecyclerViewAdapter;

/**
 * 动态列表适配器
 * Created by yuzhiyong on 2019/5/23.
 */

public class DynamicAdapter extends RecyclerView.Adapter<DynamicAdapter.MyViewHolder>{

    private Context context;

    private List<String> strList = new ArrayList<>();

    public DynamicAdapter(Context context,List<String> strList){
        this.context = context;
        this.strList = strList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        MyViewHolder viewHolder = new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.adapter_dynamic,viewGroup,false));
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder viewHolder, int i) {
        String item = strList.get(i);
        viewHolder.tvItem.setText(item);
    }

    @Override
    public int getItemCount() {
        return strList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        private TextView tvItem;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvItem = itemView.findViewById(R.id.tvItem);
        }
    }
}
