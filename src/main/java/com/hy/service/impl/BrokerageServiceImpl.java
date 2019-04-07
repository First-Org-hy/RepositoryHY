package com.hy.service.impl;

import com.hy.dao.BrokerageDao;
import com.hy.model.BrokerageDomain;
import com.hy.service.BrokerageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by yaohou on 13:00 2019/4/7.
 * description:
 */
@Service(value = "brokerageService")
public class BrokerageServiceImpl implements BrokerageService {

    @Autowired
    BrokerageDao brokerageDao;

    @Override
    public List<BrokerageDomain> selectBrokerages(BrokerageDomain brokerageDomain) {
        return brokerageDao.selectBrokerages(brokerageDomain);
    }

    @Override
    public int add(BrokerageDomain brokerageDomain) {
        return brokerageDao.insert(brokerageDomain);
    }
}
