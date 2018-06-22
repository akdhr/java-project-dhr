package com.dhr.basic.thread.communication.singleton;

import javax.jws.soap.SOAPBinding;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @Description :注释
 * Created by duanhr30063 on 2018/3/9.
 */

public enum MyObject4 {
    connectionFactory;
    private Connection connection;

    private MyObject4() {
        try {
            System.out.println("调用了MyObject4的构造");
            String url = "jdbc:mysql://localhost:3306/test";
            String username = "dhr";
            String password = "123456";
            String driverName = "com.mysql.jdbc.Driver";
            Class.forName(driverName);
            connection = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public Connection getConnection() {
        return connection;
    }


    public static void main(String args[]) {
        //需要引入渠道类
        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();
        MyThread t3 = new MyThread();
        t1.start();
        t2.start();
        t3.start();
    }
}
