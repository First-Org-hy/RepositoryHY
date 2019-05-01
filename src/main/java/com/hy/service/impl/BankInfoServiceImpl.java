package com.hy.service.impl;

import com.hy.common.Lable;
import com.hy.dao.BankInfoDao;
import com.hy.model.BankInfoDomain;
import com.hy.service.BankInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/** Created by yaohou on 17:09 2019/4/3. description: */
@Service(value = "bankInfoService")
public class BankInfoServiceImpl implements BankInfoService {

  @Autowired private BankInfoDao bankInfoDao;

  @Override
  public Lable add(BankInfoDomain bankInfoDomain) {
    Lable lable = null;
    if (bankInfoDao.selectBankInfos(bankInfoDomain).size() != 0) {
      new Lable("2", "已存在");
    } else {
      if (bankInfoDao.insert(bankInfoDomain) == 1) {
        new Lable("1", "新增成功");
      } else {
        new Lable("0", "新增失败");
      }
    }
    return lable;
  }

  @Override
  public List<BankInfoDomain> selectBankInfo(BankInfoDomain bankInfoDomain) {
    return bankInfoDao.selectBankInfos(bankInfoDomain);
  }
}
