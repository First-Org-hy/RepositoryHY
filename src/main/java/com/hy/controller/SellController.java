package com.hy.controller;

import com.hy.common.Lable;
import com.hy.model.HousesUserDomain;
import com.hy.model.SellDomain;
import com.hy.service.SellService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.github.pagehelper.PageInfo;
import java.util.List;

/** Created by shakaiyue on 14:28 2019/4/7. description:销售服务 */
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
  public PageInfo<SellDomain> query(SellDomain sell,
                                    @RequestParam(name = "pageNum", required = false, defaultValue = "1") int pageNum,
                                    @RequestParam(name = "pageSize", required = false, defaultValue = "10") int pageSize) {
    return sellService.query(sell, pageNum, pageSize);
  }
  // 楼盘商务,修改销售状态
  @ResponseBody
  @PutMapping("/update")
  public Lable update(SellDomain sellDomain) {
    return sellService.update(sellDomain);
  }

  @ResponseBody
  @GetMapping("/queryByUserParId")
  public PageInfo<SellDomain> querySellInfoByUserParId(SellDomain sell,
                                                       @RequestParam(name = "pageNum", required = false, defaultValue = "1") int pageNum,
                                                       @RequestParam(name = "pageSize", required = false, defaultValue = "10") int pageSize) {
    return sellService.querySellInfoByUserParId(sell, pageNum, pageSize);
  }

  @ResponseBody
  @GetMapping(value = "/isBusSeller")
  public Lable isBusSeller(String userId) {
    return sellService.isBusSeller(userId);
  }

  @ResponseBody
  @GetMapping(value = "/queryBySeller")
  public PageInfo<SellDomain> queryBySeller(String userId,
                                            @RequestParam(name = "pageNum", required = false, defaultValue = "1") int pageNum,
                                            @RequestParam(name = "pageSize", required = false, defaultValue = "10") int pageSize) {
    return sellService.queryBySeller(userId, pageNum, pageSize);
  }

  @ResponseBody
  @GetMapping(value = "/queryBySellId")
  public PageInfo<HousesUserDomain> queryBySellId(String userId,
                                                  @RequestParam(name = "pageNum", required = false, defaultValue = "1") int pageNum,
                                                  @RequestParam(name = "pageSize", required = false, defaultValue = "10") int pageSize) {
    return sellService.queryBySellId(userId, pageNum, pageSize);
  }
}
