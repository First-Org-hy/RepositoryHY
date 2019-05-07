package com.hy.dao;

import com.hy.model.*;
import java.util.List;

/** Created by yaohou on 17:59 2019/4/7. description: */
public interface HousesDao {
  // 查询楼盘信息
  List<HousesDomain> selectHouses(HousesDomain housesDomain);

  // 新增楼盘
  int insert(HousesDomain housesDomain);

  // 普通用户 区域/价格/筛选 楼盘: areaId,总价,avgPrice(单价),户型,装修,面积,开盘时间,售卖状况,特色
  List<HousesDomain> queryAll(HousesDomain housesDomain);

  // 根据楼盘名称，楼盘开发商查询楼盘ID作为后续特点表，图片表的Id使用
  String queryHouseId(HousesDomain housesDomain);

  // 新增楼盘特点
  int insertHouseSpcl(HousesSpcltyDomain housesSpcltyDomain);

  // 新增楼盘效果图
  int insertHousePic(HousesPictureDomain housesPictureDomain);

  // 新增楼盘配套设施
  int insertHouseMat(HousesFacilitiesDomain housesFacilitiesDomain);

  // 新增楼盘户型
  int insertHouseType(HouseTypeDomain houseTypeDomain);

  // 查询楼盘特点
  List<HousesSpcltyDomain> querySpc(String spc);

  // 查询楼盘图片
  List<HousesPictureDomain> queryPic(String pic);

  // 查询楼盘配套设施
  List<HousesFacilitiesDomain> queryMat(String mat);

  // 查询楼盘户型
  List<HouseTypeDomain> queryType(HouseTypeDomain houseTypeDomain);

  // 楼盘特点查询，所有特点去重
  List<HousesSpcltyDomain> querySpclty();

  //删除楼盘信息
  int delHouses(HousesDomain housesDomain);

  //删除楼盘特点
  int delSpc(String  housesSpclty);

  //删除楼盘图片
  int delPic(String housesPicture);

  //删除楼盘配套设施
  int delMat(String housesFacilities);

  //删除楼盘户型
  int delType(String houseType);

  //更新楼盘信息
  int updateHouses(HousesDomain housesDomain);

  //更新楼盘特点信息
  int updateHouseSpcl(HousesSpcltyDomain housesSpcltyDomain);

  //更新楼盘图片信息
  int updateHousePic(HousesPictureDomain housesPictureDomain);

  //更新楼盘配套设施信息
  int updateHouseMat(HousesFacilitiesDomain housesFacilitiesDomain);

  //更新楼盘户型信息
  int updateHouseType(HouseTypeDomain houseTypeDomain);
}
