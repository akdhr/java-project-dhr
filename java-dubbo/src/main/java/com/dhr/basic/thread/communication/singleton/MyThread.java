package com.dhr.basic.thread.communication.singleton;

/**
 * @Description :注释
 * Created by duanhr30063 on 2018/3/9.
 */

public class MyThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(MyObject4.connectionFactory.getConnection().hashCode());
        }
    }
}