package com.trial.controller.zookeeper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @date: 2021/11/12 13:48
 * @author: luoziwen
 */
@RestController
@RequestMapping("/zookeeper")
public class ZookeeperController {

    @RequestMapping("/")
    public String home() {
        return "Hello World";
    }

}
