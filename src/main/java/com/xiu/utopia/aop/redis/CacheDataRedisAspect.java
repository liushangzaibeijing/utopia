package com.xiu.utopia.aop.redis;

import com.xiu.utopia.annonation.Cache;
import com.xiu.utopia.aop.redis.KeyGenerator.DefaultKeyGeneratorStrategy;
import com.xiu.utopia.aop.redis.KeyGenerator.ParamKeyGeneratorStrategy;
import com.xiu.utopia.aop.redis.KeyGenerator.ParamLimitKeyGeneratorStrategy;
import com.xiu.utopia.utils.JsonUtil;
import com.xiu.utopia.utils.RedisUtil;
import org.apache.commons.lang.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.List;

/**
 * 切面缓存数据信息 使用注解的形式
 */
@Aspect
@Component
public class CacheDataRedisAspect {


        private static final Logger logger = LoggerFactory.getLogger(CacheDataRedisAspect.class);

        // 后期 切入点 可以为指定的注解（比如缓存注解等）
        //需要实现一个相关的注解
        @Pointcut("@annotation(com.xiu.utopia.annonation.Cache)")
        public void cacheAnonation() {}

        /**
         * 添加缓存的切面环绕通知
         * @param pjp 切入点
         * @return 查询出来数据的结果
         * @throws Throwable
         */
        @Around("cacheAnonation()")
        public String cache(ProceedingJoinPoint pjp) throws Throwable {
            //获取拦截的方法对应的类
            Class clazz = pjp.getTarget().getClass();
            //获取类名
            String className = clazz.getSimpleName();
            //获取切入点对应的方法
            MethodSignature methodSignature = ( MethodSignature) pjp.getSignature();
            String methodName = methodSignature.getName();
            Cache cacheAnnotation = methodSignature.getMethod().getDeclaredAnnotation(Cache.class);
            //获取参数信息
            Object[] argsInfo = pjp.getArgs();

            String key = getKey(cacheAnnotation, className, methodName, argsInfo);


            String result = RedisUtil.get(key);
            if(StringUtils.isBlank(result)){
                logger.info("未命中缓存,从数据库中获取数据");
                //执行方法
                Object proceed = pjp.proceed();
                result = String.valueOf(proceed);
                RedisUtil.set(key,result);

            }
            logger.info("命中缓存 key:{}",key);
            return result;
        }


    /**
     * 获取key的结果
     * @param cahceAnnotation 缓存注解
     * @param className 类名
     * @param methodName 方法名
     * @param argsInfo 参数类型
     * @return
     */
        public String getKey(Cache cahceAnnotation,String className,String methodName,Object[] argsInfo){
            String name = cahceAnnotation.name();
            String key = cahceAnnotation.key();

            String keyGenerator = cahceAnnotation.keyGenerator();

            if(StringUtils.isNotBlank(keyGenerator)){
                return keyGenerator(keyGenerator, className,methodName,argsInfo);
            }
            if(StringUtils.isNotBlank(name)){
                return name;
            }

            if(StringUtils.isNotBlank(key)){
                return key;
            }
            return keyGenerator("DEFAULT", className,methodName,argsInfo);
        }

    /**
     * key生成策略 具体实现生成key的业务逻辑
      * @param keyGenerator
     * @param className
     * @param methodName
     * @param argsInfo
     * @return
     */
    private String keyGenerator(String keyGenerator,String className,String methodName,Object[] argsInfo) {
         if("default".equalsIgnoreCase(keyGenerator)){
             //默认使用类名+方法名 之间以“_”分隔
             return new DefaultKeyGeneratorStrategy().generator(className,methodName,null,null);
         }
        if("param".equalsIgnoreCase(keyGenerator)){
             //使用类名+方法名+全部参数 之间以“_”分隔
            return new ParamKeyGeneratorStrategy().generator(className,methodName,argsInfo,null);
        }
        if("paramLimit".equalsIgnoreCase(keyGenerator)){
            //使用类名+方法名+部分参数 之间以“_”分隔 目前没有具体的实现
            return new ParamLimitKeyGeneratorStrategy().generator(className,methodName,argsInfo,null);
        }
        return  null;
    }
}
