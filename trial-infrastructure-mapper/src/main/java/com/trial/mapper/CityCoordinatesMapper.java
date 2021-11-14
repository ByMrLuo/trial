package com.trial.mapper;

import com.trial.pojo.CityCoordinates;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @description:
 * @date: 2020/7/27 15:27
 * @author: luoziwen
 */
@Mapper
public interface CityCoordinatesMapper {
    /**
     * 功能描述:添加各省市坐标
     * @param geos
     * @return: void
     * @auther: luoziwen
     * @date: 2020/7/27 16:51
     */
    void inserCityCoordinates(@Param("geosList") List<CityCoordinates> geos);
    /**
     * 功能描述:获取所有坐标
     * @param
     * @return: java.util.List<com.trial.pojo.CityCoordinates>
     * @auther: luoziwen
     * @date: 2020/7/27 18:46
     */
    List<CityCoordinates> selectAllGeo();
}
