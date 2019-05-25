package com.hy.controller;

import com.hy.common.Lable;
import com.hy.model.GuestDomain;
import com.hy.service.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/** Created by yaohou on 14:50 2019/5/3. description:客户表 */
@RestController
@RequestMapping(value = "/guest")
public class GuestController {
  @Autowired private GuestService guestService;

  // 客户管理客户查询:crtTime(开始时间),updateTime(结束时间)  guestName like 姓名,电话,楼盘,推荐人
  @ResponseBody
  @GetMapping("/query")
  public List<GuestDomain> query(GuestDomain guestDomain) {
    return guestService.query(guestDomain);
  }

  // 客户管理新增客户:guestDomain
  @ResponseBody
  @PostMapping("/add")
  public Lable add(GuestDomain guestDomain) {
    return guestService.add(guestDomain);
  }

  // 客户管理编辑备注:guestComment,guestId
  @ResponseBody
  @PutMapping("/put")
  public Lable update(GuestDomain guestDomain) {
    return guestService.update(guestDomain);
  }

  // 客户管理删除客户信息：guestId
  @ResponseBody
  @DeleteMapping("/del")
  public Lable delete(GuestDomain guestDomain) {
    return guestService.delete(guestDomain);
  }
}
