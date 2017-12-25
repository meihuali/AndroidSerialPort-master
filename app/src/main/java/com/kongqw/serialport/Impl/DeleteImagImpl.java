package com.kongqw.serialport.Impl;

import com.kongqw.serialport.ConfigUtils.ZhuZhanIp;
import com.kongqw.serialport.model.DeleteImageMode;
import com.kongqw.serialport.utils.L;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

/**
 * 项目名：AndroidSerialPort-master
 * 包名：com.kongqw.serialport.Impl
 * 文件名：DeleteImagImpl
 * 创建者 ：${梅华黎}
 * 创建时间： 2017/12/25 21:34
 * 描述：每次下载成功一张图片后就去 掉用该接口来删除 这张图片
 */
public class DeleteImagImpl implements DeleteImageMode {

    @Override
    public void DeleteImage(onSetDeleteImageLinerest linerest, String addId,String sign) {
        String url = ZhuZhanIp.zhuzhan+"/api/syncApiController/callBackAd";
        OkGo.<String>post(url)
                .params("id", addId)
                .params("sign",sign)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        L.e("删除图片："+response.body());
                    }

                    @Override
                    public void onError(Response<String> response) {
                        super.onError(response);
                        L.e("删除图片失败："+response.message());
                    }
                });
    }
}
