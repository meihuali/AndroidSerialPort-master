package com.kongqw.serialport.model;

/**
 * 项目名：AndroidSerialPort-master
 * 包名：com.kongqw.serialport.model
 * 文件名：GiftDisplayModel
 * 创建者 ：${梅华黎}
 * 创建时间： 2017/12/27 15:47
 * 描述：礼品显示 兑换
 */
public interface ShangpinglModel {
    void GifDisplay(setOnGifDisplayLinest linest,String machineId,String sign);
    interface setOnGifDisplayLinest{
        void onComple(Object object);

        void onError();
    }
}
