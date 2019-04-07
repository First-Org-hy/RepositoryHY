package com.hy.controller;

import com.hy.common.Lable;
import com.hy.model.AppDomain;
import com.hy.model.RecommendDomain;
import com.hy.service.RecommendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by yaohou on 16:16 2019/4/3.
 * description:推荐 服务
 */
@RestController
@RequestMapping(value = "recommend")
public class RecommendController {

    @Autowired
    private RecommendService recommendService;

    /**
     *
     *  添加推荐人
     * @author yaohou
     * @date 2019/4/7 12:55
     * @return com.hy.common.Lable
     */
    @ResponseBody
    @PostMapping(value = "add")
    public Lable addRecommend(RecommendDomain recommend){

        return recommendService.addRecommend(recommend);
    }

    @ResponseBody
    @GetMapping(value = "queryRecommendInfoByUserId")
    public List<RecommendDomain> queryRecommendInfoByUserId(AppDomain app){
        return recommendService.queryRecoInfoByUserId(app);
    }

    @ResponseBody
    @GetMapping(value = "queryRecommendInfoByUserParId")
    public List<RecommendDomain> queryRecommendInfoByUserParId(AppDomain app){
        return recommendService.queryRecoInfoByUserParId(app);
    }

    @ResponseBody
    @GetMapping(value = "queryRecommendInfoByGuestName")
    public List<RecommendDomain> queryRecommendInfoByGuestName(RecommendDomain reMend){
        return recommendService.queryRecoInfoByGuestName(reMend);
    }

}
