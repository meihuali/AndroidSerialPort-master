package com.kongqw.serialport.Impl;

import com.kongqw.serialport.ConfigUtils.ZhuZhanIp;
import com.kongqw.serialport.model.DelteJifenModel;
import com.kongqw.serialport.utils.L;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

/**
 * 项目名：AndroidSerialPort-master
 * 包名：com.kongqw.serialport.Impl
 * 文件名：DelteJiFenImpl
 * 创建者 ：${梅华黎}
 * 创建时间： 2017/12/27 23:05
 * 描述：TODO
 */
public class DelteJiFenImpl implements DelteJifenModel {
    @Override
    public void DeteleJifen(setOnDelteJifenLinset linset, String number, String sign) {
        String url = ZhuZhanIp.zhuzhan+"/api/syncApiController/callBackEx";
        OkGo.<String>post(url)
                .params("number",number)
                .params("sign",sign)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {

                    }

                    @Override
                    public void onError(Response<String> response) {
                        super.onError(response);

                    }
                });

    }
}
