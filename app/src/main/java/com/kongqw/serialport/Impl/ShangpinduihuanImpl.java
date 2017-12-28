package com.kongqw.serialport.Impl;

import com.google.gson.Gson;
import com.kongqw.serialport.ConfigUtils.ZhuZhanIp;
import com.kongqw.serialport.entivity.DuihuanBean;
import com.kongqw.serialport.model.ShangpinDuiHuanModel;
import com.kongqw.serialport.utils.L;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

/**
 * 项目名：AndroidSerialPort-master
 * 包名：com.kongqw.serialport.Impl
 * 文件名：ShangpinduihuanImpl
 * 创建者 ：${梅华黎}
 * 创建时间： 2017/12/27 17:09
 * 描述：TODO
 */
public class ShangpinduihuanImpl implements ShangpinDuiHuanModel {
    @Override
    public void Shangpingduihuan(final getShangpinduihuanLinerset linerset, String number, String shangpinId, String sign) {
        String url = ZhuZhanIp.zhuzhan+"/api/goodsApiController/ExchangeGoods";
        OkGo.<String>post(url)
                .params("number",number)
                .params("goodsId",shangpinId)
                .params("sign",sign)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        L.e("兑换结果：" + response.body());
                        Gson gson = new Gson();
                        DuihuanBean duihuan = gson.fromJson(response.body(), DuihuanBean.class);
                        linerset.onComple(duihuan);

                    }

                    @Override
                    public void onError(Response<String> response) {
                        super.onError(response);
                        linerset.onError();
                    }
                });

    }
}
