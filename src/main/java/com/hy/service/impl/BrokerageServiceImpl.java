package com.hy.service.impl;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hy.dao.BrokerageDao;
import com.hy.model.BrokerageDomain;
import com.hy.service.BrokerageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/** Created by yaohou on 13:00 2019/4/7. description: */
@Service(value = "brokerageService")
public class BrokerageServiceImpl implements BrokerageService {
  private static Logger logger = LoggerFactory.getLogger(BankInfoServiceImpl.class);

  @Autowired BrokerageDao brokerageDao;

  @Override
  public PageInfo<BrokerageDomain> selectBrokerages(BrokerageDomain brokerageDomain,  int pageNum, int pageSize) {
    PageHelper.startPage(pageNum, pageSize);
    List<BrokerageDomain> brokerageDomains = brokerageDao.selectBrokerages(brokerageDomain);
    logger.info("佣金信息查询：" + JSON.toJSONString(brokerageDomains));
    return new PageInfo(brokerageDomains);
  }

  @Override
  public int add(BrokerageDomain brokerageDomain) {
    return brokerageDao.insert(brokerageDomain);
  }

  @Override
  public int updateBrokeragesRead(BrokerageDomain brokerageDomain) {
    return brokerageDao.updateBrokeragesRead(brokerageDomain);
  }
}
