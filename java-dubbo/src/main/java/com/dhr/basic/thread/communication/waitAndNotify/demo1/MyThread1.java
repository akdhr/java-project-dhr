package com.dhr.basic.thread.communication.waitAndNotify.demo1;

/**
 * @Description :注释
 * Created by duanhr30063 on 2018/3/7.
 */

public class MyThread1 extends Thread {
    private Object lock;

    public MyThread1(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        try {
            synchronized (lock) {
                System.out.println("start wait time=" + System.currentTimeMillis());
                lock.wait();
                System.out.println("end wait time=" + System.currentTimeMillis());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
