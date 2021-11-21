package com.trial.service.city.impl;

import com.trial.mapper.CityCoordinatesMapper;
import com.trial.pojo.CityCoordinates;
import com.trial.pojo.http.HttpResponse;
import com.trial.service.city.CityCoordinatesService;
import com.trial.service.citycoordinates.CityCoordinatesOperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description: 各省市坐标操作类
 * @date: 2020/7/27 15:59
 * @author: luoziwen
 */
@Service
public class CityCoordinatesServiceImpl implements CityCoordinatesService {

//    @Autowired
//    private CityCoordinatesMapper cityCoordinatesMapper;

    @Autowired
    private CityCoordinatesOperationService cityCoordinatesOperationServiceImpl;

    /**
     * @description:这里只是单纯的录入，因为导入城市坐标这个东西不会这么导入的
     * 在据合中此处只有逻辑流程而不是逻辑实现
     * @param
     * @return com.trial.pojo.http.HttpResponse
     * @author Mr.Luo
     * @date 2021/11/21 23:45
     */
    @Override
    public HttpResponse insertCityCoordinates() {
        //两部操作，1.存入数据库2.存入缓存，供给计算周围的城市使用
        cityCoordinatesOperationServiceImpl.insertCityCoordinates();
        return null;
    }

//    @Override
//    public void inserCityCoordinates(List<CityCoordinates> geos) {
//        cityCoordinatesMapper.inserCityCoordinates(geos);
//    }
//
//    @Override
//    public List<CityCoordinates> selectAllGeo() {
//
//        return cityCoordinatesMapper.selectAllGeo();
//    }
}
