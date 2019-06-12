package com.hy.controller;

import com.github.pagehelper.PageInfo;
import com.hy.common.Lable;
import com.hy.model.*;
import com.hy.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/** Created by shakaiyue on 21:59 2019/4/12. description:新房，二手房，租房 Controller */
@RestController
@RequestMapping(value = "/house")
public class HouseController {

  @Autowired private HouseService houseService;

  /** 租房------------------------------------------------------- * */
  // 新增租房
  @ResponseBody
  @PostMapping("/addRentHouse")
  public Lable addRentHouse(RentHouseDomain house) {
    return houseService.addRentHouse(house);
  }

  // 普通用户租房查询,后台租房查询(名称/地理位置:houseName/houseAddress)
  @ResponseBody
  @GetMapping("/queryRent")
  public PageInfo<RentHouseDomain> queryRentHouse(
      RentHouseDomain House,
      @RequestParam(name = "pageNum", required = false, defaultValue = "1") int pageNum,
      @RequestParam(name = "pageSize", required = false, defaultValue = "10") int pageSize) {
    return houseService.queryRentHouse(House, pageNum, pageSize);
  }
  // 租房删除
  @ResponseBody
  @DeleteMapping("/delRent")
  public Lable delRentHouse(RentHouseDomain rentHouseDomain) {
    return houseService.delRentHouse(rentHouseDomain);
  }

  // 我发布的租房查询
  @ResponseBody
  @GetMapping("/queryRentsByUserId")
  public PageInfo<RentHouseDomain> queryRentsByUserId(
      RentHouseDomain rentHouseDomain,
      @RequestParam(name = "pageNum", required = false, defaultValue = "1") int pageNum,
      @RequestParam(name = "pageSize", required = false, defaultValue = "10") int pageSize) {
    return houseService.queryRentsByUserId(rentHouseDomain, pageNum, pageSize);
  }

  /** 二手房------------------------------------------------------- * */
  // 新增二手房
  @ResponseBody
  @PostMapping("/addSecond")
  public Lable addSecond(SecondHouseDomain house) {
    return houseService.addSecondHouse(house);
  }
  // 二手房删除
  @ResponseBody
  @DeleteMapping("/delSecond")
  public Lable delSecondHouse(SecondHouseDomain secondHouseDomain) {
    return houseService.delSecondHouse(secondHouseDomain);
  }

  // 普通用户二手房查询:
  @ResponseBody
  @GetMapping("/querySecond")
  public PageInfo<SecondHouseDomain> querySeconds(
      SecondHouseDomain secondHouseDomain,
      @RequestParam(name = "pageNum", required = false, defaultValue = "1") int pageNum,
      @RequestParam(name = "pageSize", required = false, defaultValue = "10") int pageSize) {
    return houseService.querySecondsByUserId(secondHouseDomain, pageNum, pageSize);
  }

  // 普通用户预约看房:orderName,orderTel,orderHouseName,orderHouseId
  @ResponseBody
  @PostMapping("/addOrderRecord")
  public Lable addOrderRecord(OrderRecordDomain order) {
    return houseService.addOrderRecord(order);
  }

  @ResponseBody
  @GetMapping("/queryDyByHouseId")
  public PageInfo<HouseDynamicDomain> queryDyByHouseId(
      String houseId,
      @RequestParam(name = "pageNum", required = false, defaultValue = "1") int pageNum,
      @RequestParam(name = "pageSize", required = false, defaultValue = "10") int pageSize) {
    return houseService.queryDyByHouseId(houseId, pageNum, pageSize);
  }

  @ResponseBody
  @PostMapping("/addHouseDynamic")
  public Lable addHouseDynamic(HouseDynamicDomain house) {
    return houseService.addHouseDynamic(house);
  }

  // 楼盘咨询查询
  @ResponseBody
  @GetMapping("/queryHousesInfo")
  public PageInfo<HousesInfoDomain> queryHousesInfo(
      @RequestParam(name = "pageNum", required = false, defaultValue = "1") int pageNum,
      @RequestParam(name = "pageSize", required = false, defaultValue = "10") int pageSize) {
    return houseService.queryHousesInfo(pageNum, pageSize);
  }

  @ResponseBody
  @PostMapping("/addHousesInfo")
  public Lable addHousesInfo(HousesInfoDomain houseInfo) {
    return houseService.addHousesInfo(houseInfo);
  }

  @ResponseBody
  @PostMapping("/delByUserId")
  public int delBrokerByUserId(AppDomain app) {
    return 0;
  }

  // 查询所有户型
  @ResponseBody
  @GetMapping(value = "queryhouseType")
  public List<HousesDomain> queryhouseType(HouseTypeDomain houseTypeDomain) {
    return houseService.queryhouseType(houseTypeDomain);
  }
  // 查看某户型
  @ResponseBody
  @GetMapping(value = "houseType")
  public List<HouseTypeDomain> houseType(HouseTypeDomain houseTypeDomain) {
    return houseService.houseType(houseTypeDomain);
  }

  // 新房管理-查询新房信息
  @ResponseBody
  @GetMapping(value = "queryNew")
  public PageInfo<HouseDomain> queryNew(
      HouseDomain houseDomain,
      @RequestParam(name = "pageNum", required = false, defaultValue = "1") int pageNum,
      @RequestParam(name = "pageSize", required = false, defaultValue = "10") int pageSize) {
    return houseService.queryNew(houseDomain, pageNum, pageSize);
  }

  // 新房管理-增加新房
  @ResponseBody
  @PostMapping("/addNewHouse")
  public Lable addNewHouse(HouseDomain house) {
    return houseService.addNewHouse(house);
  }

  // 新房管理-编辑新房
  @ResponseBody
  @PostMapping("/upNewHouse")
  public Lable upNewHouse(HouseDomain house) {
    return houseService.upNewHouse(house);
  }

  // 新房管理-删除整个楼盘下的新房
  @ResponseBody
  @PostMapping("/deNewHouse")
  public Lable deNewHouse(HouseDomain house) {
    return houseService.deNewHouse(house);
  }

  // 新房管理-删除某个新房
  @ResponseBody
  @PostMapping("/deNewHouseById")
  public Lable deNewHouseById(HouseDomain house) {
    return houseService.deNewHouseById(house);
  }
}
