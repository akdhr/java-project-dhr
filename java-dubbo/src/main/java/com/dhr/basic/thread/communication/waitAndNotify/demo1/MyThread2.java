package com.dhr.basic.thread.communication.waitAndNotify.demo1;

/**
 * @Description :注释
 * Created by duanhr30063 on 2018/3/7.
 */

public class MyThread2 extends Thread {
    private Object lock;

    public MyThread2(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        synchronized (lock) {
            System.out.println("start wait time=" + System.currentTimeMillis());
            lock.notify();
            System.out.println("end wait time=" + System.currentTimeMillis());
        }

    }
}
