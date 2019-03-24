package com.hy.model;

import java.sql.Date;

/**
 * Created by yaohou on 22:10 2019/3/21.
 * description:
 */
public class AppDomain {
    private Integer id;
    private String appName;
    private String appId;
    private String appSecret;
    private String appStatus;
    private String phone;
    private Date crtTime;
    private Date rcntlyTime;
    private String comment;

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getCrtTime() {
        return crtTime;
    }

    public void setCrtTime(Date crtTime) {
        this.crtTime = crtTime;
    }

    public Date getRcntlyTime() {
        return rcntlyTime;
    }

    public void setRcntlyTime(Date rcntlyTime) {
        this.rcntlyTime = rcntlyTime;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getAppSecret() {
        return appSecret;
    }

    public void setAppSecret(String appSecret) {
        this.appSecret = appSecret;
    }

    public String getAppStatus() {
        return appStatus;
    }

    public void setAppStatus(String appStatus) {
        this.appStatus = appStatus;
    }
}
