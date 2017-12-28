package com.kongqw.serialport.popupwindow;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.widget.TextView;
import android.widget.Toast;

import com.kongqw.serialport.R;
import com.suke.widget.SwitchButton;

import razerdp.basepopup.BasePopupWindow;

/**
 * 项目名：AndroidSerialPort-master
 * 包名：com.kongqw.serialport.popupwindow
 * 文件名：WaterSwitchPop
 * 创建者 ：${梅华黎}
 * 创建时间： 2017/12/17 0017 21:08
 * 描述：WaterSwitchPop
 */
public class WaterSwitchPop extends BasePopupWindow implements View.OnClickListener {

    private View popupView;
    private Activity activity;
    public TextView tv_wushi,tv_yibai,tv_liangbai;
    private SwitchButton switch_button;

    public WaterSwitchPop(Activity context) {
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
        popupView = LayoutInflater.from(getContext()).inflate(R.layout.water_switchpop, null);
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
            initSwitch();


        }

    }
    /**
     * 创建者 ：华黎
     * 创建时间：2017/12/17 0017 21:34
     * 描述：初始化开关
     */
    private void initSwitch() {

        switch_button = (SwitchButton) findViewById(R.id.switch_button);
//            switch_button.setChecked(true);
//            switch_button.isChecked();
//            switch_button.toggle();     //switch state
//            switch_button.toggle(false);//switch without animation
//            switch_button.setShadowEffect(true);//disable shadow effect
//            switch_button.setEnabled(false);//disable button
//            switch_button.setEnableEffect(false);//disable the switch animation
        switch_button.setOnCheckedChangeListener(new SwitchButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(SwitchButton view, boolean isChecked) {
                Toast.makeText(activity,"开关状态 "+isChecked,Toast.LENGTH_SHORT).show();
            }
        });
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
            case R.id.btn_comitt:

                break;

        }

    }
}
