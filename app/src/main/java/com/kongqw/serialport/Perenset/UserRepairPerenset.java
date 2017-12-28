package com.kongqw.serialport.Perenset;

import com.kongqw.serialport.Impl.UserRepairImpl;
import com.kongqw.serialport.View.UserRepairView;
import com.kongqw.serialport.model.UserRepairModel;

/**
 * 项目名：AndroidSerialPort-master
 * 包名：com.kongqw.serialport.Perenset
 * 文件名：UserRepairPerenset
 * 创建者 ：${梅华黎}
 * 创建时间： 2017/12/28 10:16
 * 描述：TODO
 */
public class UserRepairPerenset {
    UserRepairModel userRepairModel;
    UserRepairView userRepairView;

    public UserRepairPerenset(UserRepairView userRepairView) {
        this.userRepairView = userRepairView;
        userRepairModel = new UserRepairImpl();
    }

    public void userRepair(String number, String content, String sign) {
        if (userRepairModel != null) {
            userRepairModel.UserRepair(new UserRepairModel.setOnUserRepairLinerest() {
                @Override
                public void onComple(Object object) {
                    userRepairView.repairSuccess(object);
                }

                @Override
                public void onError() {
                    userRepairView.repairError();
                }
            },number,  content,  sign);
        }
    }
}
