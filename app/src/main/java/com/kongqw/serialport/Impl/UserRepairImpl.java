package com.kongqw.serialport.Impl;

import com.google.gson.Gson;
import com.kongqw.serialport.ConfigUtils.ZhuZhanIp;
import com.kongqw.serialport.Perenset.UserRepairPerenset;
import com.kongqw.serialport.entivity.UserRepairBean;
import com.kongqw.serialport.model.UserRepairModel;
import com.kongqw.serialport.utils.L;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

/**
 * 项目名：AndroidSerialPort-master
 * 包名：com.kongqw.serialport.Impl
 * 文件名：UserRepairImpl
 * 创建者 ：${梅华黎}
 * 创建时间： 2017/12/28 10:12
 * 描述：TODO
 */
public class UserRepairImpl implements UserRepairModel {
    @Override
    public void UserRepair(final setOnUserRepairLinerest linerest, String number, String content, String sign) {
        String url = ZhuZhanIp.zhuzhan+"/api/feedbackApiController/fault";
        OkGo.<String>post(url)
                .params("number", number)
                .params("content", content)
                .params("sign",sign )
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        L.e("故障报修成功：" + response.body());
                        Gson gson = new Gson();
                        UserRepairBean userRepairBean = gson.fromJson(response.body(), UserRepairBean.class);
                        linerest.onComple(userRepairBean);

                    }

                    @Override
                    public void onError(Response<String> response) {
                        super.onError(response);
                        linerest.onError();
                    }
                });

    }
}
