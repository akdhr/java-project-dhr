package com.dhr.dp.factory.abstractfactory.product.impl;

import com.dhr.dp.factory.abstractfactory.product.BProductInf;

/**
 * @Description :B产品实体类
 * Created by duanhr30063 on 2017/11/22.
 */

public class BProductInfImpl implements BProductInf {
    public void productName() {
        System.out.println("抽象工厂-B产品接口具体实现");
    }
}
