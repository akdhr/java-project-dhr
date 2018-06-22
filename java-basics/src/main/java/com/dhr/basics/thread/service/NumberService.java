package com.dhr.basics.thread.service;

/**
 * @Description :注释
 * Created by duanhr30063 on 2018/3/5.
 */

public class NumberService {
    private int count = 4;

    public void subcCount() {
        System.out.println(count--);
    }
}
