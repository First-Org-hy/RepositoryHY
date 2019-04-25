package com.hy.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by shakaiyue on 14:28 2019/4/7.
 * description:销售实体类
 */
public class SellDomain {
    private Integer id;
    private String userBsId;        //楼盘商务id
    private String userId; 	        //经纪人id
    private String userParentId;    //经纪公司id
    private String guestId; 	    //客户id
    private String guestName;       //客户姓名
    private String guestIdCard;     //客户身份证号
    private String guestAddress;    //客户地址
    private String housesId;        //楼盘id
    private String houseTypeId;     //户型id
    private String houseNum;	    //房间号
    private BigDecimal price;	    //单价
    private BigDecimal totalPrice;  //总价
    private String picAddress;      //图片地址
    private String sellState;       //图片地址：0 待审核，1 审核通过
    private String dealState;       //交易状态:1.看房，2.交定金 3. 交首付 4.银行房贷 5.购买完成 6. 未购买
    private BigDecimal brokerage;	//佣金
    private String brokerState;     //佣金状态
    private Date crtTime; 	        //创建时间
    private Date updateTime;        //更新时间

    private List<HousesDomain> houses;  //楼盘信息
    private String guestPhone;      //客户电话

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserBsId() {
        return userBsId;
    }

    public void setUserBsId(String userBsId) {
        this.userBsId = userBsId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserParentId() {
        return userParentId;
    }

    public void setUserParentId(String userParentId) {
        this.userParentId = userParentId;
    }

    public String getGuestId() {
        return guestId;
    }

    public void setGuestId(String guestId) {
        this.guestId = guestId;
    }

    public String getGuestName() {
        return guestName;
    }

    public void setGuestName(String guestName) {
        this.guestName = guestName;
    }

    public String getGuestIdCard() {
        return guestIdCard;
    }

    public void setGuestIdCard(String guestIdCard) {
        this.guestIdCard = guestIdCard;
    }

    public String getGuestAddress() {
        return guestAddress;
    }

    public void setGuestAddress(String guestAddress) {
        this.guestAddress = guestAddress;
    }

    public String getHousesId() {
        return housesId;
    }

    public void setHousesId(String housesId) {
        this.housesId = housesId;
    }

    public String getHouseTypeId() {
        return houseTypeId;
    }

    public void setHouseTypeId(String houseTypeId) {
        this.houseTypeId = houseTypeId;
    }

    public String getHouseNum() {
        return houseNum;
    }

    public void setHouseNum(String houseNum) {
        this.houseNum = houseNum;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getPicAddress() {
        return picAddress;
    }

    public void setPicAddress(String picAddress) {
        this.picAddress = picAddress;
    }

    public String getSellState() {
        return sellState;
    }

    public void setSellState(String sellState) {
        this.sellState = sellState;
    }

    public String getDealState() {
        return dealState;
    }

    public void setDealState(String dealState) {
        this.dealState = dealState;
    }

    public BigDecimal getBrokerage() {
        return brokerage;
    }

    public void setBrokerage(BigDecimal brokerage) {
        this.brokerage = brokerage;
    }

    public String getBrokerState() {
        return brokerState;
    }

    public void setBrokerState(String brokerState) {
        this.brokerState = brokerState;
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

    public String getGuestPhone() {
        return guestPhone;
    }

    public void setGuestPhone(String guestPhone) {
        this.guestPhone = guestPhone;
    }
}
