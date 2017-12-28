package com.kongqw.serialport.model;

/**
 * 项目名：AndroidSerialPort-master
 * 包名：com.kongqw.serialport.model
 * 文件名：ShangpinDuiHuanModel
 * 创建者 ：${梅华黎}
 * 创建时间： 2017/12/27 17:02
 * 描述：商品兑换
 */
public interface ShangpinDuiHuanModel {
    void Shangpingduihuan(getShangpinduihuanLinerset linerset, String number, String shangpinId, String sign);

    interface getShangpinduihuanLinerset{

        void onComple(Object object);


        void onError();
    }
}
