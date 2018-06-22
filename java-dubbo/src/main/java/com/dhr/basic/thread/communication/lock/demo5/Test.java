package com.dhr.basic.thread.communication.lock.demo5;

/**
 * @Description :注释
 * Created by duanhr30063 on 2018/3/8.
 */

public class Test {
    public static void main(String args[]) {
        MyService myService = new MyService();
//        ThreadA threadA = new ThreadA(myService);
//        ThreadB threadB = new ThreadB(myService);
//        ThreadC threadC = new ThreadC(myService);
//
//        threadA.start();
//        threadB.start();
//        threadC.start();
        //线程依次执行,利用多个condition进行通知处理
        ThreadA A[] = new ThreadA[5];
        ThreadB B[] = new ThreadB[5];
        ThreadC C[] = new ThreadC[5];
        for (int i = 0; i < 5; i++) {
            A[i] = new ThreadA(myService);
            B[i] = new ThreadB(myService);
            C[i] = new ThreadC(myService);
            A[i].setName("ThreadA");
            B[i].setName("ThreadB");
            C[i].setName("ThreadC");
            A[i].start();
            B[i].start();
            C[i].start();
        }
    }
}
