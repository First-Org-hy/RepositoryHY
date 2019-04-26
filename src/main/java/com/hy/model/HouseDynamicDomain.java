package com.hy.model;



/**
 * Created by shakaiyue on 22:10 2019/4/17.
 * description:楼盘动态实体类
 */
public class HouseDynamicDomain {

    private Integer dynamicId;      // 动态Id

    private String houseId;         // 楼盘ID
    private String userId;          // 发布人Id
    private String content;         // 内容
    private String crtTime;           // 创建时间
    private String updateTime;        // 更新时间


    public Integer getDynamicId() {
        return dynamicId;
    }

    public void setDynamicId(Integer dynamicId) {
        this.dynamicId = dynamicId;
    }

    public String getHouseId() {
        return houseId;
    }

    public void setHouseId(String houseId) {
        this.houseId = houseId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCrtTime() {
        return crtTime;
    }

    public void setCrtTime(String crtTime) {
        this.crtTime = crtTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }


}
