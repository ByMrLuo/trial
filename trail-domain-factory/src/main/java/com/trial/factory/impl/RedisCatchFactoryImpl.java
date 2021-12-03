package com.trial.factory.impl;

import com.trial.factory.RedisCatchFactory;
import com.trial.repository.RedisCatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundGeoOperations;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @description:
 * @date: 2021/12/4 00:52
 * @author: luoziwen
 */
@Component
public class RedisCatchFactoryImpl implements RedisCatchFactory {

    @Autowired
    RedisCatchRepository redisCatchRepository;

    @Override
    public void addBoundGeoOps(String geoKey, Map map) {
        redisCatchRepository.addBoundGeoOps(geoKey, map);
    }
}
