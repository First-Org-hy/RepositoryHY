package com.hy.controller;

import com.hy.model.RecommendDomain;
import com.hy.service.RecommendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by yaohou on 16:16 2019/4/3.
 * description:
 */
@RestController
@RequestMapping(value = "recommend")
public class RecommendController {

    @Autowired
    private RecommendService recommendService;



    @ResponseBody
    @PostMapping(value = "add")
    public int addRecommend(RecommendDomain recommend){
        // 针对楼盘推荐用户：housesId userId guestName  guestPhone， 判断这四个属性是否有
        // 查询该用户是否已经存在： 0 表示该客户已存在，（客户姓名+客户电话 校验，且客户30天有效）

        recommend.setDealState("2");
        return recommendService.addRecommend(recommend);
    }


}
