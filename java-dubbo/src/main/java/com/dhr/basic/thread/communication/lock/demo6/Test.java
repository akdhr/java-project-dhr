package com.dhr.basic.thread.communication.lock.demo6;

/**
 * @Description :注释
 * Created by duanhr30063 on 2018/3/8.
 */

public class Test {
    public static void main(String args[]) {
        ReadAndWriteLockService service = new ReadAndWriteLockService();
        //读读共享
        ReadThread readThread_A = new ReadThread(service);
        ReadThread readThread_B = new ReadThread(service);
        readThread_A.setName("readThread_A");
        readThread_B.setName("readThread_B");
        readThread_A.start();
        readThread_B.start();
        //读写互斥
        WriteThread writeThread_A = new WriteThread(service);
        writeThread_A.setName("writeThread_A");
        writeThread_A.start();
        //写写互斥
        WriteThread writeThread_B = new WriteThread(service);
        writeThread_B.setName("writeThread_B");
        writeThread_B.start();


    }
}
