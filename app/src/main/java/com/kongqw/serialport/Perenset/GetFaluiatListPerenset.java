package com.kongqw.serialport.Perenset;

import com.kongqw.serialport.Impl.GetFaluiatListImpl;
import com.kongqw.serialport.View.GetFaluiatListView;
import com.kongqw.serialport.model.GetFaluiatListModel;

/**
 * 项目名：AndroidSerialPort-master
 * 包名：com.kongqw.serialport.Perenset
 * 文件名：GetFaluiatListPerenset
 * 创建者 ：${梅华黎}
 * 创建时间： 2017/12/28 11:27
 * 描述：TODO
 */
public class GetFaluiatListPerenset {
    GetFaluiatListModel getFaluiatListModel;
    GetFaluiatListView getFaluiatListView;

    public GetFaluiatListPerenset(GetFaluiatListView getFaluiatListView) {
        this.getFaluiatListView = getFaluiatListView;
        getFaluiatListModel = new GetFaluiatListImpl();
    }

    public void getFaluiatList(String number, String sign) {
        if (getFaluiatListModel != null) {
            getFaluiatListModel.getFaluiatList(new GetFaluiatListModel.setOnGetfaluiatLinerset() {
                @Override
                public void onComplte(Object object) {
                    getFaluiatListView.getFaluiatOnSccos(object);
                }

                @Override
                public void onError() {
                    getFaluiatListView.getFaluiatOnError();
                }
            },number,sign);
        }
    }
}
