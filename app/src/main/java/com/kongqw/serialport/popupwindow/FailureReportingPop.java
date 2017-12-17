package com.kongqw.serialport.popupwindow;

import android.app.Activity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.widget.TextView;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.kongqw.serialport.R;
import com.kongqw.serialport.adapter.ExchangeGiftAdapter;
import com.kongqw.serialport.entivity.ExchangGiftBean;

import java.util.ArrayList;
import java.util.List;

import razerdp.basepopup.BasePopupWindow;

/**
 * 项目名：AndroidSerialPort-master
 * 包名：com.kongqw.serialport.popupwindow
 * 文件名：FailureReportingPop
 * 创建者 ：${梅华黎}
 * 创建时间： 2017/12/17 0017 20:03
 * 描述：FailureReportingPop  故障报修
 */
public class FailureReportingPop extends BasePopupWindow implements View.OnClickListener {

    private View popupView;
    private Activity activity;


    public FailureReportingPop(Activity context) {
        super(context);
        this.activity = context;
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
        popupView = LayoutInflater.from(getContext()).inflate(R.layout.failurereporting, null);
        return popupView;
    }

    @Override
    public View initAnimaView() {
        return popupView.findViewById(R.id.popup_anima);
    }

    private void bindEvent() {
        if (popupView != null) {
            popupView.findViewById(R.id.img_close).setOnClickListener(this);
        }

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.img_close:
                dismiss();
                break;
        }

    }
}
