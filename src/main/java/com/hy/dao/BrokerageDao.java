package com.hy.dao;

import com.hy.model.BankInfoDomain;
import com.hy.model.BrokerageDomain;

import java.util.List;

/**
 * Created by yaohou on 17:05 2019/4/3.
 * description:
 */
public interface BrokerageDao {
    int insert(BrokerageDomain brokerageDomain);

    List<BrokerageDomain> selectBrokerages();
}
