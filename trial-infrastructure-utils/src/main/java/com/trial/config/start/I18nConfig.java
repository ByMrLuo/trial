package com.trial.config.start;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


/**
 * @description: 多语言解析
 * @date: 2021/12/22 15:46
 * @author: luoziwen
 */
@Configuration
public class I18nConfig extends ReloadableResourceBundleMessageSource {

    @Bean(name = "messageSource")
    public ReloadableResourceBundleMessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageBundle = new ReloadableResourceBundleMessageSource();
        messageBundle.setBasenames("classpath:message/message");
        messageBundle.setDefaultEncoding("UTF-8");
        return messageBundle;
    }


}
