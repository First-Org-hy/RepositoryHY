package com.hy.model;

import java.util.List;

/** Created by yaohou on 17:19 2019/4/7. description:楼盘实体类 */
public class HousesDomain {
  private String housesId;
  private String userId; // 楼盘商务id
  private String housesName;
  private String housesSpclty; // 特点，使用标签表
  private List<HousesSpcltyDomain> housesSpcltyLable;

  private String houseState;
  private String pictureX; // 效果图
  private List<HousesPictureDomain> pictureXLable;

  private String pictureS; // 实施图
  private List<HousesPictureDomain> pictureSLable;

  private String pictureJ; // 交通图
  private List<HousesPictureDomain> pictureJLable;

  private String mating;
  private List<HousesFacilitiesDomain> matingLable;

  private String houseTypeId;
  private String areaZ;
  private String areaJ;
  private String areaS;
  private String developers;
  private String housesAddrss;
  private String period;
  private String areaId;
  private String buildType;
  private String greenRate;
  private String companyW;
  private String openHouse;
  private String deadLine;
  private String avgPrice;
  private String maxPrice; // 最大价格,用于页面查询条件
  private String sumPrice; // 总格,用于页面查询条件
  private String bigTOSmall; // 排序
  private String smallTOBig; // 排序
  private String housesType; // 户型
  //     包含:楼盘经纪人
  private List<AppDomain> apps;
  //     包含:楼盘动态
  private List<HouseDynamicDomain> houseDynamics;
  //     包含:楼盘户型
  private List<HouseTypeDomain> houseType;
  //     包含:楼盘配套设施
  private List<HousesFacilitiesDomain> HousesFacilities;
  //     包含:楼盘特点
  private List<HousesSpcltyDomain> housesSpcltys;
  //     包含:楼盘图片
  private List<HousesPictureDomain> housesPictures;
  //     包含:在售新房
  private List<HouseDomain> house;

  private String investor;
  private String plotRatio;
  private String familyNum;
  private String carportNum;
  private String fitment;
  private String location;
  private String recommend;
  private String crtTime;
  private String updateTime;

  public List<AppDomain> getApps() {
    return apps;
  }

  public void setApps(List<AppDomain> apps) {
    this.apps = apps;
  }

  public String getBigTOSmall() {
    return bigTOSmall;
  }

  public void setBigTOSmall(String bigTOSmall) {
    this.bigTOSmall = bigTOSmall;
  }

  public String getSmallTOBig() {
    return smallTOBig;
  }

  public void setSmallTOBig(String smallTOBig) {
    this.smallTOBig = smallTOBig;
  }

  public String getHousesType() {
    return housesType;
  }

  public void setHousesType(String housesType) {
    this.housesType = housesType;
  }

  public List<HouseDynamicDomain> getHouseDynamics() {
    return houseDynamics;
  }

  public void setHouseDynamics(List<HouseDynamicDomain> houseDynamics) {
    this.houseDynamics = houseDynamics;
  }

  public List<HouseTypeDomain> getHouseType() {
    return houseType;
  }

  public void setHouseType(List<HouseTypeDomain> houseType) {
    this.houseType = houseType;
  }

  public List<HousesFacilitiesDomain> getHousesFacilities() {
    return HousesFacilities;
  }

  public void setHousesFacilities(List<HousesFacilitiesDomain> housesFacilities) {
    HousesFacilities = housesFacilities;
  }

  public List<HousesSpcltyDomain> getHousesSpcltys() {
    return housesSpcltys;
  }

  public void setHousesSpcltys(List<HousesSpcltyDomain> housesSpcltys) {
    this.housesSpcltys = housesSpcltys;
  }

  public List<HousesPictureDomain> getHousesPictures() {
    return housesPictures;
  }

  public void setHousesPictures(List<HousesPictureDomain> housesPictures) {
    this.housesPictures = housesPictures;
  }

  public List<HouseDomain> getHouse() {
    return house;
  }

  public void setHouse(List<HouseDomain> house) {
    this.house = house;
  }

  public String getSumPrice() {
    return sumPrice;
  }

  public void setSumPrice(String sumPrice) {
    this.sumPrice = sumPrice;
  }

  public String getMaxPrice() {
    return maxPrice;
  }

  public void setMaxPrice(String maxPrice) {
    this.maxPrice = maxPrice;
  }

  public List<HousesSpcltyDomain> getHousesSpcltyLable() {
    return housesSpcltyLable;
  }

  public void setHousesSpcltyLable(List<HousesSpcltyDomain> housesSpcltyLable) {
    this.housesSpcltyLable = housesSpcltyLable;
  }

  public List<HousesPictureDomain> getPictureXLable() {
    return pictureXLable;
  }

  public void setPictureXLable(List<HousesPictureDomain> pictureXLable) {
    this.pictureXLable = pictureXLable;
  }

  public List<HousesPictureDomain> getPictureSLable() {
    return pictureSLable;
  }

  public void setPictureSLable(List<HousesPictureDomain> pictureSLable) {
    this.pictureSLable = pictureSLable;
  }

  public List<HousesPictureDomain> getPictureJLable() {
    return pictureJLable;
  }

  public void setPictureJLable(List<HousesPictureDomain> pictureJLable) {
    this.pictureJLable = pictureJLable;
  }

  public List<HousesFacilitiesDomain> getMatingLable() {
    return matingLable;
  }

  public void setMatingLable(List<HousesFacilitiesDomain> matingLable) {
    this.matingLable = matingLable;
  }

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public String getHousesId() {
    return housesId;
  }

  public void setHousesId(String housesId) {
    this.housesId = housesId;
  }

  public String getHousesName() {
    return housesName;
  }

  public void setHousesName(String housesName) {
    this.housesName = housesName;
  }

  public String getHousesSpclty() {
    return housesSpclty;
  }

  public void setHousesSpclty(String housesSpclty) {
    this.housesSpclty = housesSpclty;
  }

  public String getHouseState() {
    return houseState;
  }

  public void setHouseState(String houseState) {
    this.houseState = houseState;
  }

  public String getPictureX() {
    return pictureX;
  }

  public void setPictureX(String pictureX) {
    this.pictureX = pictureX;
  }

  public String getPictureS() {
    return pictureS;
  }

  public void setPictureS(String pictureS) {
    this.pictureS = pictureS;
  }

  public String getPictureJ() {
    return pictureJ;
  }

  public void setPictureJ(String pictureJ) {
    this.pictureJ = pictureJ;
  }

  public String getMating() {
    return mating;
  }

  public void setMating(String mating) {
    this.mating = mating;
  }

  public String getHouseTypeId() {
    return houseTypeId;
  }

  public void setHouseTypeId(String houseTypeId) {
    this.houseTypeId = houseTypeId;
  }

  public String getAreaZ() {
    return areaZ;
  }

  public void setAreaZ(String areaZ) {
    this.areaZ = areaZ;
  }

  public String getAreaJ() {
    return areaJ;
  }

  public void setAreaJ(String areaJ) {
    this.areaJ = areaJ;
  }

  public String getAreaS() {
    return areaS;
  }

  public void setAreaS(String areaS) {
    this.areaS = areaS;
  }

  public String getDevelopers() {
    return developers;
  }

  public void setDevelopers(String developers) {
    this.developers = developers;
  }

  public String getHousesAddrss() {
    return housesAddrss;
  }

  public void setHousesAddrss(String housesAddrss) {
    this.housesAddrss = housesAddrss;
  }

  public String getPeriod() {
    return period;
  }

  public void setPeriod(String period) {
    this.period = period;
  }

  public String getAreaId() {
    return areaId;
  }

  public void setAreaId(String areaId) {
    this.areaId = areaId;
  }

  public String getBuildType() {
    return buildType;
  }

  public void setBuildType(String buildType) {
    this.buildType = buildType;
  }

  public String getGreenRate() {
    return greenRate;
  }

  public void setGreenRate(String greenRate) {
    this.greenRate = greenRate;
  }

  public String getCompanyW() {
    return companyW;
  }

  public void setCompanyW(String companyW) {
    this.companyW = companyW;
  }

  public String getOpenHouse() {
    return openHouse;
  }

  public void setOpenHouse(String openHouse) {
    this.openHouse = openHouse;
  }

  public String getDeadLine() {
    return deadLine;
  }

  public void setDeadLine(String deadLine) {
    this.deadLine = deadLine;
  }

  public String getAvgPrice() {
    return avgPrice;
  }

  public void setAvgPrice(String avgPrice) {
    this.avgPrice = avgPrice;
  }

  public String getInvestor() {
    return investor;
  }

  public void setInvestor(String investor) {
    this.investor = investor;
  }

  public String getPlotRatio() {
    return plotRatio;
  }

  public void setPlotRatio(String plotRatio) {
    this.plotRatio = plotRatio;
  }

  public String getFamilyNum() {
    return familyNum;
  }

  public void setFamilyNum(String familyNum) {
    this.familyNum = familyNum;
  }

  public String getCarportNum() {
    return carportNum;
  }

  public void setCarportNum(String carportNum) {
    this.carportNum = carportNum;
  }

  public String getFitment() {
    return fitment;
  }

  public void setFitment(String fitment) {
    this.fitment = fitment;
  }

  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  public String getRecommend() {
    return recommend;
  }

  public void setRecommend(String recommend) {
    this.recommend = recommend;
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
