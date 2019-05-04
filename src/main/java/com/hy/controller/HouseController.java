package com.hy.controller;

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

  @ResponseBody
  @PostMapping("/addRentHouse")
  public Lable addRentHouse(RentHouseDomain house) {
    return houseService.addRentHouse(house);
  }

  // 普通用户租房查询
  @ResponseBody
  @GetMapping("/queryRent")
  public List<RentHouseDomain> queryRentHouse(RentHouseDomain House) {
    return houseService.queryRentHouse(House);
  }

  // 我发布的租房查询
  @ResponseBody
  @GetMapping("/queryRentsByUserId")
  public List<RentHouseDomain> queryRentsByUserId(RentHouseDomain rentHouseDomain) {
    return houseService.queryRentsByUserId(rentHouseDomain);
  }

  @ResponseBody
  @PostMapping("/addSecond")
  public Lable addSecond(SecondHouseDomain house) {
    return houseService.addSecondHouse(house);
  }

  // 普通用户二手房查询:
  @ResponseBody
  @GetMapping("/querySecond")
  public List<SecondHouseDomain> querySeconds(SecondHouseDomain secondHouseDomain) {
    return houseService.querySecondsByUserId(secondHouseDomain);
  }

  // 普通用户预约看房:orderName,orderTel,orderHouseName,orderHouseId
  @ResponseBody
  @PostMapping("/addOrderRecord")
  public Lable addOrderRecord(OrderRecordDomain order) {
    return houseService.addOrderRecord(order);
  }

  @ResponseBody
  @GetMapping("/queryDyByHouseId")
  public List<HouseDynamicDomain> queryDyByHouseId(String houseId) {
    return houseService.queryDyByHouseId(houseId);
  }

  @ResponseBody
  @PostMapping("/addHouseDynamic")
  public Lable addHouseDynamic(HouseDynamicDomain house) {
    return houseService.addHouseDynamic(house);
  }

  // 楼盘咨询查询
  @ResponseBody
  @GetMapping("/queryHousesInfo")
  public List<HousesInfoDomain> queryHousesInfo() {
    return houseService.queryHousesInfo();
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
}
