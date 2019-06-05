package com.no1worker.originalityproject.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.no1worker.common.CommonActivity;
import com.no1worker.originalityproject.R;
import com.no1worker.originalityproject.bean.EmojiInfo;
import com.shuyu.textutillib.EmojiLayout;
import com.shuyu.textutillib.RichEditText;

import java.util.ArrayList;
import java.util.List;

/**
 * 发布新动态页面
 * Created by yuzhiyong on 2019/5/27.
 */

public class CreateDynamicActivity extends CommonActivity {

    private TextView tvTitle;

    private Button btnRightButton;

    private RichEditText edtRichEdit;

    private ImageView imvEmoji;

    private EmojiLayout emojiLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_dynamic);
        findViews();
        initViews();
    }

    private void findViews() {
        edtRichEdit = findViewById(R.id.edtRichEdit);
        imvEmoji = findViewById(R.id.imvEmoji);
        tvTitle = findViewById(R.id.tvTitle);
        btnRightButton = findViewById(R.id.btnRightButton);
        emojiLayout = findViewById(R.id.emojiLayout);
    }

    private void initViews() {
        tvTitle.setText("新动态");
        btnRightButton.setText("发布");
        emojiLayout.setEditTextSmile(edtRichEdit);
        imvEmoji.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (emojiLayout.getVisibility() != View.VISIBLE) {
                    emojiLayout.setVisibility(View.VISIBLE);
                } else {
                    emojiLayout.setVisibility(View.GONE);
                }
            }
        });
        edtRichEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                emojiLayout.setVisibility(View.GONE);
            }
        });
    }

}
