package com.dhr.basic.thread.communication.waitAndNotify.demo4;

/**
 * @Description :注释
 * Created by duanhr30063 on 2018/3/7.
 */

public class Subtract {
    private String lock;

    public Subtract(String lock) {
        this.lock = lock;
    }

    public void subtract() {
        try {
            synchronized (lock) {
//                if (ValueObject.list.size() == 0) {//若改成if时，则线程通知发出后，wait后面直接往下执行，不在进行判断,一旦有多线程进行删除数据，则出现异常，见当前包下的TEST案例
                while (ValueObject.list.size() == 0) {
                    System.out.println("wait begin ThreadName=" + Thread.currentThread().getName());
                    lock.wait();
                    System.out.println("wait end ThreadName=" + Thread.currentThread().getName());
                }
                ValueObject.list.remove(0);
                System.out.println("list size=" + ValueObject.list.size());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
