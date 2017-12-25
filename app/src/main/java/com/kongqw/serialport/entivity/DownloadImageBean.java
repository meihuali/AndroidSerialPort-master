package com.kongqw.serialport.entivity;

import java.io.Serializable;

/**
 * 项目名：AndroidSerialPort-master
 * 包名：com.kongqw.serialport.entivity
 * 文件名：downloadImageBean
 * 创建者 ：${梅华黎}
 * 创建时间： 2017/12/25 21:09
 * 描述：保存下载后的图片 实体
 */
public class DownloadImageBean implements Serializable{
    String addurl;
    String addid;

    public String getAddurl() {
        return addurl;
    }

    public void setAddurl(String addurl) {
        this.addurl = addurl;
    }

    public String getAddid() {
        return addid;
    }

    public void setAddid(String addid) {
        this.addid = addid;
    }
}
