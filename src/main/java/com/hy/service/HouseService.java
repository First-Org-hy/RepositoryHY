package com.hy.service;

import com.hy.common.Lable;
import com.hy.model.*;

import java.util.List;

/**
 * Created by shakaiyue on 18:11 2019/4/7.
 * description:新房，二手房，租房 service
 */
public interface HouseService {
//    List<HousesDomain> queryHouses(HousesDomain housesDomain);

    Lable addRentHouse(RentHouseDomain house);

    List<RentHouseDomain> queryRentHouse(RentHouseDomain house);

    List<RentHouseDomain> queryRentsByUserId(String userId);

    Lable addSecondHouse(SecondHouseDomain house);

    List<SecondHouseDomain> querySecondHouse(SecondHouseDomain house);

    List<SecondHouseDomain> querySecondsByUserId(String userId);

    Lable addOrderRecord(OrderRecordDomain order);

    Lable addHouseDynamic(HouseDynamicDomain Dynamic);

    List<HouseDynamicDomain> queryDyByHouseId(String houseId);

    Lable addHousesInfo(HousesInfoDomain houseInfo);

    List<HousesInfoDomain> queryHousesInfo();
}
