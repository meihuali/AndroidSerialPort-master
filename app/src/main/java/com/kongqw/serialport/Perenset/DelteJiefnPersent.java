package com.kongqw.serialport.Perenset;

import com.kongqw.serialport.Impl.DelteJiFenImpl;
import com.kongqw.serialport.View.DelteJiFenView;
import com.kongqw.serialport.model.DelteJifenModel;

/**
 * 项目名：AndroidSerialPort-master
 * 包名：com.kongqw.serialport.Perenset
 * 文件名：DelteJiefnPersent
 * 创建者 ：${梅华黎}
 * 创建时间： 2017/12/27 23:08
 * 描述：TODO
 */
public class DelteJiefnPersent {
    DelteJifenModel delteJifenModel;
    DelteJiFenView delteJiFenView;

    public DelteJiefnPersent(DelteJiFenView delteJiFenView) {
        this.delteJiFenView = delteJiFenView;
        delteJifenModel = new DelteJiFenImpl();
    }

    public void deleteJfen(String number,String sign) {
        if (delteJifenModel != null) {
            delteJifenModel.DeteleJifen(new DelteJifenModel.setOnDelteJifenLinset() {
                @Override
                public void onComplte(Object object) {
                    delteJiFenView.DeleteOnsoncc(object);
                }

                @Override
                public void onError() {
                    delteJiFenView.DeleteOnError();
                }
            }, number, sign);
        }
    }
}
