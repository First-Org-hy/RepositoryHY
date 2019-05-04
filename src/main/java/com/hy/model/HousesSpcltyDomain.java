package com.hy.model;

/** Created by yaohou on 12:22 2019/5/3. description:楼盘特点 */
public class HousesSpcltyDomain {
  private String housesSpcltyId; // 楼盘特点id',
  private String housesSpclty; // 楼盘特点内容',
  private String crtTime; // 创建时间',
  private String updateTime; // 更新时间'

  public String getHousesSpcltyId() {
    return housesSpcltyId;
  }

  public void setHousesSpcltyId(String housesSpcltyId) {
    this.housesSpcltyId = housesSpcltyId;
  }

  public String getHousesSpclty() {
    return housesSpclty;
  }

  public void setHousesSpclty(String housesSpclty) {
    this.housesSpclty = housesSpclty;
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
