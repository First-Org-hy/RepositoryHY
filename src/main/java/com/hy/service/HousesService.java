package com.hy.service;

import com.hy.common.Lable;
import com.hy.model.HousesDomain;

import java.util.List;

/** Created by yaohou on 18:11 2019/4/7. description: */
public interface HousesService {
  /**
   * 查询楼盘信息
   *
   * @author yaohou
   * @date 2019/5/1 17:31
   * @return java.util.List<com.hy.model.HousesDomain>
   */
  List<HousesDomain> queryHouses(HousesDomain housesDomain);

  Lable addHouses(HousesDomain housesDomain);
}
