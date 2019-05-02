package com.hy.service.impl;

import com.hy.common.Lable;
import com.hy.dao.HouseDao;
import com.hy.model.*;
import com.hy.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/** Created by shakaiyue on 17:59 2019/4/12. description:新房，二手房，租房 Service */
@Service(value = "houseService")
public class HouseServiceImpl implements HouseService {

  @Autowired private HouseDao houseDao;

  //    @Override
  //    public List<HousesDomain> queryHouses(HousesDomain housesDomain) {
  //        return housesDao.selectHouses(housesDomain);
  //    }

  /**
   * 发布租房信息
   *
   * @param house
   * @return
   */
  @Override
  public Lable addRentHouse(RentHouseDomain house) {
    Lable lable = new Lable();
    int i = houseDao.addRentHouse(house);
    if (i == 1) {
      lable.setId("1");
      lable.setMessage("租房信息发布成功");
    }
    return lable;
  }

  /**
   * 租房详情查询
   *
   * @param house
   * @return
   */
  @Override
  public List<RentHouseDomain> queryRentHouse(RentHouseDomain house) {
    return houseDao.queryRentHouse(house);
  }

  /**
   * 查询用户发布的所有租房
   *
   * @param userId
   * @return
   */
  @Override
  public List<RentHouseDomain> queryRentsByUserId(String userId) {
    return houseDao.queryRentsByUserId(userId);
  }

  /**
   * 发布二手房信息
   *
   * @param house
   * @return
   */
  @Override
  public Lable addSecondHouse(SecondHouseDomain house) {
    Lable lable = new Lable();
    int i = houseDao.addSecondHouse(house);
    if (i == 1) {
      lable.setId("1");
      lable.setMessage("二手房信息发布成功");
    } else {
      lable.setId("0");
      lable.setMessage("二手房信息发布失败");
    }
    return lable;
  }

  /**
   * 二手房详情查询
   *
   * @param house
   * @return
   */
  @Override
  public List<SecondHouseDomain> querySecondHouse(SecondHouseDomain house) {
    return houseDao.querySecondHouse(house);
  }

  /**
   * 查询用户发布的所有二手房
   *
   * @param userId
   * @return
   */
  @Override
  public List<SecondHouseDomain> querySecondsByUserId(String userId) {
    return houseDao.querySecondsByUserId(userId);
  }

  /**
   * 新增预约看房记录
   *
   * @param order
   * @return
   */
  @Override
  public Lable addOrderRecord(OrderRecordDomain order) {
    Lable lable = new Lable();
    int i = houseDao.addOrderRecord(order);
    if (i == 1) {
      lable.setId("1");
      lable.setMessage("预约看房成功");
    }
    return lable;
  }

  /**
   * 根据楼盘Id查看楼盘动态
   *
   * @param houseId
   * @return
   */
  @Override
  public List<HouseDynamicDomain> queryDyByHouseId(String houseId) {
    return houseDao.queryDyByHouseId(houseId);
  }

  /**
   * 新增楼盘动态
   *
   * @param Dynamic
   * @return
   */
  @Override
  public Lable addHouseDynamic(HouseDynamicDomain Dynamic) {
    Lable lable = new Lable();
    int i = houseDao.addHouseDynamic(Dynamic);
    if (i == 1) {
      lable.setId("1");
      lable.setMessage("楼盘动态新增成功");
    }
    return lable;
  }

  /**
   * 新增楼盘资讯信息
   *
   * @param houseInfo
   * @return
   */
  @Override
  public Lable addHousesInfo(HousesInfoDomain houseInfo) {
    Lable lable = new Lable();
    int i = houseDao.addHousesInfo(houseInfo);
    if (i == 1) {
      lable.setId("1");
      lable.setMessage("楼盘资讯新增成功");
    }
    return lable;
  }

  /**
   * 房产资讯查询
   *
   * @return
   */
  @Override
  public List<HousesInfoDomain> queryHousesInfo() {
    return houseDao.queryHousesInfo();
  }

  @Override
  public List<HousesDomain> queryByUserId(AppDomain appDomain) {
    return null;
  }
}
