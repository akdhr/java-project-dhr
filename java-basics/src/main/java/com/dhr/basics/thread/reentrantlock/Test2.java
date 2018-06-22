package com.dhr.basics.thread.reentrantlock;

//import com.yuntai.pay.service.med.helper.MedpayConversionHelper;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description :注释
 * Created by duanhr30063 on 2017/12/20.
 */

public class Test2 {


    static class NumberWrapper {
        public int value = 1;
    }

    Lock lock = new ReentrantLock();
    final Condition reachThreeCon = lock.newCondition();
    final Condition reachSixCon = lock.newCondition();
    final NumberWrapper num = new NumberWrapper();

    public void print3() {
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                lock.lock();
                try {
                    System.out.println("ThreadA start wirite.");
                    while (num.value <= 3) {
                        System.out.println(num.value);
                        num.value++;
                    }
                    if (num.value > 3)
                        reachSixCon.signal();

                } catch (Exception e) {

                } finally {
                    lock.unlock();
                }
            }
        });
        threadA.start();
    }

    public void print4_6() {
        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                lock.lock();
                try {
                    System.out.println("threadB start wirite.");
                    while (num.value <= 6 && num.value > 3) {
                        System.out.println(num.value);
                        num.value++;
                    }
                    if (num.value < 3 || num.value > 6)
                        reachSixCon.await();
                } catch (Exception e) {

                } finally {
                    lock.unlock();
                }
            }
        });
        threadB.start();
    }


    public static void main(String args[]) throws Exception {
        Test2 test2 = new Test2();
        Thread.sleep(1000);
        test2.print3();
        test2.print4_6();

    }

}
