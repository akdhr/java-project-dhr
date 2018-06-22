package com.dhr.basic.thread.communication.waitAndNotify.demo2;

/**
 * @Description :注释
 * Created by duanhr30063 on 2018/3/7.
 */

public class Test {
    public static void main(String args[]) throws Exception {
        //wait and notify 等待与通知交互,以及wait释放锁和notify不释放锁
        Object lock = new Object();
        ThreadA a = new ThreadA(lock);
        a.start();
        Thread.sleep(50);
        ThreadB b = new ThreadB(lock);
        b.start();
    }

}
