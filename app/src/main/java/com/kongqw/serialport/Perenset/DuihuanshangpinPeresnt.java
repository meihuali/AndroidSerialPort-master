package com.kongqw.serialport.Perenset;

import android.app.Activity;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.kongqw.serialport.Impl.ShangpinduihuanImpl;
import com.kongqw.serialport.View.ShangpinduihuanView;
import com.kongqw.serialport.View.ShangpingliebiaoView;
import com.kongqw.serialport.model.ShangpinDuiHuanModel;

/**
 * 项目名：AndroidSerialPort-master
 * 包名：com.kongqw.serialport.Perenset
 * 文件名：DuihuanshangpinPeresnt
 * 创建者 ：${梅华黎}
 * 创建时间： 2017/12/27 17:10
 * 描述：TODO
 */
public class DuihuanshangpinPeresnt {
    ShangpinDuiHuanModel shangpinDuiHuanModel;
    ShangpinduihuanView shangpinduihuanView;

    public DuihuanshangpinPeresnt(ShangpinduihuanView shangpinduihuanView) {
        this.shangpinduihuanView =  shangpinduihuanView;
        shangpinDuiHuanModel = new ShangpinduihuanImpl();
    }

    public void shangpinduihuan(String number,String shangpinID,String sign) {
        if (shangpinDuiHuanModel != null) {
            shangpinDuiHuanModel.Shangpingduihuan(new ShangpinDuiHuanModel.getShangpinduihuanLinerset() {
                @Override
                public void onComple(Object object) {
                    shangpinduihuanView.duihuanOnSoccs(object);
                }

                @Override
                public void onError() {
                    shangpinduihuanView.duihuanOnError();
                }
            },number, shangpinID, sign);
        }
    }
}
