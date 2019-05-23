package com.no1worker.common;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.no1worker.common.permission.PermissionCallback;
import com.no1worker.common.permission.PermissionHandler;
import com.no1worker.common.permission.PermissionUtil;
import com.no1worker.common.widget.LoadingDialog;

/**
 * fragment基类
 * Created by yuzhiyong on 2019/5/21.
 */

public class CommonFragment extends Fragment {

    protected Activity activity;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.activity = (Activity) context;
    }

    private LoadingDialog loadDialog;

    public LoadingDialog getLoadDialog() {
        if (loadDialog == null) {
            loadDialog = new LoadingDialog(activity);
        }
        return loadDialog;
    }

    private PermissionHandler permissionHandler;

    /**
     * 请求权限码
     * @param callback 权限回调
     * @param permissions 权限
     */
    public void requestPermissions(PermissionCallback callback,@NonNull String... permissions) {
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
