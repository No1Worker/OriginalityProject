package com.no1worker.common.permission;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build;
import android.support.annotation.NonNull;

import com.yanzhenjie.permission.AndPermission;
import com.yanzhenjie.permission.PermissionListener;
import com.yanzhenjie.permission.Rationale;
import com.yanzhenjie.permission.RationaleListener;

import java.util.List;

/**
 * 请求权限工具类
 * Created by yuzhiyong on 2019/5/23.
 */

public class PermissionUtil {

    private final static int CODE_REQUEST_PERMISSION = 321;

    public static void requestPermission(final Activity activity, final int requestSettingCode, final PermissionCallback callback, @NonNull String... permissions){
        if (activity == null || activity.isFinishing()){
            return;
        }
        AndPermission.with(activity)
                .requestCode(CODE_REQUEST_PERMISSION)
                .permission(permissions)
                .rationale(new RationaleListener() {
                    @Override
                    public void showRequestPermissionRationale(int requestCode, Rationale rationale) {
                        AndPermission.rationaleDialog(activity, rationale).show();
                    }
                })
                .callback(new PermissionListener() {
                    @Override
                    public void onSucceed(int requestCode, @NonNull List<String> grantPermissions) {
                        if(requestCode == CODE_REQUEST_PERMISSION && callback != null) {
                            callback.onPermissionGranted(grantPermissions);
                        }
                    }

                    @Override
                    public void onFailed(int requestCode, @NonNull List<String> deniedPermissions) {
                        if(requestCode == CODE_REQUEST_PERMISSION) {
                            if (AndPermission.hasAlwaysDeniedPermission(activity, deniedPermissions)) {
                                AndPermission.defaultSettingDialog(activity, requestSettingCode).show();
                            }
                        }
                    }
                })
                .start();
    }

    public static void requestPermission(final Activity activity,final int requestSettingCode, final PermissionCallback callback, @NonNull String[]... permissions){
        if (activity == null || activity.isFinishing()){
            return;
        }
        AndPermission.with(activity)
                .requestCode(CODE_REQUEST_PERMISSION)
                .permission(permissions)
                .rationale(new RationaleListener() {
                    @Override
                    public void showRequestPermissionRationale(int requestCode, Rationale rationale) {
                        AndPermission.rationaleDialog(activity, rationale).show();
                    }
                })
                .callback(new PermissionListener() {
                    @Override
                    public void onSucceed(int requestCode, @NonNull List<String> grantPermissions) {
                        if(requestCode == CODE_REQUEST_PERMISSION && callback != null) {
                            callback.onPermissionGranted(grantPermissions);
                        }
                    }

                    @Override
                    public void onFailed(int requestCode, @NonNull List<String> deniedPermissions) {
                        if(requestCode == CODE_REQUEST_PERMISSION) {
                            if (AndPermission.hasAlwaysDeniedPermission(activity, deniedPermissions)) {
                                AndPermission.defaultSettingDialog(activity, requestSettingCode).show();
                            }
                        }
                    }
                })
                .start();
    }

    public static void requestPermission(final android.app.Fragment fragment, final int requestSettingCode, final PermissionCallback callback, @NonNull String... permissions){
        if (fragment == null || fragment.getActivity() == null || fragment.getActivity().isFinishing()){
            return;
        }
        AndPermission.with(fragment)
                .requestCode(CODE_REQUEST_PERMISSION)
                .permission(permissions)
                .rationale(new RationaleListener() {
                    @TargetApi(Build.VERSION_CODES.M)
                    @Override
                    public void showRequestPermissionRationale(int requestCode, Rationale rationale) {
                        AndPermission.rationaleDialog(fragment.getContext(), rationale).show();
                    }
                })
                .callback(new PermissionListener() {
                    @Override
                    public void onSucceed(int requestCode, @NonNull List<String> grantPermissions) {
                        if(requestCode == CODE_REQUEST_PERMISSION && callback != null) {
                            callback.onPermissionGranted(grantPermissions);
                        }
                    }

                    @Override
                    public void onFailed(int requestCode, @NonNull List<String> deniedPermissions) {
                        if(requestCode == CODE_REQUEST_PERMISSION) {
                            if (AndPermission.hasAlwaysDeniedPermission(fragment, deniedPermissions)) {
                                AndPermission.defaultSettingDialog(fragment, requestSettingCode).show();
                            }
                        }
                    }
                })
                .start();
    }

    public static void requestPermission(final android.app.Fragment fragment,final int requestSettingCode, final PermissionCallback callback, @NonNull String[]... permissions){
        if (fragment == null || fragment.getActivity() == null || fragment.getActivity().isFinishing()){
            return;
        }
        AndPermission.with(fragment)
                .requestCode(CODE_REQUEST_PERMISSION)
                .permission(permissions)
                .rationale(new RationaleListener() {
                    @TargetApi(Build.VERSION_CODES.M)
                    @Override
                    public void showRequestPermissionRationale(int requestCode, Rationale rationale) {
                        AndPermission.rationaleDialog(fragment.getContext(), rationale).show();
                    }
                })
                .callback(new PermissionListener() {
                    @Override
                    public void onSucceed(int requestCode, @NonNull List<String> grantPermissions) {
                        if(requestCode == CODE_REQUEST_PERMISSION && callback != null) {
                            callback.onPermissionGranted(grantPermissions);
                        }
                    }

                    @Override
                    public void onFailed(int requestCode, @NonNull List<String> deniedPermissions) {
                        if(requestCode == CODE_REQUEST_PERMISSION) {
                            if (AndPermission.hasAlwaysDeniedPermission(fragment, deniedPermissions)) {
                                AndPermission.defaultSettingDialog(fragment, requestSettingCode).show();
                            }
                        }
                    }
                })
                .start();
    }
    public static void requestPermission(final android.support.v4.app.Fragment fragment, final int requestSettingCode, final PermissionCallback callback, @NonNull String... permissions){
        if (fragment == null || fragment.getActivity() == null || fragment.getActivity().isFinishing()){
            return;
        }
        AndPermission.with(fragment)
                .requestCode(CODE_REQUEST_PERMISSION)
                .permission(permissions)
                .rationale(new RationaleListener() {
                    @Override
                    public void showRequestPermissionRationale(int requestCode, Rationale rationale) {
                        AndPermission.rationaleDialog(fragment.getContext(), rationale).show();
                    }
                })
                .callback(new PermissionListener() {
                    @Override
                    public void onSucceed(int requestCode, @NonNull List<String> grantPermissions) {
                        if(requestCode == CODE_REQUEST_PERMISSION && callback != null) {
                            callback.onPermissionGranted(grantPermissions);
                        }
                    }

                    @Override
                    public void onFailed(int requestCode, @NonNull List<String> deniedPermissions) {
                        if(requestCode == CODE_REQUEST_PERMISSION) {
                            if (AndPermission.hasAlwaysDeniedPermission(fragment, deniedPermissions)) {
                                AndPermission.defaultSettingDialog(fragment, requestSettingCode).show();
                            }
                        }
                    }
                })
                .start();
    }

    public static void requestPermission(final android.support.v4.app.Fragment fragment,final int requestSettingCode, final PermissionCallback callback, @NonNull String[]... permissions){
        if (fragment == null || fragment.getActivity() == null || fragment.getActivity().isFinishing()){
            return;
        }
        AndPermission.with(fragment)
                .requestCode(CODE_REQUEST_PERMISSION)
                .permission(permissions)
                .rationale(new RationaleListener() {
                    @Override
                    public void showRequestPermissionRationale(int requestCode, Rationale rationale) {
                        AndPermission.rationaleDialog(fragment.getContext(), rationale).show();
                    }
                })
                .callback(new PermissionListener() {
                    @Override
                    public void onSucceed(int requestCode, @NonNull List<String> grantPermissions) {
                        if(requestCode == CODE_REQUEST_PERMISSION && callback != null) {
                            callback.onPermissionGranted(grantPermissions);
                        }
                    }

                    @Override
                    public void onFailed(int requestCode, @NonNull List<String> deniedPermissions) {
                        if(requestCode == CODE_REQUEST_PERMISSION) {
                            if (AndPermission.hasAlwaysDeniedPermission(fragment, deniedPermissions)) {
                                AndPermission.defaultSettingDialog(fragment, requestSettingCode).show();
                            }
                        }
                    }
                })
                .start();
    }
}
