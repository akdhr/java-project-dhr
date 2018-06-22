package com.dhr.dp.singleton.lazy;

/**
 * @Description :懒汉式-单例模式（非线程安全）
 * Singleton通过将构造方法限定为private避免了类在外部被实例化，在同一个虚拟机范围内，Singleton的唯一实例只能通过getInstance()方法访问。
 * （事实上，通过Java反射机制是能够实例化构造方法为private的类的，那基本上会使所有的Java单例实现失效。此问题在此处不做讨论，姑且掩耳盗铃地认为反射机制不存在。）
 * 但是以上懒汉式单例的实现没有考虑线程安全问题，它是线程不安全的，并发环境下很可能出现多个Singleton实例，要实现线程安全
 * Created by duanhr30063 on 2017/12/1.
 */

public class LazySingleton {
    /**
     * 1.私有构造器，只允许自己创建对象
     */
    private LazySingleton() {

    }

    /**
     * 持有自我的私有变量
     */
    private static LazySingleton lazySingleton = null;

    /**
     * 唯一对外提供实例方法
     *
     * @return
     */
    public static LazySingleton getInstance() {
        if (null == lazySingleton) {
            lazySingleton = new LazySingleton();
        }
        return lazySingleton;
    }


}
