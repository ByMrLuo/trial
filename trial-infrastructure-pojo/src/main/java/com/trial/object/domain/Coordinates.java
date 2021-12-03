package com.trial.object.domain;

import lombok.Data;

/**
 * @description: 坐标值对象
 * （坐标其实应该是实体，他的经纬度确定的就是一个点...是唯一的）
 * @date: 2021/12/3 20:21
 * @author: luoziwen
 */
@Data
public class Coordinates {

    /**经度*/
    private Double longitude;
    /**纬度*/
    private Double latitude;
}
