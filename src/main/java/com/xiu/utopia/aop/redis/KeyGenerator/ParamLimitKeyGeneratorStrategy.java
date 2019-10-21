package com.xiu.utopia.aop.redis.KeyGenerator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 默认的策略生成实现类
 */
public class ParamLimitKeyGeneratorStrategy implements KeyGeneratorStrategy {
    private static final Logger logger = LoggerFactory.getLogger(ParamLimitKeyGeneratorStrategy.class);
    /**
     * 根据类名方法名生成对应的key 不适用参数
     * @param methodName 方法名
     * @param className 类名
     * @param argsInfo 参数列表
     * @return
     */
    @Override
    public String generator(String className, String methodName, Object[] argsInfo,String[] fieldList) {
        StringBuffer keyBuilder = new StringBuffer();
        keyBuilder.append(className+"_");
        keyBuilder.append(methodName+"_");
        //参数
        for(Object arg:argsInfo){
//            String.valueOf(arg);
//            keyBuilder.append(+"_");
        }
        String key = keyBuilder.substring(0, keyBuilder.length() - 1);
        logger.info("生成的key为：{}",key);
        return key;
    }
}
