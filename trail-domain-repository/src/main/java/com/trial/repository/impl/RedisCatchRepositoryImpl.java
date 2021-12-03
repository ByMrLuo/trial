package com.trial.repository.impl;

import com.trial.repository.RedisCatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundGeoOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @description:
 * @date: 2021/12/4 00:45
 * @author: luoziwen
 */
@Component
public class RedisCatchRepositoryImpl implements RedisCatchRepository {

    @Autowired
    RedisTemplate redisTemplate;

    @Override
    public void addBoundGeoOps(String geoKey, Map map) {
        BoundGeoOperations boundGeoOperations = redisTemplate.boundGeoOps(geoKey);
        boundGeoOperations.add(map);
    }
}
