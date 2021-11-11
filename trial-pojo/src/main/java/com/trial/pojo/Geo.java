package com.trial.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * @description: 省市转换类
 * @date: 2020/7/27 11:27
 * @author: luoziwen
 */
public class Geo implements Serializable {
    //城市名称
    private String name;
    //城市坐标
    private List<Double> geoCoord;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Double> getGeoCoord() {
        return geoCoord;
    }

    public void setGeoCoord(List<Double> geoCoord) {
        this.geoCoord = geoCoord;
    }

    @Override
    public String toString() {
        return "Geo{" +
                "name='" + name + '\'' +
                ", geoCoord=" + geoCoord +
                '}';
    }
}
