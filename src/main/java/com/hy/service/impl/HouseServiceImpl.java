package com.hy.service.impl;

import com.hy.common.Lable;
import com.hy.dao.HouseDao;
import com.hy.dao.HousesDao;
import com.hy.model.HousesDomain;
import com.hy.model.RentHouseDomain;
import com.hy.service.HouseService;
import com.hy.service.HousesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by shakaiyue on 17:59 2019/4/12.
 * description:新房，二手房，租房 Service
 */
@Service(value = "houseService")
public class HouseServiceImpl implements HouseService {

      @Autowired
      private HouseDao houseDao;

//    @Override
//    public List<HousesDomain> queryHouses(HousesDomain housesDomain) {
//        return housesDao.selectHouses(housesDomain);
//    }

    /**
     * 发布租房信息
     * @param house
     * @return
     */
      @Override
      public Lable addRentHouse(RentHouseDomain house) {
          Lable lable = new Lable();
          int i = houseDao.addRentHouse(house);
          if(i == 1){
              lable.setId("1");
              lable.setMessage("租房信息发布成功");
          }

        return lable;
    }


}
