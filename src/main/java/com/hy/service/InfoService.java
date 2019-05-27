package com.hy.service;

import com.hy.common.Lable;
import com.hy.model.HouseDynamicDomain;
import com.hy.model.HousesInfoDomain;
import com.github.pagehelper.PageInfo;
import java.util.List;

/** Created by yaohou on 22:16 2019/5/6. description: */
public interface InfoService {
  // 资讯查询
  PageInfo<HousesInfoDomain> queryInfo(HousesInfoDomain housesInfoDomain, int pageNum, int pageSize);
  // 资讯新增
  Lable addInfo(HousesInfoDomain housesInfoDomain);
  // 资讯删除
  Lable delInfo(HousesInfoDomain housesInfoDomain);
  // 资讯修改
  Lable updateInfo(HousesInfoDomain housesInfoDomain);
  // 楼盘动态修改
  Lable updateDynamic(HouseDynamicDomain houseDynamicDomain);
  // 楼盘动态删除
  Lable delDynamic(HouseDynamicDomain houseDynamicDomain);
  // 楼盘动态新增
  Lable addDynamic(HouseDynamicDomain houseDynamicDomain);
  // 楼盘动态查询
  PageInfo<HouseDynamicDomain> queryDynamic(HouseDynamicDomain houseDynamicDomain, int pageNum, int pageSize);
}
