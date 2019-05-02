package com.hy.controller;

import com.hy.model.AppDomain;
import com.hy.service.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/** Created by yaohou on 21:59 2019/3/21. description: */
@RestController
@RequestMapping(value = "/app")
public class AppController {

  @Autowired private AppService appService;

  @ResponseBody
  @PostMapping("/add")
  public int addApp(AppDomain app) {
    return appService.addApp(app);
  }

  @ResponseBody
  @PostMapping("/delByUserId")
  public int delBrokerByUserId(AppDomain app) {
    return appService.delBrokerByUserId(app);
  }

  // 根据公司id： parentId 查询
  @ResponseBody
  @GetMapping("/querySell")
  public List<AppDomain> querySell(AppDomain app) {
    return appService.querySell(app);
  }
}
