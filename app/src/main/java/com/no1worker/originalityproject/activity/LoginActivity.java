package com.no1worker.originalityproject.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.no1worker.common.CommonActivity;
import com.no1worker.common.retrofit.RetrofitManager;
import com.no1worker.common.retrofit.bean.UserInfo;
import com.no1worker.common.retrofit.callback.OriginalityCallBack;
import com.no1worker.common.retrofit.response.OriginalityBase;
import com.no1worker.originalityproject.R;
import com.no1worker.originalityproject.bean.LoginInfo;
import com.no1worker.originalityproject.utils.PreferUtils;

/**
 * 登录页面
 * Created by yuzhiyong on 2019/5/17.
 */

public class LoginActivity extends CommonActivity{

    private EditText edtPhone;
    private EditText edtPassWord;
    private Button btnLogin;
    private TextView tvRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        findViews();
        initViews();
    }


    private void findViews() {
        edtPhone = findViewById(R.id.edtPhone);
        edtPassWord = findViewById(R.id.edtPassWord);
        btnLogin = findViewById(R.id.btnLogin);
        tvRegister = findViewById(R.id.tvRegister);
    }

    private void initViews() {
        String phone = getIntent().getStringExtra("phone");
        if(!TextUtils.isEmpty(phone)){
            edtPhone.setText(phone);
        }
        tvRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(aty,RegisterActivity.class);
                startActivity(intent);
            }
        });
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                requestLogin();
            }
        });
    }

    /**
     * 登录
     */
    private void requestLogin() {
        getLoadDialog().show();
        RetrofitManager.createOriginalService().login(edtPhone.getText().toString(),edtPassWord.getText().toString()).enqueue(new OriginalityCallBack<UserInfo>() {
            @Override
            public void onSuccess(OriginalityBase<UserInfo> retMsgInfo) {
                PreferUtils.saveIsLogin(aty);
                PreferUtils.saveUserInfoCheckInfo(retMsgInfo.getData(),aty);
                LoginInfo loginInfo = new LoginInfo();
                loginInfo.setPhone(edtPhone.getText().toString());
                loginInfo.setPassword(edtPassWord.getText().toString());
                PreferUtils.saveLoginCheckInfo(loginInfo,aty);
                Intent intent = new Intent(aty,TabMainActivity.class);
                startActivity(intent);
            }

            @Override
            public void onFailure(OriginalityBase<UserInfo> retMsgInfo) {
                Toast.makeText(aty,retMsgInfo.getMsg(),Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFinish() {
                getLoadDialog().dismiss();
            }
        });
    }

}
