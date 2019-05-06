package com.hy.service.impl;

import com.hy.common.Lable;
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
  // 用户管理-六种类型的用户查询，无需条件
  @Override
  public List<AppDomain> query(AppDomain appDomain) {
    return appDao.query(appDomain);
  }

  // 用户管理-修改用户类型：userId，userType
  @Override
  public Lable update(AppDomain appDomain) {
    Lable lable = null;
    if (appDao.update(appDomain) == 1) {
      lable = new Lable("1", "修改成功");
    } else {
      lable = new Lable("0", "修改失败");
    }
    return null;
  }
  // 删除用户: userId
  @Override
  public Lable del(AppDomain appDomain) {
    Lable lable = null;
    if (appDao.del(appDomain) == 1) {
      lable = new Lable("1", "删除成功");
    } else {
      lable = new Lable("0", "删除失败");
    }
    return lable;
  }

  @Override
  public List<AppDomain> queryById(AppDomain app) {
    return appDao.queryById(app);
  }
}
