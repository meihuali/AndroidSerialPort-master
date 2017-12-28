package com.kongqw.serialport.entivity;

import java.util.List;

/**
 * 项目名：AndroidSerialPort-master
 * 包名：com.kongqw.serialport.entivity
 * 文件名：ShangpinBean
 * 创建者 ：${梅华黎}
 * 创建时间： 2017/12/27 16:09
 * 描述：TODO
 */
public class ShangpinBean {

    /**
     * resultCode : 0
     * resultMessage : success
     * resultData : [{"id":"d737e82dcd6f42af862b8589b87683a8","updateDate":"2017-12-23 23:20:22","createDate":"2017-12-23 23:20:22","first":null,"max":null,"orderBy":null,"updateDateStart":null,"updateDateEnd":null,"createDateStart":null,"createDateEnd":null,"name":"健康盒子","point":515,"inventory":411,"description":"常用药","imgUrl":"/uploads/sys/images/goods/c5b86dddb8f24ff9ab30ab804e1dab441514042422402.png","enable":1},{"id":"b8a1f83d42014c97b210dabd224d0c30","updateDate":"2017-12-23 23:19:50","createDate":"2017-12-23 23:19:50","first":null,"max":null,"orderBy":null,"updateDateStart":null,"updateDateEnd":null,"createDateStart":null,"createDateEnd":null,"name":"路由器","point":222,"inventory":444,"description":"wifi1111","imgUrl":"/uploads/sys/images/goods/7604a53a41c444ebb601227a6be5bb811514042390217.png","enable":1},{"id":"6f5900b97bbe4dc29b532a811040b81e","updateDate":"2017-12-23 23:19:10","createDate":"2017-12-23 23:19:10","first":null,"max":null,"orderBy":null,"updateDateStart":null,"updateDateEnd":null,"createDateStart":null,"createDateEnd":null,"name":"充电宝","point":123,"inventory":123,"description":"5V12000MAH","imgUrl":"/uploads/sys/images/goods/402da5e7efd14e03a83e8f66385c01111514042350436.png","enable":1}]
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
         * id : d737e82dcd6f42af862b8589b87683a8
         * updateDate : 2017-12-23 23:20:22
         * createDate : 2017-12-23 23:20:22
         * first : null
         * max : null
         * orderBy : null
         * updateDateStart : null
         * updateDateEnd : null
         * createDateStart : null
         * createDateEnd : null
         * name : 健康盒子
         * point : 515
         * inventory : 411
         * description : 常用药
         * imgUrl : /uploads/sys/images/goods/c5b86dddb8f24ff9ab30ab804e1dab441514042422402.png
         * enable : 1
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
        private String name;
        private int point;
        private int inventory;
        private String description;
        private String imgUrl;
        private int enable;

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

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getPoint() {
            return point;
        }

        public void setPoint(int point) {
            this.point = point;
        }

        public int getInventory() {
            return inventory;
        }

        public void setInventory(int inventory) {
            this.inventory = inventory;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getImgUrl() {
            return imgUrl;
        }

        public void setImgUrl(String imgUrl) {
            this.imgUrl = imgUrl;
        }

        public int getEnable() {
            return enable;
        }

        public void setEnable(int enable) {
            this.enable = enable;
        }
    }
}
