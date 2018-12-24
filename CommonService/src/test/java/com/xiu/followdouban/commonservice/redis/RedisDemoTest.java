package com.xiu.followdouban.commonservice.redis;

import com.xiu.followdouban.commonrpc.model.Book;
import com.xiu.followdouban.commonservice.CommonserviceApplication;
import com.xiu.followdouban.commonservice.utils.JsonUtil;
import com.xiu.followdouban.commonservice.utils.RedisKeyUtils;
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

import javax.swing.text.html.parser.Entity;
import java.util.*;
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
public class RedisDemoTest {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;


    /**
     * redis有关key的操作
     * RedisTemplate主要支持String，List,Hash,Set,ZSet这几种方式的参数，
     * 其对应的方法分别是opsForValue()、opsForList()、opsForHash()、opsForSet()、opsForZSet()。
     * 下面分别介绍这几个方法的使用。
     */
    @Test
    public void testRedisKey() {

        //获取操作字符串的操作
        ValueOperations<String, String> stringOperations = redisTemplate.opsForValue();

        Map<String, String> person = new HashMap<>(5);
        person.put("name", "谢奇秀");
        person.put("age", "23");
        person.put("birthday", "1994-10-21");
        person.put("sex", "男");
        stringOperations.multiSet(person);

        //keys  [pattern] 通过通配符获取到匹配的key * 匹配所有字符
        // ？匹配单个字符 [char/chaB/char] 匹配括号中的某个字符

        Set<String> keys = redisTemplate.keys("*");
        log.info("redis中*匹配的所有keys;{}", JsonUtil.gsonString(keys));

        keys = redisTemplate.keys("??me");
        log.info("redis中的所有keys;{}", JsonUtil.gsonString(keys));


        keys = redisTemplate.keys("birthda[xy]");
        log.info("redis中的所有keys;{}", JsonUtil.gsonString(keys));

        //删除key del key1 [key2 ...]
        redisTemplate.delete("name");
        List<String> delkeys = new ArrayList<>();
        delkeys.add("age");
        delkeys.add("sex");
        redisTemplate.delete(delkeys);

        keys = redisTemplate.keys("*");
        log.info("redis中*匹配的所有keys;{}", JsonUtil.gsonString(keys));


        //rename oldkey newkey 给key赋予一个新的name 如果新的key存在则原来的key值被覆盖
        redisTemplate.rename("name", "alias");
        //作用: 把key改名为newkey
        //返回: 发生修改返回true(说明newkey不存在),不发生修改返回false(说明newkey已经存在)
        boolean falg = redisTemplate.renameIfAbsent("name", "alias");
        if (falg) {
            log.info("修改成功");
        } else {
            log.info("修改失败");
        }

        //move key db 将对应的key存放在 一台redis的服务中默认包含16个库 该行操作将key(默认在0)移动到库索引为2中
        //移动没有发生错误 为false  移动发生错误返回true
        falg = redisTemplate.move("alias", 1);
        if (falg) {
            log.info("没有移动");
        } else {
            log.info("已经移动");
        }
        //Set<String> keys = redisTemplate.keys("*");
        log.info("redis中*匹配的所有keys;{}", JsonUtil.gsonString(keys));


        // 获取一个随机的key
        String randomKey = (String) redisTemplate.randomKey();
        log.info("随机下获取的key:{}", randomKey);

        boolean has = redisTemplate.hasKey("name");
        if (has) {
            log.info("存在");
        } else {
            log.info("不存在");
        }

        //获取redis中对应的key的类型
        DataType type = redisTemplate.type("name");
        log.info("redis中对应key的类型为：{}", type.name());

        //设置key的生命周期
        redisTemplate.expire("age", 1000, TimeUnit.MICROSECONDS);

        //查询key的生命周期
        Long expireTime = redisTemplate.getExpire("age");

        log.info("生命周期 -1 表示为持久化 -2表示key不存在 其他的正数为时间单位秒：{}", expireTime);

        //将对应的key持久化
        boolean isExpirst = redisTemplate.persist("age");

    }

    @Test
    public void testAddString() {
        //先获取可以操作redis字符串类型的操作对象
        ValueOperations<String, String> stringOperations = redisTemplate.opsForValue();
        //操作值得二进制表示
        //示范例子 将A 转换为a  A 的ASCII 为65 a的ASCII 为97 两者相差 32 即为二进制上的第六位的值不同
        //A的第六位为0 a的第二位为1 在redis操作值的二进制位上
        stringOperations.set("charcter", "A");
        stringOperations.setBit("charcter", 2, true);

        String value = stringOperations.get("charcter");

        log.info("charcter :{}", value);

        //获取key的二进制值
        boolean bit = stringOperations.getBit("charcter", 3);
        if (bit) {
            log.info("charcter 下的第二位的值：{}", 1);
        } else {
            log.info("charcter 下的第二位的值：{}", 0);
        }


    }

    /**
     * redis相关的字符串类型的操作
     */
    @Test
    public void testRedisString() {
        //先获取可以操作redis字符串类型的操作对象
        ValueOperations<String, String> stringOperations = redisTemplate.opsForValue();

        //设置单个字符串类型的key 默认持久化 且同名key覆盖
        stringOperations.set("title", "redis字符串操作");
        //设置单个字符串类型的key 并设置过期时间 且同名key覆盖
        stringOperations.set("name", "xieqx", 10, TimeUnit.MINUTES);
        //设置单个字符串类型的key 持久化 不存在执行才操作，存在则不执行
        //第一次插入因为存在 所以返回true
        boolean success = stringOperations.setIfAbsent("age", "24");
        log.info(success + "");
        //第二次因为已经存在了 所有返回false
        success = stringOperations.setIfAbsent("age", "24");
        log.info(success + "");

        //一次性设置多个值 同名覆盖
        Map<String, String> kvs = new HashMap<>();
        kvs.put("file", "maven");
        kvs.put("length", "234");
        kvs.put("size", "1024");
        stringOperations.multiSet(kvs);

        //一次性设置多个值 存在则不进行设置
        boolean isSuccess = stringOperations.multiSetIfAbsent(kvs);
        log.info("" + isSuccess);

        //获取其中单个key的值
        String value = (String) stringOperations.get("name");
        log.info("value: {}", value);

        //获取多个key的值
        List<String> keys = new ArrayList<>();
        keys.add("name");
        keys.add("size");
        keys.add("age");
        List<String> values = stringOperations.multiGet(keys);
        log.info("values :{}", JsonUtil.gsonString(values));

        //设置对应key的字符串的偏移量改为value 如果偏移量>字符长度 该字符自动补全以0x00 没有实现
        // 获取对应的key中指定范围的值 没有实现
        stringOperations.append("name", " xiu");

        String name = (String) stringOperations.get("name");
        log.info("name: {}", value);

        //获取旧值设置新值
        String oldName = (String) stringOperations.getAndSet("name", "shizb");

        log.info("oldName :{}" + oldName);

        stringOperations.set("age", "24");
        //自增 整数类型   自减 数值为负数
        stringOperations.increment("age", -22);
        //Error in execution; nested exception is io.lettuce.core.RedisCommandExecutionException:
        // ERR value is not an integer or out of range
        //stringOperations.increment("name",2);
        //自增 浮点数类型(会有精度损失) 自减 数值为负浮点数
        stringOperations.increment("size", 2.3);

    }


    //对于字符串的操作
    @Test
    public void testAdd() {
        ValueOperations<String, String> valueOperations = redisTemplate.opsForValue();
        //写入缓存
        valueOperations.set("name", "无敌破坏王");
        //获取字段值
        String value = valueOperations.get("name");
        log.info("name : {}", value);

        redisTemplate.delete("name");
        value = valueOperations.get("name");
        log.info("name : {}", value);
    }


    /**
     * redis相关的list列表操作
     */
    @Test
    public void testRedisList() {
        //获取操作list的对象
        ListOperations<String, String> listOperations = redisTemplate.opsForList();

        String key = "names";

        //从左边插入值到列表中（即插入到列表的头部）
        listOperations.leftPush(key, "zhangsan");

        //leftPush(key,privot,value)往names中插入key,插入的位置在privot的前面，如果privot不存在,则不会插入
        //在key链表中寻找’search’,并在search值之前(left)|之后(right),.插入value
        listOperations.leftPush(key, "zhangsan", "wangwu");
        //一次性插入多个数据
        listOperations.leftPushAll(key, "xieqx", "qixx", "shzb", "liangzj");
        //只有存在key对应的列表才能将这个value值插入到key所对应的列表中
        listOperations.rightPushIfPresent(key, "xieqx");

        //获取列表中的集合的大小
        Long end = listOperations.size("names");
        //获取列表中指定范围中的数据 返回一个list集合
        List<String> list = listOperations.range("names", 0, end);

        log.info("names list:{}", JsonUtil.gsonString(list));

        //从头部获取并移除列表中的一个元素
        String first = listOperations.leftPop(key);
        log.info("names list first:{}", first);
        //Blpop  从头部获取数据，没有则一直阻塞，直到超时（或者在超时之前获取到该值）
        first = listOperations.leftPop(key, 1, TimeUnit.MINUTES);
        log.info("names list first:{}", first);
        end = listOperations.size("names");
        list = listOperations.range("names", 0, end);

        log.info("names list:{}", JsonUtil.gsonString(list));

        //listOperations.rightPush() rightPushALl rightPushIfPresent 与上边操作的相似，只是一个从左边（头部），一个是从右边（尾部）

        //从列表中删除count绝对值个value（count为负数则从尾部删除，count整数则从头部删除，返回真是删除的值的个数）
        long realRemLen = listOperations.remove(key, 2, "szb");
        log.info("删除了 {}", realRemLen);

        // 剪切key对应的链接,切[start,stop]一段,并把该段重新赋给key
        listOperations.trim(key, 0, 2);

        end = listOperations.size("names");
        list = listOperations.range("names", 0, end);
        log.info("names list:{}", JsonUtil.gsonString(list));

        //lindex key index
        //作用: 返回index索引上的值,
        String value = listOperations.index(key, 2);
        log.info("names list:index下的值{}", value);

    }


    /**
     * redis相关的set操作
     */
    @Test
    public void testRedisSet() {
        //获取set相关的操作对象
        SetOperations<String, String> setOperations = redisTemplate.opsForSet();

        String key = "sores";
        //添加元素
        setOperations.add(key,"12","15","9","13","13");

        //获取元素 ，要么获取所有，要么获取随机的一个，因为set无序
        //获取key下的所有
        Set<String> sets = setOperations.members(key);
        log.info("set 列表：{}",JsonUtil.gsonString(sets));

       String randomValue = setOperations.randomMember(key);
       log.info("randomValue :{}",randomValue);


       List<String> list = setOperations.randomMembers(key,2);
       log.info("随机获取指定个数的集合数据：{}",JsonUtil.gsonString(list));
        //获取多个key无序集合中的元素（去重），count表示个数
        sets =  setOperations.distinctRandomMembers(key,5);
        log.info("set 列表：{}",JsonUtil.gsonString(sets));

       //随机移除一个元素
        String aloenRem = setOperations.pop(key);
        log.info("移除一个元素：{}",aloenRem);
        //随机移除若干个元素
        List<String> removes = setOperations.pop(key,2);
        log.info("移除若干个元素：{}",aloenRem);

        //根据值移除元素 ，值可以为一个或者多个 返回是指删除的元素个数
        long realRemve = setOperations.remove(key,"13","9");
        log.info("real remove element size is ：{}",aloenRem);

        //判断元素是否在集合中
        boolean falg = setOperations.isMember(key,"12");
        log.info("the value is exist ：{}",falg);

        //返回集合中元素的个数
        log.info("the set size is :{}",setOperations.size(key));

        //把source中的value删除,并添加到dest集合中
        boolean success =  setOperations.move(key,"9","outofDate");
        log.info("mcve is success :{}",success);
        sets = setOperations.members("outofDate");
        log.info("set 列表：{}",JsonUtil.gsonString(sets));

        //获取集合中并集，交集，差集
        setOperations.add("A","12","15","9","13","13");
        setOperations.add("B","1","15","4","13","6");

        //获取其中的交集并返回
        sets =  setOperations.intersect("A","B");
        log.info("集合之间的交集 列表：{}",JsonUtil.gsonString(sets));

        //获取其中的交集并存在另一个key中
        setOperations.intersectAndStore("A","B","C");
        sets = setOperations.members("C");
        log.info("集合之间的交集(存储) 列表：{}",JsonUtil.gsonString(sets));

        //获取集合中的交集
        setOperations.union("A","B");
        log.info("集合之间的并集 列表：{}",JsonUtil.gsonString(sets));

        setOperations.unionAndStore("A","B","C");
        sets = setOperations.members("C");
        log.info("集合之间的并集（存储） 列表：{}",JsonUtil.gsonString(sets));

        //获取集合中的差集
        setOperations.difference("A","B");
        log.info("集合之间的差集 列表：{}",JsonUtil.gsonString(sets));

        setOperations.differenceAndStore("A","B","C");
        sets = setOperations.members("C");
        log.info("集合之间的差集（存储） 列表：{}",JsonUtil.gsonString(sets));

    }

    /**
     * redis相关的Sort set操作
     */
    @Test
    public void testRedisSortSet() {
        //获取操作SortSet 操作对象
        ZSetOperations<String,String> zSetOperations = redisTemplate.opsForZSet();

        String key = "names";
        //添加元素
        //单个元素添加
        zSetOperations.add(key,"xieqx",10);

        //添加多个
        Set<ZSetOperations.TypedTuple<String>> set = new HashSet<>();
        DefaultTypedTuple<String> element = new DefaultTypedTuple<String>("szb",9.3);
        DefaultTypedTuple<String> elementA = new DefaultTypedTuple<String>("lzj",9.0);
        DefaultTypedTuple<String> elementB = new DefaultTypedTuple<String>("qxx",8.9);

        set.add(element);
        set.add(elementA);
        set.add(elementB);
        zSetOperations.add(key,set);

        //获取单个值。获取所有值
        //获取 start 到end范围的数据
        Set<String> sets = zSetOperations.range(key,0,2);

        log.info("根据范围获取的值：{}",JsonUtil.gsonString(sets));

        /*
        out(vo.rangeByLex("book", Range.range().lte("f").gte("b")));
        out(vo.rangeByLex("book", Range.range(), Limit.limit().count(2).offset(0)));
        out(vo.rangeByLex("book", Range.range(), Limit.limit().count(2).offset(2)));
         */

        //根据值去筛选数据
        //获取小于等于“value1”大于等于“value2”
        sets = zSetOperations.rangeByLex(key, RedisZSetCommands.Range.range().lte("xieqx").gte("lzj"));
        log.info("根据范围Rangge获取的值：{}",JsonUtil.gsonString(sets));

        //从key中获取从0（偏移量）数量为2的数据信息
        sets = zSetOperations.rangeByLex(key,  RedisZSetCommands.Range.range(), RedisZSetCommands.Limit.limit().count(2).offset(0));
        log.info("根据范围Rangge获取的值：{}",JsonUtil.gsonString(sets));

        //根据得分筛选数据
        sets = zSetOperations.rangeByScore(key,1,950);
        log.info("根据分数范围获取的值：{}",JsonUtil.gsonString(sets));

        sets = zSetOperations.rangeByScore(key,9.0,9.5,1,2);
        log.info("根据分数范围获取的值：{}",JsonUtil.gsonString(sets));

        //根据得分筛选数据 并将分数也会封装在TypedTuple
        Set<ZSetOperations.TypedTuple<String>> typeSet = zSetOperations.rangeByScoreWithScores(key,9.0,9.5,0,3);

         for(ZSetOperations.TypedTuple<String> typedTuple:typeSet){
             log.info("获取的信息：score {}，value {}",typedTuple.getScore(),typedTuple.getValue());
         }

         //返回元素的个数
        long count = zSetOperations.count(key,0,10);
         log.info("所有元素的个数：{}",count);


        String key2 = "names2";
        //添加元素
        //单个元素添加
        zSetOperations.add(key2,"xieqx",4);

        //添加多个
        Set<ZSetOperations.TypedTuple<String>> set2 = new HashSet<>();
        DefaultTypedTuple<String> element2 = new DefaultTypedTuple<String>("szb",3D);
        DefaultTypedTuple<String> element2A = new DefaultTypedTuple<String>("lzj",1D);
        DefaultTypedTuple<String> element2B = new DefaultTypedTuple<String>("qxx",1D);

        set2.add(element);
        set2.add(elementA);
        set2.add(elementB);
        zSetOperations.add(key2,set2);


        zSetOperations.intersectAndStore(key,key,"desc");
        sets = zSetOperations.rangeByScore("desc",0,10);
        log.info("根据分数范围获取的值：{}",JsonUtil.gsonString(sets));

    }


    /**
     * redis相关的Hash操作
     */
    @Test
    public void testRedisHash() {
        //获取操作hash的对象
        HashOperations<String,String,String > hashOperations = redisTemplate.opsForHash();
        String key = "hash";
        //存放单个hash 如果key不存在则存储，否则不存储
        hashOperations.putIfAbsent(key,"1","xieqx");
        hashOperations.putIfAbsent(key,"2","qixx");

        hashOperations.put(key,"3","szb");

        Map<String,String> data = new HashMap<>();
        data.put("4","aaa");
        data.put("5","bbb");
        data.put("6","ccc");
        hashOperations.putAll(key,data);

        //获取单个数据
       String value = hashOperations.get(key,"1");
       log.info("value:{}",value);

       Map<String,String> hashData = hashOperations.entries(key);
       log.info("hashData : {}",JsonUtil.gsonString(hashData));

       //删除 真实删除的数据
        long deleNum = hashOperations.delete(key,"1","2","3");

        //获取hash数据的长度
        long len = hashOperations.size(key);
        log.info("hash 数据长度:{}",len);

        //判断hashKey是否存在
        boolean hasKey = hashOperations.hasKey(key,"123");
        log.info("查看hashkey是否存在：{}",hasKey);

        hashOperations.put(key,"num","123");

        hashOperations.increment(key,"num",5);

        String num = hashOperations.get(key,"num");
        log.info("num:{}",num);

        //获取所有的keys
        Set<String> sets = hashOperations.keys(key);
        log.info("获取hash中所有的key:{}",JsonUtil.gsonString(key));

        //获取所有的values
        List<String> values = hashOperations.values(key);
        log.info("获取hash中所有的key:{}",JsonUtil.gsonString(values));
    }

    @Test
    public void testRedis(){
        String redis = RedisKeyUtils.generatorKey(1, Book.class);
        log.info("redis key : {}",redis);
    }
}