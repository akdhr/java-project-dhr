package com.dhr.basic.thread.communication.lock.demo6;

/**
 * @Description :注释
 * Created by duanhr30063 on 2018/3/8.
 */

public class WriteThread extends Thread {
    ReadAndWriteLockService service;

    public WriteThread(ReadAndWriteLockService service) {
        this.service = service;
    }

    @Override
    public void run() {
        service.write();
    }
}
