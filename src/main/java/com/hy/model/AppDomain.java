package com.hy.model;

import java.sql.Date;
import java.util.List;

/** Created by yaohou on 22:10 2019/3/21. description:用户实体类 */
public class AppDomain {
  private String userId;
  private String appName;
  private String appId;
  private String appSecret;
  private String userName;
  private String userIdCard;
  private String userPhone;
  private String userType;
  private String housesId;
  private String houseTypeId;
  private String companyName;
  private String parentId;
  private String userState;
  private Date crtTime;
  private Date updateTime;

  public AppDomain(String appName, String appId, String appSecret, String userName) {
    this.appName = appName;
    this.appId = appId;
    this.appSecret = appSecret;
    this.userName = userName;
  }

  public AppDomain() {}

  public AppDomain(
      String userId,
      String appName,
      String appId,
      String appSecret,
      String userName,
      String userIdCard,
      String userPhone,
      String userType,
      String housesId,
      String houseTypeId,
      String companyName,
      String parentId,
      String userState,
      Date crtTime,
      Date updateTime,
      List<SellDomain> sellList) {
    this.userId = userId;
    this.appName = appName;
    this.appId = appId;
    this.appSecret = appSecret;
    this.userName = userName;
    this.userIdCard = userIdCard;
    this.userPhone = userPhone;
    this.userType = userType;
    this.housesId = housesId;
    this.houseTypeId = houseTypeId;
    this.companyName = companyName;
    this.parentId = parentId;
    this.userState = userState;
    this.crtTime = crtTime;
    this.updateTime = updateTime;
    this.sellList = sellList;
  }

  private List<SellDomain> sellList; // 销售信息

  public List<SellDomain> getSellList() {
    return sellList;
  }

  public void setSellList(List<SellDomain> sellList) {
    this.sellList = sellList;
  }

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public String getAppName() {
    return appName;
  }

  public void setAppName(String appName) {
    this.appName = appName;
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

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getUserIdCard() {
    return userIdCard;
  }

  public void setUserIdCard(String userIdCard) {
    this.userIdCard = userIdCard;
  }

  public String getUserPhone() {
    return userPhone;
  }

  public void setUserPhone(String userPhone) {
    this.userPhone = userPhone;
  }

  public String getUserType() {
    return userType;
  }

  public void setUserType(String userType) {
    this.userType = userType;
  }

  public String getHousesId() {
    return housesId;
  }

  public void setHousesId(String housesId) {
    this.housesId = housesId;
  }

  public String getHouseTypeId() {
    return houseTypeId;
  }

  public void setHouseTypeId(String houseTypeId) {
    this.houseTypeId = houseTypeId;
  }

  public String getCompanyName() {
    return companyName;
  }

  public void setCompanyName(String companyName) {
    this.companyName = companyName;
  }

  public String getParentId() {
    return parentId;
  }

  public void setParentId(String parentId) {
    this.parentId = parentId;
  }

  public String getUserState() {
    return userState;
  }

  public void setUserState(String userState) {
    this.userState = userState;
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
}
