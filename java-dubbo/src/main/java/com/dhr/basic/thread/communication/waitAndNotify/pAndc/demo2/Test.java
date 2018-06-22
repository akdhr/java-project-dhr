package com.dhr.basic.thread.communication.waitAndNotify.pAndc.demo2;

/**
 * @Description :注释
 * Created by duanhr30063 on 2018/3/7.
 */

public class Test {
    public static void main(String args[]) throws Exception {

        MyStack myStack = new MyStack();
        P_S p = new P_S(myStack);
        C_S c = new C_S(myStack);
        P_Thread p_thread = new P_Thread(p);
        C_Thread c_thread = new C_Thread(c);
        p_thread.start();
        c_thread.start();
    }
}
