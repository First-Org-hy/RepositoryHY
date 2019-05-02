package com.hy.controller;

import com.hy.common.Lable;
import com.hy.model.AppDomain;
import com.hy.model.RecommendDomain;
import com.hy.service.RecommendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/** Created by yaohou on 16:16 2019/4/3. description:推荐 服务 */
@RestController
@RequestMapping(value = "recommend")
public class RecommendController {

  @Autowired private RecommendService recommendService;

  @ResponseBody
  @PostMapping(value = "add")
  public Lable addRecommend(RecommendDomain recommend) {
    return recommendService.addRecommend(recommend);
  }

  @ResponseBody
  @GetMapping(value = "queryByUserId")
  public List<RecommendDomain> queryRecommendInfoByUserId(AppDomain app) {
    return recommendService.queryRecoInfoByUserId(app);
  }

  // 楼盘商务,使用楼盘id housesId, 查询该楼盘推荐信息
  @ResponseBody
  @GetMapping(value = "query")
  public List<RecommendDomain> query(RecommendDomain recommendDomain) {
    return recommendService.query(recommendDomain);
  }

  @ResponseBody
  @GetMapping(value = "queryByUserParId")
  public List<RecommendDomain> queryRecommendInfoByUserParId(AppDomain app) {
    return recommendService.queryRecoInfoByUserParId(app);
  }

  @ResponseBody
  @GetMapping(value = "queryByGuestName")
  public List<RecommendDomain> queryRecommendInfoByGuestName(RecommendDomain reMend) {
    return recommendService.queryRecoInfoByGuestName(reMend);
  }

  @ResponseBody
  @GetMapping(value = "queryCompanyInfo")
  public List<AppDomain> queryCompanyInfo(String userId) {
    return recommendService.queryCompanyInfo(userId);
  }

  @ResponseBody
  @PostMapping(value = "isRecommendOfCom")
  public Lable isRecommendOfCom(String userId, String userParId) {
    return recommendService.isRecommendOfCom(userId, userParId);
  }
}
