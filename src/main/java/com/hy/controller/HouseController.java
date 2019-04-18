package com.hy.controller;

import com.hy.common.Lable;
import com.hy.model.*;

import com.hy.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by shakaiyue on 21:59 2019/4/12.
 * description:新房，二手房，租房 Controller
 */
@RestController
@RequestMapping(value = "/house")
public class HouseController {

    @Autowired
    private HouseService houseService;

    @ResponseBody
    @PostMapping("/addRentHouse")
    public Lable addRentHouse(RentHouseDomain house){
        return houseService.addRentHouse(house);
    }

    @ResponseBody
    @GetMapping("/queryRent")
    public List<RentHouseDomain> queryRentHouse(RentHouseDomain House){
        return houseService.queryRentHouse(House);
    }

    @ResponseBody
    @GetMapping("/queryRentsByUserId")
    public List<RentHouseDomain> queryRentsByUserId(String userId){
        return houseService.queryRentsByUserId(userId);
    }

    @ResponseBody
    @PostMapping("/addSecondHouse")
    public Lable addSecondHouse(SecondHouseDomain house){
        return houseService.addSecondHouse(house);
    }

    @ResponseBody
    @GetMapping("/querySecond")
    public List<SecondHouseDomain> querySecondHouse(SecondHouseDomain House){
        return houseService.querySecondHouse(House);
    }

    @ResponseBody
    @GetMapping("/querySecondsByUserId")
    public List<SecondHouseDomain> querySecondsByUserId(String userId){
        return houseService.querySecondsByUserId(userId);
    }

    @ResponseBody
    @PostMapping("/addOrderRecord")
    public Lable addOrderRecord(OrderRecordDomain order){
        return houseService.addOrderRecord(order);
    }

    @ResponseBody
    @GetMapping("/queryDyByHouseId")
    public List<HouseDynamicDomain> queryDyByHouseId(String houseId) {
        return houseService.queryDyByHouseId(houseId);
    }

    @ResponseBody
    @PostMapping("/addHouseDynamic")
    public Lable addHouseDynamic(HouseDynamicDomain house){
        return houseService.addHouseDynamic(house);
    }


    @ResponseBody
    @GetMapping("/queryHousesInfo")
    public List<HousesInfoDomain> queryHousesInfo() {
        return houseService.queryHousesInfo();
    }

    @ResponseBody
    @PostMapping("/addHousesInfo")
    public Lable addHousesInfo(HousesInfoDomain houseInfo){
        return houseService.addHousesInfo(houseInfo);
    }

    @ResponseBody
    @PostMapping("/delByUserId")
    public int delBrokerByUserId(AppDomain app){
        return 0;
    }
}
