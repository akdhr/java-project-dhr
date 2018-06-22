package com.dhr.basic.thread.art.demo1;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description :注释
 * Created by duanhr30063 on 2018/3/15.
 */

public class MyService {

    static Lock lock = new ReentrantLock();
    //只保证自己内部的map支持并发访问,但相关操作不保证同步处理,需要调用方自己控制
    static ConcurrentHashMap<String, Object> concurrentHashMap = new ConcurrentHashMap<String, Object>();

    public void setData(String key, Object value) {
        lock.lock();
        try {
            concurrentHashMap.put(key, value);
        } finally {
            lock.unlock();
        }
    }

    public Object getData(String key) {
        lock.lock();
        try {
            return concurrentHashMap.get(key);
        } finally {
            lock.unlock();
        }
    }

    public Object getSize() {
        lock.lock();
        try {
            //弱一致性返回,高并发下尽量少用
            return concurrentHashMap.size();
        } finally {
            lock.unlock();
        }
    }
}
