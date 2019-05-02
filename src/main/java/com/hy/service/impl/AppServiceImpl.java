package com.hy.service.impl;

import com.hy.dao.AppDao;
import com.hy.dao.SellDao;
import com.hy.model.AppDomain;
import com.hy.model.SellDomain;
import com.hy.service.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/** Created by yaohou on 22:14 2019/3/21. description: */
@Service(value = "appService")
public class AppServiceImpl implements AppService {

  @Autowired private AppDao appDao;
  @Autowired private SellDao sellDao;

  @Override
  public int addApp(AppDomain app) {

    Date createDate = new Date();
    java.sql.Date sqlDate = new java.sql.Date(createDate.getTime());
    app.setCrtTime(sqlDate);

    return appDao.insert(app);
  }

  @Override
  public int delBrokerByUserId(AppDomain app) {
    return appDao.delBrokerByUserId(app);
  }

  @Override
  public List<AppDomain> querySell(AppDomain app) {
    SellDomain sellDomain = null;
    List<AppDomain> appDomains = appDao.querySell(app);
    for (AppDomain appDomain : appDomains) {
      sellDomain = new SellDomain();
      sellDomain.setUserId(appDomain.getUserId());
      appDomain.setSellList(sellDao.query(sellDomain));
    }
    return appDomains;
  }
}
