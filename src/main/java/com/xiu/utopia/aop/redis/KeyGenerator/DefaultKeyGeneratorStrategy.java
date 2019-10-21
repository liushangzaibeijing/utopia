package com.xiu.utopia.aop.redis.KeyGenerator;

/**
 * 默认的策略生成实现类
 */
public class DefaultKeyGeneratorStrategy implements KeyGeneratorStrategy {
    /**
     * 根据类名方法名生成对应的key 不适用参数
     * @param methodName 方法名
     * @param className 类名
     * @param argsInfo 参数列表
     * @return
     */
    @Override
    public String generator(String className, String methodName, Object[] argsInfo,String[] filedList) {
        return className+"_"+methodName;
    }
}
