package com.dhr.basic.thread.communication.pipe.demo1;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedReader;

/**
 * @Description :注释
 * Created by duanhr30063 on 2018/3/7.
 */

public class ReadData {

    public void readMethod(PipedInputStream input) {
        try {
            System.out.println("read :");
            byte[] byteArray = new byte[20];
            int readLength = input.read(byteArray);
            while (readLength != -1) {
                String newData = new String(byteArray, 0, readLength);
                System.out.print(newData);
                readLength = input.read(byteArray);
            }
            System.out.println();
            input.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readMethod(PipedReader input) {
        try {
            System.out.println("read :");
//            byte[] byteArray = new byte[20];  //字节
            char[] byteArray = new char[20];    //字符
            int readLength = input.read(byteArray);
            while (readLength != -1) {
                String newData = new String(byteArray, 0, readLength);
                System.out.print(newData);
                readLength = input.read(byteArray);
            }
            System.out.println();
            input.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
