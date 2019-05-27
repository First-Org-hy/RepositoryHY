package com.hy.service.impl;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hy.common.Lable;
import com.hy.dao.AppDao;
import com.hy.dao.SellDao;
import com.hy.model.AppDomain;
import com.hy.model.SellDomain;
import com.hy.service.AppService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/** Created by yaohou on 22:14 2019/3/21. description: */
@Service(value = "appService")
public class AppServiceImpl implements AppService {
  private static Logger logger = LoggerFactory.getLogger(AppServiceImpl.class);

  @Autowired private AppDao appDao;
  @Autowired private SellDao sellDao;

  @Override
  public Lable addApp(AppDomain app) {
    logger.info("请求信息:" + JSON.toJSONString(app));
    Lable lable = null;
    if (appDao.insert(app) == 1) {
      lable = new Lable("1", "新增成功");
    } else {
      lable = new Lable("0", "新增失败");
    }
    return lable;
  }

  @Override
  public int delBrokerByUserId(AppDomain app) {
    return appDao.delBrokerByUserId(app);
  }

  @Override
  public PageInfo<AppDomain> querySell(AppDomain app, int pageNum, int pageSize) {
    SellDomain sellDomain = null;
    PageHelper.startPage(pageNum, pageSize);
    List<AppDomain> appDomains = appDao.querySell(app);
    for (AppDomain appDomain : appDomains) {
      sellDomain = new SellDomain();
      sellDomain.setUserId(appDomain.getUserId());
      appDomain.setSellList(sellDao.query(sellDomain));
    }
    logger.info("日志成功!" + JSON.toJSONString(appDomains));

    return new PageInfo(appDomains);
  }
  // 用户管理-六种类型的用户查询，无需条件
  @Override
  public PageInfo<AppDomain> query(AppDomain appDomain, int pageNum, int pageSize) {
    PageHelper.startPage(pageNum, pageSize);
    List<AppDomain> appDomains = appDao.query(appDomain);

    logger.info("日志成功!" + JSON.toJSONString(appDomains));
    System.out.println(appDomain);
    return new PageInfo(appDomains);
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
    return lable;
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
