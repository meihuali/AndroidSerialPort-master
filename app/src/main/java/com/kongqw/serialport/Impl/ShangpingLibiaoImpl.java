package com.kongqw.serialport.Impl;

import com.google.gson.Gson;
import com.kongqw.serialport.ConfigUtils.ZhuZhanIp;
import com.kongqw.serialport.entivity.ShangpinBean;
import com.kongqw.serialport.model.ShangpinglModel;
import com.kongqw.serialport.utils.L;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

import org.json.JSONObject;

/**
 * 项目名：AndroidSerialPort-master
 * 包名：com.kongqw.serialport.Impl
 * 文件名：ShangpingLibiaoImpl
 * 创建者 ：${梅华黎}
 * 创建时间： 2017/12/27 15:52
 * 描述：TODO
 */
public class ShangpingLibiaoImpl implements ShangpinglModel {
    @Override
    public void GifDisplay(final setOnGifDisplayLinest linest, String machineId, String sign) {
        String url = ZhuZhanIp.zhuzhan + "/api/goodsApiController/goodsList";
        OkGo.<String>post(url)
                .params("number", machineId)
                .params("sign",sign)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        L.e("礼品列表：" + response.body());
                        JSONObject obj = new JSONObject();
                        int state = obj.optInt("resultCode");
                        if (state == 0) {
                            Gson gson = new Gson();
                            ShangpinBean shangpin = gson.fromJson(response.body(), ShangpinBean.class);
                            linest.onComple(shangpin);
                        }
                    }

                    @Override
                    public void onError(Response<String> response) {
                        super.onError(response);
                        linest.onError();
                    }
                });
    }
}
