package com.hy.service;

import com.hy.common.Lable;
import com.hy.model.AppDomain;
import com.hy.model.RecommendDomain;

import java.util.List;

/**
 * Created by yaohou on 16:13 2019/4/3.
 * description:
 */
public interface RecommendService {

    Lable addRecommend(RecommendDomain recommend);

    List<RecommendDomain> queryRecoInfoByUserId(AppDomain app);

    List<RecommendDomain> queryRecoInfoByUserParId(AppDomain app);

    List<RecommendDomain> queryRecoInfoByGuestName(RecommendDomain reMend);
}
