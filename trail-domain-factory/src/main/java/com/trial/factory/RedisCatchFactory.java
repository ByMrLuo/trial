package com.trial.factory;


import java.util.List;
import java.util.Map;

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
}
