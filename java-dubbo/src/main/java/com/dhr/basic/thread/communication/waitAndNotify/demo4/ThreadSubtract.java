package com.dhr.basic.thread.communication.waitAndNotify.demo4;

/**
 * @Description :注释
 * Created by duanhr30063 on 2018/3/7.
 */

public class ThreadSubtract extends Thread {
    private Subtract r;

    public ThreadSubtract(Subtract r) {
        this.r = r;
    }

    @Override
    public void run() {
        r.subtract();
    }
}
