package com.hy.service.impl;

import com.hy.dao.AdDao;
import com.hy.model.AdDomain;
import com.hy.service.AdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/** Created by yaohou on 22:14 2019/3/21. description: */
@Service(value = "adService")
public class AdServiceImpl implements AdService {

  @Autowired private AdDao adDao;

  @Override
  public int addAd(AdDomain adDomain) {

    return adDao.insert(adDomain);
  }
}
