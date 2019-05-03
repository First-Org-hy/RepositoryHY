package com.hy.service;

import com.hy.common.Lable;
import com.hy.model.HousesDomain;

import java.util.List;

/** Created by yaohou on 18:11 2019/4/7. description: */
public interface HousesService {
  // 驻点商务楼盘查询: userId(驻点商务id)
  // 普通用户楼盘查询
  List<HousesDomain> queryHouses(HousesDomain housesDomain);

  Lable addHouses(HousesDomain housesDomain);

  // 普通用户 区域/价格/筛选 楼盘: areaId,总价,avgPrice(单价),户型,装修,面积,开盘时间,售卖状况,特色
  List<HousesDomain> queryAll(HousesDomain housesDomain);
}
