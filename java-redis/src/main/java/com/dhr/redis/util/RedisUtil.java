package com.dhr.redis.util;

import com.dhr.redis.Constans;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.util.Pool;

/**
 * @Description :注释
 * Created by duanhr30063 on 2017/12/8.
 */

public class RedisUtil {

    private static Pool<Jedis> jedisPool;

    private RedisUtil() {
    }

    /**
     * 初始化redis池资源
     *
     * @return
     */
    public static Pool<Jedis> getJedisPoolInstance() {
        if (null == jedisPool) {
            synchronized (RedisUtil.class) {
                if (jedisPool == null) {
                    JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
                    jedisPool = new JedisPool(jedisPoolConfig, Constans.IP, Constans.PORT, Constans.TIMEOUT, Constans.PASSWORD, Constans.db);
                }
            }
        }
        return jedisPool;
    }

    /**
     * 获取jedis实例，用于操作redis数据库
     *
     * @return
     */
    public static Jedis getJedisInstance() {
        return jedisPool.getResource();
    }

    public static void returnSource(Jedis jedis) {
        try {
            if (jedisPool != null) {
                //回收到pool中
                jedisPool.returnResource(jedis);
            }
        } catch (Exception e) {
            //异常销毁
            jedisPool.returnBrokenResource(jedis);
        }
    }

    /***
     * 获取对应key的值
     * @param key
     * @return
     */
    public static String get(String key) {
        return getJedisInstance().get(key);
    }

    /**
     * 设置key-value
     * @param key
     * @param value
     * @return
     */
    public static String set(String key, String value) {
        return getJedisInstance().set(key, value);
    }


    public static void main(String args[]) {
        System.out.println(RedisUtil.getJedisPoolInstance());
        System.out.println(RedisUtil.getJedisPoolInstance());
        System.out.println(RedisUtil.getJedisPoolInstance());
        RedisUtil.set("test","hello,world!");
        System.out.println(RedisUtil.get("test"));
    }

}
