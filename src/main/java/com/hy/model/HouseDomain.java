package com.hy.model;

import java.util.List;

/** Created by yaohou on 12:09 2019/5/3. description: 新房表 */
public class HouseDomain {
  private String Id;
  private String houseArea; // 区域
  private String housesId; // 楼盘ID
  private String housesName;//楼盘名称
  private String houseTypeId; // 户型：楼盘下的户型
  private String houseTypeName; //户型名称
  private String houseName; // 新房名称 10栋1单元1楼,10栋1单元1楼
  private String houseSellSt ;//新房状态，1：在售，2：已售出
  private int  houseNumTol; //登记数量
  private int  houseSellNum;//已售数量
  private int  houseRemainNum; //剩余数量
  private String crtTime; // 创建时间
  private String updateTime; // 更新时间

  private List<HouseDomain> houses ;//新房集合


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

  public String getHouseName() {
    return houseName;
  }

  public void setHouseName(String houseName) {
    this.houseName = houseName;
  }

  public String getHouseSellSt() {
    return houseSellSt;
  }

  public void setHouseSellSt(String houseSellSt) {
    this.houseSellSt = houseSellSt;
  }

  public int getHouseNumTol() {
    return houseNumTol;
  }

  public void setHouseNumTol(int houseNumTol) {
    this.houseNumTol = houseNumTol;
  }

  public int getHouseSellNum() {
    return houseSellNum;
  }

  public void setHouseSellNum(int houseSellNum) {
    this.houseSellNum = houseSellNum;
  }

  public int getHouseRemainNum() {
    return houseRemainNum;
  }

  public void setHouseRemainNum(int houseRemainNum) {
    this.houseRemainNum = houseRemainNum;
  }

  public List<HouseDomain> getHouses() {
    return houses;
  }

  public void setHouses(List<HouseDomain> houses) {
    this.houses = houses;
  }

  public String getHouseTypeName() {
    return houseTypeName;
  }

  public void setHouseTypeName(String houseTypeName) {
    this.houseTypeName = houseTypeName;
  }

  public String getHousesName() {
    return housesName;
  }

  public void setHousesName(String housesName) {
    this.housesName = housesName;
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
