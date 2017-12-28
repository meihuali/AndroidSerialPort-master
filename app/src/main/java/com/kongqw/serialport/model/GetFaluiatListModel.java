package com.kongqw.serialport.model;

/**
 * 项目名：AndroidSerialPort-master
 * 包名：com.kongqw.serialport.model
 * 文件名：GetFaluiatListModel
 * 创建者 ：${梅华黎}
 * 创建时间： 2017/12/28 11:22
 * 描述：获取故障列表
 */
public interface GetFaluiatListModel {
    void getFaluiatList(setOnGetfaluiatLinerset linerset,String number,String sign);

    interface setOnGetfaluiatLinerset{
        void onComplte(Object object);

        void onError();
    }
}
