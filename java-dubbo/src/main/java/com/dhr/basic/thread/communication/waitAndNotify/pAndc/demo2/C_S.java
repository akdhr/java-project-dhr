package com.dhr.basic.thread.communication.waitAndNotify.pAndc.demo2;

/**
 * @Description :注释
 * Created by duanhr30063 on 2018/3/7.
 */

public class C_S {
    private MyStack myStack;

    public C_S(MyStack myStack) {
        this.myStack = myStack;
    }

    public void popService() {
        System.out.println("pop=" + myStack.pop());
    }
}
