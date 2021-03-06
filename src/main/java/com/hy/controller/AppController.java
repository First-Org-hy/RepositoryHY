package com.hy.controller;

import com.github.pagehelper.PageInfo;
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

  // 新增用户
  @ResponseBody
  @PostMapping("/add")
  public Lable addApp(AppDomain app) {
    return appService.addApp(app);
  }

  // 用户管理-六种类型的用户查询，无需条件
  @ResponseBody
  @GetMapping("/query")
  public PageInfo<AppDomain> query(
      AppDomain appDomain,
      @RequestParam(name = "pageNum", required = false, defaultValue = "1") int pageNum,
      @RequestParam(name = "pageSize", required = false, defaultValue = "10") int pageSize) {
    return appService.query(appDomain, pageNum, pageSize);
  }

  // 后台登录
  @ResponseBody
  @GetMapping("/login")
  public List<AppDomain> queryLogin(AppDomain appDomain) {
    return appService.queryById(appDomain);
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

  // 删除用户
  @ResponseBody
  @PostMapping("/delByUserId")
  public int delBrokerByUserId(AppDomain app) {
    return appService.delBrokerByUserId(app);
  }

  // 根据公司id： parentId 查询
  @ResponseBody
  @GetMapping("/querySell")
  public PageInfo<AppDomain> querySell(
      AppDomain app,
      @RequestParam(name = "pageNum", required = false, defaultValue = "1") int pageNum,
      @RequestParam(name = "pageSize", required = false, defaultValue = "10") int pageSize) {
    return appService.querySell(app, pageNum, pageSize);
  }

  @ResponseBody
  @GetMapping("/queryCmpny")
  public PageInfo<AppDomain> queryCmpny(
      AppDomain appDomain,
      @RequestParam(name = "pageNum", required = false, defaultValue = "1") int pageNum,
      @RequestParam(name = "pageSize", required = false, defaultValue = "10") int pageSize) {
    // 经济公司查询
    appDomain.setUserType("4");
    return appService.query(appDomain, pageNum, pageSize);
  }

  // 经纪人新增:所属公司,
  @ResponseBody
  @PostMapping("/addMng")
  public Lable addMng(AppDomain app) {
    app.setUserType("5");
    return appService.addApp(app);
  }
  // 经纪人修改:修改公司,状态:通过,不通过
  @ResponseBody
  @PutMapping("/updateMng")
  public Lable updateMng(AppDomain appDomain) {
    return appService.update(appDomain);
  }

  // 经纪人查询:推荐查询(已成交/未成交,删除),已提成佣金,待提成佣金(修改:已领取(已领取 和 未领取 查询))
  @ResponseBody
  @GetMapping("/queryMng")
  public PageInfo<AppDomain> queryMng(
      AppDomain appDomain,
      @RequestParam(name = "pageNum", required = false, defaultValue = "1") int pageNum,
      @RequestParam(name = "pageSize", required = false, defaultValue = "10") int pageSize) {
    // 经济公司查询
    appDomain.setUserType("5");
    return appService.query(appDomain, pageNum, pageSize);
  }
  // 推荐查询(已成交/未成交,删除),已提成佣金,待提成佣金(修改:已领取(已领取 和 未领取 查询))
  // TODO

  // 经纪人删除 ('/del')

  // 经济公司新增:
  @ResponseBody
  @PostMapping("/addCmpny")
  public Lable addCmpny(AppDomain app) {
    app.setUserType("4");
    return appService.addApp(app);
  }

  // 经济公司修改:状态:通过,不通过
  @ResponseBody
  @PutMapping("/updateCmpny")
  public Lable updateCmpny(AppDomain appDomain) {
    appDomain.setUserType("4");
    return appService.update(appDomain);
  }

  // 经济公司删除('/del')
  // 经济公司查询:经纪人查询,推荐查询(已成交/未成交,删除),已提成佣金,待提成佣金(修改:已领取(已领取 和 未领取 查询))
  // TODO
}
