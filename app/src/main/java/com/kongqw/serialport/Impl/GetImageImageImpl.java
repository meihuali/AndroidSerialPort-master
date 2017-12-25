package com.kongqw.serialport.Impl;

import com.google.gson.Gson;
import com.kongqw.serialport.ConfigUtils.ZhuZhanIp;
import com.kongqw.serialport.View.GetImageView;
import com.kongqw.serialport.entivity.GetImageViewBean;
import com.kongqw.serialport.model.GetImageModel;
import com.kongqw.serialport.utils.L;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

/**
 * 项目名：AndroidSerialPort-master
 * 包名：com.kongqw.serialport.Impl
 * 文件名：GetImageImageImpl
 * 创建者 ：${梅华黎}
 * 创建时间： 2017/12/23 14:40
 * 描述：获取图片后 数据处理
 */
public class GetImageImageImpl implements GetImageModel {
    @Override
    public void GetImageView(final setOnGetImageLineset lineset, String number, String type, String sign) {
        String url = ZhuZhanIp.zhuzhan+"/api/syncApiController/getData";
        OkGo.<String>post(url)
                .params("number", number)
                .params("type",type)
                .params("sign",sign)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        L.e("获取网络图片:"+response.body());
                        Gson gson = new Gson();
                        GetImageViewBean getimage =  gson.fromJson(response.body(), GetImageViewBean.class);
                        lineset.onComple(getimage);

                    }

                    @Override
                    public void onError(Response<String> response) {
                        super.onError(response);
                        lineset.onErroy();
                    }
                });
    }
}
