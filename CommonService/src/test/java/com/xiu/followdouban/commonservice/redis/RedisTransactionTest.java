package com.xiu.followdouban.commonservice.redis;

import com.xiu.followdouban.commonservice.CommonserviceApplication;
import com.xiu.followdouban.commonservice.utils.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.DataType;
import org.springframework.data.redis.connection.RedisZSetCommands;
import org.springframework.data.redis.core.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import sun.nio.ch.ThreadPool;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/**
 * author   xieqx
 * createTime  2018/12/9
 * desc 一句话描述该功能
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = CommonserviceApplication.class)
@WebAppConfiguration
public class RedisTransactionTest {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;


    /**
     * redis的事务操作
     */
    @Test
    public void testTransaction(){
        ValueOperations<String,String> stringOper = redisTemplate.opsForValue();
        stringOper.set("张三","10000");
        stringOper.set("李四","10000");

        //开启redis的事务支持
        redisTemplate.setEnableTransactionSupport(true);
        //开启事务
        redisTemplate.multi();

         //执行转账操作 张三 减去500 李四加上500
        stringOper.increment("张三",-500);
        stringOper.increment("李四",500);

        //取消操作 则上面的转账命令不会执行,则两人的金额不会发生改变
        //redisTemplate.discard();
        //执行操作，转账成功
        redisTemplate.exec();

        String  zhangsanMoney = stringOper.get("张三");
        String lisimoney = stringOper.get("李四");

        log.info("redis discard取消(没有发生变量) 转账后张三的资金：{}，李四的资金：{}",zhangsanMoney,lisimoney);
    }


    /**
     * redis的乐观锁
     */
    @Test
    public void testoptimisticLock(){
        ValueOperations<String,String> operations = redisTemplate.opsForValue();
        operations.set("ticket","1");

        redisTemplate.watch("ticket");

        //开启redis的事务支持
        redisTemplate.setEnableTransactionSupport(true);
        //开启事务
        redisTemplate.multi();

        ValueOperations<String,String> stringOper = redisTemplate.opsForValue();
        stringOper.increment("ticket",-1);

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        redisTemplate.exec();
        log.info("当前票数：{}",stringOper.get("ticket"));

    }


}