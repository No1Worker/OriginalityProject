package com.no1worker.common.widget;


import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.Gravity;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.no1worker.originalityproject.R;

public class LoadingDialog extends Dialog {

    private final Animation hyperspaceJumpAnimation;

    private final ImageView spaceshipImage;

    private TextView tipTextView;

    private Context context;

    public LoadingDialog(Context context) {
        this(context, true, "请稍等...");
    }

    public LoadingDialog(Context context, CharSequence message) {
        this(context, true, message);
    }

    public LoadingDialog(Context context, boolean cancelable, CharSequence message) {
        super(context, R.style.connect_dialog_style);
        setContentView(R.layout.dialog_connect);
        this.context = context;
        tipTextView = (TextView) findViewById(R.id.tipTextView);// 提示文字
        tipTextView.setText(message);
        // 加载动画
        hyperspaceJumpAnimation = AnimationUtils.loadAnimation(context,
                R.anim.connect_animation);
        spaceshipImage = (ImageView) findViewById(R.id.img);
        spaceshipImage.startAnimation(hyperspaceJumpAnimation);
        setCancelable(cancelable);
        setCanceledOnTouchOutside(false);
        Window dialogWindow = getWindow();
        dialogWindow.setGravity(Gravity.CENTER);
        WindowManager.LayoutParams p = dialogWindow.getAttributes();
        p.height = WindowManager.LayoutParams.WRAP_CONTENT;
        p.width = WindowManager.LayoutParams.WRAP_CONTENT;
        dialogWindow.setAttributes(p);
    }

    @Override
    public void show() {
        if (context instanceof Activity && !((Activity) context).isFinishing()) {
            if (!isShowing()) {
                spaceshipImage.startAnimation(hyperspaceJumpAnimation);
                super.show();
            }
        }
    }

    public void show(String message) {
        tipTextView.setText(message);
        show();
    }

    @Override
    public void dismiss() {
        if (context instanceof Activity && !((Activity) context).isFinishing()) {
            super.dismiss();
        }
    }

}