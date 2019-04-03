package com.hy.service;

import com.hy.model.RecommendDomain;

import java.util.List;

/**
 * Created by yaohou on 16:13 2019/4/3.
 * description:
 */
public interface RecommendService {

    int addRecommend(RecommendDomain recommend);

    List<RecommendDomain> selectRecommends();

}
