package com.dhr.basics.thread.basic;

import com.dhr.basics.thread.service.NumberService;

/**
 * @Description :注释
 * Created by duanhr30063 on 2018/3/5.
 */

public class TestMain {
    public static void main(String args[]) {
        NumberService numberService = new NumberService();
        Thread1 thread1 = new Thread1(numberService);
        thread1.run();

    }
}
