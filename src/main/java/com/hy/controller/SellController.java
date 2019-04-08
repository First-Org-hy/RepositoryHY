package com.hy.controller;


import com.hy.common.Lable;
import com.hy.model.HousesUserDomain;
import com.hy.model.SellDomain;

import com.hy.service.SellService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

/**
 * Created by shakaiyue on 14:28 2019/4/7.
 * description:
 */
@RestController
@RequestMapping(value = "/sell")
public class SellController {

    @Autowired
    private SellService sellService;

    @ResponseBody
    @PostMapping("/addSell")
    public int addSell(SellDomain sell) {
        return sellService.addSell(sell);
    }

    @ResponseBody
    @GetMapping("/queryByUserId")
    public List<SellDomain> querySellInfoByUserId(SellDomain sell) {
        return sellService.querySellInfoByUserId(sell);
    }

    @ResponseBody
    @GetMapping("/queryByUserParId")
    public List<SellDomain> querySellInfoByUserParId(SellDomain sell) {
        return sellService.querySellInfoByUserParId(sell);
    }

    @ResponseBody
    @GetMapping(value = "isBusSeller")
    public Lable isBusSeller(String userId){
        return sellService.isBusSeller(userId);
    }

    @ResponseBody
    @GetMapping(value = "queryBySeller")
    public List<SellDomain> queryBySeller(String userId){
        return sellService.queryBySeller(userId);
    }

    @ResponseBody
    @GetMapping(value = "queryBySellId")
    public List<HousesUserDomain> queryBySellId(String userId){
        return sellService.queryBySellId(userId);
    }
}
