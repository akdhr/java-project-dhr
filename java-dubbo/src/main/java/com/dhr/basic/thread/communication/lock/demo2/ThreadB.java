package com.dhr.basic.thread.communication.lock.demo2;

/**
 * @Description :注释
 * Created by duanhr30063 on 2018/3/8.
 */

public class ThreadB extends Thread {
    private MyService service;

    public ThreadB(MyService service) {
        this.service = service;
    }

    @Override
    public void run() {
        service.awaitB();
    }
}
