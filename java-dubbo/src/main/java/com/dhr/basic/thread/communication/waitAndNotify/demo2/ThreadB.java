package com.dhr.basic.thread.communication.waitAndNotify.demo2;

/**
 * @Description :注释
 * Created by duanhr30063 on 2018/3/7.
 */

public class ThreadB extends Thread {
    private Object lock;

    public ThreadB(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        try {
            synchronized (lock) {
                for (int i = 0; i < 10; i++) {
                    MyList.add();
                    if (MyList.size() == 5) {
                        //notify 执行后并不立即释放锁,继续执行后面的代码
                        lock.notify();
                        System.out.println("已发出通知");
                    }
                    System.out.println("添加了 " + (i + 1) + "个元素");
                    Thread.sleep(1000);
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
