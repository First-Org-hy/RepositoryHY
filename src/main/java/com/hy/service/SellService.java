package com.hy.service;

import com.hy.common.Lable;
import com.hy.model.HousesUserDomain;
import com.hy.model.SellDomain;
import com.github.pagehelper.PageInfo;
import java.util.List;

public interface SellService {

  Lable addSell(SellDomain sell);

  Lable update(SellDomain sell);

  int deteleSell(SellDomain sell);
  // 通过经纪人id查询某个经纪人的销售记录
  // 根据楼盘id:housesId 查询销售信息
  PageInfo<SellDomain> query(SellDomain sell, int pageNum, int pageSize);

  PageInfo<SellDomain> querySellInfoByUserParId(SellDomain sell, int pageNum, int pageSize);

  Lable isBusSeller(String userId);

  PageInfo<SellDomain> queryBySeller(String userId, int pageNum, int pageSize);

  PageInfo<HousesUserDomain> queryBySellId(String userId, int pageNum, int pageSize);
}
