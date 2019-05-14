package com.hy.dao;

import com.hy.model.*;

import java.util.List;

/** Created by shakaiyue on 17:59 2019/4/12. description:新房，二手房，租房DAO */
public interface HouseDao {
  // List<HousesDomain> selectHouses(HousesDomain housesDomain);

  int addRentHouse(RentHouseDomain house);

  // 普通用户 租房查询
  List<RentHouseDomain> queryRentHouse(RentHouseDomain rentHou);

  // 我发布的租房查询
  List<RentHouseDomain> queryRentsByUserId(RentHouseDomain rentHouseDomain);

  int addSecondHouse(SecondHouseDomain house);

  List<SecondHouseDomain> querySecondHouse(SecondHouseDomain secondHouId);
  // 普通用户二手房查询:
  List<SecondHouseDomain> querySecondsByUserId(SecondHouseDomain secondHouseDomain);

  // 预约看房
  int addOrderRecord(OrderRecordDomain order);

  int addHouseDynamic(HouseDynamicDomain Dynamic);

  List<HouseDynamicDomain> queryDyByHouseId(String houseId);

  int addHousesInfo(HousesInfoDomain houseInfo);
  // 楼盘咨询查询
  List<HousesInfoDomain> queryHousesInfo();
  // 查询所有户型
  List<HousesDomain> queryhouseType(HouseTypeDomain houseTypeDomain);
  // 查询户型
  List<HouseTypeDomain> houseType(HouseTypeDomain houseTypeDomain);
}
