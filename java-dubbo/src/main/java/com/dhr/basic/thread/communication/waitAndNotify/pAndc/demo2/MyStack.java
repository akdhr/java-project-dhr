package com.dhr.basic.thread.communication.waitAndNotify.pAndc.demo2;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description :生产/消费处理,以下demo可满足，一对一/多;多对一/多
 * <p>
 * Created by duanhr30063 on 2018/3/7.
 */

public class MyStack {
    private List list = new ArrayList();

    synchronized public void push() {
        try {
//            if (list.size() == 1) { 1.条件改变容易发生异常，需改为while判断 2.一消费一生产正常，一旦一生产多消费就可能出现假死状态，必须改为notifyAll进行通知
            while (list.size() == 1) {
                this.wait();
            }
            list.add("anyStr" + Math.random());
            this.notify();
            System.out.println("push = " + list.size());
        } catch (Exception e) {

        }
    }

    synchronized public String pop() {
        String returnValue = "";
        try {
            while (list.size() == 0) {
                System.out.println("pop 操作中的：" + Thread.currentThread().getName() + " 线程程wait状态 ");
                this.wait();
            }
            returnValue = "" + list.get(0);
            list.remove(0);
            this.notify();
            System.out.println("pop=" + list.size());
        } catch (Exception e) {

        }
        return returnValue;
    }
}
