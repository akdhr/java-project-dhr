package com.dhr.basic.thread.communication.lock.demo1;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description :注释
 * Created by duanhr30063 on 2018/3/8.
 */

public class MyService {
    private ReentrantLock lock = new ReentrantLock();
    //单个condition
    public Condition condition = lock.newCondition();

    public void await() {
        try {

            lock.lock();
            System.out.println("await time is " + System.currentTimeMillis());
            condition.await();

        } catch (Exception e) {

        } finally {
            lock.unlock();
        }
    }

    public void signal() {
        try {
            lock.lock();
            System.out.println("signal time is " + System.currentTimeMillis());
            condition.signal();
        } catch (Exception e) {

        } finally {
            lock.unlock();
        }

    }


}
