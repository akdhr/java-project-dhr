package com.dhr.dp.proxy.inf.impl;

import com.dhr.dp.proxy.inf.IUserService;

/**
 * @Description :注释
 * Created by duanhr30063 on 2017/11/21.
 */

public class IUserServiceImpl implements IUserService {
    /**
     * cglib 不能代理final/static方法
     * 目标对象的方法如果为final/static,那么就不会被拦截,即不会执行目标对象额外的业务方法.
     * @return
     */
    public /*final*/ Integer save() {
        System.out.println("我是target对象,保存成功");
        return null;
    }
}
