package com.no1worker.originalityproject.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.no1worker.common.widget.NineGridLayout;
import com.no1worker.originalityproject.R;
import com.shuyu.textutillib.RichTextView;
import com.shuyu.textutillib.listener.SpanAtUserCallBack;
import com.shuyu.textutillib.listener.SpanTopicCallBack;
import com.shuyu.textutillib.listener.SpanUrlCallBack;
import com.shuyu.textutillib.model.TopicModel;
import com.shuyu.textutillib.model.UserModel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import me.leefeng.lfrecyclerview.LFRecyclerViewAdapter;

/**
 * 动态列表适配器
 * Created by yuzhiyong on 2019/5/23.
 */

public class DynamicAdapter extends RecyclerView.Adapter<DynamicAdapter.MyViewHolder>{

    private Context context;

    private List<String> strList = new ArrayList<>();

    String content = "这是测试文本#话题话题#哟 www.baidu.com " +
            " 来@某个人  @22222 @kkk " +
            " 好的,来几个表情[e2][e4][e55]，最后来一个电话 13245685478";

    List<TopicModel> topicModels = new ArrayList<>();

    List<UserModel> nameList = new ArrayList<>();


    List<TopicModel> topicModelsEd = new ArrayList<>();

    List<UserModel> nameListEd = new ArrayList<>();


    public DynamicAdapter(Context context,List<String> strList){
        this.context = context;
        this.strList = strList;
        initData();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        MyViewHolder viewHolder = new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.adapter_dynamic,viewGroup,false));
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder viewHolder, int i) {
        String item = strList.get(i);
        viewHolder.tvUserName.setText("用户名" + item);
        viewHolder.tvCreateTime.setText("2019-5-24 14:00");
        List<String> url = new ArrayList<>();
        for (int j = 0;j<6;j++){
            url.add("xxx");
        }
        viewHolder.gridImage.setIsShowAll(true);
        viewHolder.gridImage.setUrlList(url);
        viewHolder.tvContent.setAtColor(context.getResources().getColor(R.color.color_orange));
        viewHolder.tvContent.setTopicColor(context.getResources().getColor(R.color.color_blue));
        viewHolder.tvContent.setLinkColor(context.getResources().getColor(R.color.color_blue));
        viewHolder.tvContent.setNeedNumberShow(true);
        viewHolder.tvContent.setNeedUrlShow(true);
        viewHolder.tvContent.setSpanAtUserCallBackListener(new SpanAtUserCallBack() {
            @Override
            public void onClick(View view, UserModel userModel) {
                Toast.makeText(context, userModel.getUser_name() + " 被点击了", Toast.LENGTH_SHORT).show();
                viewHolder.tvContent.setHighlightColor(Color.TRANSPARENT);
            }
        });
        viewHolder.tvContent.setSpanTopicCallBackListener(new SpanTopicCallBack() {
            @Override
            public void onClick(View view, TopicModel topicModel) {
                Toast.makeText(context, topicModel.getTopicName() + " 被点击了", Toast.LENGTH_SHORT).show();
                viewHolder.tvContent.setHighlightColor(Color.TRANSPARENT);
            }
        });
        viewHolder.tvContent.setSpanUrlCallBackListener(new SpanUrlCallBack() {
            @Override
            public void phone(View view, String s) {
                Toast.makeText(context, s + " 被点击了", Toast.LENGTH_SHORT).show();
                viewHolder.tvContent.setHighlightColor(Color.TRANSPARENT);
            }

            @Override
            public void url(View view, String s) {
                Toast.makeText(context, s + " 被点击了", Toast.LENGTH_SHORT).show();
                viewHolder.tvContent.setHighlightColor(Color.TRANSPARENT);
            }
        });
        //所有配置完成后才设置text
        viewHolder.tvContent.setRichText(content, nameList, topicModels);
    }

    private void initData() {
        nameList.clear();
        topicModels.clear();

        UserModel userModel = new UserModel();
        userModel.setUser_name("22222");
        userModel.setUser_id("2222");
        nameList.add(userModel);
        userModel = new UserModel();
        userModel.setUser_name("kkk");
        userModel.setUser_id("23333");
        nameList.add(userModel);

        TopicModel topicModel = new TopicModel();
        topicModel.setTopicId("333");
        topicModel.setTopicName("话题话题");
        topicModels.add(topicModel);

    }

    @Override
    public int getItemCount() {
        return strList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        private ImageView imvUserLogo;
        private TextView tvUserName;
        private TextView tvCreateTime;
        private RichTextView tvContent;
        private NineGridLayout gridImage;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imvUserLogo = itemView.findViewById(R.id.imvUserLogo);
            tvUserName = itemView.findViewById(R.id.tvUserName);
            tvCreateTime = itemView.findViewById(R.id.tvCreateTime);
            tvContent = itemView.findViewById(R.id.tvContent);
            gridImage = itemView.findViewById(R.id.gridImage);
        }
    }
}
