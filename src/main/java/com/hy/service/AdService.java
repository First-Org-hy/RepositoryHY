package com.hy.service;

import com.hy.common.Lable;
import com.hy.model.AdDomain;
import com.github.pagehelper.PageInfo;

/** Created by yaohou on 22:04 2019/3/21. description: */
public interface AdService {
  Lable addAd(AdDomain adDomain);

  Lable delAd(AdDomain adDomain);

  PageInfo<AdDomain> queryAd(AdDomain adDomain, int pageNum, int pageSize);

  Lable updateApp(AdDomain adDomain);
}
