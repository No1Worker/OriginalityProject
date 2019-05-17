package com.no1worker.originalityproject.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.no1worker.common.CommonActivity;
import com.no1worker.originalityproject.R;

/**
 * 登录页面
 * Created by yuzhiyong on 2019/5/17.
 */

public class LoginActivity extends CommonActivity{

    private EditText edtUserName;
    private EditText edtPassWord;
    private Button btnLogin;
    private Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
    }

    private void findViews() {
        edtUserName = findViewById(R.id.edtUserName);
        edtPassWord = findViewById(R.id.edtPassWord);
        btnLogin = findViewById(R.id.btnLogin);
        btnRegister = findViewById(R.id.btnRegister);
    }


}
