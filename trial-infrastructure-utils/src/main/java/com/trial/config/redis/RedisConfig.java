package com.trial.config.redis;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.jsontype.impl.LaissezFaireSubTypeValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * @description: redis连接配置(防止乱码)
 * @date: 2020/7/15 11:24
 * @author: luoziwen
 */
@Configuration
public class RedisConfig {

    @Bean("redisTemplate")
    public RedisTemplate<String, Object> template(RedisConnectionFactory factory) {
        // 创建RedisTemplate<String, Object>对象
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        // 配置连接工厂
        template.setConnectionFactory(factory);

        ObjectMapper objectMapper = new ObjectMapper();
        // 定义Jackson2JsonRedisSerializer序列化对象（默认使用jdk）
        Jackson2JsonRedisSerializer<Object> jacksonSeial = new Jackson2JsonRedisSerializer<>(Object.class);
        // 指定要序列化的域，field,get和set,以及修饰符范围，ANY是都有包括private和public
        objectMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        // 指定序列化输入的类型
        /**
           DefaultTyping有四个选项：
             JAVA_LANG_OBJECT: 当对象属性类型为Object时生效；
             OBJECT_AND_NON_CONCRETE: 当对象属性类型为Object或者非具体类型（抽象类和接口）时生效；
             NON_CONCRETE_AND+_ARRAYS: 同上, 另外所有的数组元素的类型都是非具体类型或者对象类型；
             NON_FINAL: 对所有非final类型或者非final类型元素的数组。
        */
        objectMapper.activateDefaultTyping( LaissezFaireSubTypeValidator.instance , ObjectMapper.DefaultTyping.NON_FINAL, JsonTypeInfo.As.WRAPPER_ARRAY);
        jacksonSeial.setObjectMapper(objectMapper);
        //key的序列化方式
        StringRedisSerializer stringSerial = new StringRedisSerializer();
        // redis key 序列化方式使用stringSerial
        template.setKeySerializer(stringSerial);
        // redis value 序列化方式使用jackson
        template.setValueSerializer(jacksonSeial);
        // redis hash key 序列化方式使用stringSerial
        template.setHashKeySerializer(stringSerial);
        // redis hash value 序列化方式使用jackson
        template.setHashValueSerializer(jacksonSeial);

        template.setEnableDefaultSerializer(true);
        template.afterPropertiesSet();
        return template;
    }
}
