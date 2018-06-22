package com.dhr.basic.thread.art.demo2;

import com.dhr.basic.thread.art.demo2.queue.ArrayBlockingQueueTest;

/**
 * @Description :注释
 * Created by duanhr30063 on 2018/3/15.
 */

public class ReadThread extends Thread {
    private ArrayBlockingQueueTest arrayBlockingQueueTest;

    public ReadThread(ArrayBlockingQueueTest arrayBlockingQueueTest) {
        this.arrayBlockingQueueTest = arrayBlockingQueueTest;
    }


    @Override
    public void run() {
        try {
            System.out.println("线程名称：" + Thread.currentThread().getName() + "线程状态：" + Thread.currentThread().getState() + "读取数据值：" + arrayBlockingQueueTest.take());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
