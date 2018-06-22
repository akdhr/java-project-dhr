package com.dhr.basic.thread.communication.lock.demo3;

import com.dhr.basic.thread.communication.lock.demo3.*;

/**
 * @Description :注释
 * Created by duanhr30063 on 2018/3/8.
 */

public class Test {
    public static void main(String args[]) throws InterruptedException {
        MyService myService = new MyService();
//        ThreadA threadA = new ThreadA(myService);
//        threadA.start();
//        ThreadB threadB = new ThreadB(myService);
//        threadB.start();


        ThreadA tA[] = new ThreadA[10];
        ThreadB tB[] = new ThreadB[10];
        for (int i = 0; i < 10; i++) {
            tA[i] = new ThreadA(myService);
            tB[i] = new ThreadB(myService);
            tA[i].start();
            tB[i].start();
        }
    }
}
