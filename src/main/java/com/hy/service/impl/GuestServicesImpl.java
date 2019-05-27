package com.hy.service.impl;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.hy.common.Lable;
import com.hy.dao.GuestDao;
import com.hy.model.GuestDomain;
import com.hy.service.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;

/** Created by yaohou on 14:49 2019/5/3. description: */
@Service(value = "guestService")
public class GuestServicesImpl implements GuestService {
  private static Logger logger = LoggerFactory.getLogger(GuestServicesImpl.class);

  @Autowired GuestDao guestDao;

  // 客户管理客户查询:crtTime(开始时间),updateTime(结束时间)  guestName like 姓名,电话,楼盘,推荐人
  @Override
  public PageInfo<GuestDomain> query(GuestDomain guestDomain,  int pageNum, int pageSize) {
    PageHelper.startPage(pageNum, pageSize);
    List<GuestDomain> query = guestDao.query(guestDomain);
    logger.info("客户管理客户查询：" + JSON.toJSONString(query));
    return new PageInfo(query);
  }

  // 客户管理新增客户:guestDomain
  @Override
  public Lable add(GuestDomain guestDomain) {
    Lable lable = null;
    if (guestDao.insert(guestDomain) == 1) {
      lable = new Lable("1", "新增成功");
    } else {
      lable = new Lable("0", "新增失败");
    }
    return lable;
  }

  // 客户管理编辑备注:guestComment,guestId
  @Override
  public Lable update(GuestDomain guestDomain) {
    Lable lable = null;
    if (guestDao.update(guestDomain) == 1) {
      lable = new Lable("1", "修改成功");
    } else {
      lable = new Lable("1", "修改成功");
    }
    return lable;
  }

  // 客户管理删除客户信息：guestId
  @Override
  public Lable delete(GuestDomain guestDomain) {
    Lable lable = null;
    if (guestDao.delete(guestDomain) == 1) {
      lable = new Lable("1", "删除成功");
    } else {
      lable = new Lable("0", "删除失败");
    }
    return lable;
  }
}
