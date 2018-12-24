package com.xiu.followdouban.commonservice.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;


/**
 * 使用切面类来查看controller接口的执行时间
 */
@Aspect
@Slf4j
@Component
public class TimeCostAspect {

    //后期 切入点 可以为指定的注解（比如时间花费注解，日志注解等）
    @Pointcut("@annotation(com.xiu.followdouban.commonservice.annonation.TimeCostAnnotation)")
    public void timecostAnonation() {
    }

    /**
     * 注解形式的AOP使用
     * @param pjp
     * @return
     * @throws Throwable
     */
    @Around("timecostAnonation()")
    public Object aroundAnnotation(ProceedingJoinPoint pjp) throws Throwable {
        return invokeHandler(pjp);
    }


    /**
     * 使用范围相关的aop execution 表达式实现
     */
    //后期 切入点 可以为指定的注解（比如时间花费注解，日志注解等）
    @Pointcut("execution(public * com.xiu.followdouban.commonservice.service.impl..*.*(..))")
    public void timecostAnonationAll() {
    }

    @Around("timecostAnonationAll()")
    public Object aroundAnnotationAll(ProceedingJoinPoint pjp) throws Throwable {
        return invokeHandler(pjp);
    }

    private Object invokeHandler(ProceedingJoinPoint pjp) throws Throwable {
        long startTime = System.currentTimeMillis();

        Object o;
        try {
            //执行当前切入点方法
            o = pjp.proceed(pjp.getArgs());
        } catch (Throwable var7) {
            String message = var7.getClass().getName() + " / " + var7.getMessage() + " / " + var7.getStackTrace()[0];
            log.error("error", message);
            throw var7;
        }

        //获取当前执行方法名称
        Signature s = pjp.getSignature();
        MethodSignature ms = (MethodSignature)s;
        String methodName = ms.getMethod().getName();

        log.info("time cost " + (System.currentTimeMillis() - startTime) + " ms  path is " + pjp.getTarget().getClass().getName() +"."+methodName);
        //logger.info("[time cost] " + (System.currentTimeMillis() - startTime) + " ms [path is " +ms.toString()+ "]");

        return o;
    }

}