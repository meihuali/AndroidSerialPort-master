package com.kongqw.serialport.model;

/**
 * 项目名：AndroidSerialPort-master
 * 包名：com.kongqw.serialport.model
 * 文件名：DelteJifenModel
 * 创建者 ：${梅华黎}
 * 创建时间： 2017/12/27 22:57
 * 描述：TODO
 */
public interface DelteJifenModel {
    void DeteleJifen(setOnDelteJifenLinset linset,String number,String sign);

    interface setOnDelteJifenLinset{
        void onComplte(Object object);

        void onError();
    }
}
