package com.dhr.basic.thread.communication.threadlocal.demo1;

/**
 * @Description :注释
 * Created by duanhr30063 on 2018/3/7.
 */

public class ThreadA extends Thread {
    @Override
    public void run() {
        try {

            for (int i = 0; i < 100; i++) {
                Tools.t1.set("ThreadA" + (i + 1));
                System.out.println("ThreadA get Value=" + Tools.t1.get());
                Thread.sleep(200);
            }
        } catch (Exception e) {

        }
    }
}
