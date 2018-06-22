package com.dhr.basic.thread.communication.lock.demo2;

/**
 * @Description :注释
 * Created by duanhr30063 on 2018/3/8.
 */

public class ThreadA extends Thread {
    private com.dhr.basic.thread.communication.lock.demo2.MyService service;

    public ThreadA(MyService service) {
        this.service = service;
    }

    @Override
    public void run() {
        service.awaitA();
    }
}
