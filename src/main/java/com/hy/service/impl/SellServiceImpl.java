package com.hy.service.impl;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hy.common.Lable;
import com.hy.dao.HousesDao;
import com.hy.dao.SellDao;
import com.hy.model.HousesDomain;
import com.hy.model.HousesUserDomain;
import com.hy.model.RecommendDomain;
import com.hy.model.SellDomain;
import com.hy.service.SellService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/** Created by shakaiyue on 14:28 2019/4/7. description: */
@Service(value = "sellService")
public class SellServiceImpl implements SellService {
  private static Logger logger = LoggerFactory.getLogger(SellServiceImpl.class);
  @Autowired private SellDao selldao;

  @Autowired private HousesDao housesDao;

  /**
   * 增加销售记录
   *
   * @param sellDomain
   * @return
   */
  @Override
  public Lable addSell(SellDomain sellDomain) {
    Lable lable = null;
    if (selldao.addSell(sellDomain) == 1) {
      lable = new Lable("1", "新增成功");
    } else {
      lable = new Lable("0", "新增失败");
    }
    return lable;
  }

  /**
   * 修改销售记录
   *
   * @param sellDomain
   * @return
   */
  @Override
  public Lable update(SellDomain sellDomain) {
    Lable lable = null;
    if (selldao.update(sellDomain) == 1) {
      lable = new Lable("1", "修改成功");
    } else {
      lable = new Lable("0", "修改失败");
    }
    return lable;
  }

  /**
   * 删除销售记录
   *
   * @param sell
   * @return
   */
  @Override
  public int deteleSell(SellDomain sell) {
    return 0;
  }

  // 通过经纪人id查询某个经纪人的销售记录
  // 根据楼盘id:housesId 查询销售信息
  @Override
  public PageInfo<SellDomain> query(SellDomain sell,int pageNum, int pageSize) {

    List<SellDomain> query = selldao.query(sell);
    PageHelper.startPage(pageNum, pageSize);
    logger.info("通过经纪人id查询某个经纪人的销售记录:" + JSON.toJSONString(query));
    return new PageInfo(query);
  }

  /**
   * 通过经纪公司id查询经纪公司的销售记录
   *
   * @param sell
   * @return
   */
  @Override
  public PageInfo<SellDomain> querySellInfoByUserParId(SellDomain sell,int pageNum, int pageSize) {
    List<SellDomain> query = selldao.querySellInfoByUserParId(sell);
    PageHelper.startPage(pageNum, pageSize);
    logger.info("通过经纪公司id查询经纪公司的销售记录:" + JSON.toJSONString(query));
    return new PageInfo(query);
  }

  /**
   * 查询用户是否为驻点商务
   *
   * @param userId
   * @return
   */
  @Override
  public Lable isBusSeller(String userId) {
    Lable la = new Lable();
    if (selldao.isBusSeller(userId) == 1) {
      la.setId("1");
      la.setMessage("该用户是驻点商务");
    } else {
      la.setId("0");
      la.setMessage("该用户不是驻点商务");
    }
    return la;
  }

  /**
   * 查询某个驻点商务的全部销售记录
   *
   * @param userId
   * @return
   */
  @Override
  public PageInfo<SellDomain> queryBySeller(String userId,int pageNum, int pageSize) {
    List<SellDomain> sells = selldao.queryBySeller(userId);
    for (SellDomain sell : sells) {
      String houseId = sell.getHousesId();
      HousesDomain house = new HousesDomain();
      house.setHousesId(houseId);
      List<HousesDomain> houses = housesDao.selectHouses(house);
      sell.setHouses(houses);
    }
    PageHelper.startPage(pageNum, pageSize);
    logger.info("查询某个驻点商务的全部销售记录:" + JSON.toJSONString(sells));
    return new PageInfo(sells);
  }

  @Override
  public PageInfo<HousesUserDomain> queryBySellId(String userId,int pageNum, int pageSize) {
    List<HousesUserDomain> houseUsers = selldao.queryBySellId(userId);
    for (HousesUserDomain house : houseUsers) {
      String houseId = house.getHousesId();
      HousesDomain houses = new HousesDomain();
      houses.setHousesId(houseId);
      houses.setAreaId("ss");
      List<HousesDomain> housesInfo = housesDao.selectHouses(houses);
      house.setHouses(housesInfo);
    }
    PageHelper.startPage(pageNum, pageSize);
    logger.info("查询销售记录:" + JSON.toJSONString(houseUsers));
    return new PageInfo(houseUsers);
  }
}
