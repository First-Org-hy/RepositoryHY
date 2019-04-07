package com.hy.service;

import com.hy.model.SellDomain;

import java.util.List;

public interface SellService {

    int addSell(SellDomain sell);

    int updateSell(SellDomain sell);

    int deteleSell(SellDomain sell);

    List<SellDomain> querySellInfoByUserId(SellDomain sell);

    List<SellDomain> querySellInfoByUserParId(SellDomain sell);
}
