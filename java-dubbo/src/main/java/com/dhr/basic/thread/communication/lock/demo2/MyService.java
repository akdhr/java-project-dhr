package com.dhr.basic.thread.communication.lock.demo2;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description :注释
 * Created by duanhr30063 on 2018/3/8.
 */

public class MyService {
    private ReentrantLock lock = new ReentrantLock();

    public Condition conditionA = lock.newCondition();
    public Condition conditionB = lock.newCondition();
    public Condition conditionC = lock.newCondition();

    public void awaitA() {
        try {

            lock.lock();
            System.out.println("awaitA time is " + System.currentTimeMillis());
            conditionA.await();

        } catch (Exception e) {
        } finally {
            lock.unlock();
        }
    }

    public void awaitB() {
        try {

            lock.lock();
            System.out.println("awaitB time is " + System.currentTimeMillis());
            conditionB.await();

        } catch (Exception e) {

        } finally {
            lock.unlock();
        }
    }

    public void signalA() {
        try {
            lock.lock();
            System.out.println("signalA time is " + System.currentTimeMillis());
            conditionA.signal();
        } catch (Exception e) {

        } finally {
            lock.unlock();
        }

    }

    public void signalALL() {
        try {
            lock.lock();
            System.out.println("signalALL time is " + System.currentTimeMillis());
            //即使掉了signalAll也不会通知到其他的condition.
            conditionC.signalAll();
        } catch (Exception e) {

        } finally {
            lock.unlock();
        }
    }

    public void signalB() {
        try {
            lock.lock();
            System.out.println("signalB time is " + System.currentTimeMillis());
            conditionB.signal();
        } catch (Exception e) {

        } finally {
            lock.unlock();
        }

    }


}
