//package com.dhr.basics.thread.reentrantlock;
//
////import com.yuntai.pay.service.med.helper.MedpayConversionHelper;
//
//import java.util.concurrent.locks.Condition;
//import java.util.concurrent.locks.Lock;
//import java.util.concurrent.locks.ReentrantLock;
//
///**
// * @Description :注释
// * Created by duanhr30063 on 2017/12/20.
// */
//
//public class Test {
//
//
//    static class NumberWrapper {
//        public int value = 1;
//    }
//
//    public static void main(String args[]) {
////        final ReentrantLockTest lock = new ReentrantLockTest();
//        Lock lock = new ReentrantLock();
//        final Condition reachThreeCon = lock.newCondition();
//        final Condition reachSixCon = lock.newCondition();
//        final NumberWrapper num = new NumberWrapper();
//        Thread threadA = new Thread(new Runnable() {
//            @Override
//            public void run() {
//
//                lock.lock();
//                try {
//                    System.out.println("ThreadA start wirite.");
//                    while (num.value <= 3) {
//                        System.out.println(num.value);
//                        num.value++;
//                    }
//                    reachThreeCon.signal();
//                } catch (Exception e) {
//
//                } finally {
//                    lock.unlock();
//                }
//
//                lock.lock();
//                try {
//                    reachSixCon.await();
//                    System.out.println("ThreadA start wirite. for waited!");
//                    while (num.value <= 9) {
//                        System.out.println(num.value);
//                        num.value++;
//                    }
//                } catch (Exception e) {
//
//                } finally {
//                    lock.unlock();
//                }
//
//
//            }
//        });
//
//        Thread threadB = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    lock.lock();
//                    while (num.value <= 3) {
//                        //等待3输出完毕的信号
//                        reachThreeCon.await();
//                        System.out.println("threadB await");
//                    }
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                } finally {
//                    lock.unlock();
//                }
//                try {
//                    lock.lock();
//                    //已经收到信号，开始输出4，5，6
//                    System.out.println("threadB start write");
//                    while (num.value <= 6) {
//                        System.out.println(num.value);
//                        num.value++;
//                    }
//                    //4，5，6输出完毕，告诉A线程6输出完了
//                    reachSixCon.signal();
//                    System.out.println("threadB signal");
//
//                } finally {
//                    lock.unlock();
//                }
//            }
//        });
//        //启动两个线程
//        threadB.start();
//        threadA.start();
//    }
//
//}
