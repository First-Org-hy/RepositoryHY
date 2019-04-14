package com.hy.model;

import java.sql.Date;

/**
 * Created by shakaiyue on 22:10 2019/4/12.
 * description:租房实体类
 */
public class RentHouseDomain {

    private Integer id;
    private String secondHouseId;    // 租房房屋Id
    private String houseName;        // 租房名称：一期10栋A户型
    private String houseArea;        // 区域
    private String houseAddress;     // 地址
    private String housePlot;        // 小区
    private String houseSize;        // 房屋面积
    private String houseTypeId;      // 户型
    private String houseBound;       // 朝向
    private String houseFloor;       // 楼层
    private String houseFixType;     // 装修类型：0毛坯 1简装、2精装
    private String houseType;        // 户型：0整租 1合租
    private String houseStyleId;     // 特点，使用标签表
    private String housePicAddress;  // 照片地址
    private String houseMonPrice;    // 房租租金 月
    private String houseYearPrice;   // 房租租金 年
    private String houseSou;         // 房源介绍
    private String houseState;       // 是否已被租：0是 1否
    private String housePulId;       // 发布者
    private Date crtTime;          // 创建时间
    private Date updateTime;       // 更新时间
    private String dataState;        // data状态'

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSecondHouseId() {
        return secondHouseId;
    }

    public void setSecondHouseId(String secondHouseId) {
        this.secondHouseId = secondHouseId;
    }

    public String getHouseName() {
        return houseName;
    }

    public void setHouseName(String houseName) {
        this.houseName = houseName;
    }

    public String getHouseArea() {
        return houseArea;
    }

    public void setHouseArea(String houseArea) {
        this.houseArea = houseArea;
    }

    public String getHouseAddress() {
        return houseAddress;
    }

    public void setHouseAddress(String houseAddress) {
        this.houseAddress = houseAddress;
    }

    public String getHousePlot() {
        return housePlot;
    }

    public void setHousePlot(String housePlot) {
        this.housePlot = housePlot;
    }

    public String getHouseSize() {
        return houseSize;
    }

    public void setHouseSize(String houseSize) {
        this.houseSize = houseSize;
    }

    public String getHouseTypeId() {
        return houseTypeId;
    }

    public void setHouseTypeId(String houseTypeId) {
        this.houseTypeId = houseTypeId;
    }

    public String getHouseType() {
        return houseType;
    }

    public void setHouseType(String houseType) {
        this.houseType = houseType;
    }

    public String getHouseStyleId() {
        return houseStyleId;
    }

    public void setHouseStyleId(String houseStyleId) {
        this.houseStyleId = houseStyleId;
    }

    public String getHousePicAddress() {
        return housePicAddress;
    }

    public void setHousePicAddress(String housePicAddress) {
        this.housePicAddress = housePicAddress;
    }

    public String getHouseMonPrice() {
        return houseMonPrice;
    }

    public void setHouseMonPrice(String houseMonPrice) {
        this.houseMonPrice = houseMonPrice;
    }

    public String getHouseYearPrice() {
        return houseYearPrice;
    }

    public void setHouseYearPrice(String houseYearPrice) {
        this.houseYearPrice = houseYearPrice;
    }

    public String getHouseSou() {
        return houseSou;
    }

    public void setHouseSou(String houseSou) {
        this.houseSou = houseSou;
    }

    public String getHouseState() {
        return houseState;
    }

    public void setHouseState(String houseState) {
        this.houseState = houseState;
    }

    public String getHousePulId() {
        return housePulId;
    }

    public void setHousePulId(String housePulId) {
        this.housePulId = housePulId;
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

    public String getHouseBound() {
        return houseBound;
    }

    public void setHouseBound(String houseBound) {
        this.houseBound = houseBound;
    }

    public String getHouseFloor() {
        return houseFloor;
    }

    public void setHouseFloor(String houseFloor) {
        this.houseFloor = houseFloor;
    }

    public String getHouseFixType() {
        return houseFixType;
    }

    public void setHouseFixType(String houseFixType) {
        this.houseFixType = houseFixType;
    }
}
