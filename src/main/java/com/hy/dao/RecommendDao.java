package com.hy.dao;

import com.hy.model.RecommendDomain;

import java.util.List;

/**
 * Created by yaohou on 16:00 2019/4/3.
 * description:
 */
public interface RecommendDao {
    int insert(RecommendDomain recommend);

    List<RecommendDomain> selectRecommends();

}
