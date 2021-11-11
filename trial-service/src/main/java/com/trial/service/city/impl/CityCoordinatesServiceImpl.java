package com.trial.service.city.impl;

import com.trial.mapper.CityCoordinatesMapper;
import com.trial.pojo.CityCoordinates;
import com.trial.pojo.Geo;
import com.trial.service.city.CityCoordinatesService;
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

    @Autowired
    private CityCoordinatesMapper cityCoordinatesMapper;

    @Override
    public void inserCityCoordinates(List<CityCoordinates> geos) {
        cityCoordinatesMapper.inserCityCoordinates(geos);
    }

    @Override
    public List<CityCoordinates> selectAllGeo() {

        return cityCoordinatesMapper.selectAllGeo();
    }
}
