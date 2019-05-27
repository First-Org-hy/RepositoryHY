package com.hy.service;

import com.hy.common.Lable;
import com.hy.model.BankInfoDomain;
import com.github.pagehelper.PageInfo;


/** Created by yaohou on 17:07 2019/4/3. description: */
public interface BankInfoService {

  Lable add(BankInfoDomain bankInfoDomain);

  PageInfo<BankInfoDomain> selectBankInfo(BankInfoDomain bankInfoDomain,  int pageNum, int pageSize);
}
