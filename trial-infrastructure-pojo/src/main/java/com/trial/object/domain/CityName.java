package com.trial.object.domain;

import lombok.Data;

/**
 * @description:城市名称值对象
 * @date: 2021/12/3 20:14
 * @author: luoziwen
 */
@Data
public class CityName {

    /**城市名称*/
    String cityName;

    /**后缀，城市名称的后缀入省，市，区，街道*/
    String suffix;

    public String appendCiyty(){
        return cityName + suffix;
    }
}
