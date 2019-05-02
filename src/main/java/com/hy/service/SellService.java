package com.hy.service;

import com.hy.common.Lable;
import com.hy.model.HousesUserDomain;
import com.hy.model.SellDomain;

import java.util.List;

public interface SellService {

  Lable addSell(SellDomain sell);

  Lable update(SellDomain sell);

  int deteleSell(SellDomain sell);
  // 通过经纪人id查询某个经纪人的销售记录
  // 根据楼盘id:housesId 查询销售信息
  List<SellDomain> query(SellDomain sell);

  List<SellDomain> querySellInfoByUserParId(SellDomain sell);

  Lable isBusSeller(String userId);

  List<SellDomain> queryBySeller(String userId);

  List<HousesUserDomain> queryBySellId(String userId);
}
