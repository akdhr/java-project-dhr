package com.dhr.basic.thread.communication.threadlocal.demo2;

/**
 * @Description :注释
 * Created by duanhr30063 on 2018/3/7.
 */

public class ThreadLocalExt extends ThreadLocal {
    @Override
    protected Object initialValue() {
        return "I am default value!";
    }
}
