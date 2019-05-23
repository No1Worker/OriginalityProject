package com.no1worker.common.permission;

import java.util.List;

/**
 * 请求权限回调
 * Created by yuzhiyong on 2019/5/23.
 */

public interface PermissionCallback {
    void onPermissionGranted(List<String> grantPermissions);
}
