package com.hy.model;

import java.sql.Date;
import java.util.List;

/**
 * Created by shakaiyue on 22:10 2019/4/17.
 * description:预约看房实体类
 */
public class OrderRecordDomain {

    private Integer orderId;        // 预约Id

    private String orderUsId;       // 预约人ID
    private String orderName;       // 预约人姓名
    private String orderTel;        // 预约人电话
    private String orderHouseId;    // 预约楼盘Id
    private String orderHouseName;  // 预约楼盘名称
    private Date crtTime;           // 创建时间
    private Date updateTime;        // 更新时间
    private String dataState;       // data状态'

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getOrderUsId() {
        return orderUsId;
    }

    public void setOrderUsId(String orderUsId) {
        this.orderUsId = orderUsId;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public String getOrderTel() {
        return orderTel;
    }

    public void setOrderTel(String orderTel) {
        this.orderTel = orderTel;
    }

    public String getOrderHouseId() {
        return orderHouseId;
    }

    public void setOrderHouseId(String orderHouseId) {
        this.orderHouseId = orderHouseId;
    }

    public Date getCrtTime() {
        return crtTime;
    }

    public void setCrtTime(Date crtTime) {
        this.crtTime = crtTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getDataState() {
        return dataState;
    }

    public void setDataState(String dataState) {
        this.dataState = dataState;
    }

    public String getOrderHouseName() {
        return orderHouseName;
    }

    public void setOrderHouseName(String orderHouseName) {
        this.orderHouseName = orderHouseName;
    }
}
