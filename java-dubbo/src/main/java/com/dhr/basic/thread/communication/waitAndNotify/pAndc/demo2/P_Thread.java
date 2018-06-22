package com.dhr.basic.thread.communication.waitAndNotify.pAndc.demo2;

import com.dhr.basic.thread.communication.waitAndNotify.pAndc.demo1.C;

/**
 * @Description :注释
 * Created by duanhr30063 on 2018/3/7.
 */

public class P_Thread extends Thread {

    private P_S p;

    public P_Thread(P_S p) {
        this.p = p;
    }

    @Override
    public void run() {
        while (true) {
            p.pushService();
        }
    }
}
