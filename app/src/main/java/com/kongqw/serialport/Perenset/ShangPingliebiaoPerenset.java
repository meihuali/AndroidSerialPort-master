package com.kongqw.serialport.Perenset;

import android.app.Activity;

import com.kongqw.serialport.Impl.ShangpingLibiaoImpl;
import com.kongqw.serialport.View.ShangpingliebiaoView;
import com.kongqw.serialport.model.ShangpinglModel;

/**
 * 项目名：AndroidSerialPort-master
 * 包名：com.kongqw.serialport.Perenset
 * 文件名：ShangPingliebiaoPerenset
 * 创建者 ：${梅华黎}
 * 创建时间： 2017/12/27 15:53
 * 描述：商品列表显示
 */
public class ShangPingliebiaoPerenset {
    ShangpinglModel shangpinglModel;
    ShangpingliebiaoView shangpingliebiaoView;

    public ShangPingliebiaoPerenset(ShangpingliebiaoView shangpingliebiaoView) {
        this.shangpingliebiaoView = shangpingliebiaoView;
        shangpinglModel = new ShangpingLibiaoImpl();
    }



    public void showShangPin(String machineId, String sign) {
        if (shangpinglModel != null) {
            shangpinglModel.GifDisplay(new ShangpinglModel.setOnGifDisplayLinest() {
                @Override
                public void onComple(Object object) {
                    shangpingliebiaoView.shangPingSocces(object);
                }

                @Override
                public void onError() {
                    shangpingliebiaoView.shangPingError();
                }
            },machineId,sign);
        }
    }
}
