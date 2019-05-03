package com.hy.model;

/** Created by yaohou on 12:09 2019/5/3. description: 新房表 */
public class HouseDomain {
  private String Id;
  private String houseArea; // 区域
  private String housesId; // 楼盘ID
  private String houseTypeId; // 户型：楼盘下的户型
  private String houseId; // 新房id： 添加新房： 10栋1单元1楼,10栋1单元1楼
  private String crtTime; // 创建时间
  private String updateTime; // 更新时间

  public String getId() {
    return Id;
  }

  public void setId(String id) {
    Id = id;
  }

  public String getHouseArea() {
    return houseArea;
  }

  public void setHouseArea(String houseArea) {
    this.houseArea = houseArea;
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

  public String getHouseId() {
    return houseId;
  }

  public void setHouseId(String houseId) {
    this.houseId = houseId;
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
