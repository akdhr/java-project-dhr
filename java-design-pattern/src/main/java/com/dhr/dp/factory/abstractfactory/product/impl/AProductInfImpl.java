package com.dhr.dp.factory.abstractfactory.product.impl;

import com.dhr.dp.factory.abstractfactory.product.AProductInf;

/**
 * @Description :A产品实体类
 * Created by duanhr30063 on 2017/11/22.
 */

public class AProductInfImpl implements AProductInf {
    public void productName() {
        System.out.println("抽象工厂-A产品接口具体实现");
    }
}
