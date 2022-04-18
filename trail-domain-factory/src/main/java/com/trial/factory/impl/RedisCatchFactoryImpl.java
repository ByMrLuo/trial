package com.trial.factory.impl;

import com.trial.factory.RedisCatchFactory;
import com.trial.repository.RedisCatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundGeoOperations;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @description:
 * @date: 2021/12/4 00:52
 * @author: luoziwen
 */
@Component
public class RedisCatchFactoryImpl implements RedisCatchFactory {

    @Autowired
    RedisCatchRepository redisCatchRepository;
    /**
     * 功能描述:添加地图数据
     * @param geoKey
     * @param map
     * @return: void
     * @auther: luoziwen
     * @date: 2022/1/10 10:13
     */
    @Override
    public void addBoundGeoOps(String geoKey, Map map) {
        redisCatchRepository.addBoundGeoOps(geoKey, map);
    }

    /**
     * 功能描述:查询最新的公告
     * @param limit
     * @return: java.lang.String
     * @auther: luoziwen
     * @date: 2022/1/10 10:18
     */
    @Override
    public List<String> queryLatestAnnouncement(String announcementKey, Integer limit) {
        return redisCatchRepository.queryLatestAnnouncement(announcementKey, limit);
    }


    /**
     * 功能描述:添加最新的公告
     * @param announcementKey
     * @param meaasge
     * @return: void
     * @auther: luoziwen
     * @date: 2022/1/10 10:19
     */
    @Override
    public void addLatestAnnouncement(String announcementKey, String meaasge) {
        redisCatchRepository.addLatestAnnouncement(announcementKey, meaasge);
    }

    /**
     * 功能描述:添加排序所需数据
     * @param scoreRank
     * @param tuples
     * @return: void
     * @auther: luoziwen
     * @date: 2022/4/6 14:23
     */
    @Override
    public void addRankingList(String scoreRank, Set<ZSetOperations.TypedTuple<String>> tuples) {
        redisCatchRepository.addRankingList(scoreRank, tuples);
    }

    @Override
    public void addHotCity(String key, String cityName) {
        redisCatchRepository.addHotCity(key, cityName);
    }
}
