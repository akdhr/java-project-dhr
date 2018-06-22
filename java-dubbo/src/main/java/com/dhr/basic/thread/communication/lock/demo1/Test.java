package com.dhr.basic.thread.communication.lock.demo1;

/**
 * @Description :注释
 * Created by duanhr30063 on 2018/3/8.
 */

public class Test {
    public static void main(String args[]) throws InterruptedException {
        MyService service = new MyService();
        ThreadA a = new ThreadA(service);
        a.start();
        Thread.sleep(3000);
        service.signal();
    }
}
