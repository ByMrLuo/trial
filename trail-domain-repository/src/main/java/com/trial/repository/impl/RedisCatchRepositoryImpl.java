package com.trial.repository.impl;

import com.trial.repository.RedisCatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundGeoOperations;
import org.springframework.data.redis.core.DefaultTypedTuple;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @description:
 * @date: 2021/12/4 00:45
 * @author: luoziwen
 */
@Component
public class RedisCatchRepositoryImpl implements RedisCatchRepository {

    @Autowired
    RedisTemplate redisTemplate;

    /**
     * 功能描述:添加地图数据
     * @param geoKey
     * @param map
     * @return: void
     * @auther: luoziwen
     * @date: 2022/1/10 10:19
     */
    @Override
    public void addBoundGeoOps(String geoKey, Map map) {
        BoundGeoOperations boundGeoOperations = redisTemplate.boundGeoOps(geoKey);
        boundGeoOperations.add(map);
        //添加热门城市排行
    }

    /**
     * 功能描述:查询最新的公告
     * @param limit
     * @return: void
     * @auther: luoziwen
     * @date: 2022/1/10 10:19
     */
    @Override
    public List<String> queryLatestAnnouncement(String announcementKey, Integer limit) {
        //获取指定未知的数据
//        String index = redisTemplate.opsForList().index(announcementKey, limit);
        List<String> range = redisTemplate.boundListOps(announcementKey).range(0, limit);
        return range;
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
        redisTemplate.opsForList().leftPush(announcementKey, meaasge);
    }


    /**
     * 功能描述:排行榜
     * @param scoreRank
     * @param tuples
     * @return: void
     * @auther: luoziwen
     * @date: 2022/1/10 10:19
     */
    @Override
    public void addRankingList (String scoreRank, Set<ZSetOperations.TypedTuple<String>> tuples) {
        redisTemplate.opsForZSet().add(scoreRank, tuples);
    }

    @Override
    public void addHotCity(String key, String cityName) {
        redisTemplate.opsForZSet().incrementScore(key, cityName, 1);
    }
}
