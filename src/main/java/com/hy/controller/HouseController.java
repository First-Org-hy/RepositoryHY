package com.hy.controller;

import com.hy.common.Lable;
import com.hy.model.AppDomain;
import com.hy.model.RentHouseDomain;
import com.hy.service.AppService;
import com.hy.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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
    @PostMapping("/delByUserId")
    public int delBrokerByUserId(AppDomain app){
        return 1;
    }
}
