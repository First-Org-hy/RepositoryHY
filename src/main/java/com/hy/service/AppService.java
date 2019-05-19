package com.hy.service;

import com.github.pagehelper.PageInfo;
import com.hy.common.Lable;
import com.hy.model.AppDomain;

import java.util.List;

/** Created by yaohou on 22:04 2019/3/21. description: */
public interface AppService {
  Lable addApp(AppDomain app);

  int delBrokerByUserId(AppDomain app);

  /**
   * 查询经纪人销售情况
   *
   * @author yaohou
   * @date 2019/5/2 14:36
   * @return java.util.List<com.hy.model.AppDomain>
   */
  List<AppDomain> querySell(AppDomain app);
  // 用户管理-六种类型的用户查询，无需条件
  PageInfo<AppDomain> query(AppDomain appDomain, int pageNum, int pageSize);
  // 用户管理-修改用户类型：userId，userType
  Lable update(AppDomain appDomain);
  // 删除用户: userId
  Lable del(AppDomain appDomain);
  // 微信登录:仅用appid校验是否已有该用户
  List<AppDomain> queryById(AppDomain app);
}
