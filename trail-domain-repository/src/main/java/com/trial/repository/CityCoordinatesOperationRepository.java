package com.trial.repository;

import com.trial.factory.CityCoordinatesOperationFactory;
import com.trial.object.pojo.CityCoordinates;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

/**
 * @方法说明:
 * @Description:
 * @Auther: Mr.Luo
 * @Date: 2021/11/22 01:13
 */
@Component
public class CityCoordinatesOperationRepository {



    @Autowired
    private CityCoordinatesOperationFactory cityCoordinatesOperationFactory;

    public void inserCityCoordinates(ArrayList<CityCoordinates> list) {
        cityCoordinatesOperationFactory.inserCityCoordinates(list);
    }
}
