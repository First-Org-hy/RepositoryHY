package com.hy.controller;

import com.hy.common.Lable;
import com.hy.model.HousesUserDomain;
import com.hy.model.SellDomain;
import com.hy.service.SellService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/** Created by shakaiyue on 14:28 2019/4/7. description: */
@RestController
@RequestMapping(value = "/sell")
public class SellController {

  @Autowired private SellService sellService;

  @ResponseBody
  @PostMapping("/add")
  public Lable addSell(SellDomain sell) {
    return sellService.addSell(sell);
  }

  // 根据楼盘id:housesId 查询销售信息
  @ResponseBody
  @GetMapping("/query")
  public List<SellDomain> query(SellDomain sell) {
    return sellService.query(sell);
  }
  // 楼盘商务,修改销售状态
  @ResponseBody
  @PutMapping("update")
  public Lable update(SellDomain sellDomain) {
    return sellService.update(sellDomain);
  }

  @ResponseBody
  @GetMapping("/queryByUserParId")
  public List<SellDomain> querySellInfoByUserParId(SellDomain sell) {
    return sellService.querySellInfoByUserParId(sell);
  }

  @ResponseBody
  @GetMapping(value = "isBusSeller")
  public Lable isBusSeller(String userId) {
    return sellService.isBusSeller(userId);
  }

  @ResponseBody
  @GetMapping(value = "queryBySeller")
  public List<SellDomain> queryBySeller(String userId) {
    return sellService.queryBySeller(userId);
  }

  @ResponseBody
  @GetMapping(value = "queryBySellId")
  public List<HousesUserDomain> queryBySellId(String userId) {
    return sellService.queryBySellId(userId);
  }
}
