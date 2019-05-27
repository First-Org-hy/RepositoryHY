package com.hy.service.impl;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hy.common.Lable;
import com.hy.dao.InfoDao;
import com.hy.model.*;
import com.hy.service.InfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/** Created by yaohou on 22:16 2019/5/6. description: */
@Service(value = "infoService")
public class InfoServiceImpl implements InfoService {
  private static Logger logger = LoggerFactory.getLogger(InfoServiceImpl.class);
  @Autowired InfoDao infoDao;

  // 资讯查询
  @Override
  public PageInfo<HousesInfoDomain> queryInfo(HousesInfoDomain housesInfoDomain,int pageNum, int pageSize) {
    List<HousesInfoDomain> housesInfoDomains = infoDao.queryInfo(housesInfoDomain);
    for (HousesInfoDomain infos : housesInfoDomains) {
      infos.setInfoPictureDomains(infoDao.queryPic(infos.getId()));
      infos.setInfoLableDomains(infoDao.queryLable(infos.getId()));
    }
    PageHelper.startPage(pageNum, pageSize);
    logger.info("资讯查询:" + JSON.toJSONString(housesInfoDomains));
    return new PageInfo(housesInfoDomains);
  }
  // 资讯新增
  @Override
  public Lable addInfo(HousesInfoDomain housesInfoDomain) {
    Lable lable = null;
    if (infoDao.addInfo(housesInfoDomain) != 0) {
      lable = new Lable("1", "增加成功");
    } else {
      lable = new Lable("2", "增加失败");
    }
    List<String> picList = Arrays.asList(housesInfoDomain.getPicAddress().split(","));
    if (picList.size() != 0) {
      for (String pic : picList) {
        infoDao.addPic(new InfoPictureDomain(housesInfoDomain.getId(), pic));
      }
    }

    List<String> labList = Arrays.asList(housesInfoDomain.getLableId().split(","));
    if (labList.size() != 0) {
      for (String lab : labList) {
        infoDao.addLable(new InfoLableDomain(housesInfoDomain.getLableId(), lab));
      }
    }

    return lable;
  }

  // 资讯删除
  @Override
  public Lable delInfo(HousesInfoDomain housesInfoDomain) {
    Lable lable = null;
    infoDao.delPic(housesInfoDomain.getPicAddress());
    infoDao.delLable(housesInfoDomain.getLableId());
    if (infoDao.delInfo(housesInfoDomain) != 0) {
      lable = new Lable("1", "删除成功");
    } else {
      lable = new Lable("2", "删除失败");
    }
    return lable;
  }

  // 资讯修改
  @Override
  public Lable updateInfo(HousesInfoDomain housesInfoDomain) {
    Lable lable = null;
    if (infoDao.updateInfo(housesInfoDomain) != 0) {
      lable = new Lable("1", "修改成功");
    } else {
      lable = new Lable("2", "修改失败");
    }
    return lable;
  }
  // 楼盘动态修改
  @Override
  public Lable updateDynamic(HouseDynamicDomain houseDynamicDomain) {
    Lable lable = null;
    if (infoDao.updateDynamic(houseDynamicDomain) != 0) {
      lable = new Lable("1", "修改成功");
    } else {
      lable = new Lable("2", "修改失败");
    }
    return lable;
  }

  // 楼盘动态删除
  @Override
  public Lable delDynamic(HouseDynamicDomain houseDynamicDomain) {
    Lable lable = null;
    if (infoDao.delDynamic(houseDynamicDomain) != 0) {
      lable = new Lable("1", "删除成功");
    } else {
      lable = new Lable("2", "删除失败");
    }
    return lable;
  }
  // 楼盘动态增加
  @Override
  public Lable addDynamic(HouseDynamicDomain houseDynamicDomain) {
    Lable lable = null;
    if (infoDao.addDynamic(houseDynamicDomain) != 0) {
      lable = new Lable("1", "增加成功");
    } else {
      lable = new Lable("2", "增加失败");
    }
    return lable;
  }
  // 楼盘动态查询
  @Override
  public PageInfo<HouseDynamicDomain> queryDynamic(HouseDynamicDomain houseDynamicDomain,int pageNum, int pageSize) {
    List<HouseDynamicDomain> houseDynamicDomains = infoDao.queryDynamic(houseDynamicDomain);
    PageHelper.startPage(pageNum, pageSize);
    logger.info("楼盘动态查询:" + JSON.toJSONString(houseDynamicDomains));
    return new PageInfo(houseDynamicDomains);
  }
}
