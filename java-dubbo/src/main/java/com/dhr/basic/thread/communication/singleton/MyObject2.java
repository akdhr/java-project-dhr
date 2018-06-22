package com.dhr.basic.thread.communication.singleton;

import java.io.ObjectStreamException;
import java.io.Serializable;

/**
 * @Description :注释
 * Created by duanhr30063 on 2018/3/9.
 */

public class MyObject2 implements Serializable{
    private static class MyObjectHandler {
        private static MyObject2 myObject = new MyObject2();
    }

    private MyObject2() {
    }

    /**
     * 静态内部创建单例模式,只有一种方式获取实例结果
     * 注：遇到序列化对象时，使用默认的方法得到的结果仍是多例的，请注意
     * @return
     */
    public static MyObject2 getInstance() {
        return MyObjectHandler.myObject;
    }




    //反序列化对象时需要实现
    protected Object readResolve() throws ObjectStreamException{
        System.out.println("调用了readResolve方法！");
        return MyObjectHandler.myObject;
    }
}
