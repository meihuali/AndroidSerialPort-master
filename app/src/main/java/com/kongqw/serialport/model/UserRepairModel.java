package com.kongqw.serialport.model;

/**
 * 项目名：AndroidSerialPort-master
 * 包名：com.kongqw.serialport.model
 * 文件名：UserRepairModel
 * 创建者 ：${梅华黎}
 * 创建时间： 2017/12/28 10:05
 * 描述：用户故障报修
 */
public interface UserRepairModel {
    void UserRepair(setOnUserRepairLinerest linerest,String number,String content,String sing);

    interface setOnUserRepairLinerest{

        void onComple(Object object);


        void onError();
    }
}
