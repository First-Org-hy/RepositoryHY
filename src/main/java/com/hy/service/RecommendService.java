package com.hy.service;

import com.hy.common.Lable;
import com.hy.model.AppDomain;
import com.hy.model.RecommendDomain;
import com.github.pagehelper.PageInfo;
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

  PageInfo<RecommendDomain> queryRecoInfoByUserId(AppDomain app, int pageNum, int pageSize);

  PageInfo<RecommendDomain> queryRecoInfoByUserParId(AppDomain app, int pageNum, int pageSize);

  PageInfo<RecommendDomain> queryRecoInfoByGuestName(RecommendDomain reMend, int pageNum, int pageSize);

  Lable isRecommendOfCom(String userId, String userParId);

  PageInfo<AppDomain> queryCompanyInfo(String userId, int pageNum, int pageSize);

  /**
   * 查询所有推荐人信息
   *
   * @author yaohou
   * @date 2019/5/1 16:10
   * @return java.util.List<com.hy.model.RecommendDomain>
   */
  PageInfo<RecommendDomain> query(RecommendDomain recommendDomain, int pageNum, int pageSize);
}
