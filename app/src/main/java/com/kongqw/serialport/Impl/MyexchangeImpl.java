package com.kongqw.serialport.Impl;

import com.google.gson.Gson;
import com.kongqw.serialport.ConfigUtils.ZhuZhanIp;
import com.kongqw.serialport.entivity.MyExchangeBean;
import com.kongqw.serialport.model.MyexchangeModel;
import com.kongqw.serialport.utils.L;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

import org.json.JSONObject;

/**
 * 项目名：AndroidSerialPort-master
 * 包名：com.kongqw.serialport.Impl
 * 文件名：MyexchangeImpl
 * 创建者 ：${梅华黎}
 * 创建时间： 2017/12/26 20:57
 * 描述：积分兑换
 */
public class MyexchangeImpl implements MyexchangeModel {
    @Override
    public void getExchanges(final setExchangeLinerset linerset, String machineId, String type, String sign) {
        String url = ZhuZhanIp.zhuzhan+"/api/syncApiController/getData";
        OkGo.<String>post(url)
                .params("number", machineId)
                .params("type", type)
                .params("sign", sign)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        L.e("积分兑换：" + response.body());
                        JSONObject obj = new JSONObject();
                        int statae = obj.optInt("resultCode");
                        if (statae == 0) {
                            Gson gson = new Gson();
                            MyExchangeBean bean =   gson.fromJson(response.body(), MyExchangeBean.class);
                            linerset.onExchangeSscoos(bean);
                        }
                    }

                    @Override
                    public void onError(Response<String> response) {
                        super.onError(response);
                    }

                });
    }
}
