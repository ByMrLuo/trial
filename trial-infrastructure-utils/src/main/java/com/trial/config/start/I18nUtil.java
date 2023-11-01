package com.trial.config.start;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

import java.util.Locale;

/**
 * @description: 多语言配置
 * @date: 2021/12/22 16:52
 * @author: luoziwen
 */
@Component
public class I18nUtil {

    @Autowired
    private MessageSource messageSource;

    /**
     * @param code：对应文本配置的key.
     * @return 对应地区的语言消息字符串
     */

    public String getMessage(String code) {
        return getMessage(code, null);
    }

    public String getMessage(String code, Object[] args) {
        return getMessage(code, args, "");
    }

    public String getMessage(String code, Object[] args, String defaultMsg) {
        //这里使用比较方便的方法，不依赖request.
//        Locale locale = LocaleContextHolder.getLocale();
        Locale locale = Locale.US;
        return messageSource.getMessage(code, args, defaultMsg, locale);
    }

}
