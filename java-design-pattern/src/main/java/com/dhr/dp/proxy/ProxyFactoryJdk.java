package com.dhr.dp.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Description :代理对象，实现InvocationHandler接口
 * jdk动态代理使用的局限性(静态代理不常用)
 * 1.通过反射类Proxy和InvocationHandler回调接口实现的jdk动态代理，要求委托类必须实现一个接口，但事实上并不是所有类都有接口，对于没有实现接口的类，便无法使用该方方式实现动态代理。
 * 2.如果业务实现类中新增了接口中没有的方法，这些方法是无法被代理的（因为是通过接口作为参数来调用）
 * Created by duanhr30063 on 2017/11/21.
 */

public class ProxyFactoryJdk implements InvocationHandler {


    //代理目标对象
    private Object target;


    public ProxyFactoryJdk(Object target) {
        this.target = target;
    }

    /**
     * 执行代理对象的方法，其实就是执行InvocationHandle对象的invoke方法(可反编译看到public final class 生成的代理类 extends Proxy implements 目标接口)
     * 传入的参数分别是当前代理对象，当前执行的方法和参数。
     *
     * @return
     */
    public Object getProxyInstance() {
        ClassLoader targetLoader = target.getClass().getClassLoader();
        Class<?>[] interfaces = target.getClass().getInterfaces();
        return Proxy.newProxyInstance(targetLoader, interfaces, this);
    }

    /**
     * @param proxy  当前代理对象
     * @param method 当前执行的方法
     * @param args   方法参数
     * @return
     * @throws Throwable
     */
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("jdk 代理 预处理——————");
        Object object = method.invoke(target, args);
        System.out.println("jdk 代理 调用后操作——————");
        return object;
    }

}
