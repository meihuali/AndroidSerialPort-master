package com.kongqw.serialport.model;

/**
 * 项目名：AndroidSerialPort-master
 * 包名：com.kongqw.serialport.model
 * 文件名：GetImageModel
 * 创建者 ：${梅华黎}
 * 创建时间： 2017/12/23 14:38
 * 描述：获取滚动图片
 */
public interface GetImageModel {
    void GetImageView(setOnGetImageLineset lineset,String number,String type,String sign);

    interface setOnGetImageLineset{

        void onComple(Object object);

        void onErroy();
    }
}
