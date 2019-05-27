package com.hy.model;

import java.util.List;

/** Created by yaohou on 18:56 2019/5/2. description: 广告实体类 */
public class AdDomain {
  private String adId;
  private String adName; // 广告名称
  private String adAddress; // 广告位置
  private String adPicture; // 图片地址串  地址，地址，后天切割
  private List<InfoPictureDomain> infoPictureDomains; // 广告图片
  private String startTime; // 开始时间
  private String deadLine; // 标题名称
  private String crtTime; // 创建时间
  private String updateTime; // 更新时间

  public String getAdPicture() {
    return adPicture;
  }

  public void setAdPicture(String adPicture) {
    this.adPicture = adPicture;
  }

  public List<InfoPictureDomain> getInfoPictureDomains() {
    return infoPictureDomains;
  }

  public void setInfoPictureDomains(List<InfoPictureDomain> infoPictureDomains) {
    this.infoPictureDomains = infoPictureDomains;
  }

  public String getAdId() {
    return adId;
  }

  public void setAdId(String adId) {
    this.adId = adId;
  }

  public String getAdName() {
    return adName;
  }

  public void setAdName(String adName) {
    this.adName = adName;
  }

  public String getAdAddress() {
    return adAddress;
  }

  public void setAdAddress(String adAddress) {
    this.adAddress = adAddress;
  }

  public String getStartTime() {
    return startTime;
  }

  public void setStartTime(String startTime) {
    this.startTime = startTime;
  }

  public String getDeadLine() {
    return deadLine;
  }

  public void setDeadLine(String deadLine) {
    this.deadLine = deadLine;
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
