package com.dhr.basic.thread.art.demo2.queue;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description :注释
 * Created by duanhr30063 on 2018/3/15.
 */

public class ArrayBlockingQueueTest {
    private ReentrantLock lock;
    //非空
    private Condition notEmpty;
    //不可获取
    private Condition notFull;

    private Object items[];
    int count;
    int putIndex;
    int takeIndex;

    public ArrayBlockingQueueTest(int capacity) {
        this(capacity, false);
    }

    public ArrayBlockingQueueTest(int capacity, boolean fair) {
        if (capacity <= 0)
            throw new IllegalArgumentException();
        this.items = new Object[capacity];
        lock = new ReentrantLock(fair);
        notEmpty = lock.newCondition();
        notFull = lock.newCondition();
    }

    public boolean add(Object object) {
        this.lock.lock();
        try {
            if (count == this.items.length)
                return false;
            else if (count < 5) {
                notEmpty.await();
            } else
                insert(object);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.lock.unlock();
        }
        return true;
    }

    public void insert(Object x) {
        items[putIndex] = x;
        putIndex = inc(putIndex);
        ++count;
        notEmpty.signal();
    }

    final int inc(int i) {
        return (++i == items.length) ? 0 : i;
    }

    public Object take() throws InterruptedException {
        final ReentrantLock lock = this.lock;
        lock.lockInterruptibly();
        try {
            while (count == 0)
                notEmpty.await();
            return extract();
        } finally {
            lock.unlock();
        }
    }

    private Object extract() {
        final Object[] items = this.items;
        Object x = this.items[takeIndex];
        items[takeIndex] = null;
        takeIndex = inc(takeIndex);
        --count;
        notFull.signal();
        return x;
    }
}
