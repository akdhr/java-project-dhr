package com.dhr.dp.proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Description :cglib是针对具体的类(即使实现接口也不影响)来实现代理的，原理是对指定的业务类生成一个子类，并覆盖其中业务方法实现代理。
 * 因为采用的是继承，所以不能对final修饰的类进行代理。
 * Created by duanhr30063 on 2017/11/21.
 */

public class ProxyFactoryCglib implements MethodInterceptor {

    private Object target;//业务类对象，供代理方法中进行真正的业务方法调用

    //相当于JDK动态代理中的绑定
    public Object getInstance(Object target) {
        this.target = target;  //给业务对象赋值
        Enhancer enhancer = new Enhancer(); //创建加强器，用来创建动态代理类
        enhancer.setSuperclass(this.target.getClass());  //为加强器指定要代理的业务类（即：为下面生成的代理类指定父类）
        //设置回调：对于代理类上所有方法的调用，都会调用CallBack，而Callback则需要实现intercept()方法进行拦
        enhancer.setCallback(this);
        // 创建动态代理类对象并返回
        return enhancer.create();
    }

    // 实现回调方法
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        System.out.println("cglib 代理 预处理——————");
        Object object = proxy.invokeSuper(obj, args); //调用业务类（父类中）的方法
        System.out.println("cglib 代理 调用后操作——————");
        return object;
    }


}
