package com.hy.service.impl;

import com.hy.common.Lable;
import com.hy.dao.AppDao;
import com.hy.dao.HouseDao;
import com.hy.dao.HousesDao;
import com.hy.model.*;
import com.hy.service.HousesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/** Created by yaohou on 18:13 2019/4/7. description: */
@Service(value = "housesService")
public class HousesServiceImpl implements HousesService {

  @Autowired private HousesDao housesDao;

  @Autowired private AppDao appDao;

  @Autowired private HouseDao houseDao;

  // 驻点商务楼盘查询: userId(驻点商务id)
  // 普通用户楼盘查询
  @Override
  public List<HousesDomain> queryHouses(HousesDomain housesDomain) {
    return housesDao.selectHouses(housesDomain);
  }

  @Override
  public Lable addHouses(HousesDomain houses) {
    Lable lable = new Lable();
    if (!"".equals(housesDao.queryHouseId(houses)) && housesDao.queryHouseId(houses) != null) {
      lable.setId("2");
      lable.setMessage("已存在");
      return lable;
    }
    int i = housesDao.insert(houses);
    if (i == 1) {
      lable.setId("1");
      lable.setMessage("新增成功");
    } else {
      lable.setId("0");
      lable.setMessage("新增失败");
    }
    String housesId = housesDao.queryHouseId(houses);
    houses.setHousesSpclty(housesId);
    houses.setMating(housesId);
    String picX = "X" + housesId; // 效果图Id
    String picS = "S" + housesId; // 实施图Id
    String picJ = "J" + housesId; // 交通图Id
    houses.setPictureX(picX);
    houses.setPictureS(picS);
    houses.setPictureJ(picJ);

    // 新增楼盘特点
    if (houses.getHousesSpcltyLable().size() > 0) {
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
    if (houses.getPictureSLable().size() > 0) {
      for (HousesPictureDomain pic : houses.getPictureSLable()) {
        pic.setHousesPictureId(picS);
        housesDao.insertHousePic(pic);
      }
    }

    // 新增楼盘交通图
    if (houses.getPictureJLable().size() > 0) {
      for (HousesPictureDomain pic : houses.getPictureJLable()) {
        pic.setHousesPictureId(picJ);
        housesDao.insertHousePic(pic);
      }
    }

    // 新增楼盘配套设施
    if (houses.getMatingLable().size() > 0) {
      for (HousesFacilitiesDomain mating : houses.getMatingLable()) {
        housesDao.insertHouseMat(mating);
      }
    }

    // 新增楼盘户型
    if (houses.getHouseType().size() >  0) {
      for (HouseTypeDomain type : houses.getHouseType()) {
        housesDao.insertHouseType(type);
        String spcId = "HU" + housesId;
        type.setHouseTypeSpci(spcId);
        if (type.getHousesSpcltyLable().size() != 0) {
          for (HousesSpcltyDomain spc : type.getHousesSpcltyLable()) {
            spc.setHousesSpcltyId(spcId);
            housesDao.insertHouseSpcl(spc);
          }
        }

        type.setHouseTypePic(spcId);
        if (type.getPictureXLable().size() != 0) {
          for (HousesPictureDomain pic : houses.getPictureJLable()) {
            pic.setHousesPictureId(spcId);
            housesDao.insertHousePic(pic);
          }
        }
      }
    }
    return lable;
  }

  // 普通用户 区域/价格/筛选 楼盘: areaId,总价,avgPrice(单价),户型,装修,面积,开盘时间,售卖状况,特色
  @Override
  public List<HousesDomain> queryAll(HousesDomain housesDomain) {
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
        List<AppDomain> apps = appDao.query(app);
        house.setApps(apps);
        // 获取楼盘动态集合
        List<HouseDynamicDomain> dys = houseDao.queryDyByHouseId(house.getHousesId());
        house.setHouseDynamics(dys);
      }
    }
    return housesDao.queryAll(housesDomain);
  }

  // 楼盘所有特点查询，所有特点去重
  @Override
  public List<HousesSpcltyDomain> querySpclty() {
    return housesDao.querySpclty();
  }

  //删除楼盘信息
  @Override
  public Lable delHouses(HousesDomain houses) {
      Lable lable = new Lable();
      if(houses.getHousesId() != null){
          int a = housesDao.delHouses(houses);
          //删除楼盘特点
          if(houses.getHousesSpclty() != null  ){
              housesDao.delSpc(houses.getHousesSpclty());
          }
          //删除楼盘效果图
          if(houses.getPictureX() != null  ){
              housesDao.delPic(houses.getPictureX());
          }
          //删除楼盘实施图
          if(houses.getPictureS() != null  ){
              housesDao.delPic(houses.getPictureS());
          }
          //删除楼盘交通图
          if(houses.getPictureJ() != null  ){
              housesDao.delPic(houses.getPictureJ());
          }
          //删除楼盘配套设施
          if(houses.getMating() != null  ){
              housesDao.delMat(houses.getMating());
          }
          //删除楼盘户型
          if(houses.getHouseType().size() > 0){
              for(HouseTypeDomain type : houses.getHouseType()){
                  housesDao.delType(type.getHouseTypeId());
                  if(type.getPictureXLable().size() > 0 ){
                      housesDao.delPic(type.getHouseTypePic());
                  }
                  if(type.getHousesSpcltyLable().size() > 0 ){
                      housesDao.delSpc(type.getHouseTypeSpci());
                  }
              }

          }
          if(a > 0){
              lable.setId("1");
              lable.setMessage("删除成功");

          }else{
              lable.setId("0");
              lable.setMessage("删除失败");
          }
      }else{
          lable.setId("0");
          lable.setMessage("houseId为空，删除失败");
      }
      return lable;
  }

  //更新楼盘信息
  @Override
  public Lable updateHouses(HousesDomain housesDomain) {
      Lable lable = new Lable();
      if(housesDomain.getHousesId() != null){
          int a = housesDao.updateHouses(housesDomain);

          if(a > 0 ){
              lable.setId("1");
              lable.setMessage("修改成功");
          }else{
              lable.setId("0");
              lable.setMessage("修改失败");
          }
          String housesId = housesDomain.getHousesId();
          String picX = "X" + housesId; // 效果图Id
          String picS = "S" + housesId; // 实施图Id
          String picJ = "J" + housesId; // 交通图Id
          housesDomain.setHousesSpclty(housesId);
          housesDomain.setMating(housesId);
          housesDomain.setPictureX(picX);
          housesDomain.setPictureS(picS);
          housesDomain.setPictureJ(picJ);


          // 修改楼盘特点
          if (housesDomain.getHousesSpcltyLable().size() > 0) {
              for (HousesSpcltyDomain spcl : housesDomain.getHousesSpcltyLable()) {
                  spcl.setHousesSpcltyId(housesId);
                  housesDao.updateHouseSpcl(spcl);
              }
          }
          // 新增楼盘效果图
          if (housesDomain.getPictureXLable().size() > 0) {
              for (HousesPictureDomain pic : housesDomain.getPictureXLable()) {
                  pic.setHousesPictureId(picX);
                  housesDao.updateHousePic(pic);
              }
          }
          // 修改楼盘实施图
          if (housesDomain.getPictureSLable().size() > 0) {
              for (HousesPictureDomain pic : housesDomain.getPictureSLable()) {
                  pic.setHousesPictureId(picS);
                  housesDao.updateHousePic(pic);
              }
          }

          // 修改楼盘交通图
          if (housesDomain.getPictureJLable().size() > 0) {
              for (HousesPictureDomain pic : housesDomain.getPictureJLable()) {
                  pic.setHousesPictureId(picJ);
                  housesDao.updateHousePic(pic);
              }
          }

          // 修改楼盘配套设施
          if (housesDomain.getMatingLable().size() > 0) {
              for (HousesFacilitiesDomain mating : housesDomain.getMatingLable()) {
                  housesDao.updateHouseMat(mating);
              }
          }

          // 新增楼盘户型
          if (housesDomain.getHouseType().size() >  0) {
              for (HouseTypeDomain type : housesDomain.getHouseType()) {
                  housesDao.updateHouseType(type);
                  String spcId = "HU" + housesId;
                  type.setHouseTypeSpci(spcId);

                  //修改户型特点
                  if (type.getHousesSpcltyLable().size() != 0) {
                      for (HousesSpcltyDomain spc : type.getHousesSpcltyLable()) {
                          spc.setHousesSpcltyId(spcId);
                          housesDao.updateHouseSpcl(spc);
                      }
                  }

                  type.setHouseTypePic(spcId);
                  if (type.getPictureXLable().size() != 0) {
                      for (HousesPictureDomain pic : housesDomain.getPictureJLable()) {
                          pic.setHousesPictureId(spcId);
                          housesDao.updateHousePic(pic);
                      }
                  }
              }
          }

      }


      return lable;
  }
}
