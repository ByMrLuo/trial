package com.trial.controller.index;

import com.trial.config.start.I18nUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @description: 服务测试页
 * @date: 2020/7/14 18:59
 * @author: luoziwen
 */
@RestController
public class IndexController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    I18nUtil i18nUtil;

    @RequestMapping("/index")
    public String index(){
        return "hello world!";
    }

    @RequestMapping("/langue")
    public String langue(){
        return i18nUtil.getMessage("hello", null);
    }
}
