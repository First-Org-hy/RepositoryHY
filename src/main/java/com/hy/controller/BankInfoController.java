package com.hy.controller;

import com.hy.common.Lable;
import com.hy.model.BankInfoDomain;
import com.hy.service.BankInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.github.pagehelper.PageInfo;

/** Created by yaohou on 17:13 2019/4/3. description: */
@RestController
@RequestMapping(value = "bank")
public class BankInfoController {
  @Autowired private BankInfoService bankInfoService;

  /**
   * 添加银行卡
   *
   * @author yaohou
   * @date 2019/4/7 12:56
   * @return int
   */
  @ResponseBody
  @PostMapping(value = "add")
  public Lable addBankInfo(BankInfoDomain bankInfoDomain) {
    // userId:经纪人ID ，cardName 姓名， cardPhone 电话， bank 银行，cardNum 银行卡号， bankDeposit 开户行地址。 支持一人多卡

    return bankInfoService.add(bankInfoDomain);
  }

  /**
   * 银行卡信息查询
   * @param bankInfoDomain
   * @param pageNum
   * @param pageSize
   * @return
   */
  @ResponseBody
  @GetMapping(value = "query")
  public PageInfo<BankInfoDomain> queryBankInfo(BankInfoDomain bankInfoDomain,
         @RequestParam(name = "pageNum", required = false, defaultValue = "1") int pageNum,
         @RequestParam(name = "pageSize", required = false, defaultValue = "10") int pageSize) {
    return bankInfoService.selectBankInfo(bankInfoDomain, pageNum, pageSize);
  }
}
