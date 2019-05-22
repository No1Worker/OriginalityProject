package com.no1worker.originalityproject.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.no1worker.common.CommonActivity;
import com.no1worker.common.retrofit.RetrofitManager;
import com.no1worker.common.retrofit.callback.OriginalityCallBack;
import com.no1worker.common.retrofit.response.OriginalityBase;
import com.no1worker.originalityproject.R;

/**
 * 注册页面
 * Created by yuzhiyong on 2019/5/22.
 */

public class RegisterActivity extends CommonActivity {

    private EditText edtPhone;
    private EditText edtPassword;
    private EditText edtCheckPassword;
    private EditText edtUserName;
    private EditText edtEMail;
    private Button btnCommitRegister;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.activity_register);
        findViews();
        initViews();
    }

    private void findViews() {
        edtPhone = findViewById(R.id.edtPhone);
        edtPassword = findViewById(R.id.edtPassword);
        edtCheckPassword = findViewById(R.id.edtCheckPassword);
        edtUserName = findViewById(R.id.edtUserName);
        edtEMail = findViewById(R.id.edtEMail);
        btnCommitRegister = findViewById(R.id.btnCommitRegister);
    }

    private void initViews() {
        btnCommitRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checkParams())
                requestRegister();
            }
        });
    }

    private boolean checkParams() {
        if(TextUtils.isEmpty(edtPhone.getText().toString())){
            Toast.makeText(aty,"请输入手机号码",Toast.LENGTH_SHORT).show();
            return false;
        }
        if(TextUtils.isEmpty(edtPassword.getText().toString())){
            Toast.makeText(aty,"请输入密码",Toast.LENGTH_SHORT).show();
            return false;
        }
        if(!edtCheckPassword.getText().toString().equals(edtPassword.getText().toString())){
            Toast.makeText(aty,"两次密码不一致",Toast.LENGTH_SHORT).show();
            return false;
        }
        if(TextUtils.isEmpty(edtUserName.getText().toString())){
            Toast.makeText(aty,"请输入用户名",Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    private void requestRegister() {
        getLoadDialog().show();
        RetrofitManager.createOriginalService()
                .registerUser(edtPhone.getText().toString(),
                edtPassword.getText().toString(),
                edtUserName.getText().toString(),
                edtEMail.getText().toString(), "", "")
                .enqueue(new OriginalityCallBack<String>() {
                    @Override
                    public void onSuccess(OriginalityBase<String> retMsgInfo) {
                        Intent intent = new Intent(aty,LoginActivity.class);
                        intent.putExtra("phone",retMsgInfo.getData());
                        startActivity(intent);
                    }

                    @Override
                    public void onFailure(OriginalityBase<String> retMsgInfo) {
                        Toast.makeText(aty,retMsgInfo.getMsg(),Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFinish() {
                        getLoadDialog().dismiss();
                    }
                });
    }

}
