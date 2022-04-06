package com.trial.repository;

import org.springframework.data.redis.core.ZSetOperations;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @description: redis实际操作仓库
 * @date: 2021/12/4 00:46
 * @author: luoziwen
 */
public interface RedisCatchRepository {

    /**
     * 功能描述:添加地图数据
     * @param geoKey
     * @param map
     * @return: void
     * @auther: luoziwen
     * @date: 2022/1/10 10:13
     */
    void addBoundGeoOps(String geoKey, Map map);

    /**
     * 功能描述:查询最新的公告
     * @param limit
     * @return: java.lang.String
     * @auther: luoziwen
     * @date: 2022/1/10 10:18
     */
    List<String> queryLatestAnnouncement(String announcementKey, Integer limit);
    /**
     * 功能描述:添加最新的公告
     * @param announcementKey
     * @param message
     * @return: void
     * @auther: luoziwen
     * @date: 2022/1/10 10:19
     */
    void addLatestAnnouncement(String announcementKey, String message);
    /**
     * 功能描述:添加排序所需数据
     * @param scoreRank
     * @param tuples
     * @return: void
     * @auther: luoziwen
     * @date: 2022/4/6 14:23
     */
    void addRankingList(String scoreRank, Set<ZSetOperations.TypedTuple<String>> tuples);
}
