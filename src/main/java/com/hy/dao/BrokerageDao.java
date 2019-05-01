package com.hy.dao;

import com.hy.model.BrokerageDomain;

import java.util.List;

/** Created by yaohou on 17:05 2019/4/3. description: */
public interface BrokerageDao {
  int insert(BrokerageDomain brokerageDomain);

  List<BrokerageDomain> selectBrokerages(BrokerageDomain brokerageDomain);

  /**
   * 查询个人未读,且已提现的佣金消息
   *
   * @author yaohou
   * @date 2019/5/1 16:21
   * @return java.util.List<com.hy.model.BrokerageDomain>
   */
  List<BrokerageDomain> queryBrokeragesUnread(BrokerageDomain brokerageDomain);

  /**
   * 跟新佣金信息为已读
   *
   * @author yaohou
   * @date 2019/5/1 16:40
   * @return java.util.List<com.hy.model.BrokerageDomain>
   */
  int updateBrokeragesRead(BrokerageDomain brokerageDomain);
}
