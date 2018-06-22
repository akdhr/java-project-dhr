package com.dhr.basics.thread;

import java.util.concurrent.CyclicBarrier;

/**
 * @Description :注释
 * Created by duanhr30063 on 2018/4/11.
 */

public class CyclicBarrierTest {
    static CyclicBarrier cb = new CyclicBarrier(3);


    public static void main(String args[]) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("1.done");
                    cb.await();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println(1);
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("2.done");
                    cb.await();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println(2);
            }
        }).start();

        try {
            System.out.println("3.done");
            cb.await();
        } catch (Exception e) {
        }
        System.out.println(3);


    }

}
