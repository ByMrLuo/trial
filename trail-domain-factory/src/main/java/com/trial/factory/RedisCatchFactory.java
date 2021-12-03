package com.trial.factory;


import java.util.Map;

/**
 * @description:
 * @date: 2021/12/4 00:44
 * @author: luoziwen
 */
public interface RedisCatchFactory {

    void addBoundGeoOps(String geoKey, Map map);
}
