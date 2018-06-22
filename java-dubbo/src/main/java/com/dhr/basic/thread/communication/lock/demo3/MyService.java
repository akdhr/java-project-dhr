package com.dhr.basic.thread.communication.lock.demo3;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description :注释
 * Created by duanhr30063 on 2018/3/8.
 */

public class MyService {
    private ReentrantLock lock = new ReentrantLock();
    public Condition condition = lock.newCondition();
    private boolean hasValue = false;

    public void set() {
        try {
            lock.lock();
            while (hasValue) {
                System.out.println("有可能****连续");
                condition.await();
            }
            System.out.println("****");
            Thread.sleep(500);
            hasValue = true;
            condition.signal();
//            condition.signalAll();//防止多线程期间出现假死状态
        } catch (Exception e) {

        } finally {
            lock.unlock();
        }
    }

    public void get() {
        try {
            lock.lock();
            while (!hasValue) {
                System.out.println("有可能@@@@连续");
                condition.await();
            }
            System.out.println("@@@@");
            Thread.sleep(500);
            hasValue = false;
            condition.signal();
//            condition.signalAll();
        } catch (Exception e) {

        } finally {
            lock.unlock();
        }

    }


}
