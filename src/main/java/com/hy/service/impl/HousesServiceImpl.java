package com.hy.service.impl;

import com.hy.common.Lable;
import com.hy.dao.HousesDao;
import com.hy.model.HousesDomain;
import com.hy.service.HousesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by yaohou on 18:13 2019/4/7.
 * description:
 */
@Service(value = "housesService")
public class HousesServiceImpl implements HousesService{

    @Autowired
    private HousesDao housesDao;

    @Override
    public List<HousesDomain> queryHouses(HousesDomain housesDomain) {
        return housesDao.selectHouses(housesDomain);
    }

    @Override
    public Lable addHouses(HousesDomain housesDomain) {
        Lable lable = new Lable();
        int i = housesDao.insert(housesDomain);
        if(i == 1){
            lable.setId("1");
            lable.setMessage("新增成功");
        }

        return lable;
    }
}