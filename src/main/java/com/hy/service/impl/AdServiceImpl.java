package com.hy.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hy.common.Lable;
import com.hy.dao.AdDao;
import com.hy.model.AdDomain;
import com.hy.service.AdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/** Created by yaohou on 22:14 2019/3/21. description: */
@Service(value = "adService")
public class AdServiceImpl implements AdService {

  @Autowired private AdDao adDao;

  @Override
  public Lable addAd(AdDomain adDomain) {
    Lable lable = null;
    if (adDao.insert(adDomain) != 0) {
      lable = new Lable("1", "新增成功");
    } else {
      lable = new Lable("2", "新增失败");
    }

    return lable;
  }

  @Override
  public Lable delAd(AdDomain adDomain) {

    Lable lable = null;
    if (adDao.del(adDomain) != 0) {
      lable = new Lable("1", "新增成功");
    } else {
      lable = new Lable("2", "新增失败");
    }

    return lable;
  }

  @Override
  public PageInfo<AdDomain> queryAd(AdDomain adDomain, int pageNum, int pageSize) {
    PageHelper .startPage(pageNum, pageSize);
    return new PageInfo(adDao.query(adDomain));
  }

  @Override
  public Lable updateApp(AdDomain adDomain) {

    Lable lable = null;
    if (adDao.update(adDomain) != 0) {
      lable = new Lable("1", "新增成功");
    } else {
      lable = new Lable("2", "新增失败");
    }

    return lable;
  }
}
