package com.dhr.basic.thread.communication.waitAndNotify.pAndc.demo1;

/**
 * @Description :注释
 * Created by duanhr30063 on 2018/3/7.
 */

public class ThreadP extends Thread {

    private P p;

    public ThreadP(P p) {
        this.p = p;
    }

    @Override
    public void run() {
        while (true) {
            p.setValue();
        }
    }
}
