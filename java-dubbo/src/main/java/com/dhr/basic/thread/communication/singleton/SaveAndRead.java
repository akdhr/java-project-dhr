package com.dhr.basic.thread.communication.singleton;

import java.io.*;

/**
 * @Description :注释
 * Created by duanhr30063 on 2018/3/9.
 */

public class SaveAndRead {
    public static void main(String args[]) throws Exception {

        try {
            MyObject2 myObjectTest = MyObject2.getInstance();
            FileOutputStream fosRef = new FileOutputStream(new File("C:\\Users\\duanhr30063\\Desktop\\支付表结构sql.txt"));
            ObjectOutputStream oosRef = new ObjectOutputStream(fosRef);
            oosRef.writeObject(myObjectTest);
            oosRef.close();
            fosRef.close();
            System.out.println(myObjectTest.hashCode());

        }catch (Exception e){

        }
        try {
            FileInputStream fisRef = new FileInputStream(new File("C:\\Users\\duanhr30063\\Desktop\\支付表结构sql.txt"));
            ObjectInputStream iosRef = new ObjectInputStream(fisRef);
            //注意反序列化对象的时候，需要实现readResolve方法,进行实例重新获取
            MyObject2 myObjectTest = (MyObject2) iosRef.readObject();
            iosRef.close();
            fisRef.close();
            System.out.println(myObjectTest.hashCode());
        }catch (Exception e){

        }


    }
}
