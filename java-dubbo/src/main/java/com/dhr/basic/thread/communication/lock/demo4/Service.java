package com.dhr.basic.thread.communication.lock.demo4;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description :注释
 * Created by duanhr30063 on 2018/3/8.
 */

public class Service {
    private ReentrantLock lock = new ReentrantLock();

    public void method1() {
        try {
            lock.lock();
            System.out.println("method_1 getHoldCount=" + lock.getHoldCount());
            System.out.println("ThreadName=" + Thread.currentThread().getName() + "进入方法");
            Thread.sleep(Integer.MAX_VALUE);
            method2();
        } catch (InterruptedException e) {

        } finally {
            lock.unlock();
        }
    }

    public void method2() {
        try {
            lock.lock();
            System.out.println("method_2 getHoldCount=" + lock.getHoldCount());
        } finally {
            lock.unlock();
        }
    }

}
