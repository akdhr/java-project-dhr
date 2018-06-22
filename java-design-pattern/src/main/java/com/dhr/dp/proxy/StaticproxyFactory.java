package com.dhr.dp.proxy;

import com.dhr.dp.proxy.inf.IUserService;

/**
 * @Description :静态代理在使用时,需要定义接口或者父类,被代理对象与代理对象一起实现相同的接口或者是继承相同父类.
 * 总结：
 * 1.可以做到在不修改目标对象的功能前提下,对目标功能扩展.
 * 2.缺点:
 * 因为代理对象需要与目标对象实现一样的接口,所以会有很多代理类,类太多.同时,一旦接口增加方法,目标对象与代理对象都要维护.
 * Created by duanhr30063 on 2017/11/21.
 */

public class StaticproxyFactory implements IUserService {

    private IUserService target;

    public StaticproxyFactory(IUserService target) {
        this.target = target;
    }

    public Integer save() {
        System.out.println("static proxy 开始事务...");
        Integer count = target.save();//执行目标对象的方法
        System.out.println("static proxy 提交事务...");
        return count;
    }
}
