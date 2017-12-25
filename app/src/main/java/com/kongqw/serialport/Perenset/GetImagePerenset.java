package com.kongqw.serialport.Perenset;

import com.kongqw.serialport.Impl.GetImageImageImpl;
import com.kongqw.serialport.View.GetImageView;
import com.kongqw.serialport.model.GetImageModel;

/**
 * 项目名：AndroidSerialPort-master
 * 包名：com.kongqw.serialport.Perenset
 * 文件名：GetImagePerenset
 * 创建者 ：${梅华黎}
 * 创建时间： 2017/12/23 14:45
 * 描述：TODO
 */
public class GetImagePerenset {
    GetImageModel getImageModel;
    GetImageView getImageView;

    public GetImagePerenset(GetImageView getImageView) {
        this.getImageView = getImageView;
        getImageModel = new GetImageImageImpl();
    }

    public void getImageViewData(String number, String type, String sign) {
        if (getImageModel != null) {
            getImageModel.GetImageView(new GetImageModel.setOnGetImageLineset() {
                @Override
                public void onComple(Object object) {
                    getImageView.showImageRlest(object);
                }

                @Override
                public void onErroy() {
                    getImageView.showImageErroy();
                }
            }, number,  type,  sign);
        }
    }
}
