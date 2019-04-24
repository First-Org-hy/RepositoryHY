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
    Lable lable = new Lable();
    if (bankInfoDao.insert(bankInfoDomain) == 1) {
      lable.setId("1");
      lable.setMessage("成功");
    } else {
      lable.setId("2");
      lable.setMessage("失败");
    }
    return lable;
  }

  @Override
  public List<BankInfoDomain> selectBankInfo(BankInfoDomain bankInfoDomain) {
    return bankInfoDao.selectBankInfos(bankInfoDomain);
  }
}
