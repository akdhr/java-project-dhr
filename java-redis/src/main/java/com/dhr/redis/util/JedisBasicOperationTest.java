package com.dhr.redis.util;

import com.dhr.redis.Constans;
import redis.clients.jedis.Jedis;

import java.util.List;

/**
 * @Description :注释
 * Created by duanhr30063 on 2017/12/7.
 */

public class JedisBasicOperationTest {
    private static Jedis jedis = null;

    static {
        jedis = new Jedis(Constans.IP, Constans.PORT);
        jedis.auth(Constans.PASSWORD);
    }

    public static void keyTest(String key, String value) {
        String setResult = jedis.set(key, value);
        System.out.println("set result:" + setResult);
        System.out.println("get result:" + jedis.get(key));


    }

    //REDIS 五种基本类型的存取等操作实例
    public static void main(String args[]) throws Exception {
        //String
        JedisBasicOperationTest.keyTest("hello", "hello,world!");
        JedisBasicOperationTest.keyTest("hello", "");
        JedisBasicOperationTest.keyTest("hello", null);
        jedis.del("hello");
        List<String> list = jedis.lrange("hello", 1, 5);
        for (String str : list) {
            System.out.println(str);
        }

        keyTest("count", "5");
        //++操作
        //对key的value进行加1操作返回
        System.out.println(jedis.incr("count"));
        //对key进行加指定值，不存在的key默认从0开始
//        System.out.println(jedis.incrBy("key", 1));
//        System.out.println(jedis.incrBy("key", 2));

        //--操作
//        System.out.println(jedis.decr("key1"));
//        System.out.println(jedis.decr("key1"));
//        System.out.println(jedis.decrBy("key1", 2));

        //HASH存放
        System.out.println(jedis.hset("myhash", "a", "foo"));
        System.out.println(jedis.hvals("myhash"));
        jedis.hget("myhash", "a");

        //list存取-可以当做ArrayList的扩展使用,下标不受限制
        jedis.lpush("list_1", "hello", "world");
        jedis.lpush("list_1", "too!");
        System.out.println(jedis.lpop("list_1"));

        //sets存放 集合求交并差
        jedis.sadd("set_1", "001");
        jedis.sadd("set_1", "001");
        jedis.sadd("set_1", "002");
        jedis.sadd("set_2", "002");
        jedis.sadd("set_2", "003");
        //集合类似于数学中的集合,可取交、差、并、补集等
        System.out.println("before del" + jedis.smembers("set_1"));
        System.out.println(jedis.srem("set_1", "003"));
        System.out.println("after del" + jedis.smembers("set_1"));

        //返回所有给定key(set_2)与第一个key的差集
        System.out.println(jedis.sdiff("set_1","set_2"));

        System.out.println(jedis.sdiffstore("set_1","set_2"));
        System.out.println(jedis.sinter("set_1","set_2"));
        System.out.println(jedis.sunion("set_1","set_2"));

        //sorted sets类型及操作(sets的升级版)

    }


}
