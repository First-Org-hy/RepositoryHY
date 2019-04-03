package com.hy.service.impl;

import com.hy.dao.RecommendDao;
import com.hy.model.RecommendDomain;
import com.hy.service.RecommendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by yaohou on 16:14 2019/4/3.
 * description:
 */
@Service(value = "recommendService")
public class RecommendServiceImpl implements RecommendService {
    @Autowired
    private RecommendDao recommendDao;

    @Override
    public int addRecommend(RecommendDomain recommend) {
        return recommendDao.insert(recommend);
    }

    @Override
    public List<RecommendDomain> selectRecommends() {
        return recommendDao.selectRecommends();
    }
}
