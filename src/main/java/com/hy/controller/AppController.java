package com.hy.controller;

import com.hy.common.Lable;
import com.hy.model.AppDomain;
import com.hy.service.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/** Created by yaohou on 21:59 2019/3/21. description: 用户类 */
@RestController
@RequestMapping(value = "/app")
public class AppController {

  @Autowired private AppService appService;

  @ResponseBody
  @PostMapping("/add")
  public int addApp(AppDomain app) {
    return appService.addApp(app);
  }

  // 用户管理-六种类型的用户查询，无需条件
  @ResponseBody
  @GetMapping("/query")
  public List<AppDomain> query(AppDomain appDomain) {
    return appService.query(appDomain);
  }

  // 用户管理-修改用户类型：userId，userType
  // 用户管理-编辑：userId，userType,userName,userPhone
  @ResponseBody
  @PutMapping("/update")
  public Lable update(AppDomain appDomain) {
    return appService.update(appDomain);
  }
  // 用户管理-删除用户: userId
  @ResponseBody
  @DeleteMapping("/del")
  public Lable del(AppDomain appDomain) {
    return appService.del(appDomain);
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
