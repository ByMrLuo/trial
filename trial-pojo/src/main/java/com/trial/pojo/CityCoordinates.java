package com.trial.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * @description: 省市经纬度实体类
 * @date: 2020/7/27 15:27
 * @author: luoziwen
 */
public class CityCoordinates implements Serializable {

    private Integer id;
    /**城市名称*/
    private String cityName;
    /**经度*/
    private Double longitude;
    /**纬度*/
    private Double latitude;

    private Date createTime;

    private Date updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime == null? new Date() : createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime == null ? new Date() : updateTime;
    }

    @Override
    public String toString() {
        return "CityCoordinates{" +
                "id=" + id +
                ", cityName='" + cityName + '\'' +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
