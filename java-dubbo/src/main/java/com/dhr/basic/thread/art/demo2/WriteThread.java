package com.dhr.basic.thread.art.demo2;

import com.dhr.basic.thread.art.demo2.queue.ArrayBlockingQueueTest;

/**
 * @Description :注释
 * Created by duanhr30063 on 2018/3/15.
 */

public class WriteThread extends Thread {
    private ArrayBlockingQueueTest arrayBlockingQueueTest;

    public WriteThread(ArrayBlockingQueueTest arrayBlockingQueueTest) {
        this.arrayBlockingQueueTest = arrayBlockingQueueTest;
    }


    @Override
    public void run() {
        for (int i = 1; i < 10; i++) {
            arrayBlockingQueueTest.add(i);
        }
    }
}
