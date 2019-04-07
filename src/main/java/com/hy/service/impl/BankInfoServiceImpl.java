package com.hy.service.impl;

import com.hy.dao.BankInfoDao;
import com.hy.model.BankInfoDomain;
import com.hy.service.BankInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by yaohou on 17:09 2019/4/3.
 * description:
 */
@Service(value = "bankInfoService")
public class BankInfoServiceImpl implements BankInfoService {

    @Autowired
    private BankInfoDao bankInfoDao;

    @Override
    public int add(BankInfoDomain bankInfoDomain) {
        return bankInfoDao.insert(bankInfoDomain);
    }

    @Override
    public List<BankInfoDomain> selectBankInfo(BankInfoDomain bankInfoDomain) {
        return bankInfoDao.selectBankInfos(bankInfoDomain);
    }


}
