package com.hy.controller;

import com.hy.common.Lable;
import com.hy.model.BankInfoDomain;
import com.hy.service.BankInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

  @ResponseBody
  @GetMapping(value = "query")
  public List<BankInfoDomain> queryBankInfo(BankInfoDomain bankInfoDomain) {
    return bankInfoService.selectBankInfo(bankInfoDomain);
  }
}
