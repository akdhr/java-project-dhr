package com.dhr.basic.thread.communication.singleton;

/**
 * @Description :静态块中实现单例
 * Created by duanhr30063 on 2018/3/9.
 */

public class MyObject3 {
    private static MyObject3 instance = null;
    //JVM在类初始化期间会获取这个初始化锁
    static {
        instance = new MyObject3();
    }

    public static MyObject3 getInstance() {
        return instance;
    }
}
