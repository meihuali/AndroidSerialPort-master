package com.kongqw.serialport.entivity;

/**
 * 项目名：AndroidSerialPort-master
 * 包名：com.kongqw.serialport.entivity
 * 文件名：ExchangGiftBean
 * 创建者 ：${梅华黎}
 * 创建时间： 2017/12/17 0017 18:52
 * 描述：TODO
 */
public class ExchangGiftBean {
    String name;
    String jifen;
    boolean isSelect =false ;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJifen() {
        return jifen;
    }

    public void setJifen(String jifen) {
        this.jifen = jifen;
    }

    public boolean isSelect() {
        return isSelect;
    }

    public void setSelect(boolean select) {
        isSelect = select;
    }
}
