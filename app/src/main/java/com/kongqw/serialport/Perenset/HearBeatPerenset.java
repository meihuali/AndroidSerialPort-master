package com.kongqw.serialport.Perenset;

import com.kongqw.serialport.Impl.HearBeatImpl;
import com.kongqw.serialport.View.HearBeatView;
import com.kongqw.serialport.model.HeartbeatModel;

/**
 * 项目名：AndroidSerialPort-master
 * 包名：com.kongqw.serialport.Perenset
 * 文件名：HearBeatPerenset
 * 创建者 ：${梅华黎}
 * 创建时间： 2017/12/23 14:08
 * 描述：TODO
 */
public class HearBeatPerenset {
    HeartbeatModel heartbeatModel;
    HearBeatView hearBeatView;

    public HearBeatPerenset(HearBeatView hearBeatView) {
        this.heartbeatModel = new HearBeatImpl();
        this.hearBeatView = hearBeatView;
    }

    public void getImageView(String number, String postion,String sign) {
        if (heartbeatModel != null) {
            heartbeatModel.GetHeartData(new HeartbeatModel.onGetHeartDataLinerent() {
                @Override
                public void onComplete(Object object) {
                    hearBeatView.showRelust(object);
                }

                @Override
                public void onErrorComplte() {
                    hearBeatView.showErroy();
                }
            },number,postion,sign);
        }
    }
}
