package com.kongqw.serialport.Impl;

import com.google.gson.Gson;
import com.kongqw.serialport.ConfigUtils.ZhuZhanIp;
import com.kongqw.serialport.entivity.HeartBeatBean;
import com.kongqw.serialport.model.HeartbeatModel;
import com.kongqw.serialport.utils.L;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

import java.util.List;

/**
 * 项目名：AndroidSerialPort-master
 * 包名：com.kongqw.serialport.Impl
 * 文件名：HearBeatImpl
 * 创建者 ：${梅华黎}
 * 创建时间： 2017/12/23 13:59
 * 描述：广告显示的接口
 */
public class HearBeatImpl implements HeartbeatModel {


    @Override
    public void GetHeartData(final onGetHeartDataLinerent linerent, String number, String position,String sign) {
        String url = ZhuZhanIp.zhuzhan + "/api/equipmentApiController/heartbeat";
        OkGo.<String>post(url)
                .params("number",number)
                .params("position",position)
                .params("sign",sign)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        L.e("心跳请求:"+response.body());
                        Gson gson = new Gson();
                       HeartBeatBean heartBeatBean =  gson.fromJson( response.body(),HeartBeatBean.class);
                       linerent.onComplete(heartBeatBean);

                    }

                    @Override
                    public void onError(Response<String> response) {
                        super.onError(response);
                        linerent.onErrorComplte();
                    }
                });

    }
}
