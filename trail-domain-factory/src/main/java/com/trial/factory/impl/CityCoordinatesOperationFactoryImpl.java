package com.trial.factory.impl;

import com.trial.factory.CityCoordinatesOperationFactory;
import com.trial.object.pojo.CityCoordinates;
import com.trial.repository.impl.CityCoordinatesOperationRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

/**
 * @Description: 工厂是与仓库做交互，组装领域需要的实体/值对象
 * @Auther: Mr.Luo
 * @Date: 2021/11/22 01:11
 */
@Component
public class CityCoordinatesOperationFactoryImpl implements CityCoordinatesOperationFactory {

    @Autowired
    private CityCoordinatesOperationRepositoryImpl cityCoordinatesOperationRepository;

    @Override
    public void inserCityCoordinates(ArrayList<CityCoordinates> list) {

        cityCoordinatesOperationRepository.inserCityCoordinates(list);
    }
}
