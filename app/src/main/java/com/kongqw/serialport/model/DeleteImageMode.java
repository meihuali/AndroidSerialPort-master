package com.kongqw.serialport.model;

/**
 * 项目名：AndroidSerialPort-master
 * 包名：com.kongqw.serialport.model
 * 文件名：DeleteImageMode
 * 创建者 ：${梅华黎}
 * 创建时间： 2017/12/25 21:30
 * 描述：每一张图片请求成功后都要掉这个接口去删除 该图片
 */
public interface DeleteImageMode {
    void DeleteImage(onSetDeleteImageLinerest linerest,String addId,String sign);

    interface onSetDeleteImageLinerest{

        void onDeleteImgOnscc(Object object);

        void onDeleteImgOnError();
    }
}
