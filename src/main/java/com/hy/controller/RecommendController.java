package com.hy.controller;

import com.hy.common.Lable;
import com.hy.model.AppDomain;
import com.hy.model.RecommendDomain;
import com.hy.service.RecommendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.github.pagehelper.PageInfo;
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
  public PageInfo<RecommendDomain> queryRecommendInfoByUserId(AppDomain app,
                                                              @RequestParam(name = "pageNum", required = false, defaultValue = "1") int pageNum,
                                                              @RequestParam(name = "pageSize", required = false, defaultValue = "10") int pageSize) {
    return recommendService.queryRecoInfoByUserId(app, pageNum, pageSize);
  }

  // 楼盘商务,使用楼盘id housesId, 查询该楼盘推荐信息
  @ResponseBody
  @GetMapping(value = "query")
  public PageInfo<RecommendDomain> query(RecommendDomain recommendDomain,
                                         @RequestParam(name = "pageNum", required = false, defaultValue = "1") int pageNum,
                                         @RequestParam(name = "pageSize", required = false, defaultValue = "10") int pageSize) {
    return recommendService.query(recommendDomain, pageNum, pageSize);
  }

  @ResponseBody
  @GetMapping(value = "queryByUserParId")
  public PageInfo<RecommendDomain> queryRecommendInfoByUserParId(AppDomain app,
                                                                 @RequestParam(name = "pageNum", required = false, defaultValue = "1") int pageNum,
                                                                 @RequestParam(name = "pageSize", required = false, defaultValue = "10") int pageSize) {
    return recommendService.queryRecoInfoByUserParId(app, pageNum, pageSize);
  }

  @ResponseBody
  @GetMapping(value = "queryByGuestName")
  public PageInfo<RecommendDomain> queryRecommendInfoByGuestName(RecommendDomain reMend,
                                                                 @RequestParam(name = "pageNum", required = false, defaultValue = "1") int pageNum,
                                                                 @RequestParam(name = "pageSize", required = false, defaultValue = "10") int pageSize) {
    return recommendService.queryRecoInfoByGuestName(reMend, pageNum, pageSize);
  }

  @ResponseBody
  @GetMapping(value = "queryCompanyInfo")
  public PageInfo<AppDomain> queryCompanyInfo(String userId,
                                              @RequestParam(name = "pageNum", required = false, defaultValue = "1") int pageNum,
                                              @RequestParam(name = "pageSize", required = false, defaultValue = "10") int pageSize) {
    return recommendService.queryCompanyInfo(userId, pageNum, pageSize);
  }

  @ResponseBody
  @PostMapping(value = "isRecommendOfCom")
  public Lable isRecommendOfCom(String userId, String userParId) {
    return recommendService.isRecommendOfCom(userId, userParId);
  }
}
