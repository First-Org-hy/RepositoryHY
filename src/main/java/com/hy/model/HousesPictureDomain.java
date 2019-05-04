package com.hy.model;

/** Created by yaohou on 12:21 2019/5/3. description:楼盘图片地址表 */
public class HousesPictureDomain {
  private String housesPictureId; // 图片地址id',
  private String housesPicture; // 图片地址',
  private String crtTime; // 创建时间',
  private String updateTime; // 更新时间'

  public String getHousesPictureId() {
    return housesPictureId;
  }

  public void setHousesPictureId(String housesPictureId) {
    this.housesPictureId = housesPictureId;
  }

  public String getHousesPicture() {
    return housesPicture;
  }

  public void setHousesPicture(String housesPicture) {
    this.housesPicture = housesPicture;
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
