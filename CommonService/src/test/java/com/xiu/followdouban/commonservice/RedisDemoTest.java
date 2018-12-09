package com.xiu.followdouban.commonservice;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * author   xieqx
 * createTime  2018/12/9
 * desc 一句话描述该功能
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = CommonserviceApplication.class)
@WebAppConfiguration
public class RedisDemoTest {

    @Autowired
    private RedisTemplate redisTemplate;


    //对于字符串的操作
    @Test
    public void testAdd(){
        ValueOperations<String,String> valueOperations = redisTemplate.opsForValue();

        //写入缓存
        valueOperations.set("name","无敌破坏王");

        //获取字段值
        String value = valueOperations.get("name");

        log.info("name : {}",value);


        redisTemplate.delete("name");

        value = valueOperations.get("name");

        log.info("name : {}",value);



    }
}
