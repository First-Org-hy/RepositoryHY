package com.hy.service;

import com.hy.model.AppDomain;

import java.util.List;

/** Created by yaohou on 22:04 2019/3/21. description: */
public interface AppService {
  int addApp(AppDomain app);

  int delBrokerByUserId(AppDomain app);

  /**
   * 查询经纪人销售情况
   *
   * @author yaohou
   * @date 2019/5/2 14:36
   * @return java.util.List<com.hy.model.AppDomain>
   */
  List<AppDomain> querySell(AppDomain app);
}
