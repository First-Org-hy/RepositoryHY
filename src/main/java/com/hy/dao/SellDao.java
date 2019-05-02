package com.hy.dao;

import com.hy.model.HousesDomain;
import com.hy.model.HousesUserDomain;
import com.hy.model.SellDomain;

import java.util.List;

public interface SellDao {

  int addSell(SellDomain sell);

  int update(SellDomain sell);

  int deteleSell(SellDomain sell);

  // 通过经纪人id查询某个经纪人的销售记录
  // 根据楼盘id:housesId 查询销售信息
  List<SellDomain> query(SellDomain sell);

  List<SellDomain> querySellInfoByUserParId(SellDomain sell);

  int isBusSeller(String userId);

  List<SellDomain> queryBySeller(String userId);

  List<HousesDomain> queryHouseById(String houseId);

  List<HousesUserDomain> queryBySellId(String userId);
}
