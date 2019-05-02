package com.hy.dao;

import com.hy.model.AppDomain;
import com.hy.model.RecommendDomain;

import java.util.List;

/** Created by yaohou on 16:00 2019/4/3. description: */
public interface RecommendDao {
  /**
   * 添加推荐客户
   *
   * @author yaohou
   * @date 2019/5/1 15:38
   * @return int
   */
  int insert(RecommendDomain recommend);

  /**
   * 根据用户名 和 手机号判断该用户是否已被推荐
   *
   * @author yaohou
   * @date 2019/5/1 15:32
   * @return java.util.List<com.hy.model.RecommendDomain>
   */
  List<RecommendDomain> selectGuest(RecommendDomain recommendDomain);

  List<RecommendDomain> queryRecoInfoByUserId(AppDomain app);

  List<RecommendDomain> queryRecoInfoByUserParId(AppDomain app);

  List<RecommendDomain> queryRecoInfoByGuestName(RecommendDomain reMend);

  int isRecommendOfCom(String userId, String userParId);

  List<AppDomain> queryCompanyInfo(String userId);
  /**
   * 查询所有推荐人信息
   *
   * @author yaohou
   * @date 2019/5/1 16:14
   * @return java.util.List<com.hy.model.RecommendDomain>
   */
  List<RecommendDomain> query(RecommendDomain recommendDomain);
}
