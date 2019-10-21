package com.xiu.utopia.aop.redis.KeyGenerator;

/**
 * key生成策略接口 该接口中只有一个方法为生成对应的key的抽象方法
 */
public interface KeyGeneratorStrategy {

    /**
     * 生成kry
     * @param methodName 方法名
     * @param className 类名
     * @param argsInfo 参数列表
     * @return
     */
     String generator( String methodName,String className, Object[] argsInfo,String[] filedList);

}
