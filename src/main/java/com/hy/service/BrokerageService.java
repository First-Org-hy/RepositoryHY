package com.hy.service;

import com.hy.model.BrokerageDomain;

import java.util.List;

/** Created by yaohou on 12:58 2019/4/7. description: */
public interface BrokerageService {
  List<BrokerageDomain> selectBrokerages(BrokerageDomain brokerageDomain);

  int add(BrokerageDomain brokerageDomain);

  /**
   * 更新佣金信息为已读状态
   *
   * @author yaohou
   * @date 2019/5/1 16:39
   * @return java.util.List<com.hy.model.BrokerageDomain>
   */
  int updateBrokeragesRead(BrokerageDomain brokerageDomain);
}
