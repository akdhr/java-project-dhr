package com.dhr.basic.thread.communication.lock.demo3;

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
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            service.get();
        }
    }
}
