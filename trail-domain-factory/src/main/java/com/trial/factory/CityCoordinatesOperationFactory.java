package com.trial.factory;

import com.trial.mapper.CityCoordinatesMapper;
import com.trial.pojo.CityCoordinates;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

/**
 * @方法说明:工厂是与mapper做交互
 * @Description:
 * @Auther: Mr.Luo
 * @Date: 2021/11/22 01:11
 */
@Component
public class CityCoordinatesOperationFactory {

    @Autowired
    private CityCoordinatesMapper cityCoordinatesMapper;


    public void inserCityCoordinates(ArrayList<CityCoordinates> list) {
        cityCoordinatesMapper.inserCityCoordinates(list);
    }
}
