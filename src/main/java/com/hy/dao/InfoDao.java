package com.hy.dao;

import com.hy.model.HouseDynamicDomain;
import com.hy.model.HousesInfoDomain;
import com.hy.model.InfoLableDomain;
import com.hy.model.InfoPictureDomain;

import java.util.List;

/** Created by yaohou on 22:22 2019/5/6. description: */
public interface InfoDao {
  List<HousesInfoDomain> queryInfo(HousesInfoDomain housesInfoDomain);

  int addInfo(HousesInfoDomain housesInfoDomain);

  int delInfo(HousesInfoDomain housesInfoDomain);

  int updateInfo(HousesInfoDomain housesInfoDomain);

  int updateDynamic(HouseDynamicDomain houseDynamicDomain);

  int delDynamic(HouseDynamicDomain houseDynamicDomain);

  int addDynamic(HouseDynamicDomain houseDynamicDomain);

  List<HouseDynamicDomain> queryDynamic(HouseDynamicDomain houseDynamicDomain);

  int addPic(InfoPictureDomain infoPictureDomain);

  int addLable(InfoLableDomain infoPictureDomain);

  List<InfoPictureDomain> queryPic(String id);

  List<HousesInfoDomain> queryIdByHead(HousesInfoDomain housesInfoDomain);

  List<InfoLableDomain> queryLable(String id);

  int delLable(InfoLableDomain infoLableDomain);

  int delPic(InfoPictureDomain infoPictureDomain);
}
