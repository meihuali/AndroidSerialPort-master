package com.kongqw.serialport.entivity;

import java.util.List;

/**
 * 项目名：AndroidSerialPort-master
 * 包名：com.kongqw.serialport.entivity
 * 文件名：HeartBeatBean
 * 创建者 ：${梅华黎}
 * 创建时间： 2017/12/23 14:24
 * 描述：TODO
 */
public class HeartBeatBean {

    /**
     * resultCode : 0
     * resultMessage : success
     * resultData : {"data":["advertisement"],"info":{"id":"5ca50c8164ec4dd4afc712769dcd7035","updateDate":"2017-12-23 14:19:43","createDate":"2017-12-12 15:41:07","first":null,"max":null,"orderBy":null,"updateDateStart":null,"updateDateEnd":null,"createDateStart":null,"createDateEnd":null,"number":"cs201712121540","agentId":"7de95c4454414725a6b84402c3e2fcc2","position":"广州白云区","userName":"asd","userPhone":"13543214321","userAddress":"汇金广场","lastOnlineDate":"2017-12-23 14:19:43","balance":"10.00","point":0,"clickAdTime":0,"isCharging":1,"locked":0,"enable":0,"creatorId":"4e3c399a28b449c3a939877ab38ba739","lastAmendment":null,"type":1,"agentName":null}}
     */

    private int resultCode;
    private String resultMessage;
    private ResultDataBean resultData;

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

    public ResultDataBean getResultData() {
        return resultData;
    }

    public void setResultData(ResultDataBean resultData) {
        this.resultData = resultData;
    }

    public static class ResultDataBean {
        /**
         * data : ["advertisement"]
         * info : {"id":"5ca50c8164ec4dd4afc712769dcd7035","updateDate":"2017-12-23 14:19:43","createDate":"2017-12-12 15:41:07","first":null,"max":null,"orderBy":null,"updateDateStart":null,"updateDateEnd":null,"createDateStart":null,"createDateEnd":null,"number":"cs201712121540","agentId":"7de95c4454414725a6b84402c3e2fcc2","position":"广州白云区","userName":"asd","userPhone":"13543214321","userAddress":"汇金广场","lastOnlineDate":"2017-12-23 14:19:43","balance":"10.00","point":0,"clickAdTime":0,"isCharging":1,"locked":0,"enable":0,"creatorId":"4e3c399a28b449c3a939877ab38ba739","lastAmendment":null,"type":1,"agentName":null}
         */

        private InfoBean info;
        private List<String> data;

        public InfoBean getInfo() {
            return info;
        }

        public void setInfo(InfoBean info) {
            this.info = info;
        }

        public List<String> getData() {
            return data;
        }

        public void setData(List<String> data) {
            this.data = data;
        }

        public static class InfoBean {
            /**
             * id : 5ca50c8164ec4dd4afc712769dcd7035
             * updateDate : 2017-12-23 14:19:43
             * createDate : 2017-12-12 15:41:07
             * first : null
             * max : null
             * orderBy : null
             * updateDateStart : null
             * updateDateEnd : null
             * createDateStart : null
             * createDateEnd : null
             * number : cs201712121540
             * agentId : 7de95c4454414725a6b84402c3e2fcc2
             * position : 广州白云区
             * userName : asd
             * userPhone : 13543214321
             * userAddress : 汇金广场
             * lastOnlineDate : 2017-12-23 14:19:43
             * balance : 10.00
             * point : 0
             * clickAdTime : 0
             * isCharging : 1
             * locked : 0
             * enable : 0
             * creatorId : 4e3c399a28b449c3a939877ab38ba739
             * lastAmendment : null
             * type : 1
             * agentName : null
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
            private String number;
            private String agentId;
            private String position;
            private String userName;
            private String userPhone;
            private String userAddress;
            private String lastOnlineDate;
            private String balance;
            private int point;
            private int clickAdTime;
            private int isCharging;
            private int locked;
            private int enable;
            private String creatorId;
            private Object lastAmendment;
            private int type;
            private Object agentName;

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

            public String getNumber() {
                return number;
            }

            public void setNumber(String number) {
                this.number = number;
            }

            public String getAgentId() {
                return agentId;
            }

            public void setAgentId(String agentId) {
                this.agentId = agentId;
            }

            public String getPosition() {
                return position;
            }

            public void setPosition(String position) {
                this.position = position;
            }

            public String getUserName() {
                return userName;
            }

            public void setUserName(String userName) {
                this.userName = userName;
            }

            public String getUserPhone() {
                return userPhone;
            }

            public void setUserPhone(String userPhone) {
                this.userPhone = userPhone;
            }

            public String getUserAddress() {
                return userAddress;
            }

            public void setUserAddress(String userAddress) {
                this.userAddress = userAddress;
            }

            public String getLastOnlineDate() {
                return lastOnlineDate;
            }

            public void setLastOnlineDate(String lastOnlineDate) {
                this.lastOnlineDate = lastOnlineDate;
            }

            public String getBalance() {
                return balance;
            }

            public void setBalance(String balance) {
                this.balance = balance;
            }

            public int getPoint() {
                return point;
            }

            public void setPoint(int point) {
                this.point = point;
            }

            public int getClickAdTime() {
                return clickAdTime;
            }

            public void setClickAdTime(int clickAdTime) {
                this.clickAdTime = clickAdTime;
            }

            public int getIsCharging() {
                return isCharging;
            }

            public void setIsCharging(int isCharging) {
                this.isCharging = isCharging;
            }

            public int getLocked() {
                return locked;
            }

            public void setLocked(int locked) {
                this.locked = locked;
            }

            public int getEnable() {
                return enable;
            }

            public void setEnable(int enable) {
                this.enable = enable;
            }

            public String getCreatorId() {
                return creatorId;
            }

            public void setCreatorId(String creatorId) {
                this.creatorId = creatorId;
            }

            public Object getLastAmendment() {
                return lastAmendment;
            }

            public void setLastAmendment(Object lastAmendment) {
                this.lastAmendment = lastAmendment;
            }

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }

            public Object getAgentName() {
                return agentName;
            }

            public void setAgentName(Object agentName) {
                this.agentName = agentName;
            }
        }
    }
}
