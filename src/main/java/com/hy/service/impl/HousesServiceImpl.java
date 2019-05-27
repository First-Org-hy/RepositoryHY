package com.hy.service.impl;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hy.common.Lable;
import com.hy.dao.AppDao;
import com.hy.dao.HouseDao;
import com.hy.dao.HousesDao;
import com.hy.model.*;
import com.hy.service.HousesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/** Created by yaohou on 18:13 2019/4/7. description: */
@Service(value = "housesService")
public class HousesServiceImpl implements HousesService {

  private static Logger logger = LoggerFactory.getLogger(HousesServiceImpl.class);

  @Autowired private HousesDao housesDao;

  @Autowired private AppDao appDao;

  @Autowired private HouseDao houseDao;

  // 驻点商务楼盘查询: userId(驻点商务id)
  // 普通用户楼盘查询
  @Override
  public PageInfo<HousesDomain> queryHouses(HousesDomain housesDomain, int pageNum, int pageSize) {
    logger.info("HousesServiceImpl - queryHouses 楼盘查询请求参数:" + JSON.toJSONString(housesDomain));
    PageHelper.startPage(pageNum, pageSize);
    List<HousesDomain> housesDomains = housesDao.selectHouses(housesDomain);
    logger.info("普通用户楼盘查询:" + JSON.toJSONString(housesDomains));
    return new PageInfo(housesDomains);
  }

  @Transactional
  @Override
  public Lable addHouses(HousesDomain houses) {
    logger.info("HousesServiceImpl - addHouses 楼盘新增请求参数:" + JSON.toJSONString(houses));
    Lable lable = null;
    if (!"".equals(housesDao.queryHouseId(houses)) && housesDao.queryHouseId(houses) != null) {
      lable = new Lable("2", "楼盘已存在");
      return lable;
    } else {
      housesDao.insert(houses);

      try {
        String housesId = housesDao.queryHouseId(houses);
        houses.setHousesId(housesId);
        houses.setHousesSpclty(housesId);
        houses.setMating(housesId);
        String picX = "X" + housesId; // 效果图Id
        String picS = "S" + housesId; // 实施图Id
        String picJ = "J" + housesId; // 交通图Id
        houses.setPictureX(picX);
        houses.setPictureS(picS);
        houses.setPictureJ(picJ);
        houses.setMating(housesId);
        houses.setHousesType(housesId);

        houses.setHousesSpclty(housesId);
        // 新增楼盘特点
        if (houses.getHousesSpcltyLable() != null && houses.getHousesSpcltyLable().size() > 0) {
          for (HousesSpcltyDomain spcl : houses.getHousesSpcltyLable()) {
            spcl.setHousesSpcltyId(housesId);
            housesDao.insertHouseSpcl(spcl);
          }
        }
        // 新增楼盘效果图
        if (houses.getPictureXLable().size() > 0) {
          for (HousesPictureDomain pic : houses.getPictureXLable()) {
            pic.setHousesPictureId(picX);
            housesDao.insertHousePic(pic);
          }
        }

        // 新增楼盘实施图
        if (houses.getPictureSLable() != null && houses.getPictureSLable().size() > 0) {
          for (HousesPictureDomain pic : houses.getPictureSLable()) {
            pic.setHousesPictureId(picS);
            housesDao.insertHousePic(pic);
          }
        }

        // 新增楼盘交通图
        if (houses.getPictureJLable() != null && houses.getPictureJLable().size() > 0) {
          for (HousesPictureDomain pic : houses.getPictureJLable()) {
            pic.setHousesPictureId(picJ);
            housesDao.insertHousePic(pic);
          }
        }
        // 新增楼盘配套设施
        if (houses.getMatingLable() != null && houses.getMatingLable().size() > 0) {
          for (HousesFacilitiesDomain mating : houses.getMatingLable()) {
            mating.setHousesFacilitiesId(housesId);
            housesDao.insertHouseMat(mating);
          }
        }

        // 新增楼盘户型
        if (houses.getHouseType() != null && houses.getHouseType().size() > 0) {
          for (HouseTypeDomain type : houses.getHouseType()) {
            String spcId = "HU" + housesId;
            type.setHousesId(housesId);
            type.setHouseTypeSpci(spcId);
            if (type.getHousesSpcltyLable() != null && type.getHousesSpcltyLable().size() != 0) {
              for (HousesSpcltyDomain spc : type.getHousesSpcltyLable()) {
                spc.setHousesSpcltyId(spcId);
                housesDao.insertHouseSpcl(spc);
              }
            }

            type.setHouseTypePic(spcId);
            if (type.getPictureXLable() != null && type.getPictureXLable().size() != 0) {
              for (HousesPictureDomain pic : houses.getPictureJLable()) {
                pic.setHousesPictureId(spcId);
                housesDao.insertHousePic(pic);
              }
            }
            housesDao.insertHouseType(type);
          }
        }
      } catch (Exception e) {
        logger.error("新增失败" + e.getMessage());
      }
    }

    int i = housesDao.updateHouses(houses);

    if (i != 0) {
      lable = new Lable("1", "新增成功");
    } else {
      lable = new Lable("0", "新增失败");
      housesDao.delHouses(houses);
    }
    logger.info("HousesServiceImpl - addHouses - 楼盘新增成功:" + JSON.toJSONString(houses));
    return lable;
  }

  // 普通用户 区域/价格/筛选 楼盘: areaId,总价,avgPrice(单价),户型,装修,面积,开盘时间,售卖状况,特色
  @Override
  public PageInfo<HousesDomain> queryAll(HousesDomain housesDomain, int pageNum, int pageSize) {
    logger.info("HousesServiceImpl - queryAll 楼盘查询请求参数:" + JSON.toJSONString(housesDomain));
    PageHelper.startPage(pageNum, pageSize);
    List<HousesDomain> houses = housesDao.queryAll(housesDomain);
    if (houses.size() != 0) {
      for (HousesDomain house : houses) {
        // 获取楼盘特点集合
        if (!"".equals(house.getHousesSpclty())) {
          List<HousesSpcltyDomain> spcs = housesDao.querySpc(house.getHousesSpclty());
          house.setHousesSpcltyLable(spcs);
        }
        // 获取楼盘效果图集合
        if (!"".equals(house.getPictureX())) {
          List<HousesPictureDomain> picx = housesDao.queryPic(house.getPictureX());
          house.setPictureXLable(picx);
        }
        // 获取楼盘实施图集合
        if (!"".equals(house.getPictureS())) {
          List<HousesPictureDomain> pics = housesDao.queryPic(house.getPictureS());
          house.setPictureSLable(pics);
        }
        // 获取楼盘交通图集合
        if (!"".equals(house.getPictureJ())) {
          List<HousesPictureDomain> picj = housesDao.queryPic(house.getPictureJ());
          house.setPictureJLable(picj);
        }
        // 获取楼盘配套设施
        if (!"".equals(house.getMating())) {
          List<HousesFacilitiesDomain> mat = housesDao.queryMat(house.getMating());
          house.setMatingLable(mat);
        }
        // 获取楼盘户型
        List<HouseTypeDomain> types = housesDao.queryType(new HouseTypeDomain(house.getHousesId()));
        if (types.size() != 0) {
          for (HouseTypeDomain type : types) {
            if (!"".equals(type.getHouseTypePic())) {
              List<HousesPictureDomain> pic = housesDao.queryPic(type.getHouseTypePic());
              type.setPictureXLable(pic);
            }
            if (!"".equals(type.getHouseTypeSpci())) {
              List<HousesSpcltyDomain> spcs = housesDao.querySpc(type.getHouseTypeSpci());
              type.setHousesSpcltyLable(spcs);
            }
          }
        }
        house.setHouseType(types);
        // 获取经纪人集合
        AppDomain app = new AppDomain();
        app.setHousesId(house.getHousesId());
        List<AppDomain> apps = appDao.queryById(app);
        house.setApps(apps);
        // 获取楼盘动态集合
        List<HouseDynamicDomain> dys = houseDao.queryDyByHouseId(house.getHousesId());
        house.setHouseDynamics(dys);
      }
    }
    logger.info("普通用户楼盘查询:" + JSON.toJSONString(houses));
    return new PageInfo(houses);
  }

  // 楼盘所有特点查询，所有特点去重
  @Override
  public PageInfo<HousesSpcltyDomain> querySpclty(int pageNum, int pageSize) {
    logger.info("HousesServiceImpl - querySplty 楼盘特点查询 无请求参数:");
    PageHelper.startPage(pageNum, pageSize);
    List<HousesSpcltyDomain> housesSpcltyDomains = housesDao.querySpclty();
    logger.info("楼盘所有特点查询，:" + JSON.toJSONString(housesSpcltyDomains));
    return new PageInfo(housesSpcltyDomains);
  }

  // 删除楼盘信息
  @Transactional
  @Override
  public Lable delHouses(HousesDomain houses) {
    logger.info("HousesServiceImpl - delHouses 楼盘删除请求参数:" + JSON.toJSONString(houses));
    Lable lable = new Lable();
    if (houses.getHousesId() != null) {
      int a = housesDao.delHouses(houses);
      // 删除楼盘特点
      if (houses.getHousesSpclty() != null) {
        housesDao.delSpc(houses.getHousesSpclty());
      }
      // 删除楼盘效果图
      if (houses.getPictureX() != null) {
        housesDao.delPic(houses.getPictureX());
      }
      // 删除楼盘实施图
      if (houses.getPictureS() != null) {
        housesDao.delPic(houses.getPictureS());
      }
      // 删除楼盘交通图
      if (houses.getPictureJ() != null) {
        housesDao.delPic(houses.getPictureJ());
      }
      // 删除楼盘配套设施
      if (houses.getMating() != null) {
        housesDao.delMat(houses.getMating());
      }
      // 删除楼盘户型
      if (houses.getHouseType() != null && houses.getHouseType().size() > 0) {
        for (HouseTypeDomain type : houses.getHouseType()) {
          housesDao.delType(type.getHouseTypeId());
          if (type.getPictureXLable() != null && type.getPictureXLable().size() > 0) {
            housesDao.delPic(type.getHouseTypePic());
          }
          if (type.getHousesSpcltyLable() != null && type.getHousesSpcltyLable().size() > 0) {
            housesDao.delSpc(type.getHouseTypeSpci());
          }
        }
      }
      if (a > 0) {
        lable.setId("1");
        lable.setMessage("删除成功");

      } else {
        lable.setId("0");
        lable.setMessage("删除失败,无该数据");
      }
    } else {
      lable.setId("0");
      lable.setMessage("houseId为空，删除失败");
    }
    return lable;
  }

  // 更新楼盘信息
  @Transactional
  @Override
  public Lable updateHouses(HousesDomain housesDomain) {
    logger.info("HousesServiceImpl - updateHouses 楼盘修改请求参数:" + JSON.toJSONString(housesDomain));
    Lable lable = null;
    if (housesDomain.getHousesId() != null) {
      int a = 0;
      // 修改楼盘特点
      try {
        a = housesDao.updateHouses(housesDomain);
        if (housesDomain.getHousesSpcltyLable() != null
            && housesDomain.getHousesSpcltyLable().size() > 0) {
          for (HousesSpcltyDomain spcl : housesDomain.getHousesSpcltyLable()) {
            housesDao.updateHouseSpcl(spcl);
          }
        }
        // 新增楼盘效果图
        if (housesDomain.getPictureXLable() != null && housesDomain.getPictureXLable().size() > 0) {
          for (HousesPictureDomain pic : housesDomain.getPictureXLable()) {
            housesDao.updateHousePic(pic);
          }
        }
        // 修改楼盘实施图
        if (housesDomain.getPictureSLable() != null && housesDomain.getPictureSLable().size() > 0) {
          for (HousesPictureDomain pic : housesDomain.getPictureSLable()) {
            housesDao.updateHousePic(pic);
          }
        }

        // 修改楼盘交通图
        if (housesDomain.getPictureJLable() != null && housesDomain.getPictureJLable().size() > 0) {
          for (HousesPictureDomain pic : housesDomain.getPictureJLable()) {
            housesDao.updateHousePic(pic);
          }
        }

        // 修改楼盘配套设施
        if (housesDomain.getMatingLable() != null && housesDomain.getMatingLable().size() > 0) {
          for (HousesFacilitiesDomain mating : housesDomain.getMatingLable()) {
            housesDao.updateHouseMat(mating);
          }
        }

        // 新增楼盘户型
        if (housesDomain.getHouseType() != null && housesDomain.getHouseType().size() > 0) {
          for (HouseTypeDomain type : housesDomain.getHouseType()) {
            housesDao.updateHouseType(type);

            // 修改户型特点
            if (type.getHousesSpcltyLable() != null && type.getHousesSpcltyLable().size() != 0) {
              for (HousesSpcltyDomain spc : type.getHousesSpcltyLable()) {
                housesDao.updateHouseSpcl(spc);
              }
            }

            if (type.getPictureXLable() != null && type.getPictureXLable().size() != 0) {
              for (HousesPictureDomain pic : housesDomain.getPictureJLable()) {
                housesDao.updateHousePic(pic);
              }
            }
          }
        }
      } catch (Exception e) {
        lable = new Lable("0", "修改失败");
        logger.error("楼盘修改失败:" + e);
      }
      if (a > 0) {
        lable = new Lable("1", "修改成功");
        lable.setId("1");
        lable.setMessage("修改成功");
      } else {
        lable = new Lable("0", "修改失败");
      }
    } else {
      lable = new Lable("2", "housesId 为空,无修改");
    }

    return lable;
  }
}
