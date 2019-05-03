package com.hy.model;

/** Created by yaohou on 12:05 2019/5/3. description:佣金参数实体 */
public class BrokeragParamDomain {
  private String id;
  private String housesId; // 楼盘id
  private String userParentId; // 经纪公司id
  private String userId; // 经纪人id
  private String address; // 所属区域
  private String brokerage; // 佣金
  private String brokerType; // 佣金类型：1.固定，2.比例
  private String crtTime; // 创建时间
  private String updateTime; // 更新时间

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

  public String getUserParentId() {
    return userParentId;
  }

  public void setUserParentId(String userParentId) {
    this.userParentId = userParentId;
  }

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getBrokerage() {
    return brokerage;
  }

  public void setBrokerage(String brokerage) {
    this.brokerage = brokerage;
  }

  public String getBrokerType() {
    return brokerType;
  }

  public void setBrokerType(String brokerType) {
    this.brokerType = brokerType;
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
}
