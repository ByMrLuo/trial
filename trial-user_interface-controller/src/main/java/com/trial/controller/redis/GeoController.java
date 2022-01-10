package com.trial.controller.redis;

import com.alibaba.fastjson.JSONObject;
import com.trial.factory.RedisCatchFactory;
import com.trial.object.vo.HttpResponse;
import com.trial.service.city.impl.CityCoordinatesServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.*;
import org.springframework.data.redis.connection.RedisGeoCommands;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @description:
 * 这是一个对于各省市坐标的一个操作，查看周边的的省市的一些操作
 * @date: 2020/7/28 11:40
 * @author: luoziwen
 */
@RestController
@RequestMapping("/geo")
public class GeoController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

//    @Autowired
//    private PersonnelInformationService personnelInformationService;

    @Autowired
    private CityCoordinatesServiceImpl cityCoordinatesService;

    @Autowired
    private RedisCatchFactory redisCatchFactory;

    /**
     * 功能描述:向数据库插入各省市坐标
     * @param
     * @return: java.lang.String 其实返回这这里 应该是有一个对应的类相对应的，
     *          这里都是常识性规范，我就简化了
     * @auther: luoziwen
     * @date: 2020/7/28 11:43
     */
    @GetMapping("/insertGeo")
    public HttpResponse inserCityCoordinates(){

        HttpResponse httpResponse = cityCoordinatesService.insertCityCoordinates();

        System.out.println(JSONObject.toJSONString(httpResponse));
        return httpResponse;
    }
    /**
     * 功能描述:在redis缓存各省市geo数据
     * @param
     * @return: java.lang.String
     * @auther: luoziwen
     * @date: 2020/7/28 11:44
     */
    @GetMapping("/redisAdd")
    public String redisAdd(){



        return "缓存完毕";
    }


    @GetMapping("/findGeo")
    public List findGeo(){
        //设置中心坐标(此坐标为杭州:[120.19,30.26])
        Point point = new Point(120.19, 30.26);
        //设置计量单位km
        Metric metric = RedisGeoCommands.DistanceUnit.KILOMETERS;
        //设置半径
        Distance distance = new Distance(200, metric);
        //Circle对象是封装覆盖的面积，需要的要素为中心点坐标Point对象、半径（radius）、计量单位（metric）
        Circle circle = new Circle(point, distance);
        //GeoRadiusCommandArgs用来封装GEORADIUS的一些可选命令参数，WITHCOORD、COUNT、ASC等，
        // 例如我们需要在返回结果中包含坐标、中心距离、由近到远排序的前20条数据：
        RedisGeoCommands.GeoRadiusCommandArgs geoRadiusCommandArgs = RedisGeoCommands.GeoRadiusCommandArgs
                .newGeoRadiusArgs().includeDistance()
                .includeCoordinates().sortAscending().limit(20);
        //参数分别为坐标集key键，所选的为圆心的覆盖范围，还有redis的操作命令，获得结果集
//        GeoResults<RedisGeoCommands.GeoLocation<String>> radius = redisTemplate.opsForGeo().radius(GEO_KEY, circle, geoRadiusCommandArgs);
        ArrayList<Object> list = new ArrayList<>();
//        if (radius != null) {
//            radius.forEach(geoLocationGeoResult -> {
//                HashMap map = new HashMap<>();
//                RedisGeoCommands.GeoLocation<String> content = geoLocationGeoResult.getContent();
//                //member 名称  如  tianjin
//                String name = content.getName();
//                // 对应的经纬度坐标
//                Point pos = content.getPoint();
//                // 距离中心点的距离
//                Distance dis = geoLocationGeoResult.getDistance();
//                map.put("pos", pos);
//                map.put("dis", dis);
//                map.put("name", name);
//                list.add(map);
//            });
//        }
        return list;
    }

    @GetMapping("/queryLatestAnnouncement")
    public List<String>  queryLatestAnnouncement(){
        return redisCatchFactory.queryLatestAnnouncement("announcement", 1);
    }

    @GetMapping("/addLatestAnnouncement")
    public String  addLatestAnnouncement(String message){
        redisCatchFactory.addLatestAnnouncement("announcement", message);
        return "success";
    }

}
