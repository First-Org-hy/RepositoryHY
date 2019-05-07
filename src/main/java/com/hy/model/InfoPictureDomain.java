package com.hy.model;

/** Created by yaohou on 15:53 2019/5/7. description: */
public class InfoPictureDomain {
  private String infoPictureId;
  private String infoPicture;
  private String crtTime;
  private String updateTime;

  public InfoPictureDomain(String housesPictureId, String housesPicture) {
    this.infoPictureId = housesPictureId;
    this.infoPicture = housesPicture;
  }

  public InfoPictureDomain(
      String housesPictureId, String housesPicture, String crtTime, String updateTime) {
    this.infoPictureId = housesPictureId;
    this.infoPicture = housesPicture;
    this.crtTime = crtTime;
    this.updateTime = updateTime;
  }

  public InfoPictureDomain() {}

  public String getInfoPictureId() {
    return infoPictureId;
  }

  public void setInfoPictureId(String infoPictureId) {
    this.infoPictureId = infoPictureId;
  }

  public String getInfoPicture() {
    return infoPicture;
  }

  public void setInfoPicture(String infoPicture) {
    this.infoPicture = infoPicture;
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
