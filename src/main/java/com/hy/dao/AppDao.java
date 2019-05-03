package com.hy.dao;

import com.hy.model.AppDomain;

import java.util.List;

/** Created by yaohou on 22:16 2019/3/21. description: */
public interface AppDao {
  int insert(AppDomain appDomain);

  int delBrokerByUserId(AppDomain app);

  /**
   * 查询经纪人销售情况
   *
   * @author yaohou
   * @date 2019/5/2 14:38
   * @return java.util.List<com.hy.model.AppDomain>
   */
  List<AppDomain> querySell(AppDomain app);

  // 用户管理-六种类型的用户查询，无需条件
  // 楼盘查询时 经纪人集合查询
  List<AppDomain> query(AppDomain appDomain);
  // 用户管理-修改用户类型：userId，userType
  int update(AppDomain appDomain);
  // 删除用户: userId
  int del(AppDomain appDomain);
}
