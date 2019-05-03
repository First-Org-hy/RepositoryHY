package com.hy.model;

/** Created by yaohou on 12:21 2019/5/3. description:楼盘配套设施表 */
public class HousesFacilitiesDomain {
  private String lableId; // 配套设置id
  private String lableContext; // 图片地址
  private String crtTime; // 创建时间
  private String updateTime; // 更新时间

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
