package com.dhr.basic.thread.communication.threadlocal.demo1;

/**
 * @Description :注释
 * Created by duanhr30063 on 2018/3/7.
 */

public class Test {
    public static void main(String args[]) throws Exception {
        ThreadA a = new ThreadA();
        ThreadB b = new ThreadB();
        a.start();
        b.start();
        for (int i = 0; i < 100; i++) {
            Tools.t1.set("Main" + (i + 1));
            System.out.println("Main get Value=" + Tools.t1.get());
            Thread.sleep(200);
        }

    }

}
