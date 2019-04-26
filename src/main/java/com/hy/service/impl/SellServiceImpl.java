package com.hy.service.impl;

import com.hy.common.Lable;
import com.hy.dao.HousesDao;
import com.hy.dao.SellDao;
import com.hy.model.HousesDomain;
import com.hy.model.HousesUserDomain;
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

    @Autowired
    private HousesDao housesDao;

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

    /**
     * 查询用户是否为驻点商务
     * @param userId
     * @return
     */
    @Override
    public Lable isBusSeller(String userId) {
        Lable la = new Lable();
        if(selldao.isBusSeller(userId) == 1){
            la.setId("1");
            la.setMessage("该用户是驻点商务");
        }else {
            la.setId("0");
            la.setMessage("该用户不是驻点商务");
        }
        return la;
    }

    /**
     * 查询某个驻点商务的全部销售记录
     * @param userId
     * @return
     */
    @Override
    public List<SellDomain> queryBySeller(String userId) {
        List<SellDomain> sells = selldao.queryBySeller(userId);
        for(SellDomain sell : sells){
            String houseId = sell.getHousesId();
            HousesDomain house = new HousesDomain();
            house.setHousesId(houseId);
            List<HousesDomain> houses = housesDao.selectHouses(house);
            sell.setHouses(houses);
        }
        return sells;
    }

    @Override
    public List<HousesUserDomain> queryBySellId(String userId) {
       List<HousesUserDomain>  houseUsers = selldao.queryBySellId(userId);
       for(HousesUserDomain house : houseUsers) {
           String houseId = house.getHousesId();
           HousesDomain houses = new HousesDomain();
           houses.setHousesId(houseId);
           houses.setAreaId("ss");
           List<HousesDomain> housesInfo = housesDao.selectHouses(houses);
           house.setHouses(housesInfo);
       }
       return houseUsers;
    }
}
