package com.dhr.dp.proxy.test;


import com.dhr.dp.proxy.ProxyFactoryCglib;
import com.dhr.dp.proxy.ProxyFactoryJdk;
import com.dhr.dp.proxy.StaticproxyFactory;
import com.dhr.dp.proxy.inf.IUserService;
import com.dhr.dp.proxy.inf.impl.IUserServiceImpl;
import com.dhr.dp.proxy.v2.Interceptor;
import com.dhr.dp.proxy.v2.TargetProxy;

/**
 * @Description :注释
 * Created by duanhr30063 on 2017/11/21.
 */

public class ProxyTest {

    public static void main(String args[]) throws Exception {
        //1.jdk代理测试
        //目标接口
        IUserService userService_1 = new IUserServiceImpl();
        //代理对象
        userService_1 = (IUserService) new ProxyFactoryJdk(userService_1).getProxyInstance();
        //通过代理调用目标方法
//        userService_1.save();


        //2.cglib代理测试
        IUserServiceImpl iUserService_2 = new IUserServiceImpl();
        ProxyFactoryCglib proxyFactoryCglib = new ProxyFactoryCglib();
        iUserService_2 = (IUserServiceImpl) proxyFactoryCglib.getInstance(iUserService_2);
//        iUserService_2.save();


        //3.静态代理
        IUserServiceImpl iUserService_3 = new IUserServiceImpl();
        StaticproxyFactory staticproxyFactory = new StaticproxyFactory(iUserService_3);
//        staticproxyFactory.save();


        //4.优化代理,实现自定义拦截器
        //客户端可以定义各种拦截逻辑
        Interceptor interceptor = new Interceptor() {
            public void intercept() {
                System.out.println("客户端自定义拦截器,Go Go Go!!!");
            }
        };

        try {
            IUserService target = new IUserServiceImpl();
            target = (IUserService) TargetProxy.bind(target, interceptor);
            target.save();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
