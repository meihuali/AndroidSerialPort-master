package com.kongqw.serialport.popupwindow;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.widget.TextView;
import android.widget.Toast;

import com.kongqw.serialport.R;

import java.util.SimpleTimeZone;

import razerdp.basepopup.BasePopupWindow;

/**
 * 项目名：AndroidSerialPort-master
 * 包名：com.kongqw.serialport.popupwindow
 * 文件名：NotionftionPop
 * 创建者 ：${梅华黎}
 * 创建时间： 2017/12/17 0017 14:53
 * 描述：NotionftionPop  通知
 */
public class NotionftionPop extends BasePopupWindow implements View.OnClickListener {

    private View popupView;
    private Activity activity;
    private String MyNotice;
    private TextView tv_notionf;

    public NotionftionPop(Activity context,String MyNotice) {
        super(context);
        this.activity = context;
        this.MyNotice = MyNotice;
        bindEvent();
    }


    @Override
    protected Animation initShowAnimation() {
        return getDefaultScaleAnimation();
    }

    @Override
    protected Animation initExitAnimation() {
        return getDefaultScaleAnimation(false);
    }

    @Override
    public View getClickToDismissView() {
        return popupView.findViewById(R.id.click_to_dismiss);
    }

    @Override
    public View onCreatePopupView() {
        popupView = LayoutInflater.from(getContext()).inflate(R.layout.activity_notionfion, null);
        return popupView;
    }

    @Override
    public View initAnimaView() {
        return popupView.findViewById(R.id.popup_anima);
    }

    private void bindEvent() {
        if (popupView != null) {
            popupView.findViewById(R.id.img_close).setOnClickListener(this);
            popupView.findViewById(R.id.btn_close).setOnClickListener(this);
             tv_notionf= (TextView) popupView.findViewById(R.id.tv_nottifo_body);
             tv_notionf.setText(MyNotice);

        }

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_close:
                dismiss();
                break;
            case R.id.img_close:
                dismiss();
                break;

        }

    }
}
