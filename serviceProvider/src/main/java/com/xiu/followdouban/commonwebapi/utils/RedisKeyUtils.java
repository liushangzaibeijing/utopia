package com.xiu.followdouban.commonwebapi.utils;

/**
 * 操作redis操作的相关工具类
 */
public class RedisKeyUtils {

    /**
     * 生成唯一的key
     */
    /**
     * 生成单个数据库实体对应的key
     * @param id 数据主键
     * @param clazz 实体类对应的类信息
     * @return 生成的 包名_类名_id类型的key
     */
    public static String generatorKey(Integer id,Class clazz){
        String fullClassName = clazz.getCanonicalName();

        String redisKey = fullClassName+"_"+id;

        return  redisKey;
    }
}
