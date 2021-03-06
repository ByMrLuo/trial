package com.trial.service.citycoordinates;

import com.trial.object.vo.HttpResponse;

import java.util.List;

/**
 * @方法说明:
 * @Description:
 * @Auther: Mr.Luo
 * @Date: 2021/11/21 23:52
 */

public interface CityCoordinatesOperationService {
    /**
     * @description:插入数据
     * @param
     * @return void
     * @author Mr.Luo
     * @date 2021/11/22 1:09
     */
    HttpResponse<List> insertCityCoordinates();
    /**
     * 功能描述:
     * @param cityName
     * @return: void
     * @auther: luoziwen
     * @date: 2022/4/7 11:30
     */
    void addHotCity(String cityName);
}
