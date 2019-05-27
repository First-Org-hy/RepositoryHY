package com.hy.controller;

import com.hy.common.Lable;
import com.hy.model.AdDomain;
import com.hy.service.AdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.github.pagehelper.PageInfo;

/** Created by yaohou on 21:59 2019/3/21. description: 用户类 */
@RestController
@RequestMapping(value = "/ad")
public class AdController {

  @Autowired private AdService adService;

  @ResponseBody
  @PostMapping("/add")
  public Lable addApp(AdDomain adDomain){
    return adService.addAd(adDomain);
  }

  @ResponseBody
  @DeleteMapping("/del")
  public Lable delApp(AdDomain adDomain) {
    return adService.delAd(adDomain);
  }

  @ResponseBody
  @GetMapping("/query")
  public PageInfo<AdDomain> queryApp(AdDomain adDomain,
        @RequestParam(name = "pageNum", required = false, defaultValue = "1") int pageNum,
        @RequestParam(name = "pageSize", required = false, defaultValue = "10") int pageSize) {
    return adService.queryAd(adDomain, pageNum, pageSize);
  }

  @ResponseBody
  @PutMapping("/update")
  public Lable updateApp(AdDomain adDomain) {
    return adService.updateApp(adDomain);
  }
}
