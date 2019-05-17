package com.hy.service.impl;

import com.hy.common.Lable;
import com.hy.dao.HouseDao;
import com.hy.model.*;
import com.hy.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/** Created by shakaiyue on 17:59 2019/4/12. description:新房，二手房，租房 Service */
@Service(value = "houseService")
public class HouseServiceImpl implements HouseService {

  @Autowired private HouseDao houseDao;

  //    @Override
  //    public List<HousesDomain> queryHouses(HousesDomain housesDomain) {
  //        return housesDao.selectHouses(housesDomain);
  //    }

  /**
   * 发布租房信息
   *
   * @param rentHouseDomain
   * @return
   */
  @Override
  public Lable addRentHouse(RentHouseDomain rentHouseDomain) {
    Lable lable = new Lable();
    if (houseDao.queryRentHouse(rentHouseDomain).size() != 0) {
      lable.setId("12");
      lable.setMessage("租房信息发布已存在");
    } else {
      if (houseDao.addRentHouse(rentHouseDomain) == 1) {
        lable.setId("1");
        lable.setMessage("租房信息发布成功");
      } else {
        lable.setId("0");
        lable.setMessage("租房信息发布失败");
      }
    }

    return lable;
  }

  /**
   * 租房详情查询
   *
   * @param house
   * @return
   */
  @Override
  public List<RentHouseDomain> queryRentHouse(RentHouseDomain house) {
    return houseDao.queryRentHouse(house);
  }

  /**
   * 查询用户发布的所有租房
   *
   * @param rentHouseDomain
   * @return
   */
  @Override
  public List<RentHouseDomain> queryRentsByUserId(RentHouseDomain rentHouseDomain) {
    return houseDao.queryRentsByUserId(rentHouseDomain);
  }

  /**
   * 发布二手房信息
   *
   * @param house
   * @return
   */
  @Override
  public Lable addSecondHouse(SecondHouseDomain house) {
    Lable lable = new Lable();
    int i = houseDao.addSecondHouse(house);
    if (i == 1) {
      lable.setId("1");
      lable.setMessage("二手房信息发布成功");
    } else {
      lable.setId("0");
      lable.setMessage("二手房信息发布失败");
    }
    return lable;
  }

  /**
   * 二手房详情查询
   *
   * @param house
   * @return
   */
  @Override
  public List<SecondHouseDomain> querySecondHouse(SecondHouseDomain house) {
    return houseDao.querySecondHouse(house);
  }

  /**
   * 查询用户发布的所有二手房
   *
   * @param secondHouseDomain
   * @return
   */
  @Override
  public List<SecondHouseDomain> querySecondsByUserId(SecondHouseDomain secondHouseDomain) {
    return houseDao.querySecondsByUserId(secondHouseDomain);
  }

  /**
   * 新增预约看房记录
   *
   * @param order
   * @return
   */
  @Override
  public Lable addOrderRecord(OrderRecordDomain order) {
    Lable lable = new Lable();
    int i = houseDao.addOrderRecord(order);
    if (i == 1) {
      lable.setId("1");
      lable.setMessage("预约看房成功");
    }
    return lable;
  }

  /**
   * 根据楼盘Id查看楼盘动态
   *
   * @param houseId
   * @return
   */
  @Override
  public List<HouseDynamicDomain> queryDyByHouseId(String houseId) {
    return houseDao.queryDyByHouseId(houseId);
  }

  /**
   * 新增楼盘动态
   *
   * @param Dynamic
   * @return
   */
  @Override
  public Lable addHouseDynamic(HouseDynamicDomain Dynamic) {
    Lable lable = new Lable();
    int i = houseDao.addHouseDynamic(Dynamic);
    if (i == 1) {
      lable.setId("1");
      lable.setMessage("楼盘动态新增成功");
    }
    return lable;
  }

  /**
   * 新增楼盘资讯信息
   *
   * @param houseInfo
   * @return
   */
  @Override
  public Lable addHousesInfo(HousesInfoDomain houseInfo) {
    Lable lable = new Lable();
    int i = houseDao.addHousesInfo(houseInfo);
    if (i == 1) {
      lable.setId("1");
      lable.setMessage("楼盘资讯新增成功");
    }
    return lable;
  }

  // 房产资讯查询
  @Override
  public List<HousesInfoDomain> queryHousesInfo() {
    return houseDao.queryHousesInfo();
  }

  // 查询所有户型
  @Override
  public List<HousesDomain> queryhouseType(HouseTypeDomain houseTypeDomain) {
    return houseDao.queryhouseType(houseTypeDomain);
  }

  @Override
  public List<HouseTypeDomain> houseType(HouseTypeDomain houseTypeDomain) {
    return houseDao.houseType(houseTypeDomain);
  }


  //新房管理-查询
  @Override
  public List<HouseDomain> queryNew(HouseDomain houseDomain) {
    List<HouseDomain> houses = houseDao.queryNew(houseDomain);
    for(HouseDomain house : houses){

      //查询同一楼盘下的所有新房-条件：楼盘ID
      HouseDomain h = new HouseDomain();
      h.setHousesId(house.getHousesId());
      List<HouseDomain> hs = houseDao.queryNewByHousesId(h);
      if(hs.size() > 0){
        house.setHouses(hs);
      }
      //查询登记数量 0:登记数量
      h.setHouseSellSt("0");
      house.setHouseNumTol(houseDao.countHouse(h));
      //查询在售数量 1:在售数量
      h.setHouseSellSt("1");
      house.setHouseSellNum(houseDao.countHouse(h));
      //查询在售数量 2:已售数量
      h.setHouseSellSt("2");
      house.setHouseRemainNum(houseDao.countHouse(h));
    }
    return houses;
  }

  //新房管理-新增
  @Override
  public Lable addNewHouse(HouseDomain houseDomain) {
    Lable lable = new Lable();
    HouseDomain h = new HouseDomain();
    h.setHouseArea(houseDomain.getHouseArea());
    h.setHousesId(houseDomain.getHousesId());
    h.setHouseTypeId(houseDomain.getHouseTypeId());
    List<HouseDomain> houses = houseDomain.getHouses();
    int i = 0;
    if(houses.size() > 0){
      for(HouseDomain house : houses){
        h.setHouseName(house.getHouseName());
        h.setHouseSellSt("1");
        houseDao.addNewHouse(h);
        i++;
      }
    }else{
      houseDao.addNewHouse(h);
      i++;
    }
    if (i > 0) {
      lable.setId("1");
      lable.setMessage("新房添加成功");
    }else{
      lable.setId("0");
      lable.setMessage("新房添加失败");
    }
    return lable;
  }

  //新房管理-修改
  @Override
  public Lable upNewHouse(HouseDomain houseDomain) {
    Lable lable = new Lable();
    if(houseDomain.getId() == null){
      lable.setId("0");
      lable.setMessage("ID为空，新房修改失败");
    }else {
      HouseDomain h = new HouseDomain();
      h.setHouseArea(houseDomain.getHouseArea());
      h.setHousesId(houseDomain.getHousesId());
      h.setHouseTypeId(houseDomain.getHouseTypeId());
      List<HouseDomain> houses = houseDomain.getHouses();
      int i = 0;
      if (houses.size() > 0) {
        for (HouseDomain house : houses) {
          h.setId(house.getId());
          h.setHouseName(house.getHouseName());
          h.setHouseSellSt(house.getHouseSellSt());
          houseDao.upNewHouse(h);
          i++;
        }
      } else {
        houseDao.upNewHouse(h);
        i++;
      }
      if (i > 0) {
        lable.setId("1");
        lable.setMessage("新房修改成功");
      } else {
        lable.setId("0");
        lable.setMessage("新房修改失败");
      }
    }
    return lable;
  }

  //新房管理-删除整个楼盘下的新房
  @Override
  public Lable deNewHouse(HouseDomain houseDomain) {
    Lable lable = new Lable();
    if(houseDomain.getHousesId() != null){
      int i = houseDao.deNewHouse(houseDomain);
      if (i > 0) {
        lable.setId("1");
        lable.setMessage("新房删除成功");
      }else{
        lable.setId("2");
        lable.setMessage("新房删除失败");
      }
    }
    return lable;
  }

  //新房管理-删除某个新房
  @Override
  public Lable deNewHouseById(HouseDomain houseDomain) {
    Lable lable = new Lable();
    if(houseDomain.getId() != null){
      int i = houseDao.deNewHouseById(houseDomain);
      if (i > 0) {
        lable.setId("1");
        lable.setMessage("新房删除成功");
      }else{
        lable.setId("2");
        lable.setMessage("新房删除失败");
      }
    }
    return lable;
  }
}
