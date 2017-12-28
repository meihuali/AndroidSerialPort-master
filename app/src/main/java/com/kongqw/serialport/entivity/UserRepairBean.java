package com.kongqw.serialport.entivity;

/**
 * 项目名：AndroidSerialPort-master
 * 包名：com.kongqw.serialport.entivity
 * 文件名：UserRepairBean
 * 创建者 ：${梅华黎}
 * 创建时间： 2017/12/28 10:43
 * 描述：TODO
 */
public class UserRepairBean {

    /**
     * resultCode : 0
     * resultMessage : success
     * resultData : null
     */

    private int resultCode;
    private String resultMessage;
    private Object resultData;

    public int getResultCode() {
        return resultCode;
    }

    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultMessage() {
        return resultMessage;
    }

    public void setResultMessage(String resultMessage) {
        this.resultMessage = resultMessage;
    }

    public Object getResultData() {
        return resultData;
    }

    public void setResultData(Object resultData) {
        this.resultData = resultData;
    }
}
