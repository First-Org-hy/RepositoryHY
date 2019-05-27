package com.hy.dao;

import com.hy.model.AdDomain;
import com.hy.model.InfoPictureDomain;

import java.util.List;

/** Created by yaohou on 22:16 2019/3/21. description: */
public interface AdDao {
  int insert(AdDomain adDomain);

  int del(AdDomain adDomain);

  List<AdDomain> query(AdDomain adDomain);

  int update(AdDomain adDomain);

  int addAdPicture(InfoPictureDomain pictureDomain);

  int delPic(InfoPictureDomain infoPictureDomain);

  List<InfoPictureDomain> queryPic(String id);

  List<AdDomain> queryIdAdName(AdDomain adDomain);
}
