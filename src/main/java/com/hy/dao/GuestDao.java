package com.hy.dao;

import com.hy.model.GuestDomain;

import java.util.List;

/** Created by yaohou on 14:46 2019/5/3. description: */
public interface GuestDao {
  // 客户管理客户查询:crtTime(开始时间),updateTime(结束时间)  guestName like 姓名,电话,楼盘,推荐人
  List<GuestDomain> query(GuestDomain guestDomain);

  // 客户管理新增客户:guestDomain
  int insert(GuestDomain guestDomain);

  // 客户管理编辑备注:guestComment,guestId
  int update(GuestDomain guestDomain);

  // 客户管理删除客户信息：guestId
  int delete(GuestDomain guestDomain);
}
