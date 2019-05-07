package com.hy.model;

/** Created by yaohou on 15:16 2019/5/7. description: */
public class InfoLableDomain {

  private String lableId;
  private String lableContext;
  private String crtTime;
  private String updateTime;

  public InfoLableDomain(String lableId, String lableContext) {
    this.lableId = lableId;
    this.lableContext = lableContext;
  }

  public InfoLableDomain() {}

  public InfoLableDomain(String lableId, String lableContext, String crtTime, String updateTime) {
    this.lableId = lableId;
    this.lableContext = lableContext;
    this.crtTime = crtTime;
    this.updateTime = updateTime;
  }

  public String getLableId() {
    return lableId;
  }

  public void setLableId(String lableId) {
    this.lableId = lableId;
  }

  public String getLableContext() {
    return lableContext;
  }

  public void setLableContext(String lableContext) {
    this.lableContext = lableContext;
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
