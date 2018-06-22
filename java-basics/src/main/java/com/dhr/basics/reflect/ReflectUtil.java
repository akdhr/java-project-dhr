package com.dhr.basics.reflect;

import com.dhr.basics.beans.User;

import java.lang.reflect.Method;

/**
 * @Description :通过返回获取对象的属性及方法等,模拟实现代理模式调用
 * Created by duanhr30063 on 2017/11/21.
 */

public class ReflectUtil {

    public static Object getBeans(Object obj) throws Exception {
        Class temClass = obj.getClass();
        Method[] methods = temClass.getMethods();
        for (Method method : methods) {
            System.out.println(method);
        }

        Method setAgeMethod = temClass.getDeclaredMethod("setAge", Integer.class);
        setAgeMethod.invoke(temClass.newInstance(), 15);

        System.out.println(temClass.getDeclaredMethod("getAge"));
        return null;


    }


    public static void main(String args[]) throws Exception {
        User user = new User();
        user.setName("dhr");
        user.setAge(25);

        ReflectUtil.getBeans(user);


    }


}
