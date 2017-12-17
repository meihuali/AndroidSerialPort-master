package com.kongqw.serialport.popupwindow;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.widget.TextView;
import android.widget.Toast;

import com.kongqw.serialport.R;

import razerdp.basepopup.BasePopupWindow;

/**
 * 项目名：AndroidSerialPort-master
 * 包名：com.kongqw.serialport.popupwindow
 * 文件名：rechargepop
 * 创建者 ：${梅华黎}
 * 创建时间： 2017/12/17 0017 16:55
 * 描述：rechargepop  充值
 */
public class RechargePop extends BasePopupWindow implements View.OnClickListener {

    private View popupView;
    private Activity activity;
    public TextView tv_wushi,tv_yibai,tv_liangbai;

    public RechargePop(Activity context) {
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
        popupView = LayoutInflater.from(getContext()).inflate(R.layout.rechargepop, null);
        return popupView;
    }

    @Override
    public View initAnimaView() {
        return popupView.findViewById(R.id.popup_anima);
    }

    private void bindEvent() {
        if (popupView != null) {
            tv_wushi = (TextView) popupView.findViewById(R.id.tv_wushi);
            tv_wushi.setOnClickListener(this);

            tv_yibai= (TextView) popupView.findViewById(R.id.tv_yibai);
            tv_yibai.setOnClickListener(this);

            tv_liangbai = (TextView) popupView.findViewById(R.id.liangbai);
            tv_liangbai.setOnClickListener(this);

            popupView.findViewById(R.id.img_close).setOnClickListener(this);
            popupView.findViewById(R.id.tv_weixin).setOnClickListener(this);
            popupView.findViewById(R.id.tv_zhifubao).setOnClickListener(this);
        }

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.img_close:
                dismiss();
                break;
            case R.id.tv_wushi:
                Toast.makeText(activity,"等待开发中···",Toast.LENGTH_SHORT).show();
                tv_wushi.setBackgroundResource(R.drawable.button_yuanjiao_lanse);
                tv_wushi.setTextColor(activity.getResources().getColor(R.color.white));
                tv_yibai.setBackgroundResource(R.drawable.button_yuanjiaokongxin_lanse);
                tv_yibai.setTextColor(activity.getResources().getColor(R.color.lvseziti));
                tv_liangbai.setBackgroundResource(R.drawable.button_yuanjiaokongxin_lanse);
                tv_liangbai.setTextColor(activity.getResources().getColor(R.color.lvseziti));

                break;
            case R.id.tv_yibai:
                Toast.makeText(activity,"等待开发中···",Toast.LENGTH_SHORT).show();
                tv_yibai.setBackgroundResource(R.drawable.button_yuanjiao_lanse);
                tv_yibai.setTextColor(activity.getResources().getColor(R.color.white));
                tv_wushi.setBackgroundResource(R.drawable.button_yuanjiaokongxin_lanse);
                tv_wushi.setTextColor(activity.getResources().getColor(R.color.lvseziti));
                tv_liangbai.setBackgroundResource(R.drawable.button_yuanjiaokongxin_lanse);
                tv_liangbai.setTextColor(activity.getResources().getColor(R.color.lvseziti));
                break;
            case R.id.liangbai:
                Toast.makeText(activity,"等待开发中···",Toast.LENGTH_SHORT).show();

                tv_liangbai.setBackgroundResource(R.drawable.button_yuanjiao_lanse);
                tv_liangbai.setTextColor(activity.getResources().getColor(R.color.white));

                tv_wushi.setBackgroundResource(R.drawable.button_yuanjiaokongxin_lanse);
                tv_wushi.setTextColor(activity.getResources().getColor(R.color.lvseziti));

                tv_yibai.setBackgroundResource(R.drawable.button_yuanjiaokongxin_lanse);
                tv_yibai.setTextColor(activity.getResources().getColor(R.color.lvseziti));

                break;
            case R.id.tv_weixin:
                Toast.makeText(activity,"等待开发中···",Toast.LENGTH_SHORT).show();
                break;
            case R.id.tv_zhifubao:
                Toast.makeText(activity,"等待开发中···",Toast.LENGTH_SHORT).show();
                break;

        }

    }
}
