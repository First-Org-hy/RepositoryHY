package com.hy.service;

import com.hy.common.Lable;
import com.hy.model.HousesDomain;
import com.hy.model.HousesSpcltyDomain;

import java.util.List;

/** Created by yaohou on 18:11 2019/4/7. description: */
public interface HousesService {
  // 驻点商务楼盘查询: userId(驻点商务id)
  // 普通用户楼盘查询
  List<HousesDomain> queryHouses(HousesDomain housesDomain);

  Lable addHouses(HousesDomain housesDomain);

  // 普通用户 区域/价格/筛选 楼盘: areaId,总价,avgPrice(单价),户型,装修,面积,开盘时间,售卖状况,特色
  List<HousesDomain> queryAll(HousesDomain housesDomain);

  // 楼盘特点查询，所有特点去重
  List<HousesSpcltyDomain> querySpclty();

  //删除楼盘信息
  Lable delHouses(HousesDomain housesDomain);

  //更新楼盘信息
  Lable updateHouses(HousesDomain housesDomain);
}
