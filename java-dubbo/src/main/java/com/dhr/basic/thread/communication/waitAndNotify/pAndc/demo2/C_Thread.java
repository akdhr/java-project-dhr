package com.dhr.basic.thread.communication.waitAndNotify.pAndc.demo2;

/**
 * @Description :注释
 * Created by duanhr30063 on 2018/3/7.
 */

public class C_Thread extends Thread {

    private C_S c;

    public C_Thread(C_S c) {
        this.c = c;
    }

    @Override
    public void run() {
        while (true) {
            c.popService();
        }
    }
}
