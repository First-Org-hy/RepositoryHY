package com.hy.model;

import java.sql.Date;
import java.util.List;

/** Created by shakaiyue on 22:10 2019/4/17. description:楼盘资讯实体类 */
public class HousesInfoDomain {

  private String id;
  private String headline; // 标题
  private String programId; // 栏目Id
  private String programName; // 栏目名称
  private String picAddress; // 标题图片地址
  private List<InfoPictureDomain> infoPictureDomains;
  private String lableId; // 标签
  private List<InfoLableDomain> infoLableDomains;
  private String content; // 内容
  private Date crtTime; // 创建时间
  private Date updateTime; // 更新时间

  public List<InfoPictureDomain> getInfoPictureDomains() {
    return infoPictureDomains;
  }

  public void setInfoPictureDomains(List<InfoPictureDomain> infoPictureDomains) {
    this.infoPictureDomains = infoPictureDomains;
  }

  public List<InfoLableDomain> getInfoLableDomains() {
    return infoLableDomains;
  }

  public void setInfoLableDomains(List<InfoLableDomain> infoLableDomains) {
    this.infoLableDomains = infoLableDomains;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getHeadline() {
    return headline;
  }

  public void setHeadline(String headline) {
    this.headline = headline;
  }

  public String getProgramId() {
    return programId;
  }

  public void setProgramId(String programId) {
    this.programId = programId;
  }

  public String getProgramName() {
    return programName;
  }

  public void setProgramName(String programName) {
    this.programName = programName;
  }

  public String getPicAddress() {
    return picAddress;
  }

  public void setPicAddress(String picAddress) {
    this.picAddress = picAddress;
  }

  public String getLableId() {
    return lableId;
  }

  public void setLableId(String lableId) {
    this.lableId = lableId;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public Date getCrtTime() {
    return crtTime;
  }

  public void setCrtTime(Date crtTime) {
    this.crtTime = crtTime;
  }

  public Date getUpdateTime() {
    return updateTime;
  }

  public void setUpdateTime(Date updateTime) {
    this.updateTime = updateTime;
  }
}
