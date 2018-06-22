package com.dhr.basic.thread.communication.waitAndNotify.pAndc.demo1;

/**
 * @Description :注释
 * Created by duanhr30063 on 2018/3/7.
 */

public class Test {
    public static void main(String args[]) throws Exception {
        /**
         * wait 和notify实现多生产多消费,可能出现假死状态,原因wait和notify可能通知同类或异类，比如消费者通知消费者，积少成多就可能假死状态
         */
        String lock = new String("");
        P p = new P(lock);
        C c = new C(lock);
//        ThreadP threadP = new ThreadP(p);
//        ThreadC threadC = new ThreadC(c);
//        threadP.start();
//        threadC.start();
        ThreadP[] pThread = new ThreadP[2];
        ThreadC[] cThread = new ThreadC[2];
        for (int i = 0; i < 2; i++) {
            pThread[i] = new ThreadP(p);
            pThread[i].setName("生产者 " + (i + 1));
            cThread[i] = new ThreadC(c);
            cThread[i].setName("消费者 " + (i + 1));
            pThread[i].start();
            cThread[i].start();
        }
        Thread.sleep(5000);
        Thread[] threads = new Thread[Thread.currentThread().getThreadGroup().activeCount()];
        Thread.currentThread().getThreadGroup().enumerate(threads);
        for (int i = 0; i < threads.length; i++) {
            System.out.println(threads[i].getName() + " " + threads[i].getState());
        }
    }

}
