package com.trial.service.city;

import com.trial.pojo.CityCoordinates;
import com.trial.pojo.http.HttpResponse;

import java.util.List;

/**
 * @description:
 * @date: 2020/7/27 15:59
 * @author: luoziwen
 */
public interface CityCoordinatesService {

    /**
     * 功能描述:添加各省市坐标
     * @return: void
     * @auther: luoziwen
     * @date: 2020/7/27 16:50
     */
    HttpResponse insertCityCoordinates();

//    /**
//     * 功能描述:添加各省市坐标
//     * @param geos
//     * @return: void
//     * @auther: luoziwen
//     * @date: 2020/7/27 16:50
//     */
//    void inserCityCoordinates(List<CityCoordinates> geos);
//    /**
//     * 功能描述: 获取所有的坐标信息
//     * @param
//     * @return: java.util.List<com.trial.pojo.CityCoordinates>
//     * @auther: luoziwen
//     * @date: 2020/7/27 18:45
//     */
//    List<CityCoordinates> selectAllGeo();
}
