package com.dhr.basic.thread.communication.lock.demo5;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description :注释
 * Created by duanhr30063 on 2018/3/8.
 */

public class MyService {
    private ReentrantLock lock = new ReentrantLock();
    private Condition conditionA = lock.newCondition();
    private Condition conditionB = lock.newCondition();
    private Condition conditionC = lock.newCondition();


    private static int nextPrintWhoFlag = 1;

    public void methodA() {
        try {
            lock.lock();
            while (nextPrintWhoFlag != 1) {
                conditionA.await();
            }
            print123();
            nextPrintWhoFlag = 2;
            conditionB.signalAll();
        } catch (Exception e) {

        } finally {
            lock.unlock();
        }
    }

    public void methodB() {
        try {
            lock.lock();
            while (nextPrintWhoFlag != 2) {
                conditionB.await();
            }
            print123();
            nextPrintWhoFlag = 3;
            conditionC.signalAll();
        } catch (Exception e) {

        } finally {
            lock.unlock();
        }
    }

    public void methodC() {
        try {
            lock.lock();
            while (nextPrintWhoFlag != 3) {
                conditionC.await();
            }
            print123();
            nextPrintWhoFlag = 1;
            conditionA.signalAll();
        } catch (Exception e) {

        } finally {
            lock.unlock();
        }
    }

    public void print123() {
        for (int i = 0; i < 3; i++) {
            System.out.println(Thread.currentThread().getName() + ":" + (i + 1));
        }
    }
}
