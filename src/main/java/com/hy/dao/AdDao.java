package com.hy.dao;

import com.hy.model.AdDomain;

import java.util.List;

/** Created by yaohou on 22:16 2019/3/21. description: */
public interface AdDao {
  int insert(AdDomain adDomain);

  int del(AdDomain adDomain);

  List<AdDomain> query(AdDomain adDomain);

  int update(AdDomain adDomain);
}
