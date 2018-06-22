package com.dhr.basics.utils.properties;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.util.Properties;

/**
 * @Description :注释
 * Created by duanhr30063 on 2018/1/9.
 */

public class PropertiesTest {


    public static void main(String args[]) throws Exception {
        String fileName = "D:\\Idea_workspace\\java-project-dhr\\java-basics\\src\\main\\resources\\config\\log4j.properties";
        //继承Hashtable,可按照map格式取值
        Properties properties = new Properties();
        InputStream in = new FileInputStream(fileName);
        //加载
        properties.load(in);
        //设值

        properties.put("c", "动态加载参数与修改参数值");
        properties.put("d", "动态加载参数与修改参数值");
        //存储
        properties.store(new FileWriter(fileName), "注释");
        System.out.println(properties.entrySet());
        System.out.println(properties.getProperty("a"));


    }


}
