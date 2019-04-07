package com.hy.dao;

import com.hy.model.BankInfoDomain;

import java.util.List;

/**
 * Created by yaohou on 17:05 2019/4/3.
 * description:
 */
public interface BankInfoDao {
    int insert(BankInfoDomain bankInfo);

    List<BankInfoDomain> selectBankInfos(BankInfoDomain bankInfoDomain);
}
