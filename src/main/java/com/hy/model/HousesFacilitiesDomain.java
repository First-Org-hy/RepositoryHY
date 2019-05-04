package com.hy.model;

/** Created by yaohou on 12:21 2019/5/3. description:楼盘配套设施表 */
public class HousesFacilitiesDomain {
  private String housesFacilitiesId; // 配套设置id
  private String housesFacilities; // 图片地址
  private String crtTime; // 创建时间
  private String updateTime; // 更新时间

  public String getHousesFacilitiesId() {
    return housesFacilitiesId;
  }

  public void setHousesFacilitiesId(String housesFacilitiesId) {
    this.housesFacilitiesId = housesFacilitiesId;
  }

  public String getHousesFacilities() {
    return housesFacilities;
  }

  public void setHousesFacilities(String housesFacilities) {
    this.housesFacilities = housesFacilities;
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
