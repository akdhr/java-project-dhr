package com.dhr.basic.thread.communication.waitAndNotify.demo3;

/**
 * @Description :注释
 * Created by duanhr30063 on 2018/3/7.
 */

public class MyRunnable {
    static private Object lock = new Object();
    static private Runnable runnable = new Runnable() {
        public void run() {
            try {
                synchronized (lock) {
                    System.out.println("wait begin " + System.currentTimeMillis());
                    //wait(long) 等待某一时间内释放有线程对锁唤醒，超时则自动唤醒
                    lock.wait(5000);
                    System.out.println("wait end " + System.currentTimeMillis());
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    };
    static private Runnable runnable2 = new Runnable() {
        public void run() {
            synchronized (lock) {
                System.out.println("notify begin " + System.currentTimeMillis());
                lock.notify();
                System.out.println("notify end " + System.currentTimeMillis());
            }
        }
    };

    public static void main(String arg[]) throws InterruptedException {
        Thread t = new Thread(runnable);
        t.start();
        Thread.sleep(3000);
        Thread t2 = new Thread(runnable2);
        t2.start();
    }
}
