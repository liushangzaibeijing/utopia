package com.xiu.utopia.test;

import com.xiu.utopia.UtopiaApplication;
import com.xiu.utopia.annonation.Cache;
import com.xiu.utopia.busConvert.TagConvert;
import com.xiu.utopia.entity.Song;
import com.xiu.utopia.utils.JsonUtil;
import com.xiu.utopia.utils.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * author  Administrator
 * date   2018/10/24
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = UtopiaApplication.class)
@WebAppConfiguration
public class RedisServiceTest {

  @Autowired
  RedisTemplate<Object,Object> redisTemplate;

  @Test
  public  void  redisString(){
      RedisUtil.setKey("name","谢奇秀",50L, TimeUnit.SECONDS);
      CopyOnWriteArrayList o  = new CopyOnWriteArrayList();
      o.add(new String("222"));
      o.get(0);
      ReentrantReadWriteLock o1 = new ReentrantReadWriteLock();
      o1.readLock().lock();
      o1.writeLock();
      HashMap map = new HashMap();
      map.put("ss","ee");
      RedisUtil.setNX("name","张安",50L,TimeUnit.SECONDS);
  }

    @Test
    @Cache(returnClass = String.class)
    public  void  redisList(){
        List<Song> songList = new ArrayList<>();
        for(int i = 0;i<10;i++){
            Song song = new Song();
            song.setId(1);
            song.setSongName("歌曲"+i);
            song.setSongType("单曲");
            song.setSongAttr("设置");
            songList.add(song);
        }

        RedisUtil.addList("songAllPageNumber",songList);
    }


    @Test
    public  void  redisGetList(){
        List<Song> songPage = RedisUtil.getList("songAllPageNumber", Song.class);

        System.out.println("歌曲信息："+JsonUtil.obj2str(songPage));
    }


    @Test
    public void testAnnotation() throws NoSuchMethodException {
        Method redisList = RedisServiceTest.class.getMethod("redisList");
        Cache annotation = redisList.getAnnotation(Cache.class);

        System.out.println(annotation.name());
    }



}
