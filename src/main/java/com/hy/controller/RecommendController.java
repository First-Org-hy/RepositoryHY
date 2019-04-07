package com.hy.controller;

import com.hy.common.Lable;
import com.hy.model.RecommendDomain;
import com.hy.service.RecommendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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


}
