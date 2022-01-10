package com.trial.repository;

import java.util.List;
import java.util.Map;

/**
 * @description: redis实际操作仓库
 * @date: 2021/12/4 00:46
 * @author: luoziwen
 */
public interface RedisCatchRepository {


    void addBoundGeoOps(String geoKey, Map map);

    List<String> queryLatestAnnouncement(String announcementKey, Integer limit);

    void addLatestAnnouncement(String announcementKey, String message);
}
