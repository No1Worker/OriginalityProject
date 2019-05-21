package com.no1worker.common;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.no1worker.common.widget.LoadingDialog;

/**
 * 公共Activity
 * Created by yuzhiyong on 2019/5/17.
 */

public class CommonActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private LoadingDialog loadingDialog;

    public LoadingDialog getLoadDialog() {
        if (loadingDialog == null) {
            loadingDialog = new LoadingDialog(this);
        }
        return loadingDialog;
    }
}
