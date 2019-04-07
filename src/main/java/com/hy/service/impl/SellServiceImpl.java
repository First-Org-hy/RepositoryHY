package com.hy.service.impl;

import com.hy.dao.SellDao;
import com.hy.model.SellDomain;
import com.hy.service.SellService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by shakaiyue on 14:28 2019/4/7.
 * description:
 */
@Service(value = "sellService")
public class SellServiceImpl implements SellService {

    @Autowired
    private SellDao selldao;

    /**
     * 增加销售记录
     * @param sell
     * @return
     */
    @Override
    public int addSell(SellDomain sell) {
        Date createDate = new Date();
        java.sql.Date sqlDate = new java.sql.Date(createDate.getTime());
        sell.setCrtTime(sqlDate);
        return selldao.addSell(sell);
    }

    /**
     * 修改销售记录
     * @param sell
     * @return
     */
    @Override
    public int updateSell(SellDomain sell) {
        return 0;
    }

    /**
     * 删除销售记录
     * @param sell
     * @return
     */
    @Override
    public int deteleSell(SellDomain sell) {
        return 0;
    }

    /**
     * 通过经纪人id查询某个经纪人的销售记录
     * @param sell
     * @return
     */
    @Override
    public List<SellDomain> querySellInfoByUserId(SellDomain sell) {
        return selldao.querySellInfoByUserId(sell);
    }

    /**
     * 通过经纪公司id查询经纪公司的销售记录
     * @param sell
     * @return
     */
    @Override
    public List<SellDomain> querySellInfoByUserParId(SellDomain sell) {
        return selldao.querySellInfoByUserParId(sell);
    }
}
