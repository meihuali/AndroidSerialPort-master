package com.kongqw.serialport.Perenset;

import com.kongqw.serialport.Impl.DeleteImagImpl;
import com.kongqw.serialport.View.DeleteImageView;
import com.kongqw.serialport.model.DeleteImageMode;

/**
 * 项目名：AndroidSerialPort-master
 * 包名：com.kongqw.serialport.Perenset
 * 文件名：DeltePerenst
 * 创建者 ：${梅华黎}
 * 创建时间： 2017/12/25 21:44
 * 描述：TODO
 */
public class DeltePerenst {
    DeleteImageMode deleteImageMode;
    DeleteImageView deleteImageView;

    public DeltePerenst(DeleteImageView deleteImageView) {
        this.deleteImageView = deleteImageView;
        deleteImageMode = new DeleteImagImpl();
    }

    public void delteImage(String addid, String sign) {
        if (deleteImageMode != null) {
            deleteImageMode.DeleteImage(new DeleteImageMode.onSetDeleteImageLinerest() {

                @Override
                public void onDeleteImgOnscc(Object object) {
                    deleteImageView.delteSoccuc(object);
                }

                @Override
                public void onDeleteImgOnError() {
                    deleteImageView.deletError();
                }
            },addid,sign);
        }
    }
}
