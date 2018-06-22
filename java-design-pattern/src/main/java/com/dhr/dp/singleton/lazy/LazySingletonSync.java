package com.dhr.dp.singleton.lazy;

/**
 * 懒汉式单例模式（线程安全）
 */
public class LazySingletonSync {
    /**
     * 1.私有构造器，只允许自己创建对象
     */
    private LazySingletonSync() {

    }

    /**
     * 持有自我的私有变量
     */
    private static LazySingletonSync lazySingleton = null;

    /**
     * 1.唯一对外提供实例方法(加上方法同步锁)
     *
     * @return
     */
    public static synchronized LazySingletonSync getInstance_method1() {
        if (null == lazySingleton) {
            lazySingleton = new LazySingletonSync();
        }
        return lazySingleton;
    }

    /**
     * 2.唯一对外提供实例方法(双重检查锁定)
     *
     * @return
     */
    public static LazySingletonSync getInstance_method2() {
        if (null == lazySingleton) {
            synchronized (LazySingleton.class) {
                if (null == lazySingleton) {
                    lazySingleton = new LazySingletonSync();
                }
            }
        }
        return lazySingleton;
    }

    /**
     * 3.唯一对外提供实例方法(静态内部类实现)
     * 既实现了线程安全，又避免了同步带来的性能影响（推荐）
     *
     * @return
     */
    public static LazySingletonSync getInstance_method3() {
        return LazySingletonHolder.instance;
    }

    //静态内部类创建final实例,保证实例的全局唯一
    private static final class LazySingletonHolder {
        private static final LazySingletonSync instance = new LazySingletonSync();
    }

}
