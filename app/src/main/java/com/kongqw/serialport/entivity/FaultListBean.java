package com.kongqw.serialport.entivity;

import java.util.List;

/**
 * 项目名：AndroidSerialPort-master
 * 包名：com.kongqw.serialport.entivity
 * 文件名：FaultListBean
 * 创建者 ：${梅华黎}
 * 创建时间： 2017/12/28 11:09
 * 描述：TODO
 */
public class FaultListBean {

    /**
     * resultCode : 0
     * resultMessage : success
     * resultData : [{"id":"f49f8c13dbf84b4ca06ebfd51decd02f","updateDate":"2017-12-28 10:42:45","createDate":"2017-12-28 10:42:45","first":null,"max":null,"orderBy":null,"updateDateStart":null,"updateDateEnd":null,"createDateStart":null,"createDateEnd":null,"equipmentNumber":"cs2017121216011","level":3,"content":"恭恭敬敬","status":1,"transactor":null,"agentId":null,"agentName":"2dasdasd"},{"id":"49af46e2e1814b5ead7c62d07c02db70","updateDate":"2017-12-28 11:02:27","createDate":"2017-12-28 11:02:27","first":null,"max":null,"orderBy":null,"updateDateStart":null,"updateDateEnd":null,"createDateStart":null,"createDateEnd":null,"equipmentNumber":"cs2017121216011","level":3,"content":"恭恭敬敬","status":1,"transactor":null,"agentId":null,"agentName":"2dasdasd"},{"id":"97d0fc368b3b45d7a6a879e21f407fe0","updateDate":"2017-12-28 11:03:13","createDate":"2017-12-28 11:03:13","first":null,"max":null,"orderBy":null,"updateDateStart":null,"updateDateEnd":null,"createDateStart":null,"createDateEnd":null,"equipmentNumber":"cs2017121216011","level":3,"content":"木","status":1,"transactor":null,"agentId":null,"agentName":"2dasdasd"}]
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

    public static class ResultDataBean {
        /**
         * id : f49f8c13dbf84b4ca06ebfd51decd02f
         * updateDate : 2017-12-28 10:42:45
         * createDate : 2017-12-28 10:42:45
         * first : null
         * max : null
         * orderBy : null
         * updateDateStart : null
         * updateDateEnd : null
         * createDateStart : null
         * createDateEnd : null
         * equipmentNumber : cs2017121216011
         * level : 3
         * content : 恭恭敬敬
         * status : 1
         * transactor : null
         * agentId : null
         * agentName : 2dasdasd
         */

        private String id;
        private String updateDate;
        private String createDate;
        private Object first;
        private Object max;
        private Object orderBy;
        private Object updateDateStart;
        private Object updateDateEnd;
        private Object createDateStart;
        private Object createDateEnd;
        private String equipmentNumber;
        private int level;
        private String content;
        private int status;
        private Object transactor;
        private Object agentId;
        private String agentName;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getUpdateDate() {
            return updateDate;
        }

        public void setUpdateDate(String updateDate) {
            this.updateDate = updateDate;
        }

        public String getCreateDate() {
            return createDate;
        }

        public void setCreateDate(String createDate) {
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

        public int getLevel() {
            return level;
        }

        public void setLevel(int level) {
            this.level = level;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public Object getTransactor() {
            return transactor;
        }

        public void setTransactor(Object transactor) {
            this.transactor = transactor;
        }

        public Object getAgentId() {
            return agentId;
        }

        public void setAgentId(Object agentId) {
            this.agentId = agentId;
        }

        public String getAgentName() {
            return agentName;
        }

        public void setAgentName(String agentName) {
            this.agentName = agentName;
        }
    }
}
