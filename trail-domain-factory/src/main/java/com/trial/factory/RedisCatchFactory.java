package com.trial.factory;


import org.springframework.data.redis.core.ZSetOperations;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @description:
 * @date: 2021/12/4 00:44
 * @author: luoziwen
 */
public interface RedisCatchFactory {
    /**
     * 功能描述:添加地图数据
     * @param geoKey
     * @param data
     * @return: void
     * @auther: luoziwen
     * @date: 2022/1/10 10:13
     */
    void addBoundGeoOps(String geoKey, Map data);

    /**
     * 功能描述:获取最新公告
     * @param limit 查询页数
     * @return: java.lang.String
     * @auther: luoziwen
     * @date: 2022/1/10 10:15
     */
    List<String> queryLatestAnnouncement(String announcementKey, Integer limit);
    /**
     * 功能描述:添加新的公告
     * @param announcementKey
     * @param meaasge
     * @return: void
     * @auther: luoziwen
     * @date: 2022/1/10 14:18
     */
    void addLatestAnnouncement(String announcementKey, String meaasge);
    /**
     * 功能描述:添加城市排行
     * @param scoreRank
     * @param tuples
     * @return: void
     * @auther: luoziwen
     * @date: 2022/4/6 11:24
     */
    void addRankingList(String scoreRank, Set<ZSetOperations.TypedTuple<String>> tuples);
    /**
     * 功能描述:对搜索城市进行+1操作
     * @param cityName
     * @return: void
     * @auther: luoziwen
     * @date: 2022/4/7 11:23
     */
    void addHotCity(String key, String cityName);
}
