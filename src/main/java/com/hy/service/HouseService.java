package com.hy.service;

import com.hy.common.Lable;
import com.hy.model.HousesDomain;
import com.hy.model.RentHouseDomain;

import java.util.List;

/**
 * Created by shakaiyue on 18:11 2019/4/7.
 * description:新房，二手房，租房 service
 */
public interface HouseService {
//    List<HousesDomain> queryHouses(HousesDomain housesDomain);

    Lable addRentHouse(RentHouseDomain house);
}
