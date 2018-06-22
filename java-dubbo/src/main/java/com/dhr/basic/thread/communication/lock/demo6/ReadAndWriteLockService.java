package com.dhr.basic.thread.communication.lock.demo6;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Description :注释
 * Created by duanhr30063 on 2018/3/8.
 */

public class ReadAndWriteLockService {

    /**
     * 读写互斥
     * 写读互斥
     * 写写互斥
     * 读读共享
     *
     */
    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public void read() {
        try {
            lock.readLock().lock();
            System.out.println("获取读锁" + Thread.currentThread().getName() + " "+ System.currentTimeMillis());
            Thread.sleep(1000);
        } catch (Exception e) {

        } finally {
            lock.readLock().unlock();
        }
    }

    public void write() {
        try {
            lock.writeLock().lock();
            System.out.println("获取写锁" + Thread.currentThread().getName() + " "+ System.currentTimeMillis());
            Thread.sleep(1000);
        } catch (Exception e) {

        } finally {
            lock.writeLock().unlock();
        }
    }
}
