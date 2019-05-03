package com.hy.model;

/** Created by yaohou on 12:08 2019/5/3. description: 户型表 */
public class HouseTypeDomain {
  private String houseTypeId;
  private String houseTypeName; // 户型类型名称',
  private String houseTypeSpci; // 户型类型特点', /*特点，使用标签表 */
  private String houseTypePic; // 户型类型图片', /*特点，使用标签表 */
  private String houseFTTB; // 楼栋',
  private String houseTypeNum; // 居室数目',
  private String houseSize; // 建筑面积',
  private String houseAvmPrice; // 参考均价',
  private String houseTolPrice; // 参考总价',
  private String houseType; // 分类：住宅',
  private String crtTime; // 创建时间',
  private String updateTime; // 更新时间'

  public String getHouseTypeId() {
    return houseTypeId;
  }

  public void setHouseTypeId(String houseTypeId) {
    this.houseTypeId = houseTypeId;
  }

  public String getHouseTypeName() {
    return houseTypeName;
  }

  public void setHouseTypeName(String houseTypeName) {
    this.houseTypeName = houseTypeName;
  }

  public String getHouseTypeSpci() {
    return houseTypeSpci;
  }

  public void setHouseTypeSpci(String houseTypeSpci) {
    this.houseTypeSpci = houseTypeSpci;
  }

  public String getHouseTypePic() {
    return houseTypePic;
  }

  public void setHouseTypePic(String houseTypePic) {
    this.houseTypePic = houseTypePic;
  }

  public String getHouseFTTB() {
    return houseFTTB;
  }

  public void setHouseFTTB(String houseFTTB) {
    this.houseFTTB = houseFTTB;
  }

  public String getHouseTypeNum() {
    return houseTypeNum;
  }

  public void setHouseTypeNum(String houseTypeNum) {
    this.houseTypeNum = houseTypeNum;
  }

  public String getHouseSize() {
    return houseSize;
  }

  public void setHouseSize(String houseSize) {
    this.houseSize = houseSize;
  }

  public String getHouseAvmPrice() {
    return houseAvmPrice;
  }

  public void setHouseAvmPrice(String houseAvmPrice) {
    this.houseAvmPrice = houseAvmPrice;
  }

  public String getHouseTolPrice() {
    return houseTolPrice;
  }

  public void setHouseTolPrice(String houseTolPrice) {
    this.houseTolPrice = houseTolPrice;
  }

  public String getHouseType() {
    return houseType;
  }

  public void setHouseType(String houseType) {
    this.houseType = houseType;
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
