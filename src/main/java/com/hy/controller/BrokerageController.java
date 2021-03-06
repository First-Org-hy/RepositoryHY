package com.hy.controller;

import com.hy.common.Lable;
import com.hy.model.BrokerageDomain;
import com.hy.service.BrokerageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.github.pagehelper.PageInfo;

/** Created by yaohou on 13:02 2019/4/7. description: 佣金服务 */
@RestController
@RequestMapping(value = "brokerage")
public class BrokerageController {

  @Autowired private BrokerageService brokerageService;

  @ResponseBody
  @GetMapping(value = "query")
  public PageInfo<BrokerageDomain> queryBrokerages(BrokerageDomain brokerageDomain,
    @RequestParam(name = "pageNum", required = false, defaultValue = "1") int pageNum,
    @RequestParam(name = "pageSize", required = false, defaultValue = "10") int pageSize) {
    return brokerageService.selectBrokerages(brokerageDomain, pageNum, pageSize);
  }

  @ResponseBody
  @PutMapping(value = "updateRead")
  public int updateBrokeragesRead(BrokerageDomain brokerageDomain) {

    return brokerageService.updateBrokeragesRead(brokerageDomain);
  }

  @ResponseBody
  @PostMapping(value = "add")
  public Lable addBrokerages(BrokerageDomain brokerageDomain) {
    Lable lable = new Lable();

    int i = brokerageService.add(brokerageDomain);

    if (i == 1) {
      lable.setId("1");
      lable.setMessage("新增成功");
    }

    return lable;
  }
}
