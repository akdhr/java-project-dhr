package com.dhr.dp.factory;

/**
 * @Description :简单工厂模式（静态工厂方法模）是通过专门定义一个类来负责创建其他类的实例，被创建的实例通常都具有共同的父类。
 * Created by duanhr30063 on 2017/11/22.
 */

public class SimpleFactory {

    /**
     * 简单工厂模式，根据名称，创建不同产品对象
     * 缺点：违背了开闭原则，若需要添加新产品工厂类必须进行修改,由此产生抽象工厂模式
     * @param productName
     * @return
     * @throws Exception
     */
    public static Object getProduct(String productName) throws Exception {
        if ("A".equals(productName)) {
            return "AProductObject";
        } else if ("B".equals(productName)) {
            return "BProductObject";
        } else {
            throw new IllegalArgumentException("productName 参数非法");
        }
    }

}
