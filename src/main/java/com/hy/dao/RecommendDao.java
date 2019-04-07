package com.hy.dao;

import com.hy.model.AppDomain;
import com.hy.model.RecommendDomain;

import java.util.List;

/**
 * Created by yaohou on 16:00 2019/4/3.
 * description:
 */
public interface RecommendDao {
    int insert(RecommendDomain recommend);

    List<RecommendDomain> selectGuest(String guestName, String guestPhone);

    List<RecommendDomain> queryRecoInfoByUserId(AppDomain app);

    List<RecommendDomain> queryRecoInfoByUserParId(AppDomain app);

    List<RecommendDomain> queryRecoInfoByGuestName(RecommendDomain reMend);
}


