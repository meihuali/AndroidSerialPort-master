package com.kongqw.serialport.entivity;

import java.io.Serializable;
import java.util.List;

/**
 * 项目名：AndroidSerialPort-master
 * 包名：com.kongqw.serialport.entivity
 * 文件名：MyExchangeBean
 * 创建者 ：${梅华黎}
 * 创建时间： 2017/12/26 21:10
 * 描述：获取积分的实体类
 */
public class MyExchangeBean implements Serializable{

    /**
     * resultCode : 0
     * resultMessage : success
     * resultData : [{"id":"d7763059d57a4c2489224ed82c1f78f1","updateDate":null,"createDate":null,"first":null,"max":null,"orderBy":null,"updateDateStart":null,"updateDateEnd":null,"createDateStart":null,"createDateEnd":null,"point":111,"money":1,"content":"好用商品兑换发行啦！,本次积分兑换是111积分兑换1元。"}]
     */

    private int resultCode;
    private String resultMessage;
    private List<ResultDataBean> resultData;

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

    public List<ResultDataBean> getResultData() {
        return resultData;
    }

    public void setResultData(List<ResultDataBean> resultData) {
        this.resultData = resultData;
    }

    public static class ResultDataBean implements Serializable{
        /**
         * id : d7763059d57a4c2489224ed82c1f78f1
         * updateDate : null
         * createDate : null
         * first : null
         * max : null
         * orderBy : null
         * updateDateStart : null
         * updateDateEnd : null
         * createDateStart : null
         * createDateEnd : null
         * point : 111
         * money : 1
         * content : 好用商品兑换发行啦！,本次积分兑换是111积分兑换1元。
         */

        private String id;
        private Object updateDate;
        private Object createDate;
        private Object first;
        private Object max;
        private Object orderBy;
        private Object updateDateStart;
        private Object updateDateEnd;
        private Object createDateStart;
        private Object createDateEnd;
        private int point;
        private int money;
        private String content;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public Object getUpdateDate() {
            return updateDate;
        }

        public void setUpdateDate(Object updateDate) {
            this.updateDate = updateDate;
        }

        public Object getCreateDate() {
            return createDate;
        }

        public void setCreateDate(Object createDate) {
            this.createDate = createDate;
        }

        public Object getFirst() {
            return first;
        }

        public void setFirst(Object first) {
            this.first = first;
        }

        public Object getMax() {
            return max;
        }

        public void setMax(Object max) {
            this.max = max;
        }

        public Object getOrderBy() {
            return orderBy;
        }

        public void setOrderBy(Object orderBy) {
            this.orderBy = orderBy;
        }

        public Object getUpdateDateStart() {
            return updateDateStart;
        }

        public void setUpdateDateStart(Object updateDateStart) {
            this.updateDateStart = updateDateStart;
        }

        public Object getUpdateDateEnd() {
            return updateDateEnd;
        }

        public void setUpdateDateEnd(Object updateDateEnd) {
            this.updateDateEnd = updateDateEnd;
        }

        public Object getCreateDateStart() {
            return createDateStart;
        }

        public void setCreateDateStart(Object createDateStart) {
            this.createDateStart = createDateStart;
        }

        public Object getCreateDateEnd() {
            return createDateEnd;
        }

        public void setCreateDateEnd(Object createDateEnd) {
            this.createDateEnd = createDateEnd;
        }

        public int getPoint() {
            return point;
        }

        public void setPoint(int point) {
            this.point = point;
        }

        public int getMoney() {
            return money;
        }

        public void setMoney(int money) {
            this.money = money;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }
    }
}
