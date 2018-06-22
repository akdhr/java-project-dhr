package com.dhr.basic.thread.communication.pipe.demo1;

import java.io.*;

/**
 * @Description :注释
 * Created by duanhr30063 on 2018/3/7.
 */

public class Test {
    public static void main(String args[]) {
      /*
        WriteData writeData = new WriteData();
        ReadData readData = new ReadData();
        PipedOutputStream out = new PipedOutputStream();
        PipedInputStream input = new PipedInputStream();
        try {
            out.connect(input);
            ThreadRead threadRead = new ThreadRead(readData, input);
            threadRead.start();
            Thread.sleep(2000);
            ThreadWrite threadWrite = new ThreadWrite(writeData, out);
            threadWrite.start();

        } catch (IOException e) {

        } catch (InterruptedException e) {

        } */

        WriteData writeData = new WriteData();
        ReadData readData = new ReadData();
        PipedReader input = new PipedReader();
        PipedWriter out = new PipedWriter();
        try {
            out.connect(input);
            ThreadRead threadRead = new ThreadRead(readData, input);
            threadRead.start();
            Thread.sleep(2000);
            ThreadWrite threadWrite = new ThreadWrite(writeData, out);
            threadWrite.start();

        } catch (IOException e) {

        } catch (InterruptedException e) {

        }

    }
}
