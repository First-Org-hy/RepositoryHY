package com.hy.controller;

import com.hy.model.BankInfoDomain;
import com.hy.service.BankInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by yaohou on 17:13 2019/4/3.
 * description:
 */
@RestController
@RequestMapping(value = "bank")
public class BankInfoController {
    @Autowired
    private BankInfoService bankInfoService;

    @ResponseBody
    @GetMapping(value = "add")
    public int addBankInfo(BankInfoDomain bankInfoDomain){
        //userId:经纪人ID ，cardName 姓名， cardPhone 电话， bank 银行，cardNum 银行卡号， bankDeposit 开户行地址。 支持一人多卡


        return bankInfoService.add(bankInfoDomain);
    }


}
