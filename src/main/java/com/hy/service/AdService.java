package com.hy.service;

import com.hy.common.Lable;
import com.hy.model.AdDomain;

import java.util.List;

/** Created by yaohou on 22:04 2019/3/21. description: */
public interface AdService {
  Lable addAd(AdDomain adDomain);

  Lable delAd(AdDomain adDomain);

  List<AdDomain> queryAd(AdDomain adDomain);

  Lable updateApp(AdDomain adDomain);
}
