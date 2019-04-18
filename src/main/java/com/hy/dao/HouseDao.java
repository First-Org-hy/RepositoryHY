package com.hy.dao;

import com.hy.model.*;

import java.util.List;

/**
 * Created by shakaiyue on 17:59 2019/4/12.
 * description:新房，二手房，租房DAO
 */
public interface HouseDao {
    //List<HousesDomain> selectHouses(HousesDomain housesDomain);

    int addRentHouse(RentHouseDomain house);

    List<RentHouseDomain> queryRentHouse(RentHouseDomain rentHou);

    List<RentHouseDomain> queryRentsByUserId(String userId);

    int addSecondHouse(SecondHouseDomain house);

    List<SecondHouseDomain> querySecondHouse(SecondHouseDomain secondHouId);

    List<SecondHouseDomain> querySecondsByUserId(String userId);

    int addOrderRecord(OrderRecordDomain order);

    int addHouseDynamic(HouseDynamicDomain Dynamic);

    List<HouseDynamicDomain> queryDyByHouseId(String houseId);

    int addHousesInfo(HousesInfoDomain houseInfo);

    List<HousesInfoDomain> queryHousesInfo();

}
