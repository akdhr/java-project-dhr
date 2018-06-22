package com.dhr.basic.thread.communication.threadlocal.demo2;

import com.dhr.basic.thread.communication.threadlocal.demo1.ThreadA;
import com.dhr.basic.thread.communication.threadlocal.demo1.ThreadB;
import com.dhr.basic.thread.communication.threadlocal.demo1.Tools;

/**
 * @Description :注释
 * Created by duanhr30063 on 2018/3/7.
 */

public class Test {
    public static ThreadLocalExt t1 = new ThreadLocalExt();

    public static void main(String args[]) throws Exception {
        if (t1.get() == null) {
            System.out.println("木有值");
            t1.set("我的值");
        }
        System.out.println(t1.get());
        System.out.println(t1.get());
    }

}
