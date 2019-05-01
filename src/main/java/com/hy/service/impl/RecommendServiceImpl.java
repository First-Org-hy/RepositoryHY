package com.hy.service.impl;

import com.hy.common.Lable;
import com.hy.dao.RecommendDao;
import com.hy.model.AppDomain;
import com.hy.model.RecommendDomain;
import com.hy.service.RecommendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/** Created by yaohou on 16:14 2019/4/3. description: */
@Service(value = "recommendService")
public class RecommendServiceImpl implements RecommendService {
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
  public List<RecommendDomain> queryRecoInfoByUserId(AppDomain app) {
    return recommendDao.queryRecoInfoByUserId(app);
  }

  /**
   * 根据经纪公司ID查询推荐列表数据
   *
   * @param app
   * @return
   */
  @Override
  public List<RecommendDomain> queryRecoInfoByUserParId(AppDomain app) {
    return recommendDao.queryRecoInfoByUserParId(app);
  }

  /**
   * 根据经纪人ID，客户姓名，客户电话 查询推荐列表数据
   *
   * @param reMend
   * @return
   */
  @Override
  public List<RecommendDomain> queryRecoInfoByGuestName(RecommendDomain reMend) {
    return recommendDao.queryRecoInfoByGuestName(reMend);
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

  /**
   * 查询经纪公司的名称，联系电话
   *
   * @param userId
   * @return
   */
  @Override
  public List<AppDomain> queryCompanyInfo(String userId) {
    return recommendDao.queryCompanyInfo(userId);
  }

  @Override
  public List<RecommendDomain> queryAllRecommend(AppDomain app) {
    return recommendDao.queryAllRecommend();
  }
}
