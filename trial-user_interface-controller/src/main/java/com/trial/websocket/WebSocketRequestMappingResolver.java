package com.trial.websocket;

import com.mysql.cj.util.StringUtils;
import com.trial.aop.websocket.WebSocketMapping;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.FrameworkServlet;

import javax.servlet.ServletContext;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;

/**
 * @description:
 * @author: Mr.Luo
 * @create: 2023-11-07 22:44
 **/
@Component("webSocketRequestMappingResolver")
public class WebSocketRequestMappingResolver {
    /**
     * menthod,controller,params,result 的ConcurrentHashMap
     *
     * */

    public void init(){

        WebApplicationContext context = ContextLoader.getCurrentWebApplicationContext();
        ServletContext servletContext = context.getServletContext();
        if(servletContext == null){

        }

        WebApplicationContext rootContext = (WebApplicationContext) servletContext.getAttribute(FrameworkServlet.SERVLET_CONTEXT_PREFIX+ "springmvc");
        Map<String, Object> tcpControllers = rootContext.getBeansWithAnnotation(WebSocketMapping.class);
        tcpControllers.values().forEach(cls->{
            RequestMapping classRequestMapping = cls.getClass().getAnnotation(RequestMapping.class);
            String prefix = classRequestMapping != null ? "/api" + classRequestMapping.value()[0] + "/api": "";
            Method[] methods = prefix.getClass().getMethods();
            List<Method> methodsList = Arrays.asList(methods).stream().filter(m -> m.isAnnotationPresent(WebSocketMapping.class) && m.isAnnotationPresent(RequestMapping.class)).collect(Collectors.toList());
            methodsList.forEach(m ->{
                WebSocketMapping webSocketMapping = m.getAnnotation(WebSocketMapping.class);
                RequestMapping requestMapping = m.getAnnotation(RequestMapping.class);
                /**
                 * 将这些参数放到对应的集合内
                 * menthod,controller,params,result 的ConcurrentHashMap
                 * */

            });
        });
    }


    public void excute(/**请求入参*/) throws Exception{
        if(true){
            init();
        }
        //获取方法

        //获取类

        //获取参数

        //发mq
        handleMqRequest();

        //填充上下文变量

        //判定类型并return
    }

    private void handleMqRequest(){

    }
}
