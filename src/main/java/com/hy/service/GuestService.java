package com.hy.service;

import com.hy.common.Lable;
import com.hy.model.GuestDomain;

import java.util.List;

/** Created by yaohou on 14:48 2019/5/3. description: */
public interface GuestService {
  // 客户管理客户查询:crtTime(开始时间),updateTime(结束时间)  guestName like 姓名,电话,楼盘,推荐人
  List<GuestDomain> query(GuestDomain guestDomain);

  // 客户管理新增客户:guestDomain
  Lable add(GuestDomain guestDomain);

  // 客户管理编辑备注:guestComment,guestId
  Lable update(GuestDomain guestDomain);

  // 客户管理删除客户信息：guestId
  Lable delete(GuestDomain guestDomain);
}
