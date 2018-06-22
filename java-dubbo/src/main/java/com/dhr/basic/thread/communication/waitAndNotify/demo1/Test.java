package com.dhr.basic.thread.communication.waitAndNotify.demo1;

/**
 * @Description :注释
 * Created by duanhr30063 on 2018/3/7.
 */

public class Test {
    public static void main(String args[]) throws Exception {
        //after 3 Seconds continue handler
        Object lock = new Object();
        MyThread1 t1 = new MyThread1(lock);
        t1.start();
        Thread.sleep(3000);
        MyThread2 t2 = new MyThread2(lock);
        t2.start();

    }

}
