package com.hy.model;

/** Created by yaohou on 12:05 2019/5/3. description:客户实体 */
public class GuestDomain {
  private String guestId;
  private String guestName; // 客户姓名
  private String guestIdCard; // 客户身份证号
  private String guestPhone; // 客户手机
  private String housesId; // 楼盘id
  private String houseTypeId; // 户型id
  private String userParentId; // 经纪公司id
  private String userId; // 经纪人id
  private String guestComment; // 客户备注
  private String crtTime; // 创建时间
  private String updateTime; // 更新时间

  public String getGuestId() {
    return guestId;
  }

  public void setGuestId(String guestId) {
    this.guestId = guestId;
  }

  public String getGuestName() {
    return guestName;
  }

  public void setGuestName(String guestName) {
    this.guestName = guestName;
  }

  public String getGuestIdCard() {
    return guestIdCard;
  }

  public void setGuestIdCard(String guestIdCard) {
    this.guestIdCard = guestIdCard;
  }

  public String getGuestPhone() {
    return guestPhone;
  }

  public void setGuestPhone(String guestPhone) {
    this.guestPhone = guestPhone;
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

  public String getGuestComment() {
    return guestComment;
  }

  public void setGuestComment(String guestComment) {
    this.guestComment = guestComment;
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
