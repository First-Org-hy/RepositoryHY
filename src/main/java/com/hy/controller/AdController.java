package com.hy.controller;

import com.hy.model.AdDomain;
import com.hy.service.AdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/** Created by yaohou on 21:59 2019/3/21. description: 用户类 */
@RestController
@RequestMapping(value = "/ad")
public class AdController {

  @Autowired private AdService adService;

  @ResponseBody
  @PostMapping("/add")
  public int addApp(AdDomain adDomain) {
    return adService.addAd(adDomain);
  }
}
