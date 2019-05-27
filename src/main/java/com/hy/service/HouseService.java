package com.hy.service;

import com.hy.common.Lable;
import com.hy.model.*;
import com.github.pagehelper.PageInfo;
import java.util.List;

/** Created by shakaiyue on 18:11 2019/4/7. description:新房，二手房，租房 service */
public interface HouseService {
  //    List<HousesDomain> queryHouses(HousesDomain housesDomain);

  Lable addRentHouse(RentHouseDomain house);

  PageInfo<RentHouseDomain> queryRentHouse(RentHouseDomain house,  int pageNum, int pageSize);

  PageInfo<RentHouseDomain> queryRentsByUserId(RentHouseDomain rentHouseDomain,  int pageNum, int pageSize);

  Lable addSecondHouse(SecondHouseDomain house);

  PageInfo<SecondHouseDomain> querySecondHouse(SecondHouseDomain house,  int pageNum, int pageSize);

  // 普通用户二手房查询:
  PageInfo<SecondHouseDomain> querySecondsByUserId(SecondHouseDomain secondHouseDomain,  int pageNum, int pageSize);

  Lable addOrderRecord(OrderRecordDomain order);

  Lable addHouseDynamic(HouseDynamicDomain Dynamic);

  PageInfo<HouseDynamicDomain> queryDyByHouseId(String houseId, int pageNum, int pageSize);

  Lable addHousesInfo(HousesInfoDomain houseInfo);

  // 楼盘咨询查询
  PageInfo<HousesInfoDomain> queryHousesInfo(int pageNum, int pageSize);

  // 查询所有户型
  List<HousesDomain> queryhouseType(HouseTypeDomain houseTypeDomain);
  // 查询户型
  List<HouseTypeDomain> houseType(HouseTypeDomain houseTypeDomain);
  //查询新房
  PageInfo<HouseDomain> queryNew(HouseDomain houseDomain,  int pageNum, int pageSize);
  //增加新房
  Lable addNewHouse(HouseDomain houseDomain);
  //修改新房
  Lable upNewHouse(HouseDomain houseDomain);
  //删除新房
  Lable deNewHouse(HouseDomain houseDomain);
  //删除新房
  Lable deNewHouseById(HouseDomain houseDomain);
}
