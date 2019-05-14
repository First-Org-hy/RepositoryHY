package com.hy.service;

import com.hy.common.Lable;
import com.hy.model.*;

import java.util.List;

/** Created by shakaiyue on 18:11 2019/4/7. description:新房，二手房，租房 service */
public interface HouseService {
  //    List<HousesDomain> queryHouses(HousesDomain housesDomain);

  Lable addRentHouse(RentHouseDomain house);

  List<RentHouseDomain> queryRentHouse(RentHouseDomain house);

  List<RentHouseDomain> queryRentsByUserId(RentHouseDomain rentHouseDomain);

  Lable addSecondHouse(SecondHouseDomain house);

  List<SecondHouseDomain> querySecondHouse(SecondHouseDomain house);

  // 普通用户二手房查询:
  List<SecondHouseDomain> querySecondsByUserId(SecondHouseDomain secondHouseDomain);

  Lable addOrderRecord(OrderRecordDomain order);

  Lable addHouseDynamic(HouseDynamicDomain Dynamic);

  List<HouseDynamicDomain> queryDyByHouseId(String houseId);

  Lable addHousesInfo(HousesInfoDomain houseInfo);

  // 楼盘咨询查询
  List<HousesInfoDomain> queryHousesInfo();

  // 查询所有户型
  List<HousesDomain> queryhouseType(HouseTypeDomain houseTypeDomain);
  // 查询户型
  List<HouseTypeDomain> houseType(HouseTypeDomain houseTypeDomain);
}
