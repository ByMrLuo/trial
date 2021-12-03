package com.trial.repository;

import java.util.Map;

/**
 * @description:
 * @date: 2021/12/4 00:46
 * @author: luoziwen
 */
public interface RedisCatchRepository {


    void addBoundGeoOps(String geoKey, Map map);
}
