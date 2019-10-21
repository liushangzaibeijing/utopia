package com.xiu.utopia.utils;

import com.alibaba.fastjson.JSONArray;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonAnyFormatVisitor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class RedisUtil {
    private static Logger logger = LoggerFactory.getLogger(RedisUtil.class);

    /**
     * 获取对应key的最长时间
     */
    private static Long maxTime = 50L;

    /**
     * 获取对应key的最长时间
     */
    private static Integer BEGIN = 0;

    private static RedisTemplate<String,Object> redisTemplate  ;

    public static boolean  setEx(String key,String value,Long expireTime){
        return setKey(key,value,expireTime,TimeUnit.SECONDS);
    }

    public static boolean  set(String key,String value){
        ValueOperations<String, Object> stringOperations = redisTemplate.opsForValue();
        stringOperations.set(key,value);
        return true;
    }

    public static void setRedisTemplate(RedisTemplate redisTemplateset){
        if(redisTemplate==null){
            RedisUtil.redisTemplate = redisTemplateset;
        }
    }

    public static boolean  setPx(String key,String value,Long expireTime){
        return setKey(key,value,expireTime,TimeUnit.MILLISECONDS);
    }
    /**
     * 设置字符串 存在也进行删除
     * 是该redisg工具类的字符串操作的底层操作
     * @param key 缓存的key
     * @param value 缓存的value
     * @param expireTime 过期时间数 结合时间单位具体来实现
     * @param timeUnit 时间单位 秒 还是毫秒
     * @return 返回插入的成功与失败
     */
    public static boolean  setKey(String key,String value,Long expireTime, TimeUnit timeUnit){
        ValueOperations<String, Object> stringOperations = redisTemplate.opsForValue();
        if(expireTime==null){
            stringOperations.set(key,value);
            return true;
        }
        stringOperations.set(key,value,expireTime,timeUnit);
        return true;
    }


    public static boolean  setExNx(String key,String value,Long expireTime){
        return setNX(key,value,expireTime,TimeUnit.SECONDS);
    }

    public static boolean setPxNx(String key,String value,Long expireTime){
        return setNX(key,value,expireTime,TimeUnit.MICROSECONDS);
    }

    /**
     * 设置key 不存在添加 存在不添加
     * @param key
     * @param value
     * @param expireTime
     * @param timeUnit
     * @return
     */
    public static boolean setNX(String key,String value,Long expireTime,TimeUnit timeUnit){
        ValueOperations<String, Object> stringOperations = redisTemplate.opsForValue();
        // 该命令 设置key 不存在添加 存在不添加 可以实现分布式锁
        Boolean result = stringOperations.setIfAbsent(key, value);
        if(result!=null && result && expireTime != null){
            redisTemplate.expire(key,expireTime,timeUnit);
            return true;
        }
        return result;
    }

    /**
     * 获取key对应的值
     * @param key
     * @return
     */
    public static String  get(String key){
        ValueOperations<String, Object> stringOperations = redisTemplate.opsForValue();
        // 该命令 设置key 不存在添加 存在不添加 可以实现分布式锁
        String value = (String) stringOperations.get(key);
        return value;
    }

    /**
     * 添加集合列表
     * @param tList
     * @return
     */
    public static <T> Long  addList(String key,List<T> tList){
        ListOperations<String, Object> lisistOperations = redisTemplate.opsForList();
        Long aLong = lisistOperations.leftPushAll(key, tList);
        logger.info("添加的集合列表：{}",aLong);
        return aLong;
    }
    /**
     * 获取集合列表
     * @param key
     * @return
     */
    public static <T> List<T>  getList(String key,Class<T> clazz){
        ListOperations<String, Object> lisistOperations = redisTemplate.opsForList();
        if(lisistOperations.size(key)==0){
            return null;
        }
        JSONArray result = (JSONArray) lisistOperations.range(key,BEGIN,lisistOperations.size(key)).get(0);
        logger.info("添加的集合列表：{}",result.toJSONString());
        List<T> resultList = JsonUtil.readValue(result.toJSONString(), clazz);
        return resultList;
    }




}
