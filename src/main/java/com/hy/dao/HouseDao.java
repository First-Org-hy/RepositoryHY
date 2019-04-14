package com.hy.dao;

import com.hy.model.HousesDomain;
import com.hy.model.RentHouseDomain;

import java.util.List;

/**
 * Created by shakaiyue on 17:59 2019/4/12.
 * description:新房，二手房，租房DAO
 */
public interface HouseDao {
    //List<HousesDomain> selectHouses(HousesDomain housesDomain);

    int addRentHouse(RentHouseDomain house);
}
