package com.no1worker.common;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;

import com.no1worker.common.permission.PermissionCallback;
import com.no1worker.common.permission.PermissionHandler;
import com.no1worker.common.permission.PermissionUtil;
import com.no1worker.common.widget.LoadingDialog;

/**
 * 公共Activity
 * Created by yuzhiyong on 2019/5/17.
 */

public class CommonActivity extends AppCompatActivity {

    public Activity aty;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        aty = this;
    }

    private LoadingDialog loadingDialog;

    public LoadingDialog getLoadDialog() {
        if (loadingDialog == null) {
            loadingDialog = new LoadingDialog(this);
        }
        return loadingDialog;
    }

    private PermissionHandler permissionHandler;

    /**
     * 请求权限码
     * @param callback 权限回调
     * @param permissions 权限
     */
    public void requestPermissions(PermissionCallback callback, @NonNull String... permissions) {
        permissionHandler = new PermissionHandler(callback,permissions);
        PermissionUtil.requestPermission(this, PermissionHandler.DEF_REQUEST_CODE, callback, permissions);
    }

    /**
     * 请求权限码
     * @param callback 权限回调
     * @param permissions 权限
     */
    public void requestPermissions(PermissionCallback callback,
                                   @NonNull String[]... permissions) {
        permissionHandler = new PermissionHandler(callback,permissions);
        PermissionUtil.requestPermission(this, PermissionHandler.DEF_REQUEST_CODE, callback, permissions);
    }
}
