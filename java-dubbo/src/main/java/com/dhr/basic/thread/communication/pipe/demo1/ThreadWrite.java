package com.dhr.basic.thread.communication.pipe.demo1;

import java.io.PipedOutputStream;
import java.io.PipedWriter;

/**
 * @Description :注释
 * Created by duanhr30063 on 2018/3/7.
 */

public class ThreadWrite extends Thread {
    private WriteData write;
    private PipedOutputStream out;

    private PipedWriter pipedWriter;

    public ThreadWrite(WriteData writeData, PipedOutputStream out) {
        this.write = writeData;
        this.out = out;
    }

    public ThreadWrite(WriteData writeData, PipedWriter pipedWriter) {
        this.write = writeData;
        this.pipedWriter = pipedWriter;
    }

    @Override
    public void run() {
//        write.writeMethod(out);
        write.writeMethod(pipedWriter);
    }
}
