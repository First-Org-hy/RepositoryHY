package com.hy.controller;

import com.hy.common.Lable;
import com.hy.model.AdDomain;
import com.hy.service.AdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/** Created by yaohou on 21:59 2019/3/21. description: 用户类 */
@RestController
@RequestMapping(value = "/ad")
public class AdController {

  @Autowired private AdService adService;

  @ResponseBody
  @PostMapping("/add")
  public Lable addApp(AdDomain adDomain) {
    return adService.addAd(adDomain);
  }

  @ResponseBody
  @DeleteMapping("/del")
  public Lable delApp(AdDomain adDomain) {
    return adService.delAd(adDomain);
  }

  @ResponseBody
  @GetMapping("/query")
  public List<AdDomain> queryApp(AdDomain adDomain) {
    return adService.queryAd(adDomain);
  }

  @ResponseBody
  @PutMapping("/update")
  public Lable updateApp(AdDomain adDomain) {
    return adService.updateApp(adDomain);
  }
}
