package com.no1worker.common.permission;

import android.content.Context;

import com.yanzhenjie.permission.AndPermission;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 权限辅助类
 * Created by yuzhiyong on 2019/5/23.
 */

public class PermissionHandler {
    public static final int DEF_REQUEST_CODE = 1764;

    private PermissionCallback permissionCallback;

    private List<String> permissions = new ArrayList<>();

    public PermissionHandler(PermissionCallback permissionCallback,String... permissions) {
        this.permissions.addAll(Arrays.asList(permissions));
        this.permissionCallback = permissionCallback;
    }

    public PermissionHandler(PermissionCallback permissionCallback,String[]... permissions) {
        for (String[] permission : permissions) {
            this.permissions.addAll(Arrays.asList(permission));
        }
        this.permissionCallback = permissionCallback;
    }

    public void onActivityResult(Context context , int requestCode) {
        if (permissionCallback != null && requestCode == DEF_REQUEST_CODE) {
            if (AndPermission.hasPermission(context, permissions)) {
                permissionCallback.onPermissionGranted(permissions);
            }
        }
        permissionCallback = null;
    }
}
