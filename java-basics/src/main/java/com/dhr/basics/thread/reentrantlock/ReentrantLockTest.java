package com.dhr.basics.thread.reentrantlock;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * @Description :注释
 * Created by duanhr30063 on 2018/1/12.
 */

public class ReentrantLockTest {

    private final Sync sync;

    abstract static class Sync extends AbstractQueuedSynchronizerTest {
        //具体由子类去实现公平和非公平锁机制
        abstract void lock();

        //非公平锁尝试获取锁机制
        final boolean nonfairTryAcquire(int acquires) {
            final Thread current = Thread.currentThread();
            int c = getState();
            //state = 0代表可以获取锁
            if (c == 0) {
                if (compareAndSetState(0, acquires)) {
                    setExclusiveOwnerThread(current);
                    return true;
                }
                //若线程为当前线程,则再次获取锁（可重入锁）
            } else if (current == getExclusiveOwnerThread()) {
                //可重入锁时state 加1
                int nextc = c + acquires;
                if (nextc < 0) // overflow
                    throw new Error("Maximum lock count exceeded");
                setState(nextc);
                return true;
            }
            return false;
        }

        //释放锁,state递减
        protected final boolean tryRelease(int releases) {
            int c = getState() - releases;
            if (Thread.currentThread() != getExclusiveOwnerThread())
                throw new IllegalMonitorStateException();
            boolean free = false;
            if (c == 0) {
                free = true;
                setExclusiveOwnerThread(null);
            }
            setState(c);
            return free;
        }

        //获取当前对象对应的线程，state = 0 代表无锁
        final Thread getOwner() {
            return getState() == 0 ? null : getExclusiveOwnerThread();
        }

        final ConditionObjectTest newCondition() {
            return new ConditionObjectTest();
        }
    }

    /**
     * 非公平锁同步机制实现
     */
    static final class NonfairSync extends Sync {
        final void lock() {
            if (compareAndSetState(0, 1))
                setExclusiveOwnerThread(Thread.currentThread());
            else
                acquire(1);
        }

        protected final boolean tryAcquire(int acquires) {
            return nonfairTryAcquire(acquires);
        }

    }

    static final class FairSync extends Sync {
        @Override
        void lock() {

        }
    }

    public ReentrantLockTest() {
        sync = new NonfairSync();
    }

    public ReentrantLockTest(boolean fair) {
        sync = fair ? new FairSync() : new NonfairSync();
    }

    //枷锁
    public void lock() {
        sync.lock();
    }

    //释放
    public void unlock() {
        sync.release(1);
    }

    final AbstractQueuedSynchronizerTest.ConditionObjectTest newCondition() {
        return sync.newCondition();
    }
}
