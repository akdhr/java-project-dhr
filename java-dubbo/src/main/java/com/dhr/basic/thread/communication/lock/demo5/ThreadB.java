package com.dhr.basic.thread.communication.lock.demo5;


/**
 * @Description :注释
 * Created by duanhr30063 on 2018/3/8.
 */

public class ThreadB extends Thread {
    MyService myservice = new MyService();

    public ThreadB(MyService myservice) {
        this.myservice = myservice;
    }

    @Override
    public void run() {
        myservice.methodB();
    }
}
