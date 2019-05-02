package com.hy.service;

import com.hy.common.Lable;
import com.hy.model.AppDomain;
import com.hy.model.RecommendDomain;

import java.util.List;

/** Created by yaohou on 16:13 2019/4/3. description: */
public interface RecommendService {

  /**
   * 添加推荐人
   *
   * @author yaohou
   * @date 2019/4/24 22:11
   * @return com.hy.common.Lable
   */
  Lable addRecommend(RecommendDomain recommend);

  List<RecommendDomain> queryRecoInfoByUserId(AppDomain app);

  List<RecommendDomain> queryRecoInfoByUserParId(AppDomain app);

  List<RecommendDomain> queryRecoInfoByGuestName(RecommendDomain reMend);

  Lable isRecommendOfCom(String userId, String userParId);

  List<AppDomain> queryCompanyInfo(String userId);

  /**
   * 查询所有推荐人信息
   *
   * @author yaohou
   * @date 2019/5/1 16:10
   * @return java.util.List<com.hy.model.RecommendDomain>
   */
  List<RecommendDomain> query(RecommendDomain recommendDomain);
}
