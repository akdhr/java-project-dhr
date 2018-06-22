package com.dhr.basic.thread.communication.pipe.demo1;

import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.io.PipedReader;

/**
 * @Description :注释
 * Created by duanhr30063 on 2018/3/7.
 */

public class ThreadRead extends Thread {
    private ReadData read;
    //字节流
    private PipedInputStream input;

    private PipedReader pipedReader;

    public ThreadRead(ReadData read, PipedInputStream input) {
        this.read = read;
        this.input = input;
    }

    public ThreadRead(ReadData read, PipedReader pipedReader) {
        this.read = read;
        this.pipedReader = pipedReader;
    }

    @Override
    public void run() {
//        read.readMethod(input);

        read.readMethod(pipedReader);
    }
}
