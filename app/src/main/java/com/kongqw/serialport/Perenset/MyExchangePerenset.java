package com.kongqw.serialport.Perenset;

import com.kongqw.serialport.Impl.MyexchangeImpl;
import com.kongqw.serialport.View.MyexchangeView;
import com.kongqw.serialport.model.MyexchangeModel;

/**
 * 项目名：AndroidSerialPort-master
 * 包名：com.kongqw.serialport.Perenset
 * 文件名：MyExchangePerenset
 * 创建者 ：${梅华黎}
 * 创建时间： 2017/12/26 21:00
 * 描述：TODO
 */
public class MyExchangePerenset {
    MyexchangeModel myexchangeModel;
    MyexchangeView myexchangeView;

    public MyExchangePerenset(MyexchangeView myexchangeView) {
        this.myexchangeView = myexchangeView;
        myexchangeModel = new MyexchangeImpl();
    }

    public void getexchange(String machineID, String type, String sign) {
        if (myexchangeModel != null) {
            myexchangeModel.getExchanges(new MyexchangeModel.setExchangeLinerset() {
                @Override
                public void onExchangeSscoos(Object object) {
                    myexchangeView.showExchangeSoccec(object);
                }

                @Override
                public void onExchangeFailed() {
                    myexchangeView.showExchangeErroy();
                }
            }, machineID,  type,  sign);
        }
    }
}
