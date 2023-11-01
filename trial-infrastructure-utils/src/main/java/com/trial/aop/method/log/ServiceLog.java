package com.trial.aop.method.log;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

/**
 * @description:可以配合注解使用，这里我就不在吧注解的方式拿出来了
 * @author: Mr.Luo
 * @create: 2023-11-01 17:58
 **/
@Aspect
@Component
public class ServiceLog {
    /**
     * 第一个“ * ”符号,表示返回值的类型任意，注意后面有一个空格
     * com.trial.service AOP所切的服务的包名，即，需要进行横切的业务类
     *包名后面的“..” 表示当前包及下级所有包
     * 第二个“*” 表示类名，*即所有类
     * .*(..) 表示任何方法名，括号表示参数，两个点表示任何参数类型
     */
    @Pointcut("execution(* com.trial.service..*(..)) " +
              "|| execution(* com.trial.factory..*(..)) " +
              "|| execution(* com.trial.repository..*(..))")
    public void printMethod(){}

//    @Before("printMethod()")
//    public void doBefore(JoinPoint joinPoint){
//
//    }
//
//    @After("printMethod()")
//    public void doAfter(JoinPoint joinPoint){
//
//    }

    @Around("printMethod()")
    public Object doAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        //以前是前置增强
        long start = System.currentTimeMillis();
        Object[] args = proceedingJoinPoint.getArgs();
        //后续日志代替.这里应该是要把参数json化我这就不做了
        System.out.println("参数:" + args);

        String allName = proceedingJoinPoint.getSignature().toString();
        //后续日志代替
        System.out.println("调用类名称及其方法:"+ allName);

        //result为界限，不返回的话只能现在一个调用后面的调用会显示null，且会退出执行
        Object result = proceedingJoinPoint.proceed();
        //以后是后置增强
        long end = System.currentTimeMillis();
        MethodSignature methodSignature = (MethodSignature)proceedingJoinPoint.getSignature();
        StringBuilder stringBuilder = new StringBuilder();
        String clazzName = proceedingJoinPoint.getTarget().getClass().getName();
        stringBuilder.append(clazzName).append(".");
        String methodName = methodSignature.getName();
        stringBuilder.append(methodName);
        System.out.println(stringBuilder.append("方法调用结束，总耗时======") .append(end - start).append("ms").toString());
        return result;
    }

}
