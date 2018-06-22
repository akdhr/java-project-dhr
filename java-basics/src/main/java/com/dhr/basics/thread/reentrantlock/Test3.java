package com.dhr.basics.thread.reentrantlock;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description :注释
 * Created by duanhr30063 on 2018/4/23.
 */

public class Test3 {

    private ReentrantLock lock = new ReentrantLock();
    Condition condition = lock.newCondition();
    private List<Integer> list = new ArrayList<Integer>();
    Integer minSize = 0, maxSize = 10;

    public void read() {
        lock.lock();
        try {
            if (list.size() == minSize) {
                System.out.println("read await =" + Thread.currentThread().getState() + " size=" + list.size());
                condition.await();
            }
            list.remove(0);
            condition.notify();
        } catch (Exception e) {

        } finally {
            System.out.println("read=" + Thread.currentThread().getState() + "size=" + list.size());
            lock.unlock();
        }
    }

    public void write() {
        lock.lock();
        try {
            if (list.size() == maxSize) {
                System.out.println("write await =" + Thread.currentThread().getState() + " size=" + list.size());
                condition.await();
            }
            list.add(new Random().nextInt());
            condition.notify();
        } catch (Exception e) {

        } finally {
            System.out.println("write=" + Thread.currentThread().getState() + " size=" + list.size());
            lock.unlock();
        }
    }

    public static void main(String[] args) throws Exception {
        final Test3 test3 = new Test3();
        while (true) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    test3.read();
                }
            }).start();
//            new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    test3.write();
//                }
//            }).start();
            Thread.sleep(1000);
        }


    }
}
