package com.hy.service;

import com.hy.model.BrokerageDomain;

import java.util.List;

/**
 * Created by yaohou on 12:58 2019/4/7.
 * description:
 */
public interface BrokerageService {
    List<BrokerageDomain> selectBrokerages(BrokerageDomain brokerageDomain);

    int add (BrokerageDomain brokerageDomain);
}
