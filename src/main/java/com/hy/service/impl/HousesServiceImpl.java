package com.hy.service.impl;

import com.hy.common.Lable;
import com.hy.dao.AppDao;
import com.hy.dao.HouseDao;
import com.hy.dao.HousesDao;
import com.hy.model.*;
import com.hy.service.HousesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by yaohou on 18:13 2019/4/7. description:
 */
@Service(value = "housesService")
public class HousesServiceImpl implements HousesService {

    @Autowired
    private HousesDao housesDao;

    @Autowired
    private AppDao appDao;

    @Autowired
    private HouseDao houseDao;

    // 驻点商务楼盘查询: userId(驻点商务id)
    // 普通用户楼盘查询
    @Override
    public List<HousesDomain> queryHouses(HousesDomain housesDomain) {
        return housesDao.selectHouses(housesDomain);
    }

    @Override
    public Lable addHouses(HousesDomain houses) {
        Lable lable = new Lable();
        if (!"".equals(housesDao.queryHouseId(houses))) {
            lable.setId("2");
            lable.setMessage("已存在");
            return lable;
        }
        int i = housesDao.insert(houses);
        if (i == 1) {
            lable.setId("1");
            lable.setMessage("新增成功");
        } else {
            lable.setId("0");
            lable.setMessage("新增失败");
        }
        String housesId = housesDao.queryHouseId(houses);
        houses.setHousesSpclty(housesId);
        houses.setMating(housesId);
        String picX = "X" + housesId;//效果图Id
        String picS = "S" + housesId;//实施图Id
        String picJ = "J" + housesId;//交通图Id
        houses.setPictureX(picX);
        houses.setPictureS(picS);
        houses.setPictureJ(picJ);


        //新增楼盘特点
        if (houses.getHousesSpcltyLable().size() != 0) {
            for (HousesSpcltyDomain spcl : houses.getHousesSpcltyLable()) {
                spcl.setLableId(housesId);
                housesDao.insertHouseSpcl(spcl);
            }
        }
        //新增楼盘效果图
        if (houses.getPictureXLable().size() != 0) {
            for (HousesPictureDomain pic : houses.getPictureXLable()) {
                pic.setLableId(picX);
                housesDao.insertHousePic(pic);
            }
        }

        //新增楼盘实施图
        if (houses.getPictureSLable().size() != 0) {
            for (HousesPictureDomain pic : houses.getPictureSLable()) {
                pic.setLableId(picS);
                housesDao.insertHousePic(pic);
            }
        }

        //新增楼盘交通图
        if (houses.getPictureJLable().size() != 0) {
            for (HousesPictureDomain pic : houses.getPictureJLable()) {
                pic.setLableId(picJ);
                housesDao.insertHousePic(pic);
            }
        }

        //新增楼盘配套设施
        if (houses.getMatingLable().size() != 0) {
            for (HousesFacilitiesDomain mating : houses.getMatingLable()) {
                housesDao.insertHouseMat(mating);
            }
        }

        //新增楼盘户型
        if (houses.getHouseType().size() != 0) {
            for (HouseTypeDomain type : houses.getHouseType()) {
                housesDao.insertHouseType(type);
                String spcId = "HU" + housesId;
                type.setHouseTypeSpci(spcId);
                if (type.getHousesSpcltyLable().size() != 0) {
                    for (HousesSpcltyDomain spc : type.getHousesSpcltyLable()) {
                        spc.setLableId(spcId);
                        housesDao.insertHouseSpcl(spc);
                    }
                }

                type.setHouseTypePic(spcId);
                if (type.getPictureXLable().size() != 0) {
                    for (HousesPictureDomain pic : houses.getPictureJLable()) {
                        pic.setLableId(spcId);
                        housesDao.insertHousePic(pic);
                    }
                }
            }
        }


        return lable;
    }

    // 普通用户 区域/价格/筛选 楼盘: areaId,总价,avgPrice(单价),户型,装修,面积,开盘时间,售卖状况,特色
    @Override
    public List<HousesDomain> queryAll(HousesDomain housesDomain) {
        List<HousesDomain> houses = housesDao.queryAll(housesDomain);
        if (houses.size() != 0) {
            for (HousesDomain house : houses) {
                //获取楼盘特点集合
                if(!"".equals(house.getHousesSpclty())){
                    List<HousesSpcltyDomain> spcs = housesDao.querySpc(house.getHousesSpclty());
                    house.setHousesSpcltyLable(spcs);
                }
                //获取楼盘效果图集合
                if(!"".equals(house.getPictureX())){
                    List<HousesPictureDomain> picx = housesDao.queryPic(house.getPictureX());
                    house.setPictureXLable(picx);
                }
                //获取楼盘实施图集合
                if(!"".equals(house.getPictureS())){
                    List<HousesPictureDomain> pics = housesDao.queryPic(house.getPictureS());
                    house.setPictureSLable(pics);
                }
                //获取楼盘交通图集合
                if(!"".equals(house.getPictureJ())){
                    List<HousesPictureDomain> picj = housesDao.queryPic(house.getPictureJ());
                    house.setPictureJLable(picj);
                }
                //获取楼盘配套设施
                if(!"".equals(house.getMating())){
                    List<HousesFacilitiesDomain> mat = housesDao.queryMat(house.getMating());
                    house.setMatingLable(mat);
                }
                //获取楼盘户型
                List<HouseTypeDomain> types = housesDao.queryType(house.getHousesId());
                if(types.size() != 0 ){
                   for(HouseTypeDomain type : types){=
                       if(!"".equals(type.getHouseTypePic())){
                           List<HousesPictureDomain> pic = housesDao.queryPic(type.getHouseTypePic());
                           type.setPictureXLable(pic);
                       }
                       if(!"".equals(type.getHouseTypeSpci())){
                           List<HousesSpcltyDomain> spcs = housesDao.querySpc(type.getHouseTypeSpci());
                           type.setHousesSpcltyLable(spcs);
                       }
                   }
                }
                house.setHouseType(types);
                //获取经纪人集合
                AppDomain app = new AppDomain();
                app.setHousesId(house.getHousesId());
                List<AppDomain> apps = appDao.query(app);
                house.setApps(apps);
                //获取楼盘动态集合
                List<HouseDynamicDomain> dys= houseDao.queryDyByHouseId(house.getHousesId());
                house.setHouseDynamics(dys);
            }
        }
        return housesDao.queryAll(housesDomain);
    }
}
