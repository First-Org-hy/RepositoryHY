package com.hy.model;

/**
 * Created by yaohou on 15:57 2019/4/3.
 * description:推荐客户实体类
 */
public class RecommendDomain {
    private String id;
    private String housesId;
    private String userId;
    private String userName;
    private String guestName;
    private String guestPhone;
    private String dealState;
    private String crtTime;
    private String updateTime;

    private String userParentId;//经纪公司id

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHousesId() {
        return housesId;
    }

    public void setHousesId(String housesId) {
        this.housesId = housesId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getGuestName() {
        return guestName;
    }

    public void setGuestName(String guestName) {
        this.guestName = guestName;
    }

    public String getGuestPhone() {
        return guestPhone;
    }

    public void setGuestPhone(String guestPhone) {
        this.guestPhone = guestPhone;
    }

    public String getDealState() {
        return dealState;
    }

    public void setDealState(String dealState) {
        this.dealState = dealState;
    }

    public String getCrtTime() {
        return crtTime;
    }

    public void setCrtTime(String crtTime) {
        this.crtTime = crtTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getUserParentId() {
        return userParentId;
    }

    public void setUserParentId(String userParentId) {
        this.userParentId = userParentId;
    }
}
