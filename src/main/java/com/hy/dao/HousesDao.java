package com.hy.dao;

import com.hy.model.HousesDomain;

import java.util.List;

/** Created by yaohou on 17:59 2019/4/7. description: */
public interface HousesDao {
  /**
   * 查询楼盘信息
   *
   * @author yaohou
   * @date 2019/5/1 17:30
   * @return java.util.List<com.hy.model.HousesDomain>
   */
  List<HousesDomain> selectHouses(HousesDomain housesDomain);

  int insert(HousesDomain housesDomain);
}
