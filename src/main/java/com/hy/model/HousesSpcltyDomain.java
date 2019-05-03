package com.hy.model;

/** Created by yaohou on 12:22 2019/5/3. description:楼盘特点 */
public class HousesSpcltyDomain {
  private String lableId; // 楼盘特点id',
  private String lableContext; // 楼盘特点内容',
  private String crtTime; // 创建时间',
  private String updateTime; // 更新时间'

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
