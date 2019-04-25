package com.hy.model;

import java.sql.Date;
import java.util.List;

/**
 * Created by shakaiyue on 22:10 2019/3/21.
 * description:楼盘商务关系实体类
 */
public class HousesUserDomain {

    private String userId;          //驻点商务ID
    private String housesId;        //楼盘ID
    private String updateId;        //更新人id
    private Date crtTime;
    private Date updateTime;
    private List<HousesDomain> houses; //楼盘信息

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getHousesId() {
        return housesId;
    }

    public void setHousesId(String housesId) {
        this.housesId = housesId;
    }

    public String getUpdateId() {
        return updateId;
    }

    public void setUpdateId(String updateId) {
        this.updateId = updateId;
    }

    public Date getCrtTime() {
        return crtTime;
    }

    public void setCrtTime(Date crtTime) {
        this.crtTime = crtTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public List<HousesDomain> getHouses() {
        return houses;
    }

    public void setHouses(List<HousesDomain> houses) {
        this.houses = houses;
    }
}
