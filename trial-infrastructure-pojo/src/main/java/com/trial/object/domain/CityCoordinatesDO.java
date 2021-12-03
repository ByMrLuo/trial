package com.trial.object.domain;

import lombok.Data;

/**
 * @description:城市坐标实体
 * @date: 2021/12/3 22:10
 * @author: luoziwen
 */
@Data
public class CityCoordinatesDO {


    CityCoordinatesID cityCoordinatesID;

    CityName cityName;

    Coordinates coordinates;


}
