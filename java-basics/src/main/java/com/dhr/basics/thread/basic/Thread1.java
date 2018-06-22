package com.dhr.basics.thread.basic;

import com.dhr.basics.thread.service.NumberService;

/**
 * @Description :注释
 * Created by duanhr30063 on 2018/3/5.
 */

public class Thread1 implements Runnable {
    private NumberService numberService;


    public Thread1(NumberService numberService) {
        this.numberService = numberService;
    }

    @Override
    public void run() {
        numberService.subcCount();

    }
}
