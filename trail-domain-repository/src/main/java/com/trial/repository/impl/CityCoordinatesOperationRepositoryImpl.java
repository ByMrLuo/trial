package com.trial.repository.impl;

import com.trial.mapper.CityCoordinatesMapper;
import com.trial.object.pojo.CityCoordinates;
import com.trial.repository.CityCoordinatesOperationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;

/**
 * @方法说明:
 * @Description:仓库只有简单的增删改查
 * @Auther: Mr.Luo
 * @Date: 2021/11/22 01:13
 */
@Component
public class CityCoordinatesOperationRepositoryImpl implements CityCoordinatesOperationRepository {

    @Autowired
    private CityCoordinatesMapper cityCoordinatesMapper;

    @Transactional(rollbackFor = RuntimeException.class)
    public void inserCityCoordinates(ArrayList<CityCoordinates> list) {

        cityCoordinatesMapper.inserCityCoordinates(list);
    }
}
