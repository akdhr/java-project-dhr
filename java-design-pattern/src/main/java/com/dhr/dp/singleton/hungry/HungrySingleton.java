package com.dhr.dp.singleton.hungry;

/**
 * @Description :饿汉式-单例模式
 * 饿汉式在类创建的同时就已经创建好一个静态的对象供系统使用，以后不再改变，所以天生是线程安全的
 * Created by duanhr30063 on 2017/12/1.
 */

public class HungrySingleton {
    private HungrySingleton() {
    }

    private static final HungrySingleton single = new HungrySingleton();

    //静态工厂方法
    public static HungrySingleton getInstance() {
        return single;
    }
}
