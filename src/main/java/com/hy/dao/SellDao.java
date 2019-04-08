package com.hy.dao;

import com.hy.common.Lable;
import com.hy.model.HousesDomain;
import com.hy.model.HousesUserDomain;
import com.hy.model.SellDomain;

import java.util.List;

public interface SellDao {

    int addSell(SellDomain sell);

    int updateSell(SellDomain sell);

    int deteleSell(SellDomain sell);

    List<SellDomain> querySellInfoByUserId(SellDomain sell);

    List<SellDomain> querySellInfoByUserParId(SellDomain sell);

    int isBusSeller(String userId);

    List<SellDomain> queryBySeller(String userId);

    List<HousesDomain> queryHouseById(String houseId);

    List<HousesUserDomain> queryBySellId(String userId);
}
