package com.kongqw.serialport.model;

/**
 * 项目名：AndroidSerialPort-master
 * 包名：com.kongqw.serialport.model
 * 文件名：MyexchangeModel
 * 创建者 ：${梅华黎}
 * 创建时间： 2017/12/26 20:47
 * 描述：兑换积分
 */
public interface MyexchangeModel {
    void getExchanges(setExchangeLinerset linerset,String machineId,String type,String sign);
    interface setExchangeLinerset{
        void onExchangeSscoos(Object object);

        void onExchangeFailed();
    }
}
