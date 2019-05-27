package com.hy.controller;

import com.hy.common.Lable;
import com.hy.model.HouseDynamicDomain;
import com.hy.model.HousesInfoDomain;
import com.hy.service.InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.github.pagehelper.PageInfo;
import java.util.List;

/** Created by yaohou on 22:08 2019/5/6. description: 资讯,动态服务类 */
@RestController
@RequestMapping(value = "/info")
public class InfoController {

  @Autowired InfoService infoService;

  // 资讯查询
  @ResponseBody
  @GetMapping("/queryInfo")
  public PageInfo<HousesInfoDomain> queryInfo(HousesInfoDomain housesInfoDomain,
                                              @RequestParam(name = "pageNum", required = false, defaultValue = "1") int pageNum,
  @RequestParam(name = "pageSize", required = false, defaultValue = "10") int pageSize) {
    return infoService.queryInfo(housesInfoDomain, pageNum, pageSize);
  }

  // 资讯新增
  @ResponseBody
  @PostMapping("/addInfo")
  public Lable addInfo(HousesInfoDomain housesInfoDomain) {
    return infoService.addInfo(housesInfoDomain);
  }

  // 资讯删除
  @ResponseBody
  @DeleteMapping("/delInfo")
  public Lable delInfo(HousesInfoDomain housesInfoDomain) {
    return infoService.delInfo(housesInfoDomain);
  }

  // 资讯修改
  @ResponseBody
  @PutMapping("/updateInfo")
  public Lable updateInfo(HousesInfoDomain housesInfoDomain) {
    return infoService.updateInfo(housesInfoDomain);
  }

  // 楼盘动态查询
  @ResponseBody
  @GetMapping("/queryDynamic")
  public PageInfo<HouseDynamicDomain> queryDynamic(HouseDynamicDomain houseDynamicDomain,
                                               @RequestParam(name = "pageNum", required = false, defaultValue = "1") int pageNum,
                                               @RequestParam(name = "pageSize", required = false, defaultValue = "10") int pageSize) {
    return infoService.queryDynamic(houseDynamicDomain, pageNum, pageSize);
  }

  // 楼盘动态新增
  @ResponseBody
  @PostMapping("/addDynamic")
  public Lable addDynamic(HouseDynamicDomain houseDynamicDomain) {
    return infoService.addDynamic(houseDynamicDomain);
  }

  // 楼盘动态删除
  @ResponseBody
  @DeleteMapping("/delDynamic")
  public Lable delDynamic(HouseDynamicDomain houseDynamicDomain) {
    return infoService.delDynamic(houseDynamicDomain);
  }

  // 楼盘动态修改
  @ResponseBody
  @PutMapping("/updateDynamic")
  public Lable updateDynamic(HouseDynamicDomain houseDynamicDomain) {
    return infoService.updateDynamic(houseDynamicDomain);
  }
}
