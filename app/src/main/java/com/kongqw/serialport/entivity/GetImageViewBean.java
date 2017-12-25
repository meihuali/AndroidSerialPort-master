package com.kongqw.serialport.entivity;

import java.io.Serializable;
import java.util.List;

/**
 * 项目名：AndroidSerialPort-master
 * 包名：com.kongqw.serialport.entivity
 * 文件名：GetImageViewBean
 * 创建者 ：${梅华黎}
 * 创建时间： 2017/12/23 14:54
 * 描述：TODO
 */
public class GetImageViewBean implements Serializable {

    /**
     * resultCode : 0
     * resultMessage : success
     * resultData : [{"id":"1c157bfbe7a111e79b8600163e2cd77f","updateDate":null,"createDate":null,"first":null,"max":null,"orderBy":null,"updateDateStart":null,"updateDateEnd":null,"createDateStart":null,"createDateEnd":null,"equipmentNumber":"cs201712121540","type":"advertisement","value":null,"agentIds":null,"agentName":null,"adId":"51ed56420d2f499699e62f3efb63f77d","adUrl":"/uploads/sys/images/66a370b36b3f47aa81d79682c5c1367f1512029791837.gif"},{"id":"1c15f518e7a111e79b8600163e2cd77f","updateDate":null,"createDate":null,"first":null,"max":null,"orderBy":null,"updateDateStart":null,"updateDateEnd":null,"createDateStart":null,"createDateEnd":null,"equipmentNumber":"cs201712121540","type":"advertisement","value":null,"agentIds":null,"agentName":null,"adId":"32b723d80fa340f0900e45e606f717a2","adUrl":"/uploads/sys/images/b3c2ea553de341c085afdf73781867c91512026706522.jpg"},{"id":"1c166c60e7a111e79b8600163e2cd77f","updateDate":null,"createDate":null,"first":null,"max":null,"orderBy":null,"updateDateStart":null,"updateDateEnd":null,"createDateStart":null,"createDateEnd":null,"equipmentNumber":"cs201712121540","type":"advertisement","value":null,"agentIds":null,"agentName":null,"adId":"a5f8c90ec7294ed6b2b6535c59bf504e","adUrl":"/uploads/sys/images/592dec1cbf864b13bcbc6aab24cb87b91513068898851.txt"},{"id":"1c16ebe5e7a111e79b8600163e2cd77f","updateDate":null,"createDate":null,"first":null,"max":null,"orderBy":null,"updateDateStart":null,"updateDateEnd":null,"createDateStart":null,"createDateEnd":null,"equipmentNumber":"cs201712121540","type":"advertisement","value":null,"agentIds":null,"agentName":null,"adId":"caed24103ca84470b2b1a30e9f2dc47e","adUrl":"/uploads/sys/images/bb25ce1797704050844cf206383807d81513067280311.png"}]
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

    public static class ResultDataBean implements Serializable {
        /**
         * id : 1c157bfbe7a111e79b8600163e2cd77f
         * updateDate : null
         * createDate : null
         * first : null
         * max : null
         * orderBy : null
         * updateDateStart : null
         * updateDateEnd : null
         * createDateStart : null
         * createDateEnd : null
         * equipmentNumber : cs201712121540
         * type : advertisement
         * value : null
         * agentIds : null
         * agentName : null
         * adId : 51ed56420d2f499699e62f3efb63f77d
         * adUrl : /uploads/sys/images/66a370b36b3f47aa81d79682c5c1367f1512029791837.gif
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
        private String equipmentNumber;
        private String type;
        private Object value;
        private Object agentIds;
        private Object agentName;
        private String adId;
        private String adUrl;

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

        public String getEquipmentNumber() {
            return equipmentNumber;
        }

        public void setEquipmentNumber(String equipmentNumber) {
            this.equipmentNumber = equipmentNumber;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public Object getValue() {
            return value;
        }

        public void setValue(Object value) {
            this.value = value;
        }

        public Object getAgentIds() {
            return agentIds;
        }

        public void setAgentIds(Object agentIds) {
            this.agentIds = agentIds;
        }

        public Object getAgentName() {
            return agentName;
        }

        public void setAgentName(Object agentName) {
            this.agentName = agentName;
        }

        public String getAdId() {
            return adId;
        }

        public void setAdId(String adId) {
            this.adId = adId;
        }

        public String getAdUrl() {
            return adUrl;
        }

        public void setAdUrl(String adUrl) {
            this.adUrl = adUrl;
        }
    }
}
