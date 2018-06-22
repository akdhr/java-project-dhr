package com.dhr.basic.thread.communication.waitAndNotify.demo4;

/**
 * @Description :注释
 * Created by duanhr30063 on 2018/3/7.
 */

public class Test {
    public static void main(String arg[]) throws InterruptedException {
        String lock = new String("");
        Add add = new Add(lock);
        Subtract subtract = new Subtract(lock);
        ThreadSubtract subtractThread = new ThreadSubtract(subtract);
        subtractThread.setName("subThread");
        subtractThread.start();

        ThreadSubtract subtractThread2 = new ThreadSubtract(subtract);
        subtractThread2.setName("subThread");
        subtractThread2.start();

        Thread.sleep(1000);
        ThreadAdd threadAdd = new ThreadAdd(add);
        threadAdd.setName("addThread");
        threadAdd.start();


    }
}
