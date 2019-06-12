package com.hy.dao;

import com.hy.common.Lable;
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
  // 新房管理-查询：根据楼盘iD  Distinct  条件：户型名称 houseTypeName， 楼盘名称 houseName
  List<HouseDomain> queryNew(HouseDomain houseDomain);
  // 新房管理-查询每个楼盘下的所有新房
  List<HouseDomain> queryNewByHousesId(HouseDomain houseDomain);
  // 新房管理-房屋数量查询 0：登记数量  1：在售  2：已售出
  int countHouse(HouseDomain houseDomain);
  // 新房管理-新增
  int addNewHouse(HouseDomain houseDomain);

  // 新房管理-修改
  int upNewHouse(HouseDomain houseDomain);

  // 新房管理-删除整个楼盘下的新房
  int deNewHouse(HouseDomain houseDomain);

  // 新房管理-删除某个新房
  int deNewHouseById(HouseDomain houseDomain);

  // 删除租房
  Lable deRentHouse(RentHouseDomain rentHouseDomain);
  // 删除二手房
  Lable deSecondHouse(SecondHouseDomain secondHouseDomain);
}
