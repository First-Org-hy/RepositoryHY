package com.hy.service;

import com.hy.common.Lable;
import com.hy.model.BankInfoDomain;

import java.util.List;

/** Created by yaohou on 17:07 2019/4/3. description: */
public interface BankInfoService {

  Lable add(BankInfoDomain bankInfoDomain);

  List<BankInfoDomain> selectBankInfo(BankInfoDomain bankInfoDomain);
}
