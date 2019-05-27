package com.hy.service.impl;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hy.common.Lable;
import com.hy.dao.BankInfoDao;
import com.hy.model.BankInfoDomain;
import com.hy.service.BankInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/** Created by yaohou on 17:09 2019/4/3. description: */
@Service(value = "bankInfoService")
public class BankInfoServiceImpl implements BankInfoService {
  private static Logger logger = LoggerFactory.getLogger(BankInfoServiceImpl.class);

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
  public PageInfo<BankInfoDomain> selectBankInfo(BankInfoDomain bankInfoDomain, int pageNum, int pageSize) {

    PageHelper.startPage(pageNum, pageSize);
    List<BankInfoDomain> bankInfoDomains = bankInfoDao.selectBankInfos(bankInfoDomain);
    logger.info("银行卡信息查询：" + JSON.toJSONString(bankInfoDomains));
    return new PageInfo(bankInfoDomains);
  }
}
