package com.dhr.dp.proxy.v2;

import com.dhr.dp.proxy.inf.IUserService;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Description :代理类
 * Created by duanhr30063 on 2018/5/22.
 */

public class TargetProxy implements InvocationHandler {
    //真正的目标对象
    private Object target;
    private Interceptor interceptor;

    //初始化
    private TargetProxy(Object target, Interceptor interceptor) {
        this.target = target;
        this.interceptor = interceptor;

    }

    //将客户端和代理对象绑定,并返回一个代理对象
    public static Object bind(Object target, Interceptor interceptor) {
        Class<?> targetClass = target.getClass();
        //通过Proxy处理之后生成一个IUserService接口的实现类$Proxy0实现,并构造该接口定义的方法save();可参考com.dhr.dp.proxy.v2.$Proxy0类
        IUserService subject = (IUserService) Proxy.newProxyInstance(targetClass.getClassLoader(), targetClass.getInterfaces(), new TargetProxy(target, interceptor));
        //这里可以通过运行结果证明subject是Proxy的一个实例，这个实例实现了IUserService接口
        System.out.println(subject instanceof Proxy);
        System.out.println("subject的Class类是：" + subject.getClass().toString());
        System.out.print("subject中的属性有：");
        Field[] fields = subject.getClass().getDeclaredFields();
        for (Field field : fields) {
            System.out.print(field.getName() + ", ");
        }
        System.out.print("\n" + "subject中的方法有：");
        Method[] method = subject.getClass().getDeclaredMethods();
        for (Method m : method) {
            System.out.print(m.getName() + ", ");
        }
        System.out.println("\n"+"subject的父类是："+subject.getClass().getSuperclass());
        System.out.print("\n"+"subject实现的接口是：");
        Class<?>[] interfaces=subject.getClass().getInterfaces();
        for(Class<?> i:interfaces){
            System.out.print(i.getName()+", ");
        }
        System.out.println("\n\n"+"运行结果为：");
        return subject;
//        TODO 以上只是作为一次验证处理,可直接执行下面一句就可以实现接口的代理
//        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new TargetProxy(target, interceptor));
    }


    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //执行客户端自己定义的拦截器,扩展性高，防止固定代码
        interceptor.intercept();
        //注意此处proxy参数并未使用到
        return method.invoke(target, args);
    }



}
