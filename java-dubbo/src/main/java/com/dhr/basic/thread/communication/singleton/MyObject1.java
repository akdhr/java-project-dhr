package com.dhr.basic.thread.communication.singleton;

/**
 * @Description :注释
 * Created by duanhr30063 on 2018/3/9.
 */

public class MyObject1 {
    //线程可见性,但不保证原子性,须加锁
    private volatile static MyObject1 myObject;

    private MyObject1() {

    }
    //DCL双检查,实现单例模式
    public static MyObject1 getInstance() {
        try {
            if (myObject != null)
                return myObject;
            synchronized (MyObject1.class) {
                if (null == myObject)
                    myObject = new MyObject1();
            }
        } catch (Exception e) {

        }
        return myObject;
    }
}
