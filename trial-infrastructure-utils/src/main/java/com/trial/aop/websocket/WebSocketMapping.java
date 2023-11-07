package com.trial.aop.websocket;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @description: 标识注解，需要进行webSocket通信的接口
 * @author: Mr.Luo
 * @create: 2023-11-07 16:09
 **/
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface WebSocketMapping {
}
