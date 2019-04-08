package com.hy.service;

import com.hy.common.Lable;
import com.hy.model.HousesUserDomain;
import com.hy.model.SellDomain;

import java.util.List;

public interface SellService {

    int addSell(SellDomain sell);

    int updateSell(SellDomain sell);

    int deteleSell(SellDomain sell);

    List<SellDomain> querySellInfoByUserId(SellDomain sell);

    List<SellDomain> querySellInfoByUserParId(SellDomain sell);

    Lable isBusSeller(String userId);

    List<SellDomain> queryBySeller(String userId);

    List<HousesUserDomain> queryBySellId(String userId);
}
