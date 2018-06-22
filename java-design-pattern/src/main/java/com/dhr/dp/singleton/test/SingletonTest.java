package com.dhr.dp.singleton.test;

import com.dhr.dp.singleton.hungry.HungrySingleton;
import com.dhr.dp.singleton.lazy.LazySingleton;
import com.dhr.dp.singleton.lazy.LazySingletonSync;

/**
 * @Description :注释
 * Created by duanhr30063 on 2017/12/1.
 */

public class SingletonTest {

    public static void main(String args[]) {
        //懒汉式单例模式（非线程安全）
        System.out.println(LazySingleton.getInstance());
        System.out.println(LazySingleton.getInstance());

        //懒汉式单例模式（线程安全）
        System.out.println(LazySingletonSync.getInstance_method1());
        System.out.println(LazySingletonSync.getInstance_method2());
        //在内部类中创建对象，对象地址可能会和method1、2不同;保证getInstance_method3多次调用地址一致即可
        System.out.println(LazySingletonSync.getInstance_method3());
        System.out.println(LazySingletonSync.getInstance_method3());


        //饿汉式单例模式（线程安全）
        System.out.println(HungrySingleton.getInstance());
        System.out.println(HungrySingleton.getInstance());


    }
}
