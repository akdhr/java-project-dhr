package com.dhr.redis.util;

import com.dhr.redis.Constans;
import org.springframework.data.redis.core.RedisTemplate;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @Description :注释
 * Created by duanhr30063 on 2017/12/8.
 */

public class JedisPoolTest {

    //redis工具
    private static RedisTemplate<String, String> redisTemplate;
    private static JedisPool jedisPool;

    private JedisPoolTest() {
    }

    /**
     * 获取redis池资源连接
     * @return
     */
    public static JedisPool getJedisPool() {
        synchronized (JedisPoolTest.class) {
            if (null == jedisPool) {
                //可更改为spring加载redis配置
                JedisPoolConfig config = new JedisPoolConfig();
                jedisPool = new JedisPool(config, Constans.IP, Constans.PORT, 60000, Constans.PASSWORD, Constans.db);
            }
        }
        return jedisPool;
    }


    public static void main(String args[]) {

//        System.out.println(getJedisPool());
//        System.out.println(getJedisPool());
        JedisPool jedisPoolInstance = getJedisPool();
        //获取一个jedis实例
        Jedis jedis = jedisPoolInstance.getResource();
        Jedis jedis2 = jedisPoolInstance.getResource();
        System.out.println(jedis);
        System.out.println(jedis2);
        System.out.println(jedis.getClient());
        System.out.println(jedis2.getClient());

        //释放redis资源
        jedisPoolInstance.returnResource(jedis);

//      jedisPool 进行资源的分配和回收管理等.
        jedisPoolInstance.returnBrokenResource(jedis);
        jedisPoolInstance.returnResourceObject(jedis);



        //String
        /*
        jedis.set("hello", "world!");
        System.out.println(jedis.get("hello"));
        */
        String key_list = "list_1";
        //list
        if (jedis.exists(key_list)) {
            System.out.println("存在key = " + key_list);
            jedis.del(key_list);
        }
//      lpush在key对应list的头部添加字符串元素
        jedis.lpush(key_list, "world");
        jedis.lpush(key_list, "hello");
        System.out.println(jedis.lrange(key_list, 0, 1));
//        rpush在key对应list的尾部添加字符串元素
        jedis.rpush(key_list, "dhr");
        System.out.println(jedis.lrange(key_list, 0, 4));
        System.out.println(key_list + "key对应长度：" + jedis.llen(key_list));

        System.out.println("截取长度："+jedis.ltrim(key_list,0,1));
        System.out.println("返回名称为key的list中index位置的元素:"+jedis.lindex(key_list,1));
        System.out.println("给名称为key的list中index位置的元素赋值为value:"+jedis.lset(key_list,1,"test_new"));
        System.out.println(jedis.lpush(key_list,"test_new"));
        System.out.println(jedis.lrange(key_list, 0, 10));
        System.out.println("删除count个名称为key的list中值为value的元素:"+jedis.lrem(key_list,1,"test_new"));
        System.out.println(jedis.lrange(key_list, 0, 10));

        //others redis data type operation please see redis.txt
    }


}
