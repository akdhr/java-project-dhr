package com.dhr.dp.proxy.v2;

import com.dhr.dp.proxy.inf.IUserService;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.lang.reflect.UndeclaredThrowableException;

/**
 * @Description :java虚拟机类的加载(可自动生成此代码,具体可查看知识了解)
 * Created by duanhr30063 on 2018/5/22.
 */

public class $Proxy0 extends Proxy implements IUserService {
    private static Method m1;
    private static Method m0;
    private static Method m3;
    private static Method m2;

    static {
        try {
            m1 = Class.forName("java.lang.Object").getMethod("equals",
                    new Class[]{Class.forName("java.lang.Object")});

            m0 = Class.forName("java.lang.Object").getMethod("hashCode",
                    new Class[0]);

            m3 = Class.forName("***.RealSubject").getMethod("save",//接口中的方法
                    new Class[0]);

            m2 = Class.forName("java.lang.Object").getMethod("toString",
                    new Class[0]);

        } catch (NoSuchMethodException nosuchmethodexception) {
            throw new NoSuchMethodError(nosuchmethodexception.getMessage());
        } catch (ClassNotFoundException classnotfoundexception) {
            throw new NoClassDefFoundError(classnotfoundexception.getMessage());
        }
    } //static

    public $Proxy0(InvocationHandler invocationhandler) {
        super(invocationhandler);
    }

    /**
     * 实现了此 IUserService 接口,并调用了父类的拦截器中的invoke方法
     * <p>
     * QAQ
     * Q:没有发现这个target和Proxy之间的联系，一度纠结于最后调用的这个target的save()方法是怎么和invoke()联系上的，而invoke又是怎么知道request存在的
     * A:super.h.invoke(this, m3, null)调用了super中的拦截器中invoke方法
     *
     * @return
     */
    public Integer save() {
        try {
            super.h.invoke(this, m3, null);
        } catch (Error e) {
        } catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
        return null;
    }

    @Override
    public final boolean equals(Object obj) {
        try {
            return ((Boolean) super.h.invoke(this, m1, new Object[]{obj})).booleanValue();
        } catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

    @Override
    public final int hashCode() {
        try {
            return ((Integer) super.h.invoke(this, m0, null)).intValue();
        } catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }


    @Override
    public final String toString() {
        try {
            return (String) super.h.invoke(this, m2, null);
        } catch (Throwable throwable) {
            throw new UndeclaredThrowableException(throwable);
        }
    }

}