package com.dhr.basic.thread.communication.waitAndNotify.demo4;


/**
 * @Description :注释
 * Created by duanhr30063 on 2018/3/7.
 */

public class Add {
    private String lock;

    public Add(String lock) {
        this.lock = lock;
    }

    public void add() {
        synchronized (lock) {
            ValueObject.list.add("anyStr");
            lock.notifyAll();
        }
    }
}
