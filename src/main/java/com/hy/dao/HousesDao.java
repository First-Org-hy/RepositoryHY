package com.hy.dao;

import com.hy.model.HousesDomain;

import java.util.List;

/** Created by yaohou on 17:59 2019/4/7. description: */
public interface HousesDao {
  // 查询楼盘信息
  List<HousesDomain> selectHouses(HousesDomain housesDomain);

  // 新增楼盘
  int insert(HousesDomain housesDomain);

  // 普通用户 区域/价格/筛选 楼盘: areaId,总价,avgPrice(单价),户型,装修,面积,开盘时间,售卖状况,特色
  List<HousesDomain> queryAll(HousesDomain housesDomain);
}
