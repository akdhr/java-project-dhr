package com.dhr.basic.thread.communication.lock.demo2;

/**
 * @Description :注释
 * Created by duanhr30063 on 2018/3/8.
 */

public class Test {
    public static void main(String args[]) throws InterruptedException {
        com.dhr.basic.thread.communication.lock.demo2.MyService myService = new MyService();
        ThreadA a = new ThreadA(myService);
        a.setName("A");
        a.start();
        ThreadB b = new ThreadB(myService);
        b.setName("B");
        b.start();
        Thread.sleep(3000);
        myService.signalA();
        //执行结果：只有线程A被唤醒了
        //myService.signalALL();
    }
}
