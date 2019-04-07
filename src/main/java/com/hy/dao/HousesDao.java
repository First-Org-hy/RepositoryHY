package com.hy.dao;

import com.hy.model.HousesDomain;

import java.util.List;

/**
 * Created by yaohou on 17:59 2019/4/7.
 * description:
 */
public interface HousesDao {
    List<HousesDomain> selectHouses(HousesDomain housesDomain);

    int insert(HousesDomain housesDomain);
}
