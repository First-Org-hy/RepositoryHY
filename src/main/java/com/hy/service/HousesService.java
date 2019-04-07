package com.hy.service;

import com.hy.common.Lable;
import com.hy.model.HousesDomain;

import java.util.List;

/**
 * Created by yaohou on 18:11 2019/4/7.
 * description:
 */
public interface HousesService {
    List<HousesDomain> queryHouses(HousesDomain housesDomain);

    Lable addHouses(HousesDomain housesDomain);
}
