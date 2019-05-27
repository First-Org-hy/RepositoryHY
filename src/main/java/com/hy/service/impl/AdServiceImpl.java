package com.hy.service.impl;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hy.common.Lable;
import com.hy.dao.AdDao;
import com.hy.model.AdDomain;
import com.hy.model.AppDomain;
import com.hy.model.InfoPictureDomain;
import com.hy.service.AdService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/** Created by yaohou on 22:14 2019/3/21. description: */
@Service(value = "adService")
public class AdServiceImpl implements AdService {
  private static Logger logger = LoggerFactory.getLogger(AdServiceImpl.class);
  @Autowired private AdDao adDao;

  @Override
  public Lable addAd(AdDomain adDomain) {
    Lable lable = null;
    if (adDao.queryIdAdName(adDomain) != null && adDao.queryIdAdName(adDomain).size() > 0) {
      return new Lable("0", "已存在");
    }

    if (adDao.insert(adDomain) != 0) {
      lable = new Lable("1", "新增成功");
    } else {
      lable = new Lable("2", "新增失败");
    }
    AdDomain adDomain1 = adDao.queryIdAdName(adDomain).get(0);
    adDomain.setAdId(adDomain1.getAdId());
    if (adDomain.getInfoPictureDomains() != null && adDomain.getInfoPictureDomains().size() > 0) {
      for (InfoPictureDomain pictureDomain : adDomain.getInfoPictureDomains()) {
        adDao.addAdPicture(
            new InfoPictureDomain(adDomain1.getAdId(), pictureDomain.getInfoPicture()));
      }
    }
    adDao.update(adDomain);
    return lable;
  }

  @Override
  public Lable delAd(AdDomain adDomain) {

    Lable lable = null;
    if (adDao.del(adDomain) != 0) {
      lable = new Lable("1", "删除成功");
    } else {
      lable = new Lable("2", "删除失败");
    }
    if (adDomain.getInfoPictureDomains() != null && adDomain.getInfoPictureDomains().size() > 0) {
      for (InfoPictureDomain pictureDomain : adDomain.getInfoPictureDomains()) {
        adDao.delPic(pictureDomain);
      }
    }

    return lable;
  }

  @Override
  public PageInfo<AdDomain> queryAd(AdDomain adDomain, int pageNum, int pageSize) {
    List<AdDomain> adDomains = adDao.query(adDomain);
    for (AdDomain adDomain1 : adDomains) {
      adDomain1.setInfoPictureDomains(adDao.queryPic(adDomain1.getAdId()));
    }
    PageHelper.startPage(pageNum, pageSize);
    logger.info("日志成功!" + JSON.toJSONString(adDomains));
    System.out.println(adDomains);
    return new PageInfo(adDomains);
  }

  @Override
  public Lable updateApp(AdDomain adDomain) {

    Lable lable = null;
    if (adDao.update(adDomain) != 0) {
      lable = new Lable("1", "修改成功");
    } else {
      lable = new Lable("2", "修改失败");
    }
    if (adDomain.getInfoPictureDomains() != null && adDomain.getInfoPictureDomains().size() > 0) {
      adDao.delPic(adDomain.getInfoPictureDomains().get(0));
      for (InfoPictureDomain pictureDomain : adDomain.getInfoPictureDomains()) {
        adDao.addAdPicture(pictureDomain);
      }
    }
    return lable;
  }
}
