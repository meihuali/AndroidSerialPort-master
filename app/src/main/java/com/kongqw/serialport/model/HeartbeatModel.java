package com.kongqw.serialport.model;

/**
 * 项目名：AndroidSerialPort-master
 * 包名：com.kongqw.serialport.model
 * 文件名：HeartbeatModel
 * 创建者 ：${梅华黎}
 * 创建时间： 2017/12/23 13:41
 * 描述：心跳请求
 */
public interface HeartbeatModel {

    void GetHeartData(onGetHeartDataLinerent linerent,String number,String position,String sign);

    interface onGetHeartDataLinerent {
        //请求成功回调
        void onComplete(Object object);
        //请求失败·
        void onErrorComplte();
    }
}
