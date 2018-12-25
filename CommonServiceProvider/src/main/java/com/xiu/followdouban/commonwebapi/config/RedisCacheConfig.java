package com.xiu.followdouban.commonwebapi.config;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * author   xieqx
 * createTime  2018/12/9
 * desc 一句话描述该功能
 */
@Configuration
@EnableCaching
public class RedisCacheConfig {

        @Bean
        public RedisTemplate<String, String> redisTemplate(RedisConnectionFactory factory){
            RedisTemplate<String, String> redisTemplate = new RedisTemplate<String,String>();
            redisTemplate.setConnectionFactory(factory);
            // key序列化方式;（不然会出现乱码;）,但是如果方法上有Long等非String类型的话，会报类型转换错误；
            // 所以在没有自己定义key生成策略的时候，以下这个代码建议不要这么写，可以不配置或者自己实现ObjectRedisSerializer
            // 或者JdkSerializationRedisSerializer序列化方式;
            //
            RedisSerializer<String> redisSerializer = new StringRedisSerializer();// Long类型不可以会出现异常信息;
            //设置redis key hashKey的序列化规则
            redisTemplate.setKeySerializer(redisSerializer);
            redisTemplate.setHashKeySerializer(redisSerializer);
            //设置redis value的序列化规则
            redisTemplate.setValueSerializer(redisSerializer);
            redisTemplate.setHashValueSerializer(redisSerializer);
            return redisTemplate;
        }
}
