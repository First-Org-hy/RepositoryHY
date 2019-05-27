package com.hy.service.impl;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hy.common.Lable;
import com.hy.dao.RecommendDao;
import com.hy.model.AppDomain;
import com.hy.model.HouseDynamicDomain;
import com.hy.model.RecommendDomain;
import com.hy.service.RecommendService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/** Created by yaohou on 16:14 2019/4/3. description: */
@Service(value = "recommendService")
public class RecommendServiceImpl implements RecommendService {
  private static Logger logger = LoggerFactory.getLogger(RecommendServiceImpl.class);
  @Autowired private RecommendDao recommendDao;

  @Override
  public Lable addRecommend(RecommendDomain recommend) {
    Lable lable = null;
    if (recommendDao.selectGuest(recommend).size() != 0) {
      lable = new Lable("2", "已存在");
    } else {
      if (recommendDao.insert(recommend) == 1) {
        lable = new Lable("1", "新增成功");
      } else {
        lable = new Lable("0", "新增失败");
      }
    }
    return lable;
  }

  /**
   * 根据经纪人ID查询推荐列表数据
   *
   * @param app
   * @return
   */
  @Override
  public PageInfo<RecommendDomain> queryRecoInfoByUserId(AppDomain app,int pageNum, int pageSize) {

    List<RecommendDomain> recommendDomains = recommendDao.queryRecoInfoByUserId(app);
    PageHelper.startPage(pageNum, pageSize);
    logger.info("根据经纪人ID查询推荐列表数据:" + JSON.toJSONString(recommendDomains));
    return new PageInfo(recommendDomains);
  }

  /**
   * 根据经纪公司ID查询推荐列表数据
   *
   * @param app
   * @return
   */
  @Override
  public PageInfo<RecommendDomain> queryRecoInfoByUserParId(AppDomain app,int pageNum, int pageSize) {
    List<RecommendDomain> recommendDomains = recommendDao.queryRecoInfoByUserParId(app);
    PageHelper.startPage(pageNum, pageSize);
    logger.info("根据经纪公司ID查询推荐列表数据:" + JSON.toJSONString(recommendDomains));
    return new PageInfo(recommendDomains);
  }

  /**
   * 根据经纪人ID，客户姓名，客户电话 查询推荐列表数据
   *
   * @param reMend
   * @return
   */
  @Override
  public PageInfo<RecommendDomain> queryRecoInfoByGuestName(RecommendDomain reMend ,int pageNum, int pageSize)  {
    List<RecommendDomain> recommendDomains = recommendDao.queryRecoInfoByGuestName(reMend);
    PageHelper.startPage(pageNum, pageSize);
    logger.info("根据经纪人ID，客户姓名，客户电话 查询推荐列表数据:" + JSON.toJSONString(recommendDomains));
    return new PageInfo(recommendDomains);
  }

  /**
   * 判断该用户是否是某经纪公司的经纪人
   *
   * @param userId userParId
   * @return
   */
  @Override
  public Lable isRecommendOfCom(String userId, String userParId) {
    Lable la = new Lable();
    if (recommendDao.isRecommendOfCom(userId, userParId) == 1) {
      la.setId("1");
      la.setMessage("该用户是经纪人");
    } else {
      la.setId("0");
      la.setMessage("该用户不是经纪人");
    }
    return la;
  }

  // 查询经纪公司的名称，联系电话
  @Override
  public PageInfo<AppDomain> queryCompanyInfo(String userId ,int pageNum, int pageSize) {
    List<AppDomain> appDomains = recommendDao.queryCompanyInfo(userId);
    PageHelper.startPage(pageNum, pageSize);
    logger.info("查询经纪公司的名称:" + JSON.toJSONString(appDomains));
    return new PageInfo(appDomains);
  }

  // 根据楼盘id housesId,获取楼盘推荐信息
  @Override
  public PageInfo<RecommendDomain> query(RecommendDomain recommendDomain, int pageNum, int pageSize) {
    List<RecommendDomain> query = recommendDao.query(recommendDomain);
    PageHelper.startPage(pageNum, pageSize);
    logger.info("查询经纪公司的名称:" + JSON.toJSONString(query));
    return new PageInfo(query);
  }
}
