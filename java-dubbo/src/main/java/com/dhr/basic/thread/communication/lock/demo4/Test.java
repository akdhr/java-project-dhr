package com.dhr.basic.thread.communication.lock.demo4;

import java.io.Serializable;

/**
 * @Description :注释
 * Created by duanhr30063 on 2018/3/8.
 */

public class Test {
    public static void main(String args[]) {
        Service service = new Service();
        service.method1();
//        针对一些检测线程是否死锁、正在等待的线程等方法进行测试
    }

}
