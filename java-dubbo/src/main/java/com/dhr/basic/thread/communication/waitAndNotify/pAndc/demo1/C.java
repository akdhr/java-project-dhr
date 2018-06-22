package com.dhr.basic.thread.communication.waitAndNotify.pAndc.demo1;

import com.dhr.basic.thread.communication.waitAndNotify.demo4.ValueObject;

/**
 * @Description :注释
 * Created by duanhr30063 on 2018/3/7.
 */

public class C {
    private String lock;

    public C(String lock) {
        this.lock = lock;
    }

    public void getValue() {
        try {
            synchronized (lock) {
                while (ValueObject.value.equals("")) {
                    System.out.println("消费者" + Thread.currentThread().getName() + "waiting 了 ×");
                    lock.wait();
                }
                System.out.println("消费者" + Thread.currentThread().getName() + "runnable 了 √");
                ValueObject.value = "";
//                lock.notify();
                lock.notifyAll();//notifyALl即可通知同类即可通知异类，则不会出现假死状态
            }
        } catch (Exception e) {

        }
    }
}
