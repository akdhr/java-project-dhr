package com.dhr.basic.thread.communication.waitAndNotify.demo4;

/**
 * @Description :注释
 * Created by duanhr30063 on 2018/3/7.
 */

public class ThreadAdd extends Thread {
    private Add p;

    public ThreadAdd(Add p) {
        this.p = p;
    }

    @Override
    public void run() {
        p.add();
    }
}
