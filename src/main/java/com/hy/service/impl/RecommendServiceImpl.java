package com.hy.service.impl;

import com.hy.common.Lable;
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
    public Lable addRecommend(RecommendDomain recommend) {

        Lable lable = new Lable();
//        // 针对楼盘推荐用户：housesId userId guestName  guestPhone， 判断这四个属性是否有
//        if(!recommend.getHousesId().isEmpty()&!recommend.getUserId().isEmpty()&
//                !recommend.getGuestName().isEmpty()&!recommend.getGuestPhone().isEmpty()){
//            //查询该用户是否已经存在：0 表示该客户已存在，（客户姓名+客户电话 校验，且客户30天有效）
//            recommendDao.selectGuest(recommend.getGuestName(), recommend.getGuestPhone());
//
//            //设置成效状态为未成交：1
//            recommend.setDealState("1");
            if(recommendDao.insert(recommend) == 1){
                lable.setId("1");
                lable.setMessage("新增成功");
            }

//        }else{
//            lable.setId("3");
//            lable.setMessage("请求信息不正确");
//        }



        return lable;
    }

    @Override
    public List<RecommendDomain> selectRecommends() {
        return recommendDao.selectRecommends();
    }
}
