package com.kongqw.serialport.Impl;

import com.google.gson.Gson;
import com.kongqw.serialport.ConfigUtils.ZhuZhanIp;
import com.kongqw.serialport.entivity.GetUserFailuatListBean;
import com.kongqw.serialport.model.GetFaluiatListModel;
import com.kongqw.serialport.utils.L;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

import org.json.JSONObject;

/**
 * 项目名：AndroidSerialPort-master
 * 包名：com.kongqw.serialport.Impl
 * 文件名：GetFaluiatListImpl
 * 创建者 ：${梅华黎}
 * 创建时间： 2017/12/28 11:24
 * 描述：TODO
 */
public class GetFaluiatListImpl implements GetFaluiatListModel {
    @Override
    public void getFaluiatList(final setOnGetfaluiatLinerset linerset, String number, String sign) {
        String url = ZhuZhanIp.zhuzhan + "/api/feedbackApiController/get";
        OkGo.<String>post(url)
                .params("number", number)
                .params("sign", sign)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        L.e("获取故障列表");
                        JSONObject obj = new JSONObject();
                        int state = obj.optInt("resultCode");
                        if (state == 0) {
                            Gson gson = new Gson();
                            GetUserFailuatListBean bean = gson.fromJson(response.body(), GetUserFailuatListBean.class);
                            linerset.onComplte(bean);
                        }
                    }

                    @Override
                    public void onError(Response<String> response) {
                        super.onError(response);
                        linerset.onError();
                    }
                });
    }
}
